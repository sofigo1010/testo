public class emisoras {
    private String nombreemisora;
    private String frecuenciaemisora;
    private String bandaemisora;

    emisoras (String nombre, String numero, String banda){
        nombreemisora = nombre;
        frecuenciaemisora = numero;
        bandaemisora = banda;
    }
    emisoras (){}

    public String getNombreemisora() {
        return nombreemisora;
    }

    public void setNombreemisora(String nombreemisora) {
        this.nombreemisora = nombreemisora;
    }

    public String getFrecuenciaemisora() {
        return frecuenciaemisora;
    }

    public void setFrecuenciaemisora(String frecuenciaemisora) {
        this.frecuenciaemisora = frecuenciaemisora;
    }

    public String getBandaemisora() {
        return bandaemisora;
    }

    public void setBandaemisora(String bandaemisora) {
        this.bandaemisora = bandaemisora;
    }
    
    

    
    
}
