package controladores;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;

import CRUD.HuespedesCRUD;
import utils.Conexion;
import modelo.Huespedes;

public class HuespedesControlador {
	private HuespedesCRUD huespedesCrud;
	
	
	public HuespedesControlador() {
		Connection connection = new Conexion().getConexion();
		this.huespedesCrud = new HuespedesCRUD(connection);
	}
	
	public void guardar(Huespedes huespedes) {
		this.huespedesCrud.guardar(huespedes);
	}
	
	public  List<Huespedes> buscarHuespedes(){
		return this.huespedesCrud.buscar();
	}
	
	public  List<Huespedes> buscarHuespedesId(String id){
		return this.huespedesCrud.buscarId(id);
	}
	
	public void actualizar(String nombre, String apellido, Date fechaNacimiento, String nacionalidad, String telefono,Integer id_reserva) {
		this.huespedesCrud.actualizar(nombre, apellido, fechaNacimiento, nacionalidad, telefono,id_reserva, null);
	}
	 
	public void Eliminar(Integer idReserva) {
		this.huespedesCrud.Eliminar(idReserva);
	}
	
	
}
