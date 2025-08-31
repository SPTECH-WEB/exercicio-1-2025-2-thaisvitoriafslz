package school.sptech.prova_ac1;

import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.List;

public class UsuarioController {

    public ResponseEntity<List<Usuario>> buscarTodos() {
        return ResponseEntity.internalServerError().build();
    }

    public ResponseEntity<Usuario> criar(Usuario usuario) {
        return ResponseEntity.internalServerError().build();
    }

    public ResponseEntity<Usuario> buscarPorId(Integer id) {
        return ResponseEntity.internalServerError().build();
    }

    public ResponseEntity<Void> deletar(Integer id) {
        return ResponseEntity.internalServerError().build();
    }

    public ResponseEntity<List<Usuario>> buscarPorDataNascimento(LocalDate nascimento) {
        return ResponseEntity.internalServerError().build();
    }

    public ResponseEntity<Usuario> atualizar(
            Integer id,
            Usuario usuario
    ) {
        return ResponseEntity.internalServerError().build();
    }
}
