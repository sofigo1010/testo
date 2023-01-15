public class tiempo {
    private String tiemp;//el tiempo (si esta nublado,etx)
    private String temperatura;

    tiempo (String tim, String temp){
        tiemp = tim;
        temperatura = temp;
    }
    
    public String getTiemp() {
        return tiemp;
    }
    public void setTiemp(String tiemp) {
        this.tiemp = tiemp;
    }
    public String getTemperatura() {
        return temperatura;
    }
    public void setTemperatura(String temperatura) {
        this.temperatura = temperatura;
    }

    
    
}
