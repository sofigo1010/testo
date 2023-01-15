public class canciones {
    private String artist;//nombre del cantante
    private String songname;//nombre de la cancion
    private String length;
    private String tipoplaylist;

    canciones (String art, String song, String len, String tipo){
        artist = art;
        songname = song;
        length = len;
        tipoplaylist = tipo;
    }
    canciones (){
    
    }
    
    public String getArtist() {
        return artist;
    }
    public void setArtist(String artist) {
        this.artist = artist;
    }
    public String getSongname() {
        return songname;
    }
    public void setSongname(String songname) {
        this.songname = songname;
    }
    public String getLength() {
        return length;
    }
    public void setLength(String length) {
        this.length = length;
    }//duracion de la cancion
    public String getTipoplaylist() {
        return tipoplaylist;
    }
    public void setTipoplaylist(String tipoplaylist) {
        this.tipoplaylist = tipoplaylist;
    }
    
    
}
