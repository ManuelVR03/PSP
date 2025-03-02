package com.ejemplos.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="empleado")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Empleado {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;

    private Float salario;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_jefe")
    private Empleado jefe;

}
