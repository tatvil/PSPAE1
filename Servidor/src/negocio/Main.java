package negocio;

import java.util.ArrayList;

import entidad.Pelicula;

public class Main {

	public static void main(String[] args) {
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
		
	}

}
