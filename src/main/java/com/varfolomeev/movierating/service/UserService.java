package com.varfolomeev.movierating.service;

import com.varfolomeev.movierating.entity.User;
import com.varfolomeev.movierating.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public User saveUser(User user){
        return userRepository.save(user);
    }

}
