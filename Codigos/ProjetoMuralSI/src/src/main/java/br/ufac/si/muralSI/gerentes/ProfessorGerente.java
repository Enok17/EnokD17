package br.ufac.si.muralSI.gerentes;

import java.util.*;

import javax.persistence.*;

import br.ufac.si.muralSI.entidades.Professor;

public class ProfessorGerente{
	private EntityManagerFactory emf;
	private EntityManager em;
	
	public ProfessorGerente() {
		emf = Persistence.createEntityManagerFactory("muralsi");
		em = emf.createEntityManager();
	}
	
	public void adicionar(Professor professor) {
		em.getTransaction().begin();
		em.persist(professor);
		em.getTransaction().commit();
	}
	
	public Professor recuperar(long id) {
		return em.find(Professor.class, id);
	}
	
	public void atualizar(Professor professor) {
		em.getTransaction().begin();
		em.merge(professor);
		em.getTransaction().commit();
	}
	
	public void remover(Professor professor) {
		em.getTransaction().begin();
		em.remove(professor);
		em.getTransaction().commit();
	}
	
	public List<Professor> recuperarTodos(){
		return em.createNamedQuery("Professor.todos").getResultList();
	}
	
	public List<Professor> recuperarTodosPorNome(){
		return em.createNamedQuery("Professor.todosPorNome").getResultList();
	}
	
	public List<Professor> recuperarTodosPorNomeContendo(String termo){
		return em.createNamedQuery("Professor.todosPorNomeContendo")
				.setParameter("termo", "%"+termo+"%").getResultList();
	}
	
	public List<Professor> recuperarPorIdentificador(String termo){
		return em.createNamedQuery("Professor.todosPorIdentificador")
				.setParameter("termo", termo).getResultList();
	}
	
	public List<Professor> recuperarPorCentro(String termo){
		return em.createNamedQuery("Professor.todosPorCentro")
				.setParameter("termo", termo).getResultList();
	}
	
	public void encerrar() {
		em.close();
		emf.close();
	}
	
}
