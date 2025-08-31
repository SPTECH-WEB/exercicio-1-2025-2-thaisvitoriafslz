package school.sptech.prova_ac1;

import com.github.database.rider.core.api.dataset.DataSet;
import com.github.database.rider.spring.api.DBRider;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import java.util.stream.Stream;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.hamcrest.Matchers.hasSize;

@DBRider
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@DisplayName("5. [Usuario] Listagem por dataNascimento")
public class UsuarioControllerDataNascimentoTests {

    @Autowired
    private MockMvc mockMvc;

    @ParameterizedTest(
            name = "A data {0} deve retornar {1} registros com sucesso"
    )
    @MethodSource("gerarParametrosValidos")
    @DisplayName("5.1. Deve retornar usuário por data com sucesso")
    @DataSet(value = "data/nascimento/inicial-1.json", cleanBefore = true, cleanAfter = true)
    void deveRetornarStatus200EUsuario(String data, int quantidade) throws Exception {
        mockMvc.perform(get("/usuarios/filtro-data")
                        .param("nascimento", data))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(quantidade)));
    }

    @ParameterizedTest(
            name = "A data {0} não deve retornar registros"
    )
    @MethodSource("gerarParametrosInvalidos")
    @DisplayName("5.2. Não deve retornar usuários (204 No Content)")
    @DataSet(value = "data/nascimento/inicial-1.json", cleanBefore = true, cleanAfter = true)
    void deveRetornarStatus204(String data) throws Exception {
        mockMvc.perform(get("/usuarios/filtro-data")
                        .param("nascimento", data))
                .andExpect(status().isNoContent());
    }

    @Test
    @DisplayName("5.3. Não deve retornar usuários quando banco estiver vazio")
    @DataSet(value = "data/nascimento/vazio.json", cleanBefore = true, cleanAfter = true)
    void deveRetornarStatus204BancoVazio() throws Exception {
        mockMvc.perform(get("/usuarios/filtro-data")
                        .param("nascimento", "2000-01-01"))
                .andExpect(status().isNoContent());
    }


    public static Stream<Object[]> gerarParametrosValidos() {
        return Stream.of(
                new Object[]{"1985-01-01", 16},
                new Object[]{"1990-01-01", 12},
                new Object[]{"1995-01-01", 6},
                new Object[]{"2000-01-01", 2}
        );
    }

    public static Stream<Object[]> gerarParametrosInvalidos() {
        return Stream.of(
                new Object[]{"2025-01-01"},
                new Object[]{"2100-12-31"},
                new Object[]{"2010-06-15"},
                new Object[]{"2050-08-22"},
                new Object[]{"2023-05-10"}
        );
    }
}
