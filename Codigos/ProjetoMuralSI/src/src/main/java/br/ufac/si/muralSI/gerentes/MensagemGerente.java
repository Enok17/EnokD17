package br.ufac.si.muralSI.gerentes;

import java.util.*;

import javax.persistence.*;

import br.ufac.si.muralSI.entidades.Mensagem;

public class MensagemGerente{
	
	private EntityManagerFactory emf;
	private EntityManager em;
	
	public MensagemGerente() {
		emf = Persistence.createEntityManagerFactory("muralsi");
		em = emf.createEntityManager();
	}
	
	public void adicionar(Mensagem mensagem) {
		em.getTransaction().begin();
		em.persist(mensagem);
		em.getTransaction().commit();
	}
	
	public Mensagem recuperar(long id) {
		return em.find(Mensagem.class, id);
	}
	
	public void atualizar(Mensagem mensagem) {
		em.getTransaction().begin();
		em.merge(mensagem);
		em.getTransaction().commit();
	}
	
	public void remover(Mensagem mensagem) {
		em.getTransaction().begin();
		em.remove(mensagem);
		em.getTransaction().commit();
	}
	
	public List<Mensagem> recuperarTodos(){
		return em.createNamedQuery("Mensagem.todos").getResultList();
	}
	
	public List<Mensagem> recuperarTodosPorNome(){
		return em.createNamedQuery("Mensagem.todosPorNome").getResultList();
	}
	
	public List<Mensagem> recuperarTodosPorData(){
		return em.createNamedQuery("Mensagem.todosPorData").getResultList();
	}
	
	public List<Mensagem> recuperarTodosPorNomeContendo(String termo){
		return em.createNamedQuery("Mensagem.todosPorNomeContendo")
				.setParameter("termo", "%"+termo+"%")
				.getResultList();
	}
	
	public List<Mensagem> recuperarTodosPorTurma(long termo){
		return em.createNamedQuery("Mensagem.todosPorTurma")
				.setParameter("termo", termo)
				.getResultList();
	}
	
	public List<Mensagem> recuperarMensagens(String termo1, long termo2) {
		return em.createNamedQuery("Mensagem.todosPorNomeEDisciplina")
				.setParameter("termo1", "%"+termo1+"%")
				.setParameter("termo2", termo2).getResultList();
	}
	
	
	public void encerrar() {
		em.close();
		emf.close();
	}
	
}
