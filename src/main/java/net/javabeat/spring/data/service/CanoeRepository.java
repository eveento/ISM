package net.javabeat.spring.data.service;

import org.springframework.data.jpa.repository.JpaRepository;


import net.javabeat.spring.data.domain.Canoe;

public interface CanoeRepository extends JpaRepository<Canoe,Long>{

}
