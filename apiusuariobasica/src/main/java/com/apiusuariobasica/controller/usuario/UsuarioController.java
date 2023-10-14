package com.apiusuariobasica.controller.usuario;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.apiusuariobasica.controller.usuario.request.UsuarioRequest;
import com.apiusuariobasica.controller.usuario.response.UsuarioResponse;
import com.apiusuariobasica.service.usuario.UsuarioService;

@RequestMapping("/autenticar")
@RestController
public class UsuarioController {

	@Autowired
	UsuarioService usuarioService;
	
	@PostMapping("/salvarusuario")                                                                                          //|-----------------------------------------------------------------------------------------//
	public ResponseEntity<UsuarioResponse> cadastroUsuario(@RequestBody @Validated UsuarioRequest usuarioRequest,           //|Os dados passados como UsuarioRequest não caem diretamente dentro de 					//
			UriComponentsBuilder UriBuilder) throws Exception {                                                             //|UsuarioResponse, eles são utilizados para criar um novo objeto do tipo Usuario e esse 	//
																															//|objeto é o que é retornado como UsuarioResponse.											//
		UsuarioResponse usuario = usuarioService.save(usuarioRequest);														//|Sim, corpo da requisição pode ser comparado a um formulário que está esperando para ser 	//
																															//|preenchido, é onde os dados enviados pelo cliente são armazenados e enviados para o		//
		URI uri = UriBuilder.path("usuario/{id}").buildAndExpand(usuario.getId()).toUri();									//|servidor para serem processados.		
																															//
																															//|-----------------------------------------------------------------------------------------//
		return ResponseEntity.created(uri).body(usuario);																	
		
	}
	
	@GetMapping("/buscarusuario")
	public List<UsuarioResponse> listar() {
		return usuarioService.search();
	}
	
	@GetMapping("/buscarusuario/{id}")
	public ResponseEntity<UsuarioResponse> buscarPorId(@PathVariable Long id) {
	UsuarioResponse usuario = usuarioService.getById(id);
	if(usuario == null) {
	return ResponseEntity.notFound().build();
	}
	return ResponseEntity.ok(usuario);
	}
	
}
