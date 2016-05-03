package ficherosecuencial;
import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class FicheroSecuencial {
    
    public static void altaFichero(String nombre,String dni,String direccion,String telefono){
        
        try{
            
            File fichero = new File("fichSec.txt");
            if(!fichero.exists()){
            fichero.createNewFile();
            }
           
            FileWriter flujo = new FileWriter(fichero,true);
            PrintWriter escritor = new PrintWriter(flujo);
            escritor.println(nombre);
            escritor.println(dni);
            escritor.println(direccion);
            escritor.println(telefono);
            escritor.close();
        }
        catch (IOException ioe){
            System.out.println("Error al crear el fichero");
        }
        catch (Exception e){
            System.out.println("Error de fichero");
        }
        
    }
    
  
      public static void consulta(String dniConsulta){ 
    String nombre,dni,dirección,telefono;
          try{
            File fichero = new File("fichSec.txt");
            
            FileReader flujo = new FileReader(fichero);
            
            Scanner lector = new Scanner(flujo);
            
            
            
            
            
                      
           // implementa el código que falta
       
            
            
            
            
            
            
        }
        catch(IOException ioe){
            System.out.println("Error al leer el fichero");
        }
        catch(Exception e){
            System.out.println("Error de fichero");
        }
    }
    
    
    
    
    
    
    
           
           

   
        public static void main(String[] args) {
            
            String nombre=null;
            String dni=null;
            String direccion=null;
            String telefono=null;
           
            boolean error=true;
            int opcion=0;
            
            Scanner teclado = new Scanner(System.in);
        
            do{
                try{
                    opcion=0;
                    error=true;
                    System.out.println("1.- ALTAS");
                    System.out.println("2.- CONSULTAS");
                    
                    System.out.println("3.- SALIR DEL PROGRAMA");
                    System.out.println();
                    System.out.print("Seleccione una opción del menú: ");
                    opcion=teclado.nextInt();
                    if(opcion<1||opcion>3){
                        System.out.println("Seleccione una opción entre el 1 y el 3");
                    }
                }
                catch(InputMismatchException ime){
                    System.out.println("El tipo de dato introducido no es correcto");
                    error=true;
                    continue;
                }
                finally{
                    teclado.nextLine();
                }

                switch(opcion){

                    case 1:{
                            do{
                                try{
                                    error=true;
                                    System.out.print("Introduzca el nombre del alumno: ");
                                    nombre=teclado.nextLine();
                                    error=false;                               
                                }
                                catch(Exception e){
                                    System.out.println(e.getMessage());
                                    error=true;
                                }
                            }
                            while(error);

                            do{
                                try{
                                    error=true;
                                    System.out.print("Introduzca el DNI del alumno: ");
                                    dni=teclado.nextLine();
                                   
                                    error=false;
                                }
                                catch(Exception e){
                                    System.out.println(e.getMessage());
                                    error=false;
                                }
                            }
                            while(error);

                            do{
                                try{
                                    error=true;
                                    System.out.print("Introduzca la dirección del alumno: ");
                                    direccion=teclado.nextLine();
                                    
                                    error=false;
                                }
                                catch(Exception e){
                                    System.out.println(e.getMessage());
                                    error=false;
                                }
                            }
                            while(error);

                            do{
                                try{
                                    error=true;
                                    System.out.print("Introduzca el telefono del alumno: ");
                                    telefono=teclado.nextLine();
                                    
                                    error=false;
                                }
                                catch(Exception e){
                                    System.out.println(e.getMessage());
                                    error=false;
                                }
                            
                            
                            } while(error); 
                            
                            FicheroSecuencial.altaFichero(nombre,dni,direccion,telefono);
                            error=true;
                            break;
                            }
                        
                    case 2:{
                        System.out.print("Introduzca el DNI del alumno a consultar: ");
                        String dniBuscar=teclado.nextLine();
                        try{
                         
                            
                            FicheroSecuencial.consulta(dniBuscar); 
                        
                        
                        }
                        catch(Exception e){
                            System.out.println("Error de lectura");
                            error=true;}
                            break;
                        }
                     


                                            
                    
                    
                        
                    case 3:{
                        error=false;
                        break;
                    }
                }

            }while(error);
            System.out.println("Fin del programa");
    }
}
