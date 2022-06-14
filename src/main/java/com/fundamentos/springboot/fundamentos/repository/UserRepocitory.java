package com.fundamentos.springboot.fundamentos.repository;

import com.fundamentos.springboot.fundamentos.entity.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepocitory extends PagingAndSortingRepository<User, Long> {

    /*este es un query de jppql donde u es como el apode de user y ?1 es la espera de un parametro*/
@Query ("Select u from User u where u.email=?1")
    Optional<User> findByUserEmail(String email);

/*Ejemplo para ordenar a partir de un parametro enviado haciendo uso de jpql*/
    @Query("Select u from User u where u.name like ?1%")
    List<User> findAndSort(String name, Sort sort);
    /*Obtención de información usando Query methods*/
    /*a traves del nombre de los metodos spring intenta hacer la consulta,*/
    List<User> findByName(String name);
    Optional<User> findByEmailAndName(String email, String name);

    /*Uso de Query methods con Or, and, OrderBy, Between, Sort*/
    List<User> findByNameLike(String name);

    Optional<User> findByNameOrEmail(String name, String email);
    /*Uso de Query methods que encuentre informacion a partir de un intervalo de fecha que tenemos mapeada en la endtidad*/

    List<User> findByBirthdayBetween(LocalDate begin, LocalDate end);

    /*Uso de Query methods para ordenar los datos que estamos tmanejando*/
    List<User> findByNameLikeOrderByIdDesc(String name);

    /*Uso de JPQL con named parameters
    @Query("SELECT new com.fundamentos.springboot.fundamentos.dto.UserDto(u.id, u.name, u.birthday) " +
            " FROM User u " +
            " where u.birthday=:pramamFecha " +
            " and u.email=:paramEmail ")

    Optional<UserDto> getAllByBirthdayAndEmail(@Param("pramamFecha") LocalDate date, @Param("paramEmail") String email);*/

    List<User> findAll();

}
