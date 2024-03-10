package negocio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.lang.reflect.Array;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import entidad.Pelicula;

public class SocketServidor {
    
    public static final int PUERTO = 2017;
    
    public static void main(String[] args) {
        System.out.println("      APLICACION DE SERVIDOR      ");
        System.out.println("----------------------------------");
        cargarPeliculas();

        InputStreamReader entrada = null;
        PrintStream salida = null;
        
        try (ServerSocket serverSocket = new ServerSocket()){            
            
            InetSocketAddress direccion = new InetSocketAddress(PUERTO);
            serverSocket.bind(direccion);
            
            int peticion = 0;

            while(true) {    
                
                System.out.println("SERVIDOR: Esperando peticion por el puerto " + PUERTO);
                

                Socket socketAlCliente = serverSocket.accept();
                System.out.println("SERVIDOR: peticion numero " + ++peticion + " recibida");
                
                entrada = new InputStreamReader(socketAlCliente.getInputStream());
                BufferedReader bf = new BufferedReader(entrada);
                                
                
                String stringRecibido = bf.readLine();//3-4
                

                System.out.println("SERVIDOR: Me ha llegado del cliente: " + stringRecibido);

                String[] operadores = stringRecibido.split("-");
                int opcion = Integer.parseInt(operadores[0]);
                Pelicula resultado = null;
                switch (opcion) {
                    case 1:
                        System.out.println("SERVIDOR: El cliente ha elegido la opcion 1");
                        int idPelicula = Integer.parseInt(operadores[1]);
                        System.out.println("SERVIDOR: El cliente ha elegido la opcion 1 con el id: " + idPelicula);
                        resultado=buscarPeliculaPorId(idPelicula);
                        
                        break;
                    case 2:
                        System.out.println("SERVIDOR: El cliente ha elegido la opcion 2");
                        break;
                    case 3:
                        System.out.println("SERVIDOR: El cliente ha elegido la opcion 3. Cerrando la conexión...");
                        socketAlCliente.close(); // Cerramos la conexión con el cliente
                        break;
                    default:
                        System.out.println("SERVIDOR: Opción no reconocida");
                        break;
                }
                
                
                // Calculamos la suma u otra operación según la petición
                
                
                System.out.println("SERVIDOR: El resultado de la operación es: " + resultado);
                                
                // Enviamos el resultado al cliente
                salida = new PrintStream(socketAlCliente.getOutputStream());
                salida.println(resultado);

                // Cerramos la conexión con el cliente actual
                socketAlCliente.close();
            }                
        } catch (IOException e) {
            System.err.println("SERVIDOR: Error de entrada/salida");
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("SERVIDOR: Error -> " + e);
            e.printStackTrace();
        } finally {
            try {
                if (entrada != null) entrada.close();
                if (salida != null) salida.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

	private static Pelicula buscarPeliculaPorId(int idPelicula) {

		ArrayList<Pelicula> peliculas = cargarPeliculas();
		Pelicula peliculaEncontrada = null;
		for (Pelicula pelicula : peliculas) {
			if (pelicula.getId() == idPelicula) {
				System.out.println("SERVIDOR: Pelicula encontrada: " + pelicula);
				peliculaEncontrada = pelicula;
			}
		}	
		return peliculaEncontrada;
	}
	
	private static void buscarPeliculaPorTitulo(String titulo) {
		// TODO Auto-generated method stub

	}
	
	private static ArrayList<Pelicula> cargarPeliculas() {
		ArrayList<Pelicula> peliculas = new ArrayList<Pelicula>();
		peliculas.add(new Pelicula(1, "El Padrino", "Francis Ford Coppola", 10));
		peliculas.add(new Pelicula(2, "El Padrino II", "Francis Ford Coppola", 10));
		peliculas.add(new Pelicula(3, "El Padrino III", "Francis Ford Coppola", 10));
		peliculas.add(new Pelicula(4, "Terminator", "James Cameron", 15));
		peliculas.add(new Pelicula(5, "Terminator 2", "James Cameron", 15));
		peliculas.add(new Pelicula(6, "Terminator 3", "Jonathan Mostow", 15));
		peliculas.add(new Pelicula(7, "Matrix", "Lana Wachowski", 20));
		peliculas.add(new Pelicula(8, "Matrix Reloaded", "Lana Wachowski", 20));
		peliculas.add(new Pelicula(9, "Matrix Revolutions", "Lana Wachowski", 20));
		peliculas.add(new Pelicula(10, "Titanic", "James Cameron", 25));
		peliculas.add(new Pelicula(11, "Avatar", "James Cameron", 25));
		peliculas.add(new Pelicula(12, "Alien", "Ridley Scott", 20));
		peliculas.add(new Pelicula(13, "Aliens", "James Cameron", 20));
		peliculas.add(new Pelicula(14, "E.T.", "Steven Spielberg", 20));
		peliculas.add(new Pelicula(15, "Indiana Jones", "Steven Spielberg", 20));
		peliculas.add(new Pelicula(16, "Star Wars", "George Lucas", 30));
		peliculas.add(new Pelicula(17, "El Señor de los Anillos", "Peter Jackson", 30));
		peliculas.add(new Pelicula(18, "Harry Potter", "Chris Columbus", 30));
		peliculas.add(new Pelicula(19, "Jurassic Park", "Steven Spielberg", 25));
		peliculas.add(new Pelicula(20, "Parque Jurásico", "Steven Spielberg", 25));
		peliculas.add(new Pelicula(21, "La Lista de Schindler", "Steven Spielberg", 25));
		return peliculas;
	}
}
