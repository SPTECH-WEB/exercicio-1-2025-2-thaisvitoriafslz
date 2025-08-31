package school.sptech.prova_ac1;


import com.github.database.rider.core.api.dataset.DataSet;
import com.github.database.rider.core.api.dataset.ExpectedDataSet;
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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@DBRider
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@DisplayName("4. [Usuario] Remoção")
public class UsuarioControllerDeleteTests {

    @Autowired
    private MockMvc mockMvc;

    @ParameterizedTest(
            name = "O usuário com ID {0} deve ser removido com sucesso"
    )
    @MethodSource("gerarIdsValidos")
    @DisplayName("4.1. Deve remover usuário com sucesso")
    @DataSet(value = "data/remocao/inicial-1.json", cleanBefore = true, cleanAfter = true)
    void deveRemoverCorretamente(int id) throws Exception {
        mockMvc.perform(delete("/usuarios/{id}", id))
                .andExpect(status().isNoContent());
    }


    @ParameterizedTest(
            name = "O usuário com ID {0} não deve ser removido com sucesso"
    )
    @MethodSource("gerarIdsInvalidos")
    @DisplayName("4.2. Não deve remover usuário")
    @DataSet(value = "data/remocao/inicial-1.json", cleanBefore = true, cleanAfter = true)
    @ExpectedDataSet(value = "data/remocao/inicial-1.json")
    void naoDeveRemoverCorretamente(int id) throws Exception {
        mockMvc.perform(delete("/usuarios/{id}", id))
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("4.3. Deve remover usuário com sucesso [DB]")
    @DataSet(value = "data/remocao/inicial-1.json", cleanBefore = true, cleanAfter = true)
    @ExpectedDataSet(value = "data/remocao/final-1.json")
    void deveRemoverCorretamenteDb() throws Exception {
        mockMvc.perform(delete("/usuarios/{id}", 7))
                .andExpect(status().isNoContent());
    }

    public static Stream<Integer> gerarIdsValidos() {
        return Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    }

    public static Stream<Integer> gerarIdsInvalidos() {
        return Stream.of(0, 51, 22, 87, 24, 25, 101, 27, 28, 9999, 30, -1);
    }
}
