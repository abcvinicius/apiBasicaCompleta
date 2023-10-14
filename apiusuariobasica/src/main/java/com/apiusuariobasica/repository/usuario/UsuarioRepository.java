package com.apiusuariobasica.repository.usuario;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apiusuariobasica.model.usuario.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

	boolean existsByEmail(String email);
}
