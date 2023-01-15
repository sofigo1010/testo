import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class radio implements iRadio{
    private boolean conectado;
    private String banda;
    private ArrayList<emisoras>AM = new ArrayList<emisoras>();
    private ArrayList<emisoras>FM = new ArrayList<emisoras>();
    private ArrayList<emisoras>guardadas = new ArrayList<emisoras>();
    private emisoras emosoractual= new emisoras("LA SABROSONA","0.5","AM");

    radio () {
        conectado = true;
        banda = emosoractual.getBandaemisora();
        try {
            AM = leereEmisoras("AM.txt", AM);
        } catch (FileNotFoundException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        try {
            FM = leereEmisoras("FM.txt",FM);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        emosoractual = AM.get(0);

    }

    public ArrayList<emisoras> leereEmisoras(String filenam, ArrayList<emisoras>d) throws FileNotFoundException{
        File filename = new File(filenam);
        //crea las emisoras que tengo en mi archivo de playlists
        String[] data;
        Scanner sc = new Scanner(filename);
        while (sc.hasNextLine()) {
            data =sc.nextLine().split(";");
            emisoras u = new emisoras (data [0], data[1],data[2]);
            d.add(u);
        } 
        sc.close();
        return d;
    }


    public String getBanda() {
        return banda;
    }

    public void setBanda(String banda) {
        this.banda = banda;
    }

    public ArrayList<emisoras> getAM() {
        return AM;
    }

    public void setAM(ArrayList<emisoras> aM) {
        AM = aM;
    }

    public ArrayList<emisoras> getFM() {
        return FM;
    }

    public void setFM(ArrayList<emisoras> fM) {
        FM = fM;
    }

    public ArrayList<emisoras> getGuardadas() {
        return guardadas;
    }


    public void setGuardadas(ArrayList<emisoras> guardadas) {
        this.guardadas = guardadas;
    }


    public emisoras getEmosoractual() {
        return emosoractual;
    }



    public void setEmosoractual(emisoras emosoractual) {
        this.emosoractual = emosoractual;
    }

    public boolean isConectado() {
        return conectado;
    }

    public void setConectado(boolean conectado) {
        this.conectado = conectado;
    }

    @Override
    public String cambiarbanda() {
        // TODO Auto-generated method stub
        return "Banda cambiada a " + emosoractual.getBandaemisora();
    }

    @Override
    public String cambiaremisoras() {
        // TODO Auto-generated method stub
        return "Emisora cambiada a la siguiente! Emisora actual: "+emosoractual.getNombreemisora() + "\nFrecuencia: "+emosoractual.getFrecuenciaemisora();
    }

    @Override
    public String guardaremisora() {
        // TODO Auto-generated method stub
        return "Emisora guardada a favoritas!";
    }

    @Override
    public String cargaremisora() {
        // TODO Auto-generated method stub
        return "Emisora cargada! Disfruta";
    }
    
    
}
