package ec.edu.ups.proyectos.Tienda.view;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ConversationScoped;
//import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import javax.inject.Named;

import ec.edu.ups.proyectos.Tienda.model.Sesion;
import ec.edu.ups.proyectos.Tienda.on.TransaccionON;

@Named
@ConversationScoped
public class SesionB implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	TransaccionON sesionon;
	
	private Sesion sesion;
	private List<Sesion> sesiones;
	
	@PostConstruct
	public void init() {
		this.sesion= new Sesion();
		
		//listarSesiones();
	}

	public String agregarSesion() {
		this.sesionon.crearSesion(sesion);
		this.sesion = null;
		return null;
	}
	

	public void verificarSesion() {
		
	}
	
	public Sesion getSesion() {
		return sesion;
	}
	public void setSesion(Sesion sesion) {
		this.sesion = sesion;
	}
	public List<Sesion> getSesiones() {
		return sesiones;
	}
	public void setSesiones(List<Sesion> sesiones) {
		this.sesiones = sesiones;
	}

}
