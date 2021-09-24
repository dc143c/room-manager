package com.digital.innovation.one.reunion.manager.repository;

import com.digital.innovation.one.reunion.manager.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {

}
