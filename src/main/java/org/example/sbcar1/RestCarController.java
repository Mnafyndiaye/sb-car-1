package org.example.sbcar1;  // Adaptez selon votre package

import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cars")
public class RestCarController {
    private List<Car> cars = new ArrayList<>();

    public RestCarController() {
        // Initialisation avec quelques voitures
        cars.add(new Car("1", "Toyota", "Corolla", 2020, "Blanc"));
        cars.add(new Car("2", "Honda", "Civic", 2019, "Noir"));
        cars.add(new Car("3", "Ford", "Mustang", 2021, "Rouge"));
        cars.add(new Car("4", "Tesla", "Model 3", 2022, "Bleu"));
    }

    // 1) RECHERCHER toutes les voitures
    @GetMapping
    public List<Car> getAllCars() {
        return cars;
    }

    // 2) RECHERCHER une voiture par son ID
    @GetMapping("/{id}")
    public Optional<Car> getCarById(@PathVariable String id) {
        return cars.stream()
                .filter(car -> car.getId().equals(id))
                .findFirst();
    }

    // 3) CRÉER une nouvelle voiture
    @PostMapping
    public Car createCar(@RequestBody Car car) {
        cars.add(car);
        return car;
    }

    // 4) MODIFIER une voiture existante
    @PutMapping("/{id}")
    public Car updateCar(@PathVariable String id, @RequestBody Car car) {
        // Supprimer l'ancienne voiture si elle existe
        cars.removeIf(c -> c.getId().equals(id));
        // Ajouter la nouvelle voiture
        cars.add(car);
        return car;
    }

    // 5) SUPPRIMER une voiture
    @DeleteMapping("/{id}")
    public void deleteCar(@PathVariable String id) {
        cars.removeIf(c -> c.getId().equals(id));
    }
}