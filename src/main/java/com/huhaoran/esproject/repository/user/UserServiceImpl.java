package com.huhaoran.esproject.repository.user;

import com.huhaoran.esproject.entity.UserEntity;
import com.huhaoran.esproject.repository.UserRepository;
import com.huhaoran.esproject.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserEntity findUserEntityByName(String userName) {
        return userRepository.findByName(userName);
    }
}
