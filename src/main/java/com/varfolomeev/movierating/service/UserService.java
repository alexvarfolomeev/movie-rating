package com.varfolomeev.movierating.service;

import com.varfolomeev.movierating.entity.User;
import com.varfolomeev.movierating.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Set;

import static com.amazonaws.services.servicecatalog.model.AccessLevelFilterKey.Role;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    public BCryptPasswordEncoder getPasswordEncoder() {
        return passwordEncoder;
    }
    public void setPasswordEncoder(BCryptPasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public User saveUser(User user) throws Exception {
        var dbUser = userRepository.findUserByEmail(user.getEmail());
        if (dbUser.isPresent()){
            throw new Exception("User is already exists!");
        }
        var saveUser = User
                .builder()
                .firstname(user.getFirstname())
                .lastname(user.getLastname())
                .birthDate(user.getBirthDate())
                .password(passwordEncoder.encode(user.getPassword()))
                .roles(user.getRoles())
                .build();
        return userRepository.save(saveUser);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository
                .findUserByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
}
