package com.bridgelabz.mbaas.web.controller;

import com.bridgelabz.mbaas.persist.entity.User;
import com.bridgelabz.mbaas.persist.repo.UserRepo;
import com.bridgelabz.mbaas.security.SecurityUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SeurityController {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PersistentTokenRepository tokenRepo;

    @RequestMapping(value = "/security/account", method = RequestMethod.GET)
    public @ResponseBody
    User getUserAccount()  {
        User user = userRepo.findByUserName(SecurityUtils.getCurrentLogin());
        user.setPassword(null);
        return user;
    }

}
