package school.sptech.prova_ac1;

import com.github.database.rider.core.api.dataset.DataSet;
import com.github.database.rider.spring.api.DBRider;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import java.util.stream.Stream;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@DBRider
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@DisplayName("3. [Usuario] Busca por ID")
public class UsuarioControllerBuscaPorIdTests {

    @Autowired
    private MockMvc mockMvc;

    @ParameterizedTest(
            name = "O usuário com ID {0} deve ser retornado com sucesso"
    )
    @MethodSource("gerarIdsValidos")
    @DisplayName("3.1. Deve retornar usuário com sucesso")
    @DataSet(value = "data/id/inicial.json", cleanBefore = true, cleanAfter = true)
    void deveRetornarStatus200EUsuario(Integer id) throws Exception {
        mockMvc.perform(get("/usuarios/{id}", id))
                .andExpect(status().isOk());
    }

    @ParameterizedTest(
            name = "O usuário com ID {0} não deve ser encontrado"
    )
    @MethodSource("gerarIdsInvalidos")
    @DisplayName("3.2. Não deve retornar usuário")
    @DataSet(value = "data/id/inicial.json", cleanBefore = true, cleanAfter = true)
    void deveRetornarStatus404(Integer id) throws Exception {
        mockMvc.perform(get("/usuarios/{id}", id))
                .andExpect(status().isNotFound());
    }

    public static Stream<Integer> gerarIdsValidos() {
        return Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    }

    public static Stream<Integer> gerarIdsInvalidos() {
        return Stream.of(0, 11, 22, 13, 24, 25, 101, 27, 28, 9999, 30, -1);
    }
}
