package br.com.model.persistence.dao;

import br.com.model.dto.AlunoDTO;
import br.com.model.persistence.Aluno;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class AlunoDAOTest {
    @BeforeEach
    public void setUp() {
        AlunoDTO.matricula = 9;
        AlunoDTO.cpf = "75489";
        AlunoDTO.nome = "Paula";
        AlunoDTO.idade = 25;
    }

    @Test
    public void inserirAluno() throws Exception {
        Aluno aluno = AlunoDAO.inserirAluno();
        Aluno result = AlunoDAO.lerDadosAlunos(aluno.getMatricula());

        assertEquals(aluno.getMatricula(), result.getMatricula());
        assertEquals(aluno.getCpf(), result.getCpf());
        assertEquals(aluno.getNome(), result.getNome());
        assertEquals(aluno.getIdade(), result.getIdade());
    }

    @Test
    public void atualizarDadosAluno() throws Exception {
        Aluno aluno = AlunoDAO.atualizarDadosAluno(1);
        Aluno result = AlunoDAO.lerDadosAlunos(aluno.getMatricula());

        assertEquals(aluno.getCpf(), result.getCpf());

    }

    @Test
    public void deletarDadosAluno() throws Exception {
        Aluno aluno = AlunoDAO.deletarDadosAluno();
        Aluno result = AlunoDAO.lerDadosAlunos(aluno.getMatricula());

        assertEquals(aluno.getMatricula(), result.getMatricula());

    }
}
