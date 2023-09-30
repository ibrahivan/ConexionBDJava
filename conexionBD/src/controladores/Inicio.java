package controladores;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import dtos.LibroDto;
import servicios.ImplConexion;
import servicios.InterfazConexion;
import servicios.ImplCrud;
import servicios.InterfazCrud;
import util.metodosExternos;

/**
 * Clase principal de la aplicación ivp
 */
public class Inicio {

	/**
	 * Método de acceso a la aplicación de consola
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		InterfazConexion cpi = new ImplConexion();
		InterfazCrud crud = new ImplCrud();
		metodosExternos util = new metodosExternos();
		ArrayList<LibroDto> listaLibros = new ArrayList<>();

		Scanner sc = new Scanner(System.in);
		int opcion;
		do {
			util.mostrarMenu(); // mostramos menu
			opcion = util.CapturaEntero("\n\tIntroduce una opcion", 0, 4);
			// control de errores
			while (opcion < 0 || opcion > 4) {

				System.out.println("\n\t\t\t**ERROR**");
				opcion = util.CapturaEntero("Introduce una opcion", 0, 4);
				
			}
			System.out.flush();
			switch (opcion) {

			case 1:
				try {
					Connection conexion = cpi.generaConexion();

					if (conexion != null) {
						listaLibros = crud.seleccionaTodosLibros(conexion);
						
						int opc = util.CapturaEntero("Desea ver todos los libros (Pulsa 1) o ver un solo libro (Pulsa 2)", 1, 2);
						if (opc == 1) {
							for (int i = 0; i < listaLibros.size(); i++) {
								System.out.println("\n" + listaLibros.get(i).toString());

							}
						} else {
							System.out.println("Libros disponibles según su id:");
							for (int i = 0; i < listaLibros.size(); i++)
								System.out.println("Id Libro: " + listaLibros.get(i).getIdLibro());

							System.out.println("Elige el libro que quieres ver por su id: ");
							int id = sc.nextInt();
							for (int i = 0; i < listaLibros.size(); i++) {
								if (listaLibros.get(i).getIdLibro() == id)
									System.out.println("\n" + listaLibros.get(i).toString());
								
							}
						}
						conexion.close();
					}

				} catch (Exception e) {
					System.out.println("[ERROR-Main] Se ha producido un error al ejecutar la aplicación: " + e);
				}
				break;
			case 2:
				try {
					Connection conexion = cpi.generaConexion();

					if (conexion != null) {
						System.out.println("---INSERTAR LIBROS---");
						listaLibros = crud.seleccionaTodosLibros(conexion);
						for (int i = 0; i < listaLibros.size(); i++)
							System.out.println("\n" + listaLibros.get(i).toString());
						crud.opcIDU(conexion, 1);
						conexion.close();
					}

				} catch (Exception e) {
					System.out.println("[ERROR-Main] Se ha producido un error al ejecutar la aplicación: " + e);
				}
				break;
			case 3:
				try {
					Connection conexion = cpi.generaConexion();

					if (conexion != null) {
						System.out.println("---BORRAR LIBROS---");
						listaLibros = crud.seleccionaTodosLibros(conexion);
						for (int i = 0; i < listaLibros.size(); i++)
							System.out.println("\n" + listaLibros.get(i).toString());
						crud.opcIDU(conexion, 2);
						conexion.close();
					}

				} catch (Exception e) {
					System.out.println("[ERROR-Main] Se ha producido un error al ejecutar la aplicación: " + e);
				}
				break;
			case 4:
				try {
					Connection conexion = cpi.generaConexion();

					if (conexion != null) {
						System.out.println("---ACTUALIZA LIBROS---");
						listaLibros = crud.seleccionaTodosLibros(conexion);
						for (int i = 0; i < listaLibros.size(); i++)
							System.out.println("\n" + listaLibros.get(i).toString());
						crud.opcIDU(conexion, 3);
						conexion.close();

					}

				} catch (Exception e) {
					System.out.println("[ERROR-Main] Se ha producido un error al ejecutar la aplicación: " + e);
				}
				break;

			}
			if (opcion != 0) {
				System.out.print("\n\n\tPulsa una tecla para volver al menú... ");
				sc.nextLine();
				System.out.flush();
			}

		} while (opcion != 0);
		System.out.println("\n\tSaliendo de la aplicacion  \n\tPulse cualquier tecla para cerrar el programa");
		sc.nextLine();
	}

}
