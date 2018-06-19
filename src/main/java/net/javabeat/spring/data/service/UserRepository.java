package net.javabeat.spring.data.service;

import net.javabeat.spring.data.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

}
