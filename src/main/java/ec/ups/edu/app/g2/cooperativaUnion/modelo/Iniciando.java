package ec.ups.edu.app.g2.cooperativaUnion.modelo;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

import ec.ups.edu.app.g2.cooperativaUnion.DAO.CuentaAhorroDAO;
import ec.ups.edu.app.g2.cooperativaUnion.DAO.EmpleadoDAO;
import ec.ups.edu.app.g2.cooperativaUnion.EN.Empleado;

@Startup
@Singleton
public class Iniciando {
	
	@Inject
	private EmpleadoDAO eDAO;
	
	
	
	@PostConstruct
	public void init() {
		
		if(eDAO.listarEmpleados().size() == 0) {
			Empleado e =new Empleado();
			e.setCedula("0104898721");
			e.setNombre("Fabian");
			e.setApellido("Armijos");
			e.setCargo("admin");
			e.setDireccion("Av Americas");
			e.setCorreo("marceloas@hotmail.es");
			e.setPassword("admin");
			eDAO.insertEmpleado(e);
		}
	
		if(eDAO.listarEmpleados().size() == 0) {
			Empleado e1 =new Empleado();
			e1.setCedula("0104898722");
			e1.setNombre("Domenica");
			e1.setApellido("Muñoz");
			e1.setCargo("admin");
			e1.setDireccion("Sayausi");
			e1.setCorreo("domenica@hotmail.es");
			e1.setPassword("admin");
			eDAO.insertEmpleado(e);
	}

}
	
}
