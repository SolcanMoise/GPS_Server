package com.gps.service.GPS.services;

import com.gps.service.GPS.exceptions.BusinessException;
import com.gps.service.GPS.models.User;
import com.gps.service.GPS.models.dto.UserLoginDTO;
import com.gps.service.GPS.models.dto.UserRegisterDTO;
import com.gps.service.GPS.models.security.Role;
import com.gps.service.GPS.repository.RoleRepository;
import com.gps.service.GPS.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * @author solcanm
 * @version 1.0
 * @since 2019-11-13
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<User> getUsers() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public User login(UserLoginDTO userLoginDTO) throws BusinessException {

        if (Objects.isNull(userLoginDTO)) {
            throw new BusinessException(401, "Body null!");
        }

        if (Objects.isNull(userLoginDTO.getEmail())) {
            throw new BusinessException(400, "Email cannot be null");
        }

        if (Objects.isNull(userLoginDTO.getPassword())) {
            throw new BusinessException(400, "Password cannot be null");
        }

        final User user = userRepository.findByEmail(userLoginDTO.getEmail());

        if (Objects.isNull(user)) {
            throw new BusinessException(401, "Bad credentials!");
        }

        if (!passwordEncoder.matches(userLoginDTO.getPassword(), user.getPassword())) {
            throw new BusinessException(401, "Bad credentials!");
        }

        return user;
    }

    @Override
    public User register(UserRegisterDTO userRegisterDTO) throws BusinessException {

        if (Objects.isNull(userRegisterDTO)) {
            throw new BusinessException(401, "Body null");
        }

        if (Objects.isNull(userRegisterDTO.getEmail())) {
            throw new BusinessException(400, "Email cannot be null");
        }

        if (Objects.isNull(userRegisterDTO.getPassword())) {
            throw new BusinessException(400, "Password cannot be null");
        }

        if (Objects.isNull(userRegisterDTO.getFirstName())) {
            throw new BusinessException(400, "First name cannot be null");
        }

        if (Objects.isNull(userRegisterDTO.getLastName())) {
            throw new BusinessException(400, "Last name cannot be null");
        }

        User basicUser = createUser(userRegisterDTO);

        return userRepository.save(basicUser);
    }

    private User createUser(UserRegisterDTO userRegisterDTO) {
        User basicUser = new User();
        basicUser.setEmail(userRegisterDTO.getEmail());
        basicUser.setPassword(passwordEncoder.encode(userRegisterDTO.getPassword()));
        basicUser.setFirstName(userRegisterDTO.getFirstName());
        basicUser.setLastName(userRegisterDTO.getLastName());
        basicUser.setRoles(getRoles());
        return basicUser;
    }

    private Set<Role> getRoles() {
        Role role = roleRepository.findById(2L).get();
        Set<Role> roleSet = new HashSet<>();
        roleSet.add(role);

        return roleSet;
    }
}
