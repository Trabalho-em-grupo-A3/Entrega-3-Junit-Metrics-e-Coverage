package br.com.model.persistence.dao;

import br.com.controller.AngendamentoAulaResponse;
import br.com.model.dto.AgendamentoAulaDTO;
import br.com.model.dto.AulaDTO;
import br.com.model.persistence.AgendamentoAula;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AgendamentoAulaDAOTest {
    @BeforeEach
    public void setUp() {
        AgendamentoAulaDTO.idAgendamento = 4;

        String dateString = "2023-11-25 16:00:00";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date parsedDate = dateFormat.parse(dateString);
            AulaDTO.diaHorarioAula = new Timestamp(parsedDate.getTime());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        AgendamentoAulaDTO.idAula = 10;
        AgendamentoAulaDTO.matriculaAluno = 123;

    }
    @Test
    public void testAgendarAula() throws Exception {
        AgendamentoAula agendamentoAula = AgendamentoAulaDAO.agendarAula(8, 123);
        AngendamentoAulaResponse result = AgendamentoAulaDAO.mostrarAgendamentos(agendamentoAula.getMatriculaAluno());

        assertEquals(agendamentoAula.getMatriculaAluno(), result.getMatriculaAluno());

    }

}
