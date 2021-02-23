package ec.edu.ups.proyectos.Tienda.dao;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.sound.midi.MidiSystem;

import ec.edu.ups.proyectos.Tienda.model.Cliente;
import ec.edu.ups.proyectos.Tienda.model.Sesion;


/**
 * 
 * @author fabian Clase java encargada del manejo de opraciones sobre la base de
 *         datos, tendremos operaciones CRUD si los requerimientos nos lo pide
 * 
 */
@Stateless
public class ClienteDAO {
	/**
	 * Injeccion del entity manager
	 */

	@Inject
	private EntityManager em;

	/**
	 * Metodo que permite crear un objeto mediante la persitencia
	 * 
	 * @param cliente pide el objeto que va aser insertado en nuestra DB
	 */
	public void crearCliente(Cliente cliente) {
		em.persist(cliente);
	}



	/**
	 * Metodo para buscar un cliente, mediante la persistencia realizará un find del
	 * cliente mediante la cedula, permitiendonos tener un objeto de retorno
	 * 
	 * @param cedula parametro unico que buscará una cedula dentro del cliente
	 * @return un objeto de tipo Cliente
	 */
	public Cliente buscarClienteId(int id) {
		Cliente cli = em.find(Cliente.class, id);
		System.out.println(cli.getCedula());
		return cli;
	}

	/**
	 * Metodo que permite actualizar la información de un cliente mediante un merge
	 * de la persistencia
	 * 
	 * @param cliente mediante un cliente actualizara este cliente
	 */
	public void actualizarCliente(Cliente cliente) {
		em.merge(cliente);
	}

	/**
	 * Metodo que permite tener un arreglo de todos los clientes, esto lo realizamos
	 * mediante jpql
	 * 
	 * @return arreglo de clientes
	 */
	public List<Cliente> mostrarClientes() {
		String jpql = "SELECT a FROM Cliente a";
		Query query = em.createQuery(jpql, Cliente.class);
		List<Cliente> clientes = query.getResultList();
		return clientes;
	}

	public Cliente buscarClienteCorreo(String correo) {
		Cliente cli = new Cliente();
		try {
			String jpql = "SELECT c FROM Cliente c where c.correo = :correo";
			Query query = em.createQuery(jpql, Cliente.class);
			query.setParameter("correo", correo);
			cli = (Cliente) query.getSingleResult();
		} catch (Exception e) {
			cli = null;
		}

		return cli;
	}
	
	/*public Cliente clienteLogIn(UsuarioSesion usuarioSesion) {
		System.out.println("Cliente DAO    " +usuarioSesion.toString());
		Cliente cl= this.buscarClienteCorreo(usuarioSesion.getCorreo());
		try {
			String jpql = "SELECT c FROM Cliente c WHERE c.correo = :correo AND c.clave = :clave";
			
			Query q = em.createQuery(jpql, Cliente.class);
			q.setParameter("correo", cl.getCorreo());
			q.setParameter("clave", cl.getClave());
			cl = (Cliente) q.getSingleResult();
			System.out.println("Cliente ======>>>>>> "+cl.getCorreo());
			
		} catch (Exception e) {
			System.out.println("<========ERROR  ClienteDAO  ClIENTE OGIN ======>>>>>>");
			cl = null;
		}
		return cl;
	}*/
	
	

	/*
		public List<Sesion> clienteSesiones(String cedula) {
		String jqpl = "SELECT c FROM Cliente c JOIN FETCH c.listaSesiones where c.cedula = :cedula";
		Query query = em.createQuery(jqpl, Cliente.class);
		query.setParameter("cedula", cedula);
		 Cliente cuen = (Cliente) query.getSingleResult();
		List<Sesion> trans = new ArrayList<>();
		for (Sesion t : cuen.getListaSesiones()) {
			trans.add(t);	
		}
		System.out.println("<<<<<<<<<<< Transaccion en cliente dao >>>>>> "+trans.toString());
		return trans;
		}
*/

}
