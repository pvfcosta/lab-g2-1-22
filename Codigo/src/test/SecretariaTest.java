package test;

import business.Aluno;
import business.Curso;
import business.Professor;
import business.SecretariaSingleton;
import exception.SecretariaException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SecretariaTest {
	SecretariaSingleton sec;
	Aluno erick;
	Curso eds;
	Professor prof;
	
	@BeforeEach
	void setUp() throws Exception {
		sec = SecretariaSingleton.getInstancia();
		erick = new Aluno(null, null, null, 0, null, 0, null);
		eds = new Curso("null",1);
		prof = new Professor(null, null, null, 0, null);
		sec.adicionarCurso(eds);
	}
	
	//Testes método matricularAluno()

	@Test
	void testMatricularAluno() throws SecretariaException {
		sec.matricularAluno(erick, eds);
		assertThat(eds.getAlunos(), hasItems(erick));
	}
	
	@Test
	void testMatricularAlunoNull() {
		Aluno nulo = null;
		SecretariaException thrown = Assertions.assertThrows(SecretariaException.class, () -> {
			sec.matricularAluno(nulo, eds);
		}, "SecretariaException was expected");
		
		Assertions.assertEquals("Não foi possível adicionar o aluno. (Aluno Nulo)", thrown.getMessage());
	}
	
	@Test
	void testMatricularAlunoCursoNull() {
		Curso nulo = null;
		SecretariaException thrown = Assertions.assertThrows(SecretariaException.class, () -> {
			sec.matricularAluno(erick, nulo);
		}, "SecretariaException was expected");
		
		Assertions.assertEquals("Não foi possível adicionar o aluno. (Curso Nulo)", thrown.getMessage());
	}
	
	//Testes método contratarProfessor()
	
	@Test
	void testContratarProfessor() throws SecretariaException {
		sec.contratarProfessor(prof);
		assertThat(sec.getProfessores(), hasItems(prof));
	}
	
	@Test
	void testContratarProfessorNull() {
		Professor nulo = null;
		SecretariaException thrown = Assertions.assertThrows(SecretariaException.class, () -> {
			sec.contratarProfessor(nulo);
		}, "SecretariaException was expected");
		
		Assertions.assertEquals("Não foi possível contratar o professor. (Professor Nulo)", thrown.getMessage());
	}
	
	//Testes método demitirProfessor()
	
	@Test
	void testDemitirProfessor() throws SecretariaException {
		sec.contratarProfessor(prof);
		assertEquals(sec.demitirProfessor(prof), prof);
	}
	
	@Test
	void testDemitirProfessorInexistente() {
		SecretariaException thrown = Assertions.assertThrows(SecretariaException.class, () -> {
			sec.demitirProfessor(prof);
		}, "SecretariaException was expected");
		
		Assertions.assertEquals("Não foi possível demitir o professor. (Professor não contratado)", thrown.getMessage());
	
	}

	//Testes método manusearMatriculaGeral()
}
