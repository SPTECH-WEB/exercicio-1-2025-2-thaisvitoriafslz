package school.sptech.prova_ac1;

import com.fasterxml.jackson.databind.ObjectMapper;
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
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@DBRider
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@DisplayName("6. [Usuario] Atualização")
public class UsuarioControllerAtualizacaoTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    @ParameterizedTest(
            name = "A atualização do usuário com com id {0} nome {1}, email {2}, cpf {3}, senha {4} e data de nascimento {5} deve ser realizado com sucesso"
    )
    @DataSet(value = "/data/atualizacao/inicial-1.json")
    @MethodSource("school.sptech.prova_ac1.fixture.UsuarioCadastroFixture#gerarAtributosAtualizacao")
    @DisplayName(" 6.1. Deve atualizar corretamente")
    void deveAtualizarCorretamente(
            Integer id,
            String nome,
            String email,
            String cpf,
            String senha,
            String dataNascimento
    ) throws Exception {

        Map<String, Object> usuario = new HashMap<>();
        usuario.put("nome", "%s - ATUALIZADO".formatted(nome));
        usuario.put("email", email);
        usuario.put("cpf", cpf);
        usuario.put("senha", senha);
        usuario.put("dataNascimento", LocalDate.parse(dataNascimento).plusYears(id));

        mockMvc.perform(put("/usuarios/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(usuario)))
                .andExpect(status().isOk());
    }

    @Test
    @DataSet(value = "/data/atualizacao/inicial-2.json", cleanAfter = true, cleanBefore = true)
    @ExpectedDataSet(value = "/data/atualizacao/final-2.json")
    @DisplayName(" 6.2. Deve atualizar considerando o id da URL")
    void deveAtualizarConsiderandoIdDaUrl() throws Exception {

        int idCorreto = 8;
        int idIncorreto = 7;

        Map<String, Object> usuario = new HashMap<>();
        usuario.put("id", idIncorreto);
        usuario.put("nome", "Casimiro Miguel é dieferente do Tirulipa");
        usuario.put("email", "casimiro@elite.com");
        usuario.put("cpf", "88899900011");
        usuario.put("senha", "Esquece, isso aqui é a elite");
        usuario.put("dataNascimento", LocalDate.parse("1993-10-20").plusYears(1));

        mockMvc.perform(put("/usuarios/{id}", idCorreto)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(usuario)))
                .andExpect(status().isOk());
    }

    @ParameterizedTest(
            name = "A atualização do usuário com com id {0} nome {1}, email {2}, cpf {3}, senha {4} e data de nascimento {5} não deve ser realizada"
    )
    @DataSet(value = "/data/atualizacao/inicial-1.json", cleanBefore = true, cleanAfter = true)
    @ExpectedDataSet(value = "/data/atualizacao/inicial-1.json")
    @MethodSource("school.sptech.prova_ac1.fixture.UsuarioCadastroFixture#gerarAtributosAtualizacaoInvalidos")
    @DisplayName(" 6.3. Deve atualizar corretamente")
    void deveImpedirAtualizacao(
            Integer id,
            String nome,
            String email,
            String cpf,
            String senha,
            String dataNascimento
    ) throws Exception {

        Map<String, Object> usuario = new HashMap<>();
        usuario.put("nome", nome);
        usuario.put("email", email);
        usuario.put("cpf", cpf);
        usuario.put("senha", senha);
        usuario.put("dataNascimento", LocalDate.parse(dataNascimento));

        mockMvc.perform(put("/usuarios/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(usuario)))
                .andExpect(status().isConflict());
    }
}
