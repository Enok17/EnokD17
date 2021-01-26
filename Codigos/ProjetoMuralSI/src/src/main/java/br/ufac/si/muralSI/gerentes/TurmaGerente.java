package br.ufac.si.muralSI.gerentes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.ufac.si.muralSI.entidades.Aviso;
import br.ufac.si.muralSI.entidades.Turma;

public class TurmaGerente {
	
	private EntityManagerFactory emf;
	private EntityManager em;
	
	public TurmaGerente() {
		emf = Persistence.createEntityManagerFactory("muralsi");
		em = emf.createEntityManager();
	}
	
	public void adicionar(Turma turma) {
		em.getTransaction().begin();
		em.persist(turma);
		em.getTransaction().commit();
	}
	
	public Turma recuperar(long id) {
		return em.find(Turma.class, id);
	}
	
	public void atualizar(Turma turma) {
		em.getTransaction().begin();
		em.merge(turma);
		em.getTransaction().commit();
	}
	
	public void remover(Turma turma) {
		em.getTransaction().begin();
		em.remove(turma);
		em.getTransaction().commit();
	}
	
	public List<Turma> recuperarTodos(){
		return em.createNamedQuery("Turma.todos").getResultList();
	}
	
	public List<Turma> recuperarTodosPorNome(){
		return em.createNamedQuery("Turma.todosPorNome").getResultList();
	}
	
	public List<Turma> recuperarTodosPorNomeContendo(String termo){
		return em.createNamedQuery("Turma.todosPorNomeContendo")
				.setParameter("termo", "%"+termo+"%")
				.getResultList();
	}
	
	public List<Turma> recuperarTodosPorProfessorContendo(long termo){
		return em.createNamedQuery("Turma.todosPorProfessorContendo")
				.setParameter("termo", termo)
				.getResultList();
	}
	
	public List<Turma> recuperarTodosPorDisciplinaContendo(String termo){
		return em.createNamedQuery("Turma.todosPorDisciplinaContendo")
				.setParameter("termo", termo)
				.getResultList();
	}
	
	public void encerrar() {
		em.close();
		emf.close();
	}
	
}
