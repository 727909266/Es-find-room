package com.huhaoran.esproject.service;

import com.huhaoran.esproject.entity.UserEntity;
import org.springframework.stereotype.Service;

public interface IUserService {
    UserEntity findUserEntityByName(String userName);
}
