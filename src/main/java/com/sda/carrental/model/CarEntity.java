package com.sda.carrental.model;

import com.sda.carrental.model.enums.CarType;
import com.sda.carrental.model.enums.Transmission;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "cars")
public class CarEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "car_id", nullable = false)
    private Long carId;

    @Column(name = "make")
    private String make;

    @Column(name = "model")
    private String model;

    @Enumerated(EnumType.STRING)
    @Column(name = "transmission")
    private Transmission transmission;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private CarType carType;

    @Column(name = "production_year")
    private String productionYear;

    @Column(name = "price_per_day")
    private BigDecimal pricePerDay;
}
