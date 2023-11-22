package br.com.model.persistence.dao;

import br.com.model.dto.AulaDTO;
import br.com.model.persistence.Aula;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AulaDAOTest {

    @BeforeEach
    public void setUp() {
        AulaDTO.idAula = 8;
        AulaDTO.nomeAula = "Natacao";

        String dateString = "2023-11-25 16:00:00";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date parsedDate = dateFormat.parse(dateString);
            AulaDTO.diaHorarioAula = new Timestamp(parsedDate.getTime());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        AulaDTO.matriculaInstrutor = 1;
    }

    @Test
    public void testInserirAula() throws Exception {
        Aula aula = AulaDAO.inserirAula();
        Aula result = AulaDAO.lerDadosAula(aula.getIdAula());

        assertEquals(aula.getIdAula(), result.getIdAula());
        assertEquals(aula.getNomeAula(), result.getNomeAula());
        assertEquals(aula.getDiaHorarioAula(), result.getDiaHorarioAula());
        assertEquals(aula.getMatriculaInstrutor(), result.getMatriculaInstrutor());
    }

    @Test
    public void atualizarDadosAula() throws Exception {
        AulaDTO.nomeAula = "Teste";
        Aula aula = AulaDAO.atualizarDadosAula(1);
        Aula result = AulaDAO.lerDadosAula(aula.getIdAula());

        assertEquals(aula.getNomeAula(), result.getNomeAula());

    }
    @Test
    public void testDeletarDadosAula() throws Exception {
        Aula aula = AulaDAO.deletarDadosAula();
        Aula result = AulaDAO.lerDadosAula(aula.getIdAula());

        assertEquals(aula.getIdAula(), result.getIdAula());

    }
}