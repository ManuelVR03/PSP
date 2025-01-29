package com.ejemplos.DTO;

import lombok.*;

@Getter
@Setter
public class EmpleadoDTO {
    private Long id;
    private String nombre;
    private String email;
    private double salario;
    private String departamentoNombre;
    private String proyectoNombre;
}