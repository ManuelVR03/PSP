package com.ejemplos.DTO;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ejemplos.modelo.Sendero;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class SenderoDTOConverter {

	@Autowired
	private ModelMapper modelMapper;
	
	public SenderoDTO convertirADto(Sendero sendero) {
		return modelMapper.map(sendero, SenderoDTO.class);
	}
	
	public SenderoDTOWeb convertirADtoWeb(Sendero sendero) {
		return modelMapper.map(sendero, SenderoDTOWeb.class);
	}
	
	public Sendero convertirASend(CreateSenderoDTO createSenderoDto) {
		return modelMapper.map(createSenderoDto, Sendero.class);
	}
}
