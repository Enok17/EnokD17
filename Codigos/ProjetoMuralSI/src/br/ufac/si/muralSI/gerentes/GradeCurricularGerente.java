package br.ufac.si.muralSI.gerentes;

import java.util.*;

import javax.persistence.*;

import br.ufac.si.muralSI.entidades.GradeCurricular;

public class GradeCurricularGerente{
	private EntityManagerFactory emf;
	private EntityManager em;
	
	public GradeCurricularGerente() {
		emf = Persistence.createEntityManagerFactory("muralsi");
		em = emf.createEntityManager();
	}
	
	public void adicionar(GradeCurricular gradeCurricular) {
		em.getTransaction().begin();
		em.persist(gradeCurricular);
		em.getTransaction().commit();
	}
	
	public GradeCurricular recuperar(long id) {
		return em.find(GradeCurricular.class, id);
	}
	
	public void atualizar(GradeCurricular gradeCurricular) {
		em.getTransaction().begin();
		em.merge(gradeCurricular);
		em.getTransaction().commit();
	}
	
	public void remover(GradeCurricular gradeCurricular) {
		em.getTransaction().begin();
		em.remove(gradeCurricular);
		em.getTransaction().commit();
	}
	
	public List<GradeCurricular> recuperarTodos(){
		return em.createNamedQuery("GradeCurricular.todos").getResultList();
	}
	
	public List<GradeCurricular> recuperarTodosPorNome(){
		return em.createNamedQuery("GradeCurricular.todosPorNome").getResultList();
	}
	
	public List<GradeCurricular> recuperarTodosPorNomeContendo(String termo1, int termo2){
		return em.createNamedQuery("GradeCurricular.todosPorNomeContendo")
				.setParameter("termo1", "%"+termo1+"%")
				.setParameter("termo2", termo2).getResultList();
	}
	
	public void encerrar() {
		em.close();
		emf.close();
	}
	
}
