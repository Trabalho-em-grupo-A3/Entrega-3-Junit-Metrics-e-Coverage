package br.com.model.persistence.dao;
import br.com.model.dto.InstrutorDTO;
import br.com.model.persistence.Instrutor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class InstrutorDAOTest {
    @BeforeEach
    public void setUp() {
        InstrutorDTO.matriculaInstrutor = 2;
        InstrutorDTO.nomeInstrutor = "Mariano";
    }

    @Test
    public void inserirInstrutor() throws SQLException {
        Instrutor instrutor = InstrutorDAO.inserirInstrutor();
        Instrutor result = InstrutorDAO.lerDadosInstrutor(instrutor.getMatriculaInstrutor());

        assertEquals(instrutor.getMatriculaInstrutor(), result.getMatriculaInstrutor());
        assertEquals(instrutor.getNomeInstrutor(), result.getNomeInstrutor());
    }

    @Test
    public void atualizarDadosInstrutor() throws Exception {
        Instrutor instrutor = InstrutorDAO.atualizarDadosInstrutor();
        Instrutor result = InstrutorDAO.lerDadosInstrutor(instrutor.getMatriculaInstrutor());

        assertEquals(instrutor.getMatriculaInstrutor(), result.getMatriculaInstrutor());
    }

    @Test
    public void deletarDadosInstrutor() throws Exception {
        Instrutor instrutor = InstrutorDAO.deletarDadosInstrutor();
        Instrutor result = InstrutorDAO.lerDadosInstrutor(instrutor.getMatriculaInstrutor());

        assertEquals(instrutor.getMatriculaInstrutor(), result.getMatriculaInstrutor());
    }
}
