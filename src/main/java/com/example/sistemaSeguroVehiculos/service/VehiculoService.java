package com.example.sistemaSeguroVehiculos.service;

import com.example.sistemaSeguroVehiculos.entity.Vehiculo;

import java.util.List;
import java.util.Optional;

public interface VehiculoService {

    Vehiculo registerVehiculo(Vehiculo vehiculo); //metodo para registrar un nuevo producto

    List<Vehiculo> listVehiculo(); //METODO PARA ALISTAR TODOS LOS PRODUCTOS

    Optional<Vehiculo> searchVehiculoByModelo(String name); //Para buscar un producto por nombre

    Optional<Vehiculo>searchVehiculoById(Long idVehiculo); //Metodo para buscar un producto por ID

    Vehiculo updateVehiculo(Long idVehiculo, Vehiculo vehiculo);//Metodo para actualizar un producto existente

    void deleteVehiculo(Long idVehiculo); //Metodo para eleminiar un producto por su ID
}