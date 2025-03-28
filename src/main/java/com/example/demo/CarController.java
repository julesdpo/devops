package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cars")
public class CarController {

    // Liste des voitures simulée (normalement, ça viendrait d'une base de données)
    private List<Car> cars = new ArrayList<>(List.of(
        new Car("AA11BB", "Ferrari", 100),
        new Car("BB22CC", "Tesla", 80),
        new Car("CC33DD", "BMW", 90)
    ));

    // 🔹 1️⃣ Récupérer toutes les voitures disponibles
    @GetMapping
    public List<Car> listAvailableCars() {
        return cars.stream().filter(car -> !car.isRented()).collect(Collectors.toList());
    }

    // 🔹 2️⃣ Obtenir les détails d'une voiture
    @GetMapping("/{plateNumber}")
    public Car getCarDetails(@PathVariable String plateNumber) throws Exception {
        return cars.stream()
                   .filter(c -> c.getPlateNumber().equalsIgnoreCase(plateNumber))
                   .findFirst()
                   .orElseThrow(() -> new Exception("Car not found"));
    }

    // 🔹 3️⃣ Louer ou rendre une voiture
    @PutMapping("/{plateNumber}")
    public String rentOrReturnCar(
        @PathVariable String plateNumber,
        @RequestParam boolean rent,
        @RequestBody(required = false) Dates dates
    ) throws Exception {
        Car car = getCarDetails(plateNumber);

        if (rent) {
            if (car.isRented()) return "❌ Cette voiture est déjà louée.";
            car.setRented(true);
            car.setDates(dates);
            return "✅ Voiture louée avec succès.";
        } else {
            if (!car.isRented()) return "❌ Cette voiture n'était pas louée.";
            car.setRented(false);
            car.setDates(null);
            return "✅ Voiture rendue avec succès.";
        }
    }
}
