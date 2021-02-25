package ec.edu.ups.proyectos.Tienda.service;

import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import ec.edu.ups.proyectos.Tienda.model.Cliente;
import ec.edu.ups.proyectos.Tienda.model.Comentario;
import ec.edu.ups.proyectos.Tienda.on.TransaccionON;
import ec.edu.ups.proyectos.Tienda.view.UsuarioSesion;

@Path("tienda")
public class serRest {

	@Inject
	TransaccionON on;
	
	@POST
	@Path("/login")
	@Produces("application/json")
	@Consumes("application/json")
	public Respuesta logIn(UsuarioSesion usuarioSesion) {
		Respuesta r = new Respuesta();
		try {
			r = on.clienteLogIn(usuarioSesion);
		} catch (Exception e) {
			e.printStackTrace();
			r.setCodigo(99);
			r.setMensaje(e.getMessage());
		}
		return r;
	}
	
	@POST
	@Path("/comentario")
	@Produces("application/json")
	@Consumes("application/json")
	public Respuesta comentarioC(Comentario comentario) {
		Respuesta com = new Respuesta();
		try {
			this.on.crearComentario(comentario);
			com.setCodigo(1);
			com.setMensaje("Recibido");
		} catch (Exception e) {
			e.printStackTrace();
			com.setCodigo(99);
			com.setMensaje(e.getMessage());
		}
		return com;
	}
	
	@GET
	@Path("clientelogincorreo")
	@Produces("application/json")
	public Cliente buscarClienteLogin(@QueryParam("correo") String correo) {
		try {
			return on.obtenerClienteLogin(correo);
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
	@GET
	@Path("comentarios")
	@Produces("application/json")
	public List <Comentario> comentarios() {
		try {
			return on.getComentarios();
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}


}
