package com.security.login.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

import com.security.login.config.JwtTokenUtil;
import com.security.login.model.*;
import com.security.login.service.UserService;

//@CrossOrigin(origins = "*", maxAge = 3600)
@Path("/token")
public class AuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private UserService userService;

	@POST 
    @Path("/generate-token")
   	@Consumes(value={MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Produces(value={MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public ApiResponse<AuthToken> register(LoginUser loginUser) throws AuthenticationException {

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginUser.getUsername(), loginUser.getPassword()));
        final User user = userService.findOne(loginUser.getUsername());
        final String token = jwtTokenUtil.generateToken(user);
        
        return new ApiResponse<>(200, "success",new AuthToken(token, user.getUsername()));
        
       
     
         
    }

}