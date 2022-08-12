package com.zahid.controllers;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.zahid.models.Account;
import com.zahid.services.AccountService;
import com.zahid.services.UserSecurityService;

@Controller
public class ProfileController {

    private final Logger logger = LoggerFactory.getLogger(HomeController.class);
    private AccountService accountService;

    @GetMapping("/profile")
    public ModelAndView getProfile() {
        logger.debug("request to GET tour list");
 
        ModelAndView modelAndView = new ModelAndView("profile");
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        logger.info("Principal: ", principal);
        logger.info("Context: ", SecurityContextHolder.getContext());
        
        String username;
        if (principal instanceof UserDetails) {
            username = ((UserDetails)principal).getUsername();
        } else {
            username = principal.toString();
        }
        // username = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
        // Account account = accountService.getAccountByEmail(username);

        // logger.info("Username : ", username);
        // if (account != null) {
        //     logger.info("Profile Controller: ", account);
        //     modelAndView.addObject("account", account);
        // }

        return modelAndView;
    }
}
