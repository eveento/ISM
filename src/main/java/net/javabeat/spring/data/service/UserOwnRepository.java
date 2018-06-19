package net.javabeat.spring.data.service;

import net.javabeat.spring.data.domain.User;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserOwnRepository extends Repository<User, Long> {

    @Query(value = "from User x where x.id=:id")
    User getUserById(@Param("id") long id);

    @Query(value="from User x where x.login=:login and x.password=:password")
    User checkLogin(@Param("login") String login, @Param("password") String password);
    
    @Modifying
    @Query(value="update User x Set x.email=?2 where x.id=?1")
    void updateEmail(long id, String email);

    @Query(value="from User u")
    List<User> getAllUsers();
}

