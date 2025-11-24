package com.example.sistemaSeguroVehiculos.repository;/*
un repositorio es una interfaz que define metodos para interactuar
con la base de datos extiende JpaRepository para promocionar operaciones CRUD y consultas personalizadas
 */

import com.example.sistemaSeguroVehiculos.entity.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository // indica que esta interfaz es un respositorio de Spring
public interface VehiculoRepository extends JpaRepository<Vehiculo, Long>{

    Optional<Vehiculo> findByVehiculoModelo(String vehiculoModelo);

    Optional<Vehiculo> findByIdVehiculo(Long idVehiculo);

}