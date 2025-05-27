package com.sgp.api.Controller;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.sgp.api.Dto.UsuarioDto;
import com.sgp.api.model.Usuario;
import com.sgp.api.service.UsuarioService;

public class UsuarioController {
    
@GetMapping
public ResponseEntity<List<UsuarioDto>> listarUsuarios() {
    return ResponseEntity.ok().body(UsuarioService.carregarUsuariosCadastrados());
    
}

@GetMapping("/{id}")
public ResponseEntity<UsuarioDto> buscarUsuarioPeloId(@PathVariable("id") Long id){
    UsuarioDto usuario = UsuarioService.obterDadosUsuarioPeloId(id);

    if  (Objects.isNull(usuario)) {
        return ResponseEntity.notFound().build();

    }
 
    return ResponseEntity.status(HttpStatus.OK).body(usuario);

}

@DeleteMapping("/{id}")
public ResponseEntity<Void> deletarUsuario(@PathVariable("id") Long id) {
    UsuarioDto usuario = UsuarioService.obterDadosUsuarioPeloId(id);

    if (Objects.isNull(usuario)) {
        return ResponseEntity.notFound().build();

    }

    UsuarioService.excluirUsuario(id);

    return ResponseEntity.noContent().build();

}

@PostMapping
public ResponseEntity<Usuario> cadastrarUsuario(@RequestBody Usuario usuario) {
    return ResponseEntity.status(HttpStatus.CREATED).body(UsuarioService.salvarUsuario(usuario));

}

@PutMapping("/{id}")
public ResponseEntity<Usuario> atualizarUsuario(@PathVariable("id") Long id, @RequestBody Usuario);
   UsuarioDto usuario = usuarioService.obterDadosUsuarioPeloId(id);

   if (Objects.isNull(usuario)) {
      return ResponseEntity.notFound().build();
      
   }

@Autowired
private UsuarioService usuarioService;


}
