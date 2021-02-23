package ec.edu.ups.proyectos.Tienda.on;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.proyectos.Tienda.dao.ClienteDAO;
import ec.edu.ups.proyectos.Tienda.dao.ComentarioDAO;
import ec.edu.ups.proyectos.Tienda.dao.SesionDAO;
import ec.edu.ups.proyectos.Tienda.model.Cliente;
import ec.edu.ups.proyectos.Tienda.model.Comentario;
import ec.edu.ups.proyectos.Tienda.model.Sesion;

@Stateless
public class TransaccionON {

	@Inject
	ClienteDAO clientedao;

	@Inject
	ComentarioDAO comentariodao;

	@Inject
	SesionDAO sesiondao;
	
	
	public void crearSesion(Sesion sesion) {
		this.sesiondao.crearSesion(sesion);
	}
	
	public Sesion buscarSesionCorreo(String correo)  {
		return this.sesiondao.buscarSesionCorreo(correo);
	}
	
	
	public void crearCliente(Cliente cliente) {
		this.crearCliente(cliente);
		
	}
	
	public Cliente obtenerClienteLogin(String correo) throws Exception {
		return this.clientedao.buscarClienteCorreo(correo);
	}
	
	public void crearComentario(Comentario comentario) {
		this.comentariodao.crearComentario(comentario);
	}
	
	public List<Comentario> getComentarios(){
		return this.comentariodao.getComentarios();
	}

}
