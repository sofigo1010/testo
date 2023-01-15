import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class productividad implements iProductividad{
    private ArrayList<tiempo>tiempos = new ArrayList<tiempo>();//posibles tiempos que podrían presentarse
    private boolean conectado = false;

    productividad (){
        try {
            tiempos = leertTiempos(tiempos);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    public ArrayList<tiempo> leertTiempos(ArrayList<tiempo> tem) throws FileNotFoundException{
        File filename = new File("tiempo.txt");
        //crea tiempos aleatorios que tengo en mi archivo 
        String[] data;
        Scanner sc = new Scanner(filename);
        while (sc.hasNextLine()) {
            data =sc.nextLine().split(";");
            tiempo u = new tiempo (data [0], data[1]);
            tem.add(u);
        } 
        sc.close();
        return tem;
    }

    @Override
    public String vertiempo() {
        //obtiene un valor random para luego obtener el posible tiempo de la arraylist utilizando su numero de indice
        Random rand = new Random();
        int rands = rand.nextInt(tiempos.size());
        String tiempito = "El pronóstico del tiempo actual es:\n"+tiempos.get(rands).getTiemp()+"\nLa temperatura es de: "+tiempos.get(rands).getTemperatura();
        return tiempito;
        // TODO Auto-generated method stub
        
    }


    
    public ArrayList<tiempo> getTiempos() {
        return tiempos;
    }



    public void setTiempos(ArrayList<tiempo> tiempos) {
        this.tiempos = tiempos;
    }


    public boolean isConectado() {
        return conectado;
    }


    public void setConectado(boolean conectado) {
        this.conectado = conectado;
    }
    
}
