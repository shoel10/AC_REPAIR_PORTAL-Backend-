package com.examly.springapp.model;


import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="devices")

public class Device {

    @Id
   @Column(name="id")

    private long id;

    @Column(name="brand")
    private String brand;

    @Column(name="type")
    private String type;

    @Column(name="model")
    private String model;

}
