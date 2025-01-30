package com.ejemplos.DTO;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ejemplos.modelo.DepartamentoRepositorio;
import com.ejemplos.modelo.Empleado;
import com.ejemplos.modelo.ProyectoRepositorio;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class EmpleadoDTOConverter {

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
    private DepartamentoRepositorio departamentoRepository;
	
	@Autowired
    private ProyectoRepositorio proyectoRepository;

    // Configurar ModelMapper para mapear departamento_id a una entidad Departamento
    @PostConstruct
    public void setupMapper() {
        modelMapper.addMappings(new PropertyMap<CreateEmpleadoDTO, Empleado>() {
            @Override
            protected void configure() {
                map().setNombre(source.getNombre());
                map().setEmail(source.getEmail());
                map().setSalario(source.getSalario());

                using(ctx -> {
                    Long departamentoId = (Long) ctx.getSource();
                    return departamentoRepository.findById(departamentoId)
                        .orElseThrow(() -> new RuntimeException("Departamento no encontrado"));
                }).map(source.getDepartamento_id(), destination.getDepartamento());
                
                using(ctx -> {
                    Long proyectoId = (Long) ctx.getSource();
                    return proyectoRepository.findById(proyectoId)
                        .orElseThrow(() -> new RuntimeException("Proyecto no encontrado"));
                }).map(source.getProyecto_id(), destination.getProyecto());
            }
        });
    }
	
	public EmpleadoDTO convertirADTO(Empleado empleado) {
		return modelMapper.map(empleado, EmpleadoDTO.class);
	}
	
	public Empleado convertirAEmpl(CreateEmpleadoDTO empleado) {
		return modelMapper.map(empleado, Empleado.class);
	}
}
