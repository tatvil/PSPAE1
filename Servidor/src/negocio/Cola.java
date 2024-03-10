package negocio;

import java.util.LinkedList;
import java.util.Queue;

import entidad.Pelicula;

public class Cola {
	
	public final static int MAX_ELEMENTOS = 3;
	

	private Queue<Pelicula> cola = new LinkedList<>();
	
	
	public synchronized void addMensaje(Pelicula pelicula){

		while(cola.size() == MAX_ELEMENTOS){
			try {
				wait();
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}
		
		cola.offer(pelicula);

		notify();
	}
	
	public synchronized Pelicula getMensaje(){
		Pelicula s = null;
		while(cola.size() == 0){
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		s = cola.poll();

		notify();
		return s;
	}
	
}
