package com.fundamentos.springboot.fundamentos.repository;

import com.fundamentos.springboot.fundamentos.entity.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepocitory extends JpaRepository<User, Long> {

    /*este es un query de jppql donde u es como el apode de user y ?1 es la espera de un parametro*/
@Query ("Select u from User u where u.email=?1")
    Optional<User> findByUserEmail(String email);

/*Ejemplo para ordenar a partir de un parametro enviado haciendo uso de jpql*/
    @Query("Select u from User u where u.name like ?1%")
    List<User> findAndSort(String name, Sort sort);

}
