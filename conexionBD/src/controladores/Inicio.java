package controladores;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import dtos.LibroDto;
import servicios.ImplConexion;
import servicios.InterfazConexion;
import servicios.ImplConsultas;
import servicios.InterfazConsultas;

/**
 * Clase principal de la aplicación
 * ivp
 */
public class Inicio {

	/**
	 * Método de acceso a la aplicación de consola
	 * @param args
	 */
	public static void main(String[] args) {
		
		InterfazConexion cpi = new ImplConexion();
		InterfazConsultas consultaspi = new ImplConsultas();
		ArrayList<LibroDto> listaLibros = new ArrayList<>();
		
		try {
			Connection conexion = cpi.generaConexion();
			
			if(conexion != null) {
				listaLibros = consultaspi.seleccionaTodosLibros(conexion);
				for(int i=0;i<listaLibros.size();i++) {
					System.out.println(listaLibros.get(i).toString());
				}
			}	
			
		} catch (Exception e) {
			System.out.println("[ERROR-Main] Se ha producido un error al ejecutar la aplicación: " + e);
		}
		
	
		
	}
	
	

}
