package View;

import java.util.Scanner;

import Model.User;

public class Interfaz_Administrador extends Interfaz {
	
	Interfaz_Administrador(){
		boolean flag = true;
		int op = opciones_general();
		while (flag){
			if (op==1){		
				new_user();
			}else if (op==2){
				
			}else if (op==3){
				
			}else if (op==0){
				flag=false;
			}else{
				op = opciones_general();
			}
		}
	}

	void new_user(){
		User user = new User( new_id(), new_name(), new_password() );
	}

	private int new_id() {
		Scanner scan = new Scanner (System.in);
		System.out.println("Ingrese un id para el usuario");
		
		return Integer.parseInt(scan.nextLine());
	}

	private String new_name() {
		Scanner scan = new Scanner (System.in);
		System.out.println("Ingrese un nombre para el usuario");	
		String newName = String.valueOf(scan.nextLine());
		return newName;		
	}
	
	private String new_password() {
		Scanner scan = new Scanner (System.in);
		System.out.println("Ingrese un password para el usuario");
		String newPass = String.valueOf(scan.nextLine());
		return newPass;				
	}

	private int opciones_general(){
		Scanner scan = new Scanner (System.in);
		System.out.println("1.\tUsuarios");
		System.out.println("2.\tServicios");
		System.out.println("3.\tInventario");
		System.out.println("0.\tSalir");
		
		return Integer.parseInt(scan.nextLine());
	}
}