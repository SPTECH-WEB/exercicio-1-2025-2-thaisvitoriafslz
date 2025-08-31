package school.sptech.prova_ac1.fixture;

import java.lang.reflect.Method;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class UsuarioCadastroFixture {

    public static Stream<Object[]> gerarAtributosAtualizacao() {
        return Stream.of(
                new Object[]{1, "Felipe Neto", "felipe@neto.com", "11122233344", "cancelado123", "1988-01-21"},
                new Object[]{2, "Whindersson Nunes", "whindersson@nunes.com", "22233344455", "piada123", "1995-01-05"},
                new Object[]{3, "Juliette Freire", "juliette@bbb.com", "33344455566", "cacto123", "1989-12-03"},
                new Object[]{4, "Carlinhos Maia", "carlinhos@maia.com", "44455566677", "fofoca123", "1991-06-08"},
                new Object[]{5, "Lucas Rangel", "lucas@rangel.com", "55566677788", "trend123", "1997-05-09"},
                new Object[]{6, "Kéfera Buchmann", "kefera@buchmann.com", "66677788899", "livro123", "1993-07-25"},
                new Object[]{7, "Tirullipa", "tirullipa@comedia.com", "77788899900", "risada123", "1984-11-16"},
                new Object[]{8, "Casimiro Miguel", "casimiro@caze.com", "88899900011", "react123", "1993-10-20"},
                new Object[]{9, "Gkay", "gkay@farofa.com", "99900011122", "farofa123", "1992-12-03"},
                new Object[]{10, "Neymar Jr.", "neymar@poker.com", "00011122233", "drible123", "1992-02-05"},
                new Object[]{11, "Jojo Todynho", "jojo@todynho.com", "12312312312", "lactose123", "1997-02-11"},
                new Object[]{12, "Viih Tube", "viih@tube.com", "23423423423", "banho123", "2000-08-18"},
                new Object[]{13, "MC Mirella", "mcmirella@funk.com", "34534534534", "beat123", "1998-06-10"},
                new Object[]{14, "Danilo Gentili", "danilo@gentili.com", "45645645645", "treta123", "1979-09-27"},
                new Object[]{15, "Rafinha Bastos", "rafinha@bastos.com", "56756756756", "polêmica123", "1976-12-05"},
                new Object[]{16, "Eduardo Sterblitch", "eduardo@sterblitch.com", "67867867867", "zorra123", "1987-01-15"},
                new Object[]{17, "Maísa Silva", "maisa@silva.com", "78978978978", "fofura123", "2002-05-22"},
                new Object[]{18, "Pocah", "pocah@funk.com", "89089089089", "ronco123", "1994-10-13"},
                new Object[]{19, "Ícaro Silva", "icaro@silva.com", "90190190190", "ator123", "1987-03-19"},
                new Object[]{42, "Mano Brown", "mano@brown.com", "01201201201", "rap123", "1970-04-22"}
        );
    }

    public static Stream<Object[]> gerarAtributosAtualizacaoInvalidos() {
        return Stream.of(
                new Object[]{1, "Felipe Neto", "whindersson@nunes.com", "11122233344", "cancelado123", "1988-01-21"},
                new Object[]{2, "Whindersson Nunes", "felipe@neto.com", "22233344455", "piada123", "1995-01-05"},
                new Object[]{3, "Juliette Freire", "juliette@bbb.com", "55566677788", "cacto123", "1989-12-03"},
                new Object[]{4, "Carlinhos Maia", "casimiro@caze.com", "44455566677", "fofoca123", "1991-06-08"},
                new Object[]{5, "Lucas Rangel", "lucas@rangel.com", "99900011122", "trend123", "1997-05-09"},
                new Object[]{6, "Kéfera Buchmann", "lucas@rangel.com", "99900011122", "livro123", "1993-07-25"},
                new Object[]{7, "Tirullipa", "jojo@todynho.com", "77788899900", "risada123", "1984-11-16"},
                new Object[]{8, "Casimiro Miguel", "danilo@gentili.com", "88899900011", "react123", "1993-10-20"},
                new Object[]{9, "Gkay", "gkay@farofa.com", "55566677788", "farofa123", "1992-12-03"},
                new Object[]{10, "Neymar Jr.", "neymar@poker.com", "12312312312", "drible123", "1992-02-05"},
                new Object[]{11, "Jojo Todynho", "jojo@todynho.com", "56756756756", "lactose123", "1997-02-11"},
                new Object[]{12, "Viih Tube", "neymar@poker.com", "23423423423", "banho123", "2000-08-18"},
                new Object[]{13, "MC Mirella", "mcmirella@funk.com", "45645645645", "beat123", "1998-06-10"},
                new Object[]{14, "Danilo Gentili", "pocah@funk.com", "45645645645", "treta123", "1979-09-27"},
                new Object[]{15, "Rafinha Bastos", "pocah@funk.com", "23423423423", "polêmica123", "1976-12-05"},
                new Object[]{16, "Eduardo Sterblitch", "maisa@silva.com", "67867867867", "zorra123", "1987-01-15"},
                new Object[]{17, "Maísa Silva", "eduardo@sterblitch.com", "78978978978", "fofura123", "2002-05-22"},
                new Object[]{18, "Pocah", "pocah@funk.com", "78978978978", "ronco123", "1994-10-13"},
                new Object[]{19, "Ícaro Silva", "mano@brown.com", "90190190190", "ator123", "1987-03-19"},
                new Object[]{42, "Mano Brown", "icaro@silva.com", "01201201201", "rap123", "1970-04-22"}
        );
    }


    public static Stream<Object[]> gerarAtributos() {
        return Stream.of(
                new Object[]{"Felipe Neto", "felipe@neto.com", "11122233344", "cancelado123", "1988-01-21"},
                new Object[]{"Whindersson Nunes", "whindersson@nunes.com", "22233344455", "piada123", "1995-01-05"},
                new Object[]{"Juliette Freire", "juliette@bbb.com", "33344455566", "cacto123", "1989-12-03"},
                new Object[]{"Carlinhos Maia", "carlinhos@maia.com", "44455566677", "fofoca123", "1991-06-08"},
                new Object[]{"Lucas Rangel", "lucas@rangel.com", "55566677788", "trend123", "1997-05-09"},
                new Object[]{"Kéfera Buchmann", "kefera@buchmann.com", "66677788899", "livro123", "1993-07-25"},
                new Object[]{"Tirullipa", "tirullipa@comedia.com", "77788899900", "risada123", "1984-11-16"},
                new Object[]{"Casimiro Miguel", "casimiro@caze.com", "88899900011", "react123", "1993-10-20"},
                new Object[]{"Gkay", "gkay@farofa.com", "99900011122", "farofa123", "1992-12-03"},
                new Object[]{"Neymar Jr.", "neymar@poker.com", "00011122233", "drible123", "1992-02-05"},
                new Object[]{"Jojo Todynho", "jojo@todynho.com", "12312312312", "lactose123", "1997-02-11"},
                new Object[]{"Viih Tube", "viih@tube.com", "23423423423", "banho123", "2000-08-18"},
                new Object[]{"MC Mirella", "mcmirella@funk.com", "34534534534", "beat123", "1998-06-10"},
                new Object[]{"Danilo Gentili", "danilo@gentili.com", "45645645645", "treta123", "1979-09-27"},
                new Object[]{"Rafinha Bastos", "rafinha@bastos.com", "56756756756", "polêmica123", "1976-12-05"},
                new Object[]{"Eduardo Sterblitch", "eduardo@sterblitch.com", "67867867867", "zorra123", "1987-01-15"},
                new Object[]{"Maísa Silva", "maisa@silva.com", "78978978978", "fofura123", "2002-05-22"},
                new Object[]{"Pocah", "pocah@funk.com", "89089089089", "ronco123", "1994-10-13"},
                new Object[]{"Ícaro Silva", "icaro@silva.com", "90190190190", "ator123", "1987-03-19"},
                new Object[]{"Mano Brown", "mano@brown.com", "01201201201", "rap123", "1970-04-22"}
        );
    }

    public static Object gerarUsuario(String nome, String email, String cpf, String senha, String dataNascimento) {
        return gerarUsuarioCadastro(nome, email, cpf, senha, dataNascimento);
    }

    public static List<Object> gerarUsuarios() {
        List<Object> usuarios = new ArrayList<>();
        usuarios.add(gerarUsuarioCadastro("Felipe Neto", "felipe@neto.com", "11122233344", "cancelado123", "1988-01-21"));
        usuarios.add(gerarUsuarioCadastro("Whindersson Nunes", "whindersson@nunes.com", "22233344455", "piada123", "1995-01-05"));
        usuarios.add(gerarUsuarioCadastro("Juliette Freire", "juliette@bbb.com", "33344455566", "cacto123", "1989-12-03"));
        usuarios.add(gerarUsuarioCadastro("Carlinhos Maia", "carlinhos@maia.com", "44455566677", "fofoca123", "1991-06-08"));
        usuarios.add(gerarUsuarioCadastro("Lucas Rangel", "lucas@rangel.com", "55566677788", "trend123", "1997-05-09"));
        usuarios.add(gerarUsuarioCadastro("Kéfera Buchmann", "kefera@buchmann.com", "66677788899", "livro123", "1993-07-25"));
        usuarios.add(gerarUsuarioCadastro("Tirullipa", "tirullipa@comedia.com", "77788899900", "risada123", "1984-11-16"));
        usuarios.add(gerarUsuarioCadastro("Casimiro Miguel", "casimiro@caze.com", "88899900011", "react123", "1993-10-20"));
        usuarios.add(gerarUsuarioCadastro("Gkay", "gkay@farofa.com", "99900011122", "farofa123", "1992-12-03"));
        usuarios.add(gerarUsuarioCadastro("Neymar Jr.", "neymar@poker.com", "00011122233", "drible123", "1992-02-05"));
        usuarios.add(gerarUsuarioCadastro("Jojo Todynho", "jojo@todynho.com", "12312312312", "lactose123", "1997-02-11"));
        usuarios.add(gerarUsuarioCadastro("Viih Tube", "viih@tube.com", "23423423423", "banho123", "2000-08-18"));
        usuarios.add(gerarUsuarioCadastro("MC Mirella", "mcmirella@funk.com", "34534534534", "beat123", "1998-06-10"));
        usuarios.add(gerarUsuarioCadastro("Danilo Gentili", "danilo@gentili.com", "45645645645", "treta123", "1979-09-27"));
        usuarios.add(gerarUsuarioCadastro("Rafinha Bastos", "rafinha@bastos.com", "56756756756", "polêmica123", "1976-12-05"));
        usuarios.add(gerarUsuarioCadastro("Eduardo Sterblitch", "eduardo@sterblitch.com", "67867867867", "zorra123", "1987-01-15"));
        usuarios.add(gerarUsuarioCadastro("Maísa Silva", "maisa@silva.com", "78978978978", "fofura123", "2002-05-22"));
        usuarios.add(gerarUsuarioCadastro("Pocah", "pocah@funk.com", "89089089089", "ronco123", "1994-10-13"));
        usuarios.add(gerarUsuarioCadastro("Ícaro Silva", "icaro@silva.com", "90190190190", "ator123", "1987-03-19"));
        usuarios.add(gerarUsuarioCadastro("Mano Brown", "mano@brown.com", "01201201201", "rap123", "1970-04-22"));

        return usuarios;
    }

    public static Object gerarUsuarioCadastro(
            String nome,
            String email,
            String cpf,
            String senha,
            String dataNascimento
    ) {
        try {
            Class<?> clazz = Class.forName("school.sptech.prova_ac1.Usuario");
            Object usuario = clazz.getDeclaredConstructor().newInstance();

            Method setNome = clazz.getMethod("setNome", String.class);
            Method setEmail = clazz.getMethod("setEmail", String.class);
            Method setCpf = clazz.getMethod("setCpf", String.class);
            Method setSenha = clazz.getMethod("setSenha", String.class);
            Method setDataNascimento = clazz.getMethod("setDataNascimento", LocalDate.class);

            setNome.invoke(usuario, nome);
            setEmail.invoke(usuario, email);
            setCpf.invoke(usuario, cpf);
            setSenha.invoke(usuario, senha);
            setDataNascimento.invoke(usuario, LocalDate.parse(dataNascimento));

            return usuario;
        } catch (Exception e) {
            throw new RuntimeException("Erro ao instanciar o objeto Usuario", e);
        }
    }
}
