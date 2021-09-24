package com.digital.innovation.one.reunion.manager.controller;

import com.digital.innovation.one.reunion.manager.exception.ResourceNotFoundException;
import com.digital.innovation.one.reunion.manager.model.Room;
import com.digital.innovation.one.reunion.manager.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class RoomController {

    @Autowired
    private RoomRepository roomRepository;

    @GetMapping("/rooms")
    public List getAllRooms(){
        return roomRepository.findAll();
    }

    @GetMapping("/rooms/{id}")
    public ResponseEntity<Room> getRoomById(@PathVariable(value = "id") long id) throws ResourceNotFoundException {
        Room room = roomRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Room not found: " + id));
        return ResponseEntity.ok().body(room);
    }

    @PostMapping("/rooms")
    public Room createRoom(@Valid @RequestBody Room room) throws ResourceNotFoundException {
        return roomRepository.save(room);
    }

    @PutMapping("/rooms/{id}")
    public ResponseEntity<Room> getRoomById(@PathVariable(value = "id") long id, @Valid @RequestBody Room room) throws ResourceNotFoundException {
        Room roomFound = roomRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Room not found: " + id));
        roomRepository.save(room);
        return ResponseEntity.ok().body(room);
    }

    @DeleteMapping("/rooms/{id}")
    public Map<String, Boolean> deleteById(@PathVariable(value = "id") long id) throws ResourceNotFoundException {
        Room roomFound = roomRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Room not found: " + id));
        roomRepository.deleteById(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Deleted: " + id, Boolean.TRUE);
        return response;
    }
}
