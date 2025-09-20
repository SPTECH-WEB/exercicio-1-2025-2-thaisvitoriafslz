package school.sptech.prova_ac1;

import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Repository
public class UsuarioRepository {
    private final Map<Integer, Usuario> usuarios = new HashMap<>();
    private final AtomicInteger contador = new AtomicInteger(1);

    public Usuario save(Usuario usuario) {
        if (usuario.getId() == null) {
            usuario.setId(contador.getAndIncrement());
        }
        usuarios.put(usuario.getId(), usuario);
        return usuario;
    }

    public List<Usuario> findAll() {
        return new ArrayList<>(usuarios.values());
    }

    public Optional<Usuario> findById(Integer id) {
        return Optional.ofNullable(usuarios.get(id));
    }

    public void deleteById(Integer id) {
        usuarios.remove(id);
    }

    public boolean existsByEmail(String email) {
        return usuarios.values().stream()
                .anyMatch(u -> u.getEmail().equals(email));
    }

    public boolean existsByCpf(String cpf) {
        return usuarios.values().stream()
                .anyMatch(u -> u.getCpf().equals(cpf));
    }

    public boolean existsByEmailAndIdNot(String email, Integer id) {
        return usuarios.values().stream()
                .anyMatch(u -> u.getEmail().equals(email) && !u.getId().equals(id));
    }

    public boolean existsByCpfAndIdNot(String cpf, Integer id) {
        return usuarios.values().stream()
                .anyMatch(u -> u.getCpf().equals(cpf) && !u.getId().equals(id));
    }

    public List<Usuario> findByDataNascimentoAfter(LocalDate data) {
        return usuarios.values().stream()
                .filter(u -> u.getDataNascimento().isAfter(data))
                .collect(Collectors.toList());
    }
}