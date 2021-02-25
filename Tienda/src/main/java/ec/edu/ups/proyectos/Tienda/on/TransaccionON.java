package ec.edu.ups.proyectos.Tienda.on;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.proyectos.Tienda.dao.ClienteDAO;
import ec.edu.ups.proyectos.Tienda.dao.ComentarioDAO;
import ec.edu.ups.proyectos.Tienda.dao.SesionDAO;
import ec.edu.ups.proyectos.Tienda.model.Cliente;
import ec.edu.ups.proyectos.Tienda.model.Comentario;
import ec.edu.ups.proyectos.Tienda.model.Sesion;
import ec.edu.ups.proyectos.Tienda.service.Respuesta;
import ec.edu.ups.proyectos.Tienda.view.UsuarioSesion;

@Stateless
public class TransaccionON implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	ClienteDAO clientedao;

	@Inject
	ComentarioDAO comentariodao;

	@Inject
	SesionDAO sesiondao;
	
	public Respuesta clienteLogIn(UsuarioSesion usuarioSesion) throws Exception{
		System.out.println("usuario sesion"+usuarioSesion.toString());
		Respuesta respuesta= new Respuesta();
		Cliente  cliente=this.clientedao.clienteLogIn(usuarioSesion);
		System.out.println(cliente.getCorreo());
		if (cliente.getCorreo().equals(usuarioSesion.getCorreo()) && 
				cliente.getClave().equals(usuarioSesion.getClave())) 
				
				{
			respuesta.setCodigo(200);
			respuesta.setMensaje("ok");
		}else  {
			respuesta.setCodigo(500);
			respuesta.setMensaje("Credenciales incorrectas");
		}
		
		
		return respuesta;
	}

	
	public void clienteBuscarcliente (Cliente cliente){
		
	}
	
	
	public void crearSesion(Sesion sesion) {
		this.sesiondao.crearSesion(sesion);
	}
	
	public Sesion buscarSesionCorreo(String correo)  {
		return this.sesiondao.buscarSesionCorreo(correo);
	}
	
	
	public void crearCliente(Cliente cliente) {
		this.clientedao.crearCliente(cliente);
		
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
