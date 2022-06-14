package com.fundamentos.springboot.fundamentos.controller;

import com.fundamentos.springboot.fundamentos.caseUse.CreateUser;
import com.fundamentos.springboot.fundamentos.caseUse.DeleteUser;
import com.fundamentos.springboot.fundamentos.caseUse.GetUser;
import com.fundamentos.springboot.fundamentos.caseUse.UpdateUser;
import com.fundamentos.springboot.fundamentos.entity.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/users")
public class UserRestController {
    //insert, get, delete, update
    private GetUser getUser;
    private CreateUser createUser;
    private UpdateUser updateUser;
    private DeleteUser deleteUser;

    public UserRestController(GetUser getUser, CreateUser createUser, UpdateUser updateUser, DeleteUser deleteUser) {
        this.getUser = getUser;
        this.createUser = createUser;
        this.updateUser = updateUser;
        this.deleteUser = deleteUser;
    }
@GetMapping("/")
    List<User> get()
    {
        return  getUser.getAll();
    }
    private User user;
    @PostMapping("/")
    ResponseEntity<User> newUser(@RequestBody User newUser)
    {
        return  new ResponseEntity<>(createUser.save(newUser), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    ResponseEntity delUser (@PathVariable Long id)
    {
        deleteUser.remove(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PutMapping("{id}")
    ResponseEntity<User> replaceUser (@RequestBody User nUser, @PathVariable Long id)
    {
        return new ResponseEntity<>(updateUser.update(nUser, id), HttpStatus.OK);
    }
}
