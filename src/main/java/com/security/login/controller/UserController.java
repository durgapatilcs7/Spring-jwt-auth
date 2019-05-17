package com.security.login.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import com.security.login.model.ApiResponse;
import com.security.login.model.User;
import com.security.login.model.UserDto;
import com.security.login.service.UserService;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

//@CrossOrigin(origins = "*", maxAge = 3600)
@Path("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @POST
	@Consumes(MediaType.APPLICATION_JSON)
    public ApiResponse<User> saveUser(UserDto user){
        return new ApiResponse<>(HttpStatus.OK.value(), "User saved successfully.",userService.save(user));
    }

    @GET
	@Produces(MediaType.APPLICATION_JSON)
    public ApiResponse<List<User>> listUser(){
        return new ApiResponse<>(HttpStatus.OK.value(), "User list fetched successfully.",userService.findAll());
    }

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
    public ApiResponse<User> getOne(@PathParam("id") int id){
        return new ApiResponse<>(HttpStatus.OK.value(), "User fetched successfully.",userService.findById(id));
    }

	@PUT
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
    public ApiResponse<UserDto> update(UserDto userDto) {
        return new ApiResponse<>(HttpStatus.OK.value(), "User updated successfully.",userService.update(userDto));
    }

	@DELETE
	@Path("/{id}")
    public ApiResponse<Void> delete(@PathParam("id") int id) {
        userService.delete(id);
        return new ApiResponse<>(HttpStatus.OK.value(), "User deleted successfully.", null);
    }



}