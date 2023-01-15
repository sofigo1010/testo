import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class contactos {
    private String Nombre;
    private String Numero;

    
    public contactos(String nombre, String numero) {
        Nombre = nombre;
        Numero = numero;
    }

    public String getNombre() {
        return Nombre;
    }
    
    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getNumero() {
        return Numero;
    }
    public void setNumero(String numero) {
        Numero = numero;
    }


    
}
