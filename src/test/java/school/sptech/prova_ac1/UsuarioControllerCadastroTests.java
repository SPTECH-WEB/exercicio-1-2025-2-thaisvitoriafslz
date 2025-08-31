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
import school.sptech.prova_ac1.fixture.UsuarioCadastroFixture;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@DBRider
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@DisplayName("1. [Usuario] cadastro")
public class UsuarioControllerCadastroTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @ParameterizedTest(
            name = "O cadastro do usuário com nome {0}, email {1}, cpf {2}, senha {3} e data de nascimento {4} deve ser realizado com sucesso"
    )
    @MethodSource("school.sptech.prova_ac1.fixture.UsuarioCadastroFixture#gerarAtributos")
    @DisplayName("1.1. Deve cadastrar usuário corretamente")
    void deveCadastrarUsuarioCorretamente(
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

        mockMvc.perform(post("/usuarios")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(usuario)))
                .andExpect(status().isCreated());
    }

    @Test
    @DataSet(value = "data/cadastro/inicial.json", cleanBefore = true, cleanAfter = true)
    @ExpectedDataSet(value = "data/cadastro/inicial.json")
    @DisplayName("1.2. Deve impedir cadastro de usuário com email já existente")
    void deveImpedirCadastroDeUsuarioComEmailJaExistente() throws Exception {
        Object object = UsuarioCadastroFixture.gerarUsuario(
                "Serjão dos foguetes",
                "eduardo@sterblitch.com",
                "67867867111",
                "zorra123",
                "1987-01-15"
        );

        mockMvc.perform(post("/usuarios")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(object)))
                .andExpect(status().isConflict());
    }

    @Test
    @DataSet(value = "data/cadastro/inicial.json", cleanBefore = true, cleanAfter = true)
    @ExpectedDataSet(value = "data/cadastro/inicial.json")
    @DisplayName("1.3. Deve impedir cadastro de usuário com cpf já existente")
    void deveImpedirCadastroDeUsuarioComCpfJaExistente() throws Exception {
        Object object = UsuarioCadastroFixture.gerarUsuario(
                "Serjão dos foguetes",
                "space@today.com",
                "67867867867",
                "elon é um gênio cara",
                "1987-01-15"
        );

        mockMvc.perform(post("/usuarios")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(object)))
                .andExpect(status().isConflict());
    }

    @Test
    @DataSet(value = "data/cadastro/inicial.json", cleanBefore = true, cleanAfter = true)
    @ExpectedDataSet(value = "data/cadastro/inicial.json")
    @DisplayName("1.4. Deve impedir cadastro de usuário com cpf e email já existentes")
    void deveImpedirCadastroDeUsuarioComCpfEEmailJaExistente() throws Exception {
        Object object = UsuarioCadastroFixture.gerarUsuario(
                "Serjão dos foguetes",
                "eduardo@sterblitch.com",
                "67867867867",
                "zorra123",
                "1987-01-15"
        );

        mockMvc.perform(post("/usuarios")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(object)))
                .andExpect(status().isConflict());
    }

    @Test
    @DataSet(value = "data/cadastro/inicial-2.json", cleanBefore = true, cleanAfter = true)
    @ExpectedDataSet(value = "data/cadastro/final-2.json")
    @DisplayName("1.5. Deve cadastrar corretamente [Teste DB]")
    void deveCadastrarUsuarioCorretamente() throws Exception {
        Object bobBurnquist = UsuarioCadastroFixture.gerarUsuario(
                "Bob Burnquist",
                "bob@burn.com",
                "0123012345678",
                "megaRampaÉFicha...",
                "1976-10-10"
        );

        mockMvc.perform(post("/usuarios")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(bobBurnquist)))
                .andExpect(status().isCreated());
    }
}
