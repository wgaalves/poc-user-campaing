package com.willalves.fanservice.controller;

import com.willalves.fanservice.model.User;
import com.willalves.fanservice.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RequestMapping("/api")
@AllArgsConstructor
@Api(value = "User" , description = "Users")
@Controller
public class UserController {
    private UserService userService;

    @ApiOperation(value = "Get User by Id")
    @RequestMapping(value = "/user/{id}",
            method = RequestMethod.GET,
            produces = "application/json")
    public ResponseEntity<Optional<User>> findCampaign(@Valid @PathVariable("id") Long id){
        Optional<User> found = userService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(found);
    }


    @ApiOperation(value = "Create User")
    @RequestMapping(value = "/user/",
            method = RequestMethod.POST,
            consumes = "application/json",
            produces = "application/json")
    public ResponseEntity<User> saveProduct(@Valid @RequestBody User values) throws Exception {
        User saved = userService.save(values);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @ApiOperation(value = "Update User")
    @RequestMapping(value = "/user/",
            method = RequestMethod.PATCH,
            consumes = "application/json",
            produces = "application/json")
    public ResponseEntity<User> updateProduct(@Valid @RequestBody User values) {
        User saved = userService.update(values);
        return ResponseEntity.status(HttpStatus.OK).body(saved);
    }


    @ApiOperation(value = "Delete User")
    @RequestMapping(value = "/user/{id}",
            method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteProduct(@PathVariable("id") Long id) {
        userService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("");
    }
}
