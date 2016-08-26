package com.bridgelabz.mbaas.persist.repo;

import java.util.List;

import com.bridgelabz.mbaas.persist.entity.Profile;
import com.bridgelabz.mbaas.persist.entity.User;

public interface UserRepo {

    User findByUserName(String login);

    List<User> findAll();

    void createUser(String userId, Profile profile);
}
