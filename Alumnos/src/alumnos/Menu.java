package alumnos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;

public class Menu {

    public static void main(String[] args) {
        
        String nif=null;
        String nombre=null;
        String telefono=null;
        String direccion=null;
        int nota=0;
        boolean error=true;
        int opcion;
        Scanner teclado = new Scanner(System.in);
        
        do{
            try{
                error=true;
                System.out.println();
                System.out.println("1.- AÑADIR Alumno");
                System.out.println("2.- LISTAR Alumnos");
                System.out.println("3.- SALIR DE LA APLICACION");
                System.out.println();
                System.out.print("SELECCIONE UNA OPCION DEL MENU: ");
                opcion = teclado.nextInt();
                System.out.println();
            }
            catch(InputMismatchException ime){
                System.out.println("El tipo de dato introducido no es correcto");
                error = true;
                continue;
            }
            catch(Exception e){
                System.out.println("Error de teclado");
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
                            System.out.print("Introduzca el NIF del Alumno: ");
                            nif = teclado.nextLine();
                            
                            error=false;
                        }
                        catch(Exception e){
                            System.out.println(e.getMessage());
                            error=true;
                            continue;
                        }
                    }
                    while(error);
                    
                    do{
                        try{
                            error=true;
                            System.out.print("Introduzca el nombre del Alumno: ");
                            nombre=teclado.nextLine();
                            
                            error=false;
                        }
                        catch(Exception e){
                            System.out.println(e.getMessage());
                            error=true;
                            continue;
                        }
                    }
                    while(error);
                    
                    do{
                        try{
                            error=true;
                            System.out.print("Introduzca el teléfono del Alumno: ");
                            telefono=teclado.nextLine();
                            
                            error=false;
                        }
                        catch(Exception e){
                            System.out.println(e.getMessage());
                            error=true;
                            continue;
                        }
                    }
                    while(error);
                    
                    do{
                        try{
                            error=true;
                            System.out.print("Introduzca la dirección del Alumno: ");
                            direccion=teclado.nextLine();
                            
                            error=false;
                        }
                        catch(Exception e){
                            System.out.println(e.getMessage());
                            error=true;
                            continue;
                        }
                    }
                    while(error);
                    
                    do{
                        try{
                            error=true;
                            System.out.print("Introduzca la nota del alumno: ");
                            nota=teclado.nextInt();
                            error=false;
                        }
                        catch(InputMismatchException ime){
                            System.out.println("El tipo de dato introducido no es correcto");
                            error=true;
                            continue;
                        }
                        catch(Exception e){
                            System.out.println("Error de teclado");
                            error=true;
                            continue;
                        }
                    }
                    while(error);
                    
                        Alumnos alumno = new Alumnos (nif,nombre,telefono,direccion,nota);
                        anadirAlumno(alumno);
                        error=true;
                        break;
                }
                    
                case 2:{
                    listarAlumnos();
                    error=true;
                    break;
                }
                    
                
                    
                case 3:{
                    error=false;
                    break;
                }
            }           
        }
        while(error);
        System.out.println("Fin del programa");
    }
  public static void  anadirAlumno(Alumnos alumno){
        try{ 
            File fichero = new File("cli.dat");
            if(fichero.exists()==false){
                fichero.createNewFile();
            }
           
             FileOutputStream flujo = new FileOutputStream(fichero,true);
            if(tieneRegistros())
            {               
           ObjectOutputStream escritor = new MiObjectOutputStream(flujo);
            
            escritor.writeObject(alumno);
            escritor.close();}
           else
            {    
            ObjectOutputStream escritor = new ObjectOutputStream(flujo);
            
            escritor.writeObject(alumno);
            }
        }
        catch(IOException ioe){
            System.out.println("Error de fichero");
        }
        catch(Exception e){
            System.out.println("Error de fichero");
        }
    }
    
    public static void listarAlumnos(){
        try{
            File fichero = new File("cli.dat");
            FileInputStream flujo = new FileInputStream(fichero);
            
            
            
            
            
            // Implementa el codigo que falta
       
        
        
        
        
        
        
        
        
        
        
        }
        catch(FileNotFoundException fnfe){
            System.out.println("Fichero no encontrado");
        }
        catch(IOException ioe){
            System.out.println("Error de fichero");
        }
        catch(Exception e){
            System.out.println("Error de fichero");
        }
    }
    
    
     private static boolean tieneRegistros(){
       boolean tiene = false ;
        
         try {
            
         File fichero = new File("cli.dat");
            FileInputStream flujo = new FileInputStream(fichero);
            ObjectInputStream lector = new ObjectInputStream(flujo);
            
         
        Alumnos alumno = null ;
        

            // Leer el objeto del fichero
            alumno = (Alumnos) lector.readObject();

            if (alumno != null)
                tiene = true ;
            flujo.close();
            lector.close();
        } catch (FileNotFoundException e) {
            System.out.println( "Error: " + e.getMessage() ) ;
        } catch (Exception ex) {
            System.out.println( "Capturada excepción en tieneRegistros()" ) ;}
        finally {
          // fiCliLec.close();
          //  fluent.close();
       }

        return(tiene);
    }

}  

