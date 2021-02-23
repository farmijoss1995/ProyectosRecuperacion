package ec.edu.ups.proyectos.Tienda.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;



/**
 * 
 * 
 * 
 */
@Entity
public class Cliente implements Serializable {
	/**
	 * Implementaci[on de la variable de serializacion
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Implementación de la variable Id, este atributo será el encargado de ser la
	 * primary key en nuestra base de datos
	 */

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(length = 10)
	private String cedula;
	private String apellidos;
	private String nombres;
	private String telefono;
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaRegistro;

	private String estado;
	private String correo;
	private String clave;
	
	@JsonIgnore
	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
	@JoinColumn(name = "cliente_comentario_id")
	private List<Comentario> comentarios;
	
	
	@JsonIgnore
	@OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
	@JoinColumn(name = "cliente_cedula")
    private List<Sesion> listaSesiones;

	

	public void addComentario(Comentario comentario) {
		if (comentarios == null) {
			comentarios = new ArrayList<>();
		}
		comentario.setFechaRegistro(new Date());
		comentarios.add(comentario);
	}


	/**
	 * Getters and setters: Metodos encargados del acceso a datos declarados
	 * públicos,los setters nos sirven para asignar un valor inicial a un atributo,
	 * pero de forma explícita, además el Setter nunca retorna nada (Siempre es
	 * void), y solo nos permite dar acceso público a ciertos atributos que deseemos
	 * el usuario pueda modificar, miestras que los getters nos sirven para obtener
	 * (recuperar o acceder) el valor ya asignado a un atributo y utilizarlo para
	 * cierto método.
	 * 
	 */

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

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

	public List<Comentario> getComentarios() {
		return comentarios;
	}

	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}

	public List<Sesion> getListaSesiones() {
		return listaSesiones;
	}

	public void setListaSesiones(List<Sesion> listaSesiones) {
		this.listaSesiones = listaSesiones;
	}


	@Override
	public String toString() {
		return "Cliente [id=" + id + ", cedula=" + cedula + ", apellidos=" + apellidos + ", nombres=" + nombres
				+ ", telefono=" + telefono + ", fechaRegistro=" + fechaRegistro + ", estado="
				+ estado + ", correo=" + correo + ", clave=" + clave + ", comentarios=" + comentarios
				+ ", listaSesiones=" + listaSesiones + "]";
	}
	
	

	
}
