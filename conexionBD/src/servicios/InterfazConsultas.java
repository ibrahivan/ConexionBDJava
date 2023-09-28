package servicios;

import java.sql.Connection;
import java.util.ArrayList;

import dtos.LibroDto;

/**
 * Interfaz que define los métodos de consulta a Postgresql
 * ivp
 */
public interface InterfazConsultas {
	
	/**
	 * Método que realiza un select all sobre el catálogo de libros
	 * ivp
	 * @param conexionGenerada
	 * @return lista de libros
	 */
	public ArrayList<LibroDto> seleccionaTodosLibros(Connection conexionGenerada);
	
}
