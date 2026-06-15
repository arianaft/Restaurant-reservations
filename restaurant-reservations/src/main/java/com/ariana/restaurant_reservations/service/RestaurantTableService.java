package com.ariana.restaurant_reservations.service;

import com.ariana.restaurant_reservations.model.RestaurantTable;
import com.ariana.restaurant_reservations.repository.RestauranTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


//Componente de servicio
@Service
public class RestaurantTableService {
    @Autowired
    private RestauranTableRepository restaurantTableRepository;

    //Método devuelve todas las mesas
    public List<RestaurantTable> getAllTable(){
        return restaurantTableRepository.findAll();
    }

    //Método buscar mesa por id
    public Optional<RestaurantTable> getTableById(Long id){
        return restaurantTableRepository.findById(id);

    }

    //Método crear mesa
    public  RestaurantTable createTable(RestaurantTable table){
        return restaurantTableRepository.save(table);
    }


    //Método eliminar mesa
    public void deleteTable(Long id){
        restaurantTableRepository.deleteById(id);
    }


}
