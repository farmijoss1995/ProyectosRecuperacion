package ec.edu.ups.proyectos.Tienda.view;

import java.io.IOException;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.UUID;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIData;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

import ec.edu.ups.proyectos.Tienda.model.Cliente;
import ec.edu.ups.proyectos.Tienda.model.Comentario;
import ec.edu.ups.proyectos.Tienda.model.Sesion;
import ec.edu.ups.proyectos.Tienda.on.TransaccionON;



@Named
@ViewScoped
public class ClienteB implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private FacesContext facesContext;
	
	@Inject
	private TransaccionON transaccionon;

	private Cliente newcliente;
	
	private Comentario newComentario;
	
	private Sesion newSesion;

	private UIData usersDataTable;
	
	

	int intento = 1;

	public void setUsersDataTable(UIData usersDataTable) {
		this.usersDataTable = usersDataTable;
	}

	public UIData getUsersDataTable() {
		return usersDataTable;
	}

//private Usuario usuarioLogin;
	
	@PostConstruct
	public void init() {
		/*this.newcliente= 
		this.usuarioLogin=recuperarUsuarioLogin(); 
		newcliente = new Cliente();

		listarClientes();*/
	}

	public String agregarCliente() throws Exception {
		
			try {
				// usuarioon.crearUsuario(usuario);
				this.transaccionon.crearCliente(newcliente);
				
			} catch (Exception e) {
				// TODO: handle exception
			}

		//}
		return null;
	}

	public String agregarComentario() throws Exception {
		
		try {
			// usuarioon.crearUsuario(usuario);
			this.transaccionon.crearComentario(newComentario);
			
		} catch (Exception e) {
			// TODO: handle exception
		}

	//}
	return null;
}

	public String addComentario() {
		Comentario comentario = new Comentario();
		comentario.setCliente(newcliente);
		newcliente.addComentario(comentario);

		return null;
	}

	

	public String login() throws Exception {
		String retorno = null;
		Cliente clienteLogeado = transaccionon.obtenerClienteLogin(newcliente.getCorreo());
		Sesion sesion = new Sesion();
		if (clienteLogeado.getCorreo().equals(newcliente.getCorreo())) {
			if (clienteLogeado.getClave().equals(newcliente.getClave())) {
				setUsuarioOK(sesion, clienteLogeado);
				intento = 1;
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("cliente", clienteLogeado);
				retorno = "cuentasCliente?faces-redirect=true";
			} else {
				sesion.setCorreo(this.newcliente.getCorreo());
				sesion.setClave(this.newcliente.getClave());
				sesion.setEstado("fallido");
				sesion.setFecha(new Date());
				sesion.setIntentos(intento++);
				this.transaccionon.crearSesion(sesion);
				//this.sesionon.crearSesion(sesion);
				retorno = "loginCliente?faces-redirect=true";
				/*if (intento > 3) {
					//clienteLogeado.setEstado("InAct");
					//this.clienteon.actualizarCliente(clienteLogeado);
				}*/
				
			} 
			}/*else {
				retorno = "loginCliente?faces-redirect=true";

		}*/

		return retorno;
	}

	public void setUsuarioOK(Sesion sesion, Cliente clienteLogeado) {
		sesion.setCorreo(clienteLogeado.getCorreo());
		sesion.setClave(clienteLogeado.getClave());
		sesion.setEstado("satisfactorio");
		sesion.setFecha(new Date());
		sesion.setIntentos(1);
		this.transaccionon.crearSesion(sesion);
		//this.sesionon.crearSesion(sesion);

	}

	public void clienteInLogin() {
		FacesContext fc = FacesContext.getCurrentInstance();
		Cliente usuarioLogin = (Cliente) fc.getExternalContext().getSessionMap().get("cliente");
		try {
			if (usuarioLogin!=null) {
			} else {
				fc.getExternalContext().redirect("loginCliente.xhtml");
			}
		} catch (IOException e) {

		}
	}
	public List<Comentario> listar() {
		
		return this.transaccionon.getComentarios();
	}
	
	
	public String cuentaparm() {
		//System.out.println("parametro de entrada "+newcuenta.getId());
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("cliente", newcliente.getId());		
		return null;//"transaccionesCuenta?faces-redirect=true";
	}

	/**
	 * Getteres ansd setters
	 */

	public FacesContext getFacesContext() {
		return facesContext;
	}

	public void setFacesContext(FacesContext facesContext) {
		this.facesContext = facesContext;
	}

	public Cliente getNewcliente() {
		return newcliente;
	}

	public void setNewcliente(Cliente newcliente) {
		this.newcliente = newcliente;
	}

	public Comentario getNewComentario() {
		return newComentario;
	}

	public void setNewComentario(Comentario newComentario) {
		this.newComentario = newComentario;
	}

	public Sesion getNewSesion() {
		return newSesion;
	}

	public void setNewSesion(Sesion newSesion) {
		this.newSesion = newSesion;
	}
	
	

}
