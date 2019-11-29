package com.gouveia.bancobuilder.repository;

import com.gouveia.bancobuilder.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, String> {
    Usuario findById(int id);
}
