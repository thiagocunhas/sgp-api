package com.sgp.api.service;

import java.time.LocalDate;
import java.time.Period;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.sgp.api.Dto.UsuarioDto;
import com.sgp.api.model.Usuario;

public class UsuarioService {
    
public UsuarioDto obterDadosUsuarioPeloId(Long id) {
    Optional<Usuario> usuarioOpt = usuarioRepository.findById(id);

    if (usuarioOpt.isPresent()){
        Usuario usuario = usuarioOpt.get();

        UsuarioDto dto = new UsuarioDto();

        dto.setId(usuario.getId());
        dto.setNome(usuario.getNome());
        dto.setEmail(usuario.getEmail());
        dto.setCpf(usuario.getCpf());
        dto.setDataNascimento(usuario.getDataNascimento());
        dto.setStatus(usuario.getStatus());

        LocalDate dataAtual = LocalDate.now();
        LocalDate dataNascimento = usuario.getDataNascimento();

        Period periodo = Period.between(dataNascimento, dataAtual);

        dto.setIdade(periodo.getYears());

        return dto;

    }

 return null;

}

public void excluirUsuario(Long id) {
    usuarioRepository.deleteById(id);
    
}

public Usuario salvUsuario (Usuario usuario) {
    return usuarioRepository.save(usuario);

}

@Autowired
private UsuarioRepository usuarioRepository;

}
