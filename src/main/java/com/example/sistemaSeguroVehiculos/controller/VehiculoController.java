package com.example.sistemaSeguroVehiculos.controller;

import com.example.sistemaSeguroVehiculos.entity.Vehiculo;
import com.example.sistemaSeguroVehiculos.service.VehiculoService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/vehiculos")
public class VehiculoController {

    @Autowired
    private VehiculoService vehiculoService;


    @PostMapping("/register")
    public ResponseEntity<?>registerProduct(@RequestBody Vehiculo vehiculo){
        Vehiculo newVehiculo = vehiculoService.registerVehiculo(vehiculo);
        return ResponseEntity.status(HttpStatus.CREATED).body(newVehiculo); //Retorna el vehiculo creado en el estatus 284
    }

    @GetMapping("/list")
    public ResponseEntity<List<Vehiculo>> listVehiculo() {
        List<Vehiculo> vehiculos = vehiculoService.listVehiculo();
        return ResponseEntity.ok(vehiculos); // Retornar la lista de vehiculos con el status 200 ok
    }

    @GetMapping("/search/modelo/{vehiculoModelo}")
    public ResponseEntity<?> searchProductByModelo(@PathVariable String vehiculoModelo) {
        Optional<Vehiculo> vehiculo = vehiculoService.searchVehiculoByModelo(vehiculoModelo);
        return vehiculo.isPresent()
                ? ResponseEntity.ok(vehiculo.get())
                : ResponseEntity.status(HttpStatus.NOT_FOUND).body("Vehiculo no encontrado.");
    }

    @GetMapping("/search/id/{idVehiculo}")
    public ResponseEntity<?> searchVehiculoById(@PathVariable Long idVehiculo) {
        Optional<Vehiculo> vehiculo = vehiculoService.searchVehiculoById(idVehiculo);
        return vehiculo.isPresent()
                ? ResponseEntity.ok(vehiculo.get())
                : ResponseEntity.status(HttpStatus.NOT_FOUND).body("Vehiculo no encontrado.");
    }

    @PutMapping("/update/{idVehiculo}")
    public ResponseEntity<?> updateVehiculo(@PathVariable Long idVehiculo, @RequestBody Vehiculo vehiculo) {
        try {
            Vehiculo updateVehiculo = new Vehiculo();
            updateVehiculo.setVehiculoPlaca(vehiculo.getVehiculoPlaca());
            updateVehiculo.setVehiculoMarca(vehiculo.getVehiculoMarca());
            updateVehiculo.setVehiculoModelo(vehiculo.getVehiculoModelo());
            updateVehiculo.setVehiculoAño(vehiculo.getVehiculoAño());
            updateVehiculo.setVehiculoColor(vehiculo.getVehiculoColor());

            Vehiculo vehiculoDB = vehiculoService.updateVehiculo(idVehiculo, updateVehiculo);
            return ResponseEntity.ok(vehiculoDB);

        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
        }
    }

    @DeleteMapping("/delete/{idVehiculo}")
    public ResponseEntity<?> deleteVehiculo(@PathVariable Long idVehiculo) {
        try {
            vehiculoService.deleteVehiculo(idVehiculo);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
        }
    }
}