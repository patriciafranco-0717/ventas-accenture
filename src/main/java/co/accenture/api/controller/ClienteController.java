package co.accenture.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import co.accenture.api.dto.ClienteDto;
import co.accenture.api.service.IClienteService;

@RestController
@RequestMapping("/cliente")
@CrossOrigin("*")
public class ClienteController {
	
	@Autowired
	private IClienteService clienteService;
	
	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	public List<ClienteDto> getAll(){
		return clienteService.getAll();
	}
}
