public interface iTelefono {
    public String Conectar(); // para conectar al modo teléfono
    public String desconectar();
    public String MostrarContactos();//para mostrar los contactos 
    public String LlamarContacto();//para llamar a alguien
    public String FinalizarLLamada();//para cortar la llamada
    public String PonerEnEspera();//para poner en espera la llamada
}
