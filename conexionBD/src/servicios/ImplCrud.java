package servicios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import java.util.Scanner;
import dtos.LibroDto;
import util.ADto;

/**
 * Implementación de la interfaz de consultas sobre Postgresql ivp
 */
public class ImplCrud implements InterfazCrud {

	@Override
	public ArrayList<LibroDto> seleccionaTodosLibros(Connection conexionGenerada) {

		Statement declaracionSQL = null;
		ResultSet resultadoConsulta = null;
		ArrayList<LibroDto> listaLibros = new ArrayList<>();
		ADto adto = new ADto();

		try {

			// Se abre una declaración
			declaracionSQL = conexionGenerada.createStatement();
			// Se define la consulta de la declaración y se ejecuta
			resultadoConsulta = declaracionSQL.executeQuery("SELECT * FROM \"gbp_almacen\".\"gbp_alm_cat_libros\"");

			// Llamada a la conversión a dtoAlumno
			listaLibros = adto.resultsALibrosDto(resultadoConsulta);
			int i = listaLibros.size();
			System.out.println("[INFORMACIÓN-ImplCrud-seleccionaTodosLibros] Número libros: " + i);

			System.out.println(
					"[INFORMACIÓN-ImplCrud-seleccionaTodosLibros] Cierre conexión, declaración y resultado");
			resultadoConsulta.close();
			declaracionSQL.close();
			conexionGenerada.close();

		} catch (SQLException e) {

			System.out.println(
					"[ERROR-ImplCrud-seleccionaTodosLibros] Error generando o ejecutando la declaracionSQL: "
							+ e);
			return listaLibros;

		}
		return listaLibros;

	}

	@Override
	public void insertaLibros(Connection conexionGenerada) {
		// TODO Auto-generated method stub

		PreparedStatement declaracionSQL = null;
		
		ArrayList<LibroDto> listaLibros = new ArrayList<>();
		
		LibroDto libro = new LibroDto();
		Scanner sc = new Scanner(System.in);
		System.out.println("Título del libro:");
		libro.setTitulo(sc.next());
		System.out.println("Autor del libro:");
		libro.setAutor(sc.next());
		System.out.println("ISBN del libro:");
		libro.setIsbn(sc.next());
		System.out.println("Edicion del libro:");
		libro.setEdicion(sc.nextInt());
		
	
		
		try {
			
			
			// Se abre una declaración
			declaracionSQL =  conexionGenerada.prepareStatement("INSERT INTO gbp_almacen.gbp_alm_cat_libros (titulo, autor, isbn, edicion) VALUES (?,?,?,?)");
			// Se define la consulta de la declaración y se ejecuta
			//Se insertan los datos
			declaracionSQL.setString(1, libro.getTitulo());
			declaracionSQL.setString(2, libro.getAutor());
			declaracionSQL.setString(3, libro.getIsbn());
			declaracionSQL.setInt(4, libro.getEdicion());
			declaracionSQL.executeUpdate();
			
			declaracionSQL.close();
			conexionGenerada.close();

		} catch (SQLException e) {

			System.out.println(
					"[ERROR-ImplCrud-insertaLibros] Error generando o ejecutando la declaracionSQL: "
							+ e);
			

		}
		

	}
 
	@Override
	public ArrayList<LibroDto> borraLibros(Connection conexionGenerada, ArrayList<LibroDto>l ) {
		// TODO Auto-generated method stub
		Statement declaracionSQL = null;
		
		ArrayList<LibroDto> listaLibros = new ArrayList<>();
	
		LibroDto libro = new LibroDto();
		Scanner sc = new Scanner(System.in);
		System.out.println("Que libro quiere borrar por su id: ");
		libro.setIdLibro(sc.nextLong());
		
		
		try {
			// Se abre una declaración y se define la consulta de la declaración y se ejecuta
			declaracionSQL = conexionGenerada.prepareStatement("DELETE FROM gbp_almacen.gbp_alm_cat_libros WHERE libro_id = ?");
			
			
			
			declaracionSQL.close();
			conexionGenerada.close();

		} catch (SQLException e) {

			System.out.println(
					"[ERROR-ImplCrud-borraLibros] Error generando o ejecutando la declaracionSQL: "
							+ e);
			return listaLibros;

		}
		return listaLibros;

	}

	@Override
	public ArrayList<LibroDto> actualizaLibros(Connection conexionGenerada) {
		// TODO Auto-generated method stub
		Statement declaracionSQL = null;
		ResultSet resultadoConsulta = null;
		ArrayList<LibroDto> listaLibros = new ArrayList<>();
		ADto adto = new ADto();
		try {
			// Se abre una declaración
			declaracionSQL = conexionGenerada.createStatement();
			// Se define la consulta de la declaración y se ejecuta
			resultadoConsulta = declaracionSQL.executeQuery("SELECT * FROM \"gbp_almacen\".\"gbp_alm_cat_libros\"");

			// Llamada a la conversión a dtoAlumno
			listaLibros = adto.resultsALibrosDto(resultadoConsulta);
			int i = listaLibros.size();
			System.out.println("[INFORMACIÓN-ImplCrud-actualizaLibros] Número libros: " + i);

			System.out.println(
					"[INFORMACIÓN-ImplCrud-actualizaLibros] Cierre conexión, declaración y resultado");
			resultadoConsulta.close();
			declaracionSQL.close();
			conexionGenerada.close();

		} catch (SQLException e) {

			System.out.println(
					"[ERROR-ImplCrud-actualizaLibros] Error generando o ejecutando la declaracionSQL: "
							+ e);
			return listaLibros;

		}
		return listaLibros;

	}

	
}
