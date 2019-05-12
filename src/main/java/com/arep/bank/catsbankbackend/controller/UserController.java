package com.arep.bank.catsbankbackend.controller;

import com.arep.bank.catsbankbackend.model.User;
import com.arep.bank.catsbankbackend.service.BankAccountException;
import com.arep.bank.catsbankbackend.service.UserService;

import com.arep.bank.catsbankbackend.service.UserVerificationService;
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

    @Autowired
    private UserVerificationService verificationService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Token login(@RequestBody User login)
            throws ServletException {
        System.out.println(login);
        try {
            System.out.println(userService.getUsers());
        } catch (BankAccountException e) {
            e.printStackTrace();
        }
        String jwtToken;

        int id = login.getId();
        String password = login.getPassword();

        User user;
        try {
            user = userService.getUserById(id);

        } catch (BankAccountException e) {

            throw new ServletException("User id not found.");
        }

        String pwd = user.getPassword();

        if (!password.equals(pwd)) {
            throw new ServletException("Invalid login. Please check your name and password.");
        }
        //
        jwtToken = Jwts.builder().setSubject(Integer.toString(id)).claim("roles", "user").setIssuedAt(new Date()).signWith(
                SignatureAlgorithm.HS256, "secretkey").compact();

        return new Token(jwtToken);
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<?> register(@RequestBody User register)
            throws ServletException {
        if (register.getEmail() != null && register.getName() != null && register.getPassword() != null && register.getName() != null) {
            if (verificationService.verifyUser(register.getId(), register.getName(), register.getType())) {
                if (!verificationService.isUserBlackListed(register.getId())) {
                    try {
                        userService.createUser(register);
                        return new ResponseEntity<>(HttpStatus.CREATED);
                    }catch(Exception e){
                        return new ResponseEntity<>(new ServletException("No fue posible crear el ususario, intente nuevamente"), HttpStatus.BAD_REQUEST);
                    }
                } else {
                    return new ResponseEntity<>(new ServletException("Usuario encontrado en listas de riesgo, no es posible crear cuenta"), HttpStatus.BAD_REQUEST);
                }
            } else {
                return new ResponseEntity<>(new ServletException("Datos ingresados no son veridicos, no es posible crear cuenta"), HttpStatus.BAD_REQUEST);
            }

        }else{
            return new ResponseEntity<>(new ServletException("Datos ingresados no estan completos"),HttpStatus.BAD_REQUEST);
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
