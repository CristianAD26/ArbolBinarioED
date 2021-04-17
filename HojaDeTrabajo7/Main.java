import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Main {

    public static String Idioma;
    public static String IdiomaTraducido;

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        ArbolBinario<Comparador> Arbol = new ArbolBinario<Comparador>();
        int opciones=0,opciones2=0;
        boolean Iterador = false;
        boolean Iterador2=false;
        
        while (!Iterador){
        	try {
        		 
        		System.out.println("Comencemos a traducir! En que idioma esta el texto que quiere traducir?");
        	    System.out.println("\n1 Ingles\n2 Espanol\n3 Frances");
        	        
                opciones=entrada.nextInt();
            switch(opciones) {
            	case 1:
            		Idioma="Ingles";
            		Iterador=true;
            		break;
            	case 2:
            		Idioma="Espanol";
            		Iterador=true;
            		break;
            	case 3:
            		Idioma="Frances";
            		Iterador=true;
            	default:
            		System.out.println("Ingrese una opcion valida");
            		break;
            		}
             
        }catch (Exception e) {
        	
        	System.out.println("El valor ingresado es invalido\n");
        	entrada.next();
        
        	}
        
        }

    
        entrada.nextLine();
        Iterador2=false;
        while (!Iterador2){
        	try {
        	     System.out.println("A que idioma desea realizar la traduccion? ");
        	     System.out.println("\n1 Ingles\n2 Espanol\n3 Frances");
        	        
                opciones2=entrada.nextInt();
            switch(opciones2) {
            	case 1:
            		IdiomaTraducido="Ingles";
            		Iterador2=true;
            		break;
            	case 2:
            		IdiomaTraducido="Frances";
            		Iterador2=true;
            		break;
            	case 3:
            		IdiomaTraducido="Espanol";
            		Iterador2=true;
            		break;
            	default:
            		System.out.println("Ingrese una opcion valida");
            		break;
            		}
             
        }catch (Exception e) {
        	
        	System.out.println("El valor ingresado es invalido\n");
        	entrada.next();
        
        	}
        }

        try {
            File myObj = new File("Diccionario.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] words = data.split(",");
                Comparador word = new Comparador(words[0],words[1],words[2]);
              
                Arbol.add(word);
                
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Se ha detectado un error");
            e.printStackTrace();
        }

        try {
            File myObj = new File("texto.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String Texto = myReader.nextLine();
                System.out.println("\nTexto a traducir:");
                System.out.println(Texto);
                Texto=Texto.replace("*","");
                String[] palabras = Texto.split(" ");
                for (int i=0;i<palabras.length;i++){
                    if (Arbol.locate(new Comparador(palabras[i])) != null){
                        palabras[i] = Arbol.locate(new Comparador(palabras[i])).value.getWord(IdiomaTraducido);
                    }
                }
                Texto = String.join(" ",palabras);
                System.out.println("\nTexto traducido:");
                System.out.println(Texto);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Se ha detectado un error ");
            e.printStackTrace();
        }


    }
}

