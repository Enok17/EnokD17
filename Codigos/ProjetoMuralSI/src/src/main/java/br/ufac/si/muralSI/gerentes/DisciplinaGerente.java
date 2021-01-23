package br.ufac.si.muralSI.gerentes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.ufac.si.muralSI.entidades.Disciplina;

public class DisciplinaGerente {
	
	private EntityManagerFactory emf;
	private EntityManager em;
	
	public DisciplinaGerente() {
		emf = Persistence.createEntityManagerFactory("muralsi");
		em = emf.createEntityManager();
	}
	
	public void adicionar(Disciplina disciplina) {
		em.getTransaction().begin();
		em.persist(disciplina);
		em.getTransaction().commit();
	}
	
	public Disciplina recuperar(long id) {
		return em.find(Disciplina.class, id);
	}
	
	public void atualizar(Disciplina disciplina) {
		em.getTransaction().begin();
		em.merge(disciplina);
		em.getTransaction().commit();
	}
	
	public void remover(Disciplina disciplina) {
		em.getTransaction().begin();
		em.remove(disciplina);
		em.getTransaction().commit();
	}
	
	public List<Disciplina> recuperarTodos(){
		return em.createNamedQuery("Disciplina.todos").getResultList();
	}
	
	public List<Disciplina> recuperarTodosPorNome(){
		return em.createNamedQuery("Disciplina.todosPorNome").getResultList();
	}
	
	public List<Disciplina> recuperarTodosPorNomeContendo(String termo){
		return em.createNamedQuery("Disciplina.todosPorNomeContendo")
				.setParameter("termo", "%"+termo+"%")
				.getResultList();
	}
	
	public List<Disciplina> recuperarTodosPorPeriodo(int termo){
		return em.createNamedQuery("Disciplina.todosPorPeriodo")
				.setParameter("termo", termo)
				.getResultList();
	}
	
	public void encerrar() {
		em.close();
		emf.close();
	}
	
}
