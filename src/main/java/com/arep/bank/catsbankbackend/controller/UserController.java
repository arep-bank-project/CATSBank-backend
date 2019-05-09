package com.arep.bank.catsbankbackend.controller;

import com.arep.bank.catsbankbackend.model.User;
import com.arep.bank.catsbankbackend.service.BankAccountException;
import com.arep.bank.catsbankbackend.service.UserService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import java.util.Date;


@RestController
@RequestMapping("/user")

@CrossOrigin(origins = "*")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Token login(@RequestBody User login)
            throws ServletException {

        String jwtToken;

        if (login.getEmail() == null || login.getPassword() == null) {
            throw new ServletException("Please fill in email and password");
        }

        String email = login.getEmail();
        String password = login.getPassword();

        User user;
        try {
            user = userService.getUserByEmail(email);

        } catch (BankAccountException e) {

            throw new ServletException("User email not found.");
        }

        String pwd = user.getPassword();

        if (!password.equals(pwd)) {
            throw new ServletException("Invalid login. Please check your name and password.");
        }
        //
        jwtToken = Jwts.builder().setSubject(email).claim("roles", "user").setIssuedAt(new Date()).signWith(
                SignatureAlgorithm.HS256, "secretkey").compact();

        return new Token(jwtToken);
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<?> register(@RequestBody User register)
            throws ServletException {
        if (register.getEmail() != null && register.getName() != null && register.getPassword() != null && register.getName() != null) {
            try {
                userService.createUser(register);
                return new ResponseEntity<>(HttpStatus.CREATED);
            } catch (Exception e) {
                throw new ServletException("Invalid data while creation user");
            }
        }else{
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    public class Token {

        String accessToken;

        public Token(String accessToken) {
            this.accessToken = accessToken;
        }

        public String getAccessToken() {
            return accessToken;
        }

        public void setAccessToken(String access_token) {
            this.accessToken = access_token;
        }
    }

}
