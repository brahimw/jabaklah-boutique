package com.boutique.jabaklah.service;

import com.boutique.jabaklah.model.User;

public interface UserService {

    boolean saveUser(User user);

    User findUserByEmail(String email);

}
