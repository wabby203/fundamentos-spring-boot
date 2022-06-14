package com.fundamentos.springboot.fundamentos.service;

import com.fundamentos.springboot.fundamentos.entity.User;
import com.fundamentos.springboot.fundamentos.repository.UserRepocitory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Slf4j
@Service
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

    public User save(User newUser) {
        return  userRepocitory.save(newUser);
    }

    public User update(User newUser) {
        return  userRepocitory.save(newUser);
    }

    public User delete(User newUser) {
        return  userRepocitory.save(newUser);
    }

    public void deleteById(Long id) {
        userRepocitory.deleteById(id);
    }

    public User update(User nUser, Long id)
    {
        return    userRepocitory.findById(id)
                .map(
                        user -> {
                            user.setEmail(nUser.getEmail());
                            user.setBirthday(nUser.getBirthday());
                            user.setName(nUser.getName());
                            return userRepocitory.save(user);
                        }
                ).get();
    }
}
