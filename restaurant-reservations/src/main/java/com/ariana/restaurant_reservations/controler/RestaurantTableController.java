package com.ariana.restaurant_reservations.controler;

import com.ariana.restaurant_reservations.model.RestaurantTable;
import com.ariana.restaurant_reservations.service.RestaurantTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tables")

public class RestaurantTableController {
    @Autowired
    private RestaurantTableService restaurantTableService;

    //Endpoint GET

    @GetMapping
    public ResponseEntity<List<RestaurantTable>> getAllTables(){

        return ResponseEntity.ok(restaurantTableService.getAllTable());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RestaurantTable> getTableById(@PathVariable Long id){
        return restaurantTableService.getTableById(id)
                .map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());

    }

    //Endpoint POST

    @PostMapping
    public ResponseEntity<RestaurantTable> createTable(@RequestBody RestaurantTable table){
        return ResponseEntity.status(HttpStatus.CREATED).body(restaurantTableService.createTable(table));
    }


    //Endpoint DELETE
    @DeleteMapping ("/{id}")
    public ResponseEntity<Void> deleteTable(@PathVariable Long id){
        restaurantTableService.deleteTable(id);
        return ResponseEntity.noContent().build();

    }



}

