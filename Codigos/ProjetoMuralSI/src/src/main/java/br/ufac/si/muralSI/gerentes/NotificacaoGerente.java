package br.ufac.si.muralSI.gerentes;

import java.util.*;

import javax.persistence.*;

import br.ufac.si.muralSI.entidades.Notificacao;

public class NotificacaoGerente{
	
	private EntityManagerFactory emf;
	private EntityManager em;
	
	public NotificacaoGerente() {
		emf = Persistence.createEntityManagerFactory("muralsi");
		em = emf.createEntityManager();
	}
	
	public void adicionar(Notificacao notificacao) {
		em.getTransaction().begin();
		em.persist(notificacao);
		em.getTransaction().commit();
	}
	
	public Notificacao recuperar(long id) {
		return em.find(Notificacao.class, id);
	}
	
	public void atualizar(Notificacao notificacao) {
		em.getTransaction().begin();
		em.merge(notificacao);
		em.getTransaction().commit();
	}
	
	public void remover(Notificacao notificacao) {
		em.getTransaction().begin();
		em.remove(notificacao);
		em.getTransaction().commit();
	}
	
	public List<Notificacao> recuperarTodos(){
		return em.createNamedQuery("Notificacao.todos").getResultList();
	}
	
	public List<Notificacao> recuperarTodosPorNome(){
		return em.createNamedQuery("Notificacao.todosPorNome").getResultList();
	}
	
	public List<Notificacao> recuperarTodosPorNomeContendo(String termo){
		return em.createNamedQuery("Notificacao.todosPorNomeContendo")
				.setParameter("termo", "%"+termo+"%")
				.getResultList();
	}
	
	public List<Notificacao> recuperarTodosPorPeriodo(int termo){
		return em.createNamedQuery("Notificacao.todosPorPeriodo")
				.setParameter("termo", termo)
				.getResultList();
	}
	
	public List<Notificacao> recuperarNotificacoes(String termo1, int termo2) {
		return em.createNamedQuery("Notificacao.todosPorNomeEPeriodo")
				.setParameter("termo1", "%"+termo1+"%")
				.setParameter("termo2", termo2).getResultList();
	}
	
	
	public void encerrar() {
		em.close();
		emf.close();
	}
	
}
