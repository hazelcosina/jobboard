package com.ota.jobboard.service;

import com.ota.jobboard.entity.User;

import java.util.List;

public interface IUserService {
    List<User> getAll();
    User save(User user);
}
