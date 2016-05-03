package alumnos;
import java.io.*;

public class Alumnos implements Serializable{
    
    String nif;
    String nombre;
    String telefono;
    String direccion;
    int nota;
    
    public Alumnos(String nif,String nombre,String telefono,String direccion,int deuda){
        this.nif=nif;
        this.nombre=nombre;
        this.telefono=telefono;
        this.direccion=direccion;
        this.nota=nota;
    }
    
}