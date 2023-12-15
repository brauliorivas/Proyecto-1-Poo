package com.cristian.proyecto1;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Usuarios {

	protected List<String> registro = new ArrayList<>();
	protected Scanner entradaOpc = new Scanner(System.in);
	protected Scanner entradaU = new Scanner(System.in);
	protected Scanner entradaE = new Scanner(System.in);
	protected Menu menuPrincipal;
	protected String opcion;
	protected int contador = 0;
	protected int id = 0;
	
	public Usuarios() {
		menu();
	}
	
	protected void menu() {
		System.out.println("\nUsuarios:\n\n" + "1)Listar usuarios.\n" + "2)Crear usuarios.\n" + "3)Editar usuarios.\n" + "4)Eliminar usuarios.\n" + "5)Volver atrás.\n");
		System.out.println("Opción:");
		
		opcion = entradaOpc.next();
		
		switch(opcion) {
			case "1":
				listar();
				break;
			case "2":
				crear();
				break;
			case "3":
				editar();
				break;
			case "4":
				eliminar();
				break;
			case "5":
				volverAtras();
				break;
				
			default:
				System.out.println("\nLa opción ingresada no es valida.");
				menu();
				break;
		}
	}
	
	protected void listar() {
		if(registro[0] == null) {
			System.out.println("\nActualmente no hay información de usuarios.");
			menu();
		}else {
			System.out.println("\n");
			Iterator<String> it = registro.iterator();
			int i = 0;
			if (it.hasNext()) {
				while (it.hasNext()) {
					System.out.println(c + "." + it.next());
				}
			} else {
				System.out.println(c + ".");
			}
			menu();
		}
	}
	
	protected void crear() {
		if(contador >= registro.length) {
			System.out.println("\nLo sentimos, a excedido el limite de usuarios permitidos.");
			menu();
		}else {
			System.out.println("\nPor favor ingrese el usuario a registrar:");
			registro[contador] = entradaU.next();
			contador++;
			System.out.println("El usuario a sido registrado con exito.");
			menu();
		}
	}

	protected void editar() {
		for(int c = 0; c < registro.length; c++) {
			if(registro[c] == null) {
				System.out.println("\nLo sentimos, no existe ningun registro de usuarios.");
				menu();
			}else {
				System.out.println("\nPor favor indique el id del usuario ha editar:");
				id = entradaE.nextInt();
				
				if(id >= registro.length) {
					System.out.println("\nLo sentimos, el valor ingresado no es valido.");
					menu();
				}else {
					if(registro[id] != null) {
						System.out.println("\nIndique el nuevo nombre de usuario:");
						registro[id] = entradaU.next();
						System.out.println("\nEl usuario fue editado correctamente.");
						menu();
					}else {
						System.out.println("\nLo sentimos, no se puede editar un campo vacio.");
						menu();
					}
				}
			}
		}
	}

	protected void eliminar() {
		for(int i = 0; i < registro.length; i++) {
			if(registro[i] == null) {
				System.out.println("\nLo sentimos, la base de datos se encuentra vacia.");
				menu();
			}else {
				System.out.println("\nPor favor indique el id del usuario ha eliminar:");
				id = entradaE.nextInt();
				
				if(registro[id] != null) {
					if(id < registro.length) {
						for(int c = id; c < registro.length; c++) {
							if((c + 1) < registro.length) {
								registro[c] = null;
								registro[c] = registro[c + 1];
								registro[c + 1] = null;
							}else {
								registro[c] = null;
							}
						}
						contador -= 1;
						System.out.println("\nEl registro se ha eliminado con éxito.");
					}else {
						System.out.println("\nEl id proporcinado no es valido.");
					}
					menu();
				}else {
					System.out.println("\nLo sentimos, no se puede eliminar un campo vacio.");
					menu();
				}
			}
		}
	}
	
	public void volverAtras() {
		menuPrincipal = new Menu();
	}
}
