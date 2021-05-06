package co.accenture.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.accenture.api.dto.ClienteDto;
import co.accenture.api.model.Cliente;
import co.accenture.api.repository.IClienteRepository;

@Service
public class ClienteService implements IClienteService{

	@Autowired
	private IClienteRepository clienteRepository;
	
	@Override
	public List<ClienteDto> getAll() {
		List<Cliente> clientes = clienteRepository.findAll();
		List<ClienteDto> clientesDto = new ArrayList<>();
		clientes.forEach(c -> {
			ClienteDto cl = new ClienteDto();
			cl.setCedula(c.getCedula());
			cl.setNombre(c.getNombre());
			cl.setApellido(c.getApellido());
			cl.setDireccion(c.getDireccion());
			cl.setEmail(c.getEmail());
			clientesDto.add(cl);
		});
		return clientesDto;
	}
}
