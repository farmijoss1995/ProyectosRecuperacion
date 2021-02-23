package ec.edu.ups.proyectos.Tienda.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ec.edu.ups.proyectos.Tienda.model.Comentario;

@Stateless
public class ComentarioDAO {

	/**
	 * Injeccion del entity manager
	 */

	@Inject
	private EntityManager em;
	
	
	public void crearComentario(Comentario comentario) {
		em.persist(comentario);
	}
	
	public List<Comentario> getComentarios(){
		String jpql = "SELECT a FROM Cpmentario a";
		Query query = em.createQuery(jpql, Comentario.class);
		List<Comentario> comentarios = query.getResultList();
		return comentarios;
	}
	
	
}
