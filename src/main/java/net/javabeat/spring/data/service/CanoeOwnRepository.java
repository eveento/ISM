package net.javabeat.spring.data.service;

import net.javabeat.spring.data.domain.Canoe;
import net.javabeat.spring.data.domain.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.Repository;


import java.util.List;

public interface CanoeOwnRepository extends Repository<Canoe, Long>{


    @Query(value = "from Canoe c where c.id=:id")
    Canoe getCanoeById(@Param("id") long id);

    @Query(value = "from Canoe c where c.size=:size")
    List<Canoe> getCanoeBySize(@Param("size") String size);
    
    @Query(value = "from Canoe")
    List<Canoe> getAllCanoes();

    @Query(value="from Canoe c where c.status=:status")
    List<Canoe> getCanoeByStatus(@Param("status") int status);

    @Modifying
    @Query(value="update Canoe c Set c.url=?2 where c.id=?1")
    void uploadCanoeImage(long id, String href);

    @Modifying
    @Query(value="update Canoe c Set c.status=?2 where c.id=?1")
    void updateStatus(long id, int status);
}
