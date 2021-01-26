package br.ufac.si.muralSI.gerentes;

import java.util.*;

import javax.persistence.*;

import br.ufac.si.muralSI.entidades.Aviso;

public class AvisoGerente{
	
	private EntityManagerFactory emf;
	private EntityManager em;
	
	public AvisoGerente() {
		emf = Persistence.createEntityManagerFactory("muralsi");
		em = emf.createEntityManager();
	}
	
	public void adicionar(Aviso aviso) {
		em.getTransaction().begin();
		em.persist(aviso);
		em.getTransaction().commit();
	}
	
	public Aviso recuperar(long id) {
		return em.find(Aviso.class, id);
	}
	
	public void atualizar(Aviso aviso) {
		em.getTransaction().begin();
		em.merge(aviso);
		em.getTransaction().commit();
	}
	
	public void remover(Aviso aviso) {
		em.getTransaction().begin();
		em.remove(aviso);
		em.getTransaction().commit();
	}
	
	public List<Aviso> recuperarTodos(){
		return em.createNamedQuery("Aviso.todos").getResultList();
	}
	
	public List<Aviso> recuperarTodosPorNome(){
		return em.createNamedQuery("Aviso.todosPorNome").getResultList();
	}
	
	public List<Aviso> recuperarTodosPorData(){
		return em.createNamedQuery("Aviso.todosPorData").getResultList();
	}
	
	public List<Aviso> recuperarTodosPorNomeContendo(String termo){
		return em.createNamedQuery("Aviso.todosPorNomeContendo")
				.setParameter("termo", "%"+termo+"%")
				.getResultList();
	}
	
	public List<Aviso> recuperarTodosPorTurma(long termo){
		return em.createNamedQuery("Aviso.todosPorDisciplina")
				.setParameter("termo", termo)
				.getResultList();
	}
	
	public List<Aviso> recuperarAvisos(String termo1, long termo2) {
		return em.createNamedQuery("Aviso.todosPorNomeETurma")
				.setParameter("termo1", "%"+termo1+"%")
				.setParameter("termo2", termo2).getResultList();
	}
	
	
	public void encerrar() {
		em.close();
		emf.close();
	}
	
}
