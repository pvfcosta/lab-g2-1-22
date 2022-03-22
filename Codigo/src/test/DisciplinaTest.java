package test;

import business.Disciplina;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class DisciplinaTest {

    Disciplina disciplina;

    //testa criar disciplina

    @Test
    void testaCriaDisciplina(){
        disciplina = new Disciplina(1,"Projeto de Software", 60, true,4);
        assertEquals("Projeto de Software",disciplina.getNome());
    }

}
