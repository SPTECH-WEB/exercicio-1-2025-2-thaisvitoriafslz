package school.sptech.prova_ac1;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface UsuarioRepository {
    Usuario save(Usuario usuario);
    List<Usuario> findAll();
    Optional<Usuario> findById(Integer id);
    void deleteById(Integer id);
    boolean existsByEmail(String email);
    boolean existsByCpf(String cpf);
    boolean existsByEmailAndIdNot(String email, Integer id);
    boolean existsByCpfAndIdNot(String cpf, Integer id);
    List<Usuario> findByDataNascimentoAfter(LocalDate data);
}
