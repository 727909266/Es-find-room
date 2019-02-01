package com.huhaoran.esproject.repository;

import com.huhaoran.esproject.ApplicationTests;
import com.huhaoran.esproject.entity.UserEntity;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class UserRepositoryTest extends ApplicationTests {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void testFindOne() {
        Optional<UserEntity> user = userRepository.findById(1L);
        Assert.assertEquals("1", user.get().getStatus());
    }
}
