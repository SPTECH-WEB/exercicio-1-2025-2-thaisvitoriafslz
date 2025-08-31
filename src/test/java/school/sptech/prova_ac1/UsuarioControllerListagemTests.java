package school.sptech.prova_ac1;

import com.github.database.rider.core.api.dataset.DataSet;
import com.github.database.rider.core.api.dataset.ExpectedDataSet;
import com.github.database.rider.spring.api.DBRider;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@DBRider
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@DisplayName("2. [Usuario] Listagem")
public class UsuarioControllerListagemTests {

    @Autowired
    private MockMvc mockMvc;

    private final String URL = "/usuarios";

    @Test
    @DataSet(value = "data/listagem/inicial.json", cleanBefore = true, cleanAfter = true)
    @ExpectedDataSet(value = "data/listagem/inicial.json")
    @DisplayName("2.1. Deve retornar status 200 e lista de usuários")
    void deveRetornarStatus200EListaDeUsuarios() throws Exception {
        mockMvc.perform(get("/usuarios"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(10)));
    }

    @Test
    @DisplayName("2.3. Deve retornar status 204 e lista de usuários vazia")
    @DataSet(value = "data/listagem/vazio.json", cleanBefore = true, cleanAfter = true)
    @ExpectedDataSet(value = "data/listagem/vazio.json")
    void deveRetornarStatus204EListaDeUsuariosVazia() throws Exception {
        mockMvc.perform(get("/usuarios"))
                .andExpect(status().isNoContent());
    }
}
