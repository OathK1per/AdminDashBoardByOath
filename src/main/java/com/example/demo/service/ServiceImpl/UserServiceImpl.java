package com.example.demo.service.ServiceImpl;

import com.example.demo.pojo.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean login(User user) {
        User user1 = userRepository.findUserByNameAndPassword(user.getName(), user.getPassword());

        if (user1 != null) {
            return true;
        }
        return false;
    }

    @Override
    public boolean register(User user) {

        User userByName = userRepository.findUserByName(user.getName());
        if (userByName != null) {
            return false;
        }
        User user1 = userRepository.save(user);
        if (user1 != null) {
            return true;
        }

        return false;
    }

}
