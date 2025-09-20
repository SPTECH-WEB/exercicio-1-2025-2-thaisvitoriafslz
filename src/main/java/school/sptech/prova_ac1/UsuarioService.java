package school.sptech.prova_ac1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario cadastrarUsuario(Usuario usuario) {
        if (usuarioRepository.existsByEmail(usuario.getEmail()) ||
                usuarioRepository.existsByCpf(usuario.getCpf())) {
            return null; // Indica conflito
        }
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> listarTodosUsuarios() {
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> buscarUsuarioPorId(Integer id) {
        return usuarioRepository.findById(id);
    }

    public boolean excluirUsuario(Integer id) {
        if (usuarioRepository.findById(id).isPresent()) {
            usuarioRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<Usuario> buscarPorDataNascimentoMaiorQue(LocalDate data) {
        return usuarioRepository.findByDataNascimentoAfter(data);
    }

    public Usuario atualizarUsuario(Integer id, Usuario usuarioAtualizado) {
        Optional<Usuario> usuarioExistente = usuarioRepository.findById(id);
        if (!usuarioExistente.isPresent()) {
            return null; // Usuário não encontrado
        }

        // Verifica se email ou CPF já existem para outros usuários
        if (usuarioRepository.existsByEmailAndIdNot(usuarioAtualizado.getEmail(), id) ||
                usuarioRepository.existsByCpfAndIdNot(usuarioAtualizado.getCpf(), id)) {
            throw new RuntimeException("CONFLICT"); // Indica conflito
        }

        usuarioAtualizado.setId(id);
        return usuarioRepository.save(usuarioAtualizado);
    }
}