package com.ejemplos.DTO;



import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ejemplos.modelo.Producto;


import lombok.RequiredArgsConstructor;

@Component 
@RequiredArgsConstructor
public class ProductoDTOConverter {
	
	
  
    @Autowired
    private ModelMapper modelMapper;
	
		
	public ProductoDTO convertirADto(Producto producto) {
		return modelMapper.map(producto, ProductoDTO.class);
		
	}
	
	public Producto convertirAProd(CreateProductoDTO createProductoDto) {
		return modelMapper.map(createProductoDto, Producto.class);
		
	}

}
