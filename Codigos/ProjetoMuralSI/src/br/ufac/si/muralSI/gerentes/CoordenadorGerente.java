package br.ufac.si.muralSI.gerentes;

import java.util.*;

import javax.persistence.*;

import br.ufac.si.muralSI.entidades.Coordenador;

public class CoordenadorGerente{
	private EntityManagerFactory emf;
	private EntityManager em;
	
	public CoordenadorGerente() {
		emf = Persistence.createEntityManagerFactory("muralsi");
		em = emf.createEntityManager();
	}
	
	public void adicionar(Coordenador coordenador) {
		em.getTransaction().begin();
		em.persist(coordenador);
		em.getTransaction().commit();
	}
	
	public Coordenador recuperar(long id) {
		return em.find(Coordenador.class, id);
	}
	
	public void atualizar(Coordenador coordenador) {
		em.getTransaction().begin();
		em.merge(coordenador);
		em.getTransaction().commit();
	}
	
	public void remover(Coordenador coordenador) {
		em.getTransaction().begin();
		em.remove(coordenador);
		em.getTransaction().commit();
	}
	
	public List<Coordenador> recuperarTodos(){
		return em.createNamedQuery("Coordenador.todos").getResultList();
	}
	
	public List<Coordenador> recuperarTodosPorNome(){
		return em.createNamedQuery("Coordenador.todosPorNome").getResultList();
	}
	
	public List<Coordenador> recuperarTodosPorNomeContendo(String termo){
		return em.createNamedQuery("Coordenador.todosPorNomeContendo")
				.setParameter("termo", "%"+termo+"%").getResultList();
	}
	
	public List<Coordenador> recuperarPorIdentificador(String termo){
		return em.createNamedQuery("Coordenador.todosPorIdentificador")
				.setParameter("termo", termo).getResultList();
	}
	
	public void encerrar() {
		em.close();
		emf.close();
	}
	
}
