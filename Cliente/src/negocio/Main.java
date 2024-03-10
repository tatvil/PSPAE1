package negocio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Main {
	public static final int PUERTO = 2017;
	public static final String IP_SERVER = "localhost";
	
	public static void main(String[] args) {
		System.out.println("        APLICACI�N CLIENTE         ");
		System.out.println("-----------------------------------");

		InetSocketAddress direccionServidor = new InetSocketAddress(IP_SERVER, PUERTO);
		
		try (Scanner sc = new Scanner(System.in)){
						
			System.out.println("CLIENTE: Esperando a que el servidor acepte la conexion");
			Socket socketAlServidor = new Socket();
			socketAlServidor.connect(direccionServidor);
			System.out.println("CLIENTE: Conexion establecida a " + IP_SERVER + " por el puerto " + PUERTO);

			InputStreamReader entrada = new InputStreamReader(socketAlServidor.getInputStream());
			BufferedReader entradaBuffer = new BufferedReader(entrada);
			
			PrintStream salida = new PrintStream(socketAlServidor.getOutputStream());
			
			String opcion = "";
			do {
				System.out.println("1. Consultar pelicula por ID");
				System.out.println("2. Consultar pelicula por titulo");
				System.out.println("3. Salir de la aplicacion");
				System.out.println("CLIENTE: Escribe una opcion (3 para terminar): ");
				opcion = sc.nextLine();//frase que vamos a mandar para contar
				
				switch (opcion) {
				case "1":
					System.out.println("CLIENTE: Escribe el ID de la pelicula: ");
					String id = sc.nextLine();
					salida.println(opcion + "-" + id);
					break;
				case "2":
					System.out.println("CLIENTE: Escribe el titulo de la pelicula: ");
					String titulo = sc.nextLine();
					salida.println(opcion + "-" + titulo);
					break;
				case "3":
					break;
				}
				
				salida.println(opcion);
				System.out.println("CLIENTE: Esperando respuesta ...... ");				
				String respuesta = entradaBuffer.readLine();
				
				System.out.println("CLIENTE: Servidor responde: " + respuesta);
				
			}while(!opcion.equals("3"));
			//Cerramos la conexion
			socketAlServidor.close();
		} catch (UnknownHostException e) {
			System.err.println("CLIENTE: No encuentro el servidor en la direccion" + IP_SERVER);
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("CLIENTE: Error de entrada/salida");
			e.printStackTrace();
		} catch (Exception e) {
			System.err.println("CLIENTE: Error -> " + e);
			e.printStackTrace();
		}
		
		System.out.println("CLIENTE: Fin del programa");
	}

}
