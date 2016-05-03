/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ficherodirecto;

import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;


import java.util.*;

public class FicheroDirecto {
    
    
    
    
    
    
    public static void consultarArticulo(int codArticulo){
        
        try{
            String descripcion="";
            int precio=0,i=0;
            int codigo;
            int unidades=0;
            File fichero = new File("fichDir.txt");
            
            RandomAccessFile flujo = new RandomAccessFile(fichero,"rw");
            
            flujo.seek((codArticulo-1)*50);
            codigo=flujo.readInt();
            if(codigo==codArticulo){
               
                for(i=0;i<19;i++)
                    descripcion+=flujo.readChar();                
            
            precio = flujo.readInt();
            unidades = flujo.readInt();
            System.out.println("INFORMACION DE LA PELICULA SOLICITADA");
            System.out.println("CODIGO: "+codArticulo);
            System.out.println("DIRECTOR: "+descripcion);
            System.out.println("AÃ‘O: "+precio);
            System.out.println("UNIDADES: "+unidades);}
            else 
             System.out.println("la pelicula no esta dada de alta");   
            flujo.close();
            System.out.println();
            }
            catch(FileNotFoundException fnfe){
                System.out.println("No se ha encontrado el fichero");
            }
            catch(EOFException eofe){
                System.out.println("La pelÃ­cula consultada no existe");
            }
            catch(IOException ioe){
                System.out.println("Error de lectura");
            }
            catch(Exception e){
                System.out.println("Error de fichero");
            }
    }
    
    //Cada registro del fichero tiene 50 bytes
    public static void AltaArticulo(int codArticulo,String descripción,int precio,int unidades){
        
        try{
            File fichero = new File("fichDir.txt");
            
            RandomAccessFile flujo =new RandomAccessFile(fichero,"rw");
           
            
            
            
            
            
            // El registro tiene 40 bytes
            // implementa el codigo que falta
            
            
            
            
            
            
            
            
            
        }catch(IOException ioe){
            System.out.println("Error de acceso al fichero");
        }
        catch(Exception e){
            System.out.println("Error de fichero");
        }
    }
    
    

    public static void main(String[] args) {
        
        int codArticulo=0;
        String descripcion=null;
        int precio=0;
        int unidades=0;
        boolean error=true;
        int opcion=0;
        Scanner teclado = new Scanner(System.in);
        do{
            try{
                error=true;
                System.out.println("1.- ALTAS");
                System.out.println("2.- CONSULTAS");
                
                System.out.println("3.- SALIR DEL PROGRAMA");
                System.out.println();
                System.out.print("SELECCIONE UNA OPCIÃ“N DEL MENÃš: ");
                opcion=teclado.nextInt();
                if(opcion<0||opcion>3){
                    System.out.println("Seleccione una opciÃ³n correcta");
                }
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
            finally{
                teclado.nextLine();
            }
            
            switch(opcion){
                
                case 1:{
                    // Implementa el codigo que falta
                    error=true;
                    FicheroDirecto.AltaArticulo(codArticulo,descripcion,precio,unidades);
                break;
                }
                    
                
                    
                case 2:{
                    do{
                        try{
                            error=true;
                            System.out.print("Introduzca el cÃ³digo del articulo a consultar: ");
                            codArticulo=teclado.nextInt();
                            FicheroDirecto.consultarArticulo(codArticulo);
                            error=false;
                        }
                        catch(InputMismatchException ime){
                            System.out.println("Debe introducir un nÃºmero entero");
                            error=true;
                        }
                        catch(Exception e){
                            System.out.println(e.getMessage());
                            error=true;
                        }
                        finally{
                            teclado.nextLine();
                        }
                    }
                    while(error);
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
        public static void crearfichero(){
       // Crea un fichero vacio con los cóodigos de pelicula con valor cero
            int i;
            String descripcion="bcccccccccccccccccccbbbnnnnnnnnnnnnnnnnnn";
            descripcion=descripcion.substring(0,19);
            
                try{
            File fichero = new File("fichDir.txt");
            fichero.delete();
            
                fichero.createNewFile();
            
            //Crea un flujo de E/S para un fichero de acceso directo, en modo rw para grabar
            RandomAccessFile flujo =new RandomAccessFile(fichero,"rw");
           for(i=1;i<=1000;i++) 
           {flujo.writeInt(0);
            flujo.writeChars(descripcion);
            flujo.writeInt(0);
            flujo.writeInt(0);}
           
            flujo.close();
        }catch(IOException ioe){
            System.out.println("Error de acceso al fichero");
        }
        catch(Exception e){
            System.out.println("Error de fichero");
        }
    }
    }

