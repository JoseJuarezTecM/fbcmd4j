package org.fbcmd4j;

import java.net.MalformedURLException;
import java.util.InputMismatchException;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.FacebookFactory;
import facebook4j.Page;
import facebook4j.Post;
import facebook4j.ResponseList;

public class Main {
	private static final Logger logger = LogManager.getLogger(Main.class);
	private static final Facebook facebook = new FacebookFactory().getInstance();
	private static final String APP_VERSION = "v1.0";


	public static void main(String[] args) {
		logger.info("Iniciando aplicacion.");

		int seleccion;
		try (Scanner scanner = new Scanner(System.in)){
			while(true){
				// Inicio Menu
				System.out.format("Cliente de Facebook4j %s\n\n", APP_VERSION);
				System.out.println("Opciones: ");
				System.out.println("(1) Obtener News Feed");
				System.out.println("(2) buscar paginas");
				System.out.println("(3) Publicar estado en Wall");
				System.out.println("(4) Publicar LINK en Wall");
				System.out.println("(5) Salir");
				System.out.println("\nPor favor ingrese una opcion: ");
				// Fin de Menu
				try {
					seleccion = scanner.nextInt();
					scanner.nextLine();

					switch(seleccion){
						case 1: 
							logger.info("Opcion seleccionada '(1) Obtener News Feed'");
							ResponseList<Post> feed = Utils.obtenerWall(facebook);
							
							for(Post post : feed) {
								System.out.println(post.getMessage());
							}
							
							break;
						