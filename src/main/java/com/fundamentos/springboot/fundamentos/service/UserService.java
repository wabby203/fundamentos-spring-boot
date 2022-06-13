package com.fundamentos.springboot.fundamentos.service;

import com.fundamentos.springboot.fundamentos.entity.User;
import com.fundamentos.springboot.fundamentos.repository.UserRepocitory;
import lombok.extern.slf4j.Slf4j;

import javax.transaction.Transactional;
import java.util.List;

@Slf4j
public class UserService {

    private UserRepocitory userRepocitory;

    public UserService (UserRepocitory userRepocitory)
    {
        this.userRepocitory = userRepocitory;
    }


    @Transactional /*esa anotacion nos sirve para si surge un error, nos ayudara a hacer un rollback de la consulta*/
    public void saveTransactional(List<User> users)
    {
        users.stream()
                .peek(user -> log.info("Usuario insertado :" + user))
                .forEach(userRepocitory::save);
    }

    public  List<User> getAllUsers()
    {
        return userRepocitory.findAll();
    }
}
