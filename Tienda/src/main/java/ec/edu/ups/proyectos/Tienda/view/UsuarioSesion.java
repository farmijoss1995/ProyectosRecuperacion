package ec.edu.ups.proyectos.Tienda.view;

import java.io.Serializable;

public class UsuarioSesion implements Serializable {
	private String correo;
	private String clave;
	private String nuevaClave;
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public String getNuevaClave() {
		return nuevaClave;
	}
	public void setNuevaClave(String nuevaClave) {
		this.nuevaClave = nuevaClave;
	}
	@Override
	public String toString() {
		return "UsuarioSesion [correo=" + correo + ", clave=" + clave + ", nuevaClave=" + nuevaClave + "]";
	}
	
	
}
