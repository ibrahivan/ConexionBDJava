package servicios;

import java.sql.Connection;
import java.util.ArrayList;

import dtos.LibroDto;

/**
 * Interfaz que define los métodos de consulta a Postgresql
 * ivp
 */
public interface InterfazCrud {
	
	/**
	 * Método que realiza un select all sobre el catálogo de libros
	 * ivp
	 * @param conexionGenerada
	 * @return lista de libros
	 */
	public ArrayList<LibroDto> seleccionaTodosLibros(Connection conexionGenerada);
	
	/**
	 * Método que inserta libros en el catálogo de libros
	 * ivp
	 * @param conexionGenerada
	 * @return lista de libros
	 */
	public void insertaLibros(Connection conexionGenerada);
	
	/**
	 * Método que borra libros del catálogo de libros
	 * ivp
	 * @param conexionGenerada
	 * @return lista de libros
	 */
	public ArrayList<LibroDto> borraLibros(Connection conexionGenerada, ArrayList<LibroDto>l);
	
	/**
	 * Método que realiza actualizaciones sobre el catálogo de libros
	 * ivp
	 * @param conexionGenerada
	 * @return lista de libros
	 */
	public ArrayList<LibroDto> actualizaLibros(Connection conexionGenerada);

	
	
}
