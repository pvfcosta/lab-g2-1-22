package test;

import business.*;
import exception.SecretariaException;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CursoTest {
    Disciplina disc;
    Curso curso;

    @BeforeEach
    void setUp() {
        disc = new Disciplina(1,"Projeto de Software", 60, true,4);
        curso = new Curso(null,1);
    }

    @Test
    void testaAdicionarDisciplina(){
        curso.addDisciplina(disc);
        assertEquals(1, curso.getDisciplinas().size());
        assertEquals(60,curso.getCargaHoraria());
    }

    @Test
    void testaRemoveDisciplina(){
        curso.addDisciplina(disc);
        assertEquals(1, curso.getDisciplinas().size());
        assertEquals(60,curso.getCargaHoraria());
        assertEquals(true,curso.removerDisciplina(disc));
        assertEquals(0,curso.getCargaHoraria());
    }

}
