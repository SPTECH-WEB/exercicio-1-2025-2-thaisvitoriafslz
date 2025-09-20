package school.sptech.prova_ac1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<Usuario>> buscarTodos() {
        List<Usuario> usuarios = usuarioService.listarTodosUsuarios();
        return ResponseEntity.ok(usuarios);
    }

    @PostMapping
    public ResponseEntity<Usuario> criar(@RequestBody Usuario usuario) {
        Usuario usuarioCadastrado = usuarioService.cadastrarUsuario(usuario);
        if (usuarioCadastrado == null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioCadastrado);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> buscarPorId(@PathVariable Integer id) {
        Optional<Usuario> usuario = usuarioService.buscarUsuarioPorId(id);
        if (usuario.isPresent()) {
            return ResponseEntity.ok(usuario.get());
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        boolean excluido = usuarioService.excluirUsuario(id);
        if (excluido) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/filtro-data")
    public ResponseEntity<List<Usuario>> buscarPorDataNascimento(
            @RequestParam("nascimento") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate nascimento) {
        List<Usuario> usuarios = usuarioService.buscarPorDataNascimentoMaiorQue(nascimento);
        return ResponseEntity.ok(usuarios);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> atualizar(
            @PathVariable Integer id,
            @RequestBody Usuario usuario
    ) {
        try {
            Usuario usuarioAtualizado = usuarioService.atualizarUsuario(id, usuario);
            if (usuarioAtualizado == null) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(usuarioAtualizado);
        } catch (RuntimeException e) {
            if ("CONFLICT".equals(e.getMessage())) {
                return ResponseEntity.status(HttpStatus.CONFLICT).build();
            }
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}

