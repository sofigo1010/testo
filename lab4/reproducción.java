import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class reproducción implements iReproduccion{

    private ArrayList<canciones>chillpList = new ArrayList<canciones>();
    private ArrayList<canciones>reggaetonpList = new ArrayList<canciones>();
    private boolean conectado = false;
    private canciones cancionactual = new canciones();
    private String cualplaylist;
    private ArrayList<String> listadoplst = new ArrayList<String>();

    reproducción () {
        //constructor que crea mis playlists automaticamente
        try {
            chillpList = leerplaylist("chillplaylist.txt", chillpList);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            reggaetonpList = leerplaylist("reggaetonplaylist.txt", reggaetonpList);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        cancionactual = chillpList.get(0);
        listadoplst.add("chillpList");
        listadoplst.add("reggaetonpList");

    }

    
    

    public ArrayList<canciones> leerplaylist(String filenam, ArrayList<canciones> reggaetonpList2) throws FileNotFoundException{
        File filename = new File(filenam);
        //crea las canciones que tengo en mi archivo de playlists
        String[] data;
        Scanner sc = new Scanner(filename);
        while (sc.hasNextLine()) {
            data =sc.nextLine().split(";");
            canciones u = new canciones (data [0], data[1],data[2],data[3]);
            reggaetonpList2.add(u);
        } 
        sc.close();
        return reggaetonpList2;
    }

    


    public ArrayList<canciones> getChillpList() {
        return chillpList;
    }

    public void setChillpList(ArrayList<canciones> chillpList) {
        this.chillpList = chillpList;
    }

    public ArrayList<canciones> getReggaetonpList() {
        return reggaetonpList;
    }

    public void setReggaetonpList(ArrayList<canciones> reggaetonpList) {
        this.reggaetonpList = reggaetonpList;
    }


    @Override
    public String seleccionarListaReproduccion() {
        // TODO Auto-generated method stub
        return "Lista de reproducción seleccionada!";
    }


    @Override
    public String cambiarCancion() {
        // TODO Auto-generated method stub
        return "Skip a la siguiente exitoso! Disfruta";
    }


    @Override
    public String escucharCancion() {
        // TODO Auto-generated method stub
        return "Escuchando la canción: " + cancionactual.getSongname()+"\nArtista: "+cancionactual.getArtist()+"\nDuración: "+cancionactual.getLength()+"\nPlaylist: "+cancionactual.getTipoplaylist();
    }


    public boolean isConectado() {
        return conectado;
    }


    public void setConectado(boolean conectado) {
        this.conectado = conectado;
    }

    public canciones getCancionactual() {
        return cancionactual;
    }

    public void setCancionactual(canciones cancionactual) {
        this.cancionactual = cancionactual;
    }

    public String getCualplaylist() {
        return cualplaylist;
    }

    public void setCualplaylist(String cualplaylist) {
        this.cualplaylist = cualplaylist;
    }


    public ArrayList<String> getListadoplst() {
        return listadoplst;
    }


    public void setListadoplst(ArrayList<String> listadoplst) {
        this.listadoplst = listadoplst;
    }

    
    
}
