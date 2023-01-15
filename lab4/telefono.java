import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class telefono implements iTelefono{
    private boolean conectado = false;
    private boolean llamadaactiva = false;
    private boolean llamadaespera = false;
    private String llamadaenespera;
    private String llamadaactivada;
    private ArrayList<contactos> contactosn = new ArrayList<contactos>();

    telefono () {
        try {
            contactosn = leercContactos(contactosn);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    public ArrayList<contactos> leercContactos( ArrayList<contactos>d) throws FileNotFoundException{
        File filename = new File("contactos.txt");
        //crea las canciones que tengo en mi archivo de playlists
        String[] data;
        Scanner sc = new Scanner(filename);
        while (sc.hasNextLine()) {
            data =sc.nextLine().split(";");
            contactos u = new contactos (data [0], data[1]);
            d.add(u);
        } 
        sc.close();
        return d;
    }
    
    
    public boolean isConectado() {
        return conectado;
    }
    public void setConectado(boolean conectado) {
        this.conectado = conectado;
    }
    public boolean isLlamadaactiva() {
        return llamadaactiva;
    }
    public void setLlamadaactiva(boolean llamadaactiva) {
        this.llamadaactiva = llamadaactiva;
    }
    public boolean isLlamadaespera() {
        return llamadaespera;
    }
    public void setLlamadaespera(boolean llamadaespera) {
        this.llamadaespera = llamadaespera;
    }
    public String getLlamadaenespera() {
        return llamadaenespera;
    }
    public void setLlamadaenespera(String llamadaenespera) {
        this.llamadaenespera = llamadaenespera;
    }
    public ArrayList<contactos> getContactosn() {
        return contactosn;
    }
    public void setContactosn(ArrayList<contactos> contactosn) {
        this.contactosn = contactosn;
    }
    @Override
    public String Conectar() {
        // TODO Auto-generated method stub
        return "Teléfono conectado";
    }
    @Override
    public String desconectar() {
        // TODO Auto-generated method stub
        return "Teléfono desconectado";
    }
    @Override
    public String MostrarContactos() {
        // TODO Auto-generated method stub
        return "Lista de contactos:";
    }
    @Override
    public String LlamarContacto() {
        // TODO Auto-generated method stub
        return "Llamando a: ";
    }
    @Override
    public String FinalizarLLamada() {
        // TODO Auto-generated method stub
        return "Llamada finalizada";
    }
    @Override
    public String PonerEnEspera() {
        // TODO Auto-generated method stub
        return "Llamada puesta en espera";
    }
    public String getLlamadaactivada() {
        return llamadaactivada;
    }
    public void setLlamadaactivada(String llamadaactivada) {
        this.llamadaactivada = llamadaactivada;
    }

    
}
