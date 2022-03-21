package test;

import business.*;
import exception.SecretariaException;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TurmaTest {
    Turma turma1;
    Disciplina disc;
    Professor prof;
    Aluno aluno;
    Curso curso;

    @BeforeEach
    void setUp() {
        disc = new Disciplina(1,"Projeto de Software", 60, true,4);
        turma1 = new Turma(1, "2022/1",disc);
        prof = new Professor("Fulano","fulano@teste.com","1234",1,"12312312311");
        curso = new Curso(null,1);
        aluno = new Aluno("Ciclano", "ciclano@teste.com","123456",1,"12345678910",1,curso);
    }

    @Test
    void testaAdiocionarProfessor(){
        turma1.adicionarProfessor(prof);
        assertEquals(1,turma1.getProfessores().size());
    }

    @Test
    void testaAdicionarAluno() throws SecretariaException {
        turma1.adicionarAluno(aluno);
        assertEquals(1,turma1.getAlunos().size());
    }

    @Test
    void testaRemoverProfessor(){
        turma1.adicionarProfessor(prof);
        assertEquals(1,turma1.getProfessores().size());
        turma1.removerProfessor(prof);
        assertEquals(true,turma1.getProfessores().isEmpty());
    }

    @Test
    void testaRemoverAluno() throws SecretariaException {
        turma1.adicionarAluno(aluno);
        assertEquals(1,turma1.getAlunos().size());
        turma1.removerAluno(aluno);
        assertEquals(true,turma1.getAlunos().isEmpty());
    }

    @Test
    void testaAbrirMatricula(){
        turma1.abrirMatricula(true);
        assertEquals(true,turma1.isMatriculaAberta());
    }
}
