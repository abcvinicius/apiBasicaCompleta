
/*
package com.apiusuariobasica.service.implementation;


import com.apiusuariobasica.exception.RegraDeNegocioException;
import com.apiusuariobasica.repository.usuario.UsuarioRepository;

public class UsuarioServiceImplementation  {
	
	private UsuarioRepository usuarioRepository;
	
	public UsuarioServiceImplementation(UsuarioRepository usuarioRepository) {
		super();
		this.usuarioRepository = usuarioRepository;
	}
	
	//------------------------------------------------------------------//
	public void validarEmail(String email) {
		boolean existe = usuarioRepository.existsByEmail(email);
		if (existe) {
			throw new RegraDeNegocioException("Já existe um usuário cadastrado com esse email.");
		}
		
	}

}
*/