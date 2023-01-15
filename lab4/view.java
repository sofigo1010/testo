import javax.swing.JOptionPane;

public class view {
    int respuesta = 0;
    String resp = "";
    radio radioc = new radio();
    telefono tel = new telefono();
    productividad productivity = new productividad();
    reproducción repro = new reproducción();


    public int menu(){
        //opciones del menu y dependiendo de qué modo esté activo, imprime en pantalla la situación
        if (radioc.isConectado() == true){
            respuesta = Integer.parseInt(JOptionPane.showInputDialog("Bienvenid@ al simulador de radio de Mercedes-Benz del carro clase C!\nQué desea hacer?\n1. Ver opciones de modo Radio\n2. Ver opciones de modo teléfono\n3. Ver opciones de modo reproducción\n4. Ver opciones de modo productividad\n5. Salir de simulación"+"\n\n\nActualmente estás en modo radio!\nEmisora actual: " + radioc.getEmosoractual().getNombreemisora()+"\nFrecuencia: "+ radioc.getEmosoractual().getFrecuenciaemisora()+"\nBanda: "+radioc.getEmosoractual().getBandaemisora()));
        }
        else if (tel.isConectado() == true){
            if ( tel.isLlamadaespera() == false){
                respuesta = Integer.parseInt(JOptionPane.showInputDialog("Bienvenid@ al simulador de radio de Mercedes-Benz del carro clase C!\nQué desea hacer?\n1. Ver opciones de modo Radio\n2. Ver opciones de modo teléfono\n3. Ver opciones de modo reproducción\n4. Ver opciones de modo productividad\n5. Salir de simulación"+"\n\n\nActualmente estás en modo teléfono y no tienes llamadas en espera"));
            }
            else if (tel.isLlamadaespera() == true){
                respuesta = Integer.parseInt(JOptionPane.showInputDialog("Bienvenid@ al simulador de radio de Mercedes-Benz del carro clase C!\nQué desea hacer?\n1. Ver opciones de modo Radio\n2. Ver opciones de modo teléfono\n3. Ver opciones de modo reproducción\n4. Ver opciones de modo productividad\n5. Salir de simulación"+"\n\n\nActualmente estás en modo teléfono y tienes una llamada en espera"));
            }
            
        }
        else if (productivity.isConectado() == true){
            respuesta = Integer.parseInt(JOptionPane.showInputDialog("Bienvenid@ al simulador de radio de Mercedes-Benz del carro clase C!\nQué desea hacer?\n1. Ver opciones de modo Radio\n2. Ver opciones de modo teléfono\n3. Ver opciones de modo reproducción\n4. Ver opciones de modo productividad\n5. Salir de simulación"+"\n\n\nActualmente estás en modo productividad\n"+productivity.vertiempo()));
        }
        else if (repro.isConectado() == true){
            respuesta = Integer.parseInt(JOptionPane.showInputDialog("Bienvenid@ al simulador de radio de Mercedes-Benz del carro clase C!\nQué desea hacer?\n1. Ver opciones de modo Radio\n2. Ver opciones de modo teléfono\n3. Ver opciones de modo reproducción\n4. Ver opciones de modo productividad\n5. Salir de simulación"+"\n\n\nActualmente estás en modo reproducción\n"+repro.escucharCancion() ));
        }
        return respuesta;
    }

    public int menuradio(){
        //opciones del radio
        radioc.setConectado(true);
        tel.setConectado(false);
        productivity.setConectado(false);
        repro.setConectado(false);
        respuesta = Integer.parseInt(JOptionPane.showInputDialog("Opciones del modo Radio!\n1. Cambiar de banda\n2. Pasar a la siguiente emisora\n3. Guardar emisora actual en favoritos\n4. Cargar emisora de las favoritas\nQué deseas hacer?"));
        return respuesta;
    }
    public void bandacambio(){
        //ensena mensaje de cambio de banda
        JOptionPane.showMessageDialog(null, radioc.cambiarbanda());
    }

    public void invalido(){
        JOptionPane.showMessageDialog(null, "Respuesta inválida, intente de nuevo");
    }
    
    public void emisoracambiada(){
        //mensaje de cambio de emisora exitoso
        JOptionPane.showMessageDialog(null, "\n"+radioc.cambiaremisoras());
    }
    public void guardaremisora(){
        //mensaje de emisora guardada
        JOptionPane.showMessageDialog(null, radioc.guardaremisora());
    }
    public int cargaremisora(){
        //escoger que emisora quiere cargar
        String emisorasg = "";
        for (int i = 0; i< radioc.getGuardadas().size();i++){
            emisorasg = i + ". " +radioc.getGuardadas().get(i).getNombreemisora()+"\n";
        }
        respuesta = Integer.parseInt(JOptionPane.showInputDialog("Lista de emisoras guardadas:\n\n" + emisorasg+"Cuál te gustaría escuchar? Ingresa su número de índice"));
        return respuesta;
    }
    public void cargadaexitosa(){
        //mensaje de carga exitosa
        JOptionPane.showMessageDialog(null, radioc.cargaremisora());
    }

    public int menutelefono(){
        //menu del telefono 
        radioc.setConectado(false);
        tel.setConectado(true);
        productivity.setConectado(false);
        repro.setConectado(false);
        respuesta = Integer.parseInt(JOptionPane.showInputDialog("Opciones del modo teléfono!\n1. Conectar teléfono \n2. Desconectar teléfono\n3. Mostrar contactos\n4. Realizar llamada\n5. Finalizar llamada\n6. Cambiar a llamada en espera\nQué deseas hacer?"));
        return respuesta;
    }

    public void conectartel (){
        //metodo para conectar telefono
        if (tel.isConectado() == true){
            JOptionPane.showMessageDialog(null, "Tu teléfono ya está conectado");
        }
        else if (tel.isConectado() == false){
            JOptionPane.showMessageDialog(null,tel.Conectar());
            radioc.setConectado(false);
            tel.setConectado(true);
            productivity.setConectado(false);
            repro.setConectado(false);
        }
    }

    public void desconectartel(){
        //metodo para desconectar el telefono y regresar al default que es radio
        if (tel.isConectado() == false){ 
            JOptionPane.showMessageDialog(null, "Tu teléfono ya está desconectado");
        }
        if (tel.isConectado() ==true){
            JOptionPane.showMessageDialog(null, tel.desconectar()+"\n\nRegresando a modo default: Modo Radio");
            radioc.setConectado(true);
            tel.setConectado(false);
            productivity.setConectado(false);
            repro.setConectado(false);
        }
    }

    public void mostrarcontactos(){
        //muestra los contactos del teléfono
        resp = "Lista de contactos en el teléfono:\n\n";
        for (int i = 0; i< tel.getContactosn().size(); i++){
            resp += i + ". " + tel.getContactosn().get(i).getNombre()+"\n";
        }
        JOptionPane.showMessageDialog(null, resp);
    }

    public int llamada(){
        //para escoger a quien llamar
        resp = "Lista de contactos en el teléfono:\n\n";
        for (int i = 0; i< tel.getContactosn().size(); i++){
            resp += i + ". " + tel.getContactosn().get(i).getNombre()+"\n";
        }
        resp += "\nA quién quieres llamar? ingresa su número de índice";
        respuesta = Integer.parseInt(JOptionPane.showInputDialog(resp));
        return respuesta;
    }
    public void llamadaactivada(){
        //para decir a quien llama
        JOptionPane.showMessageDialog(null, tel.LlamarContacto()+tel.getLlamadaactivada());
    }
    public void llamadaenaccion(){
        //para decir que ya está en una llamada
        JOptionPane.showMessageDialog(null, "Ya tienes una llamada activa, cuelga primero");
    }
    public void cortarllamada(){
        //cortar llamada
        respuesta = Integer.parseInt(JOptionPane.showInputDialog(null, "Quieres: \n1. Cortar llamada en espera \n2. Cortar llamada activa"));
        if ( respuesta == 2){ 
            if (tel.isLlamadaactiva() == true){
                tel.setLlamadaactiva(false);
                tel.setLlamadaactivada(null);
                JOptionPane.showMessageDialog(null, tel.FinalizarLLamada());
            }
            else if (tel.isLlamadaactiva() == false && tel.isLlamadaespera() == false){
                JOptionPane.showMessageDialog(null, "No tenías ninguna llamada activa");
            }
        }
        else if ( respuesta == 1){
            if (tel.isLlamadaespera() == true){
                tel.setLlamadaespera(false);
                tel.setLlamadaenespera(null);
                JOptionPane.showMessageDialog(null, tel.FinalizarLLamada());
            }
            else if (tel.isLlamadaactiva() == false && tel.isLlamadaespera() == false){
                JOptionPane.showMessageDialog(null, "No tenías ninguna llamada en espera activa");
            }

        }

    }

    public void llamadaenespera (){
        //poner llamada en espera
        if ( tel.isLlamadaactiva() ==true && tel.isLlamadaespera() == false){
            tel.setLlamadaactiva(false);
            tel.setLlamadaespera(true);
            tel.setLlamadaenespera(tel.getLlamadaactivada());
            tel.setLlamadaactivada(null);
            JOptionPane.showMessageDialog(null, tel.PonerEnEspera());
        }
        else if (tel.isLlamadaactiva() == false && tel.isLlamadaespera() ==true || tel.isLlamadaactiva() == true && tel.isLlamadaespera() ==true){
            JOptionPane.showMessageDialog(null, "Ya tienes una llamada en espera, cuelga primero");
        }
        else if (tel.isLlamadaactiva() == false && tel.isLlamadaespera() == false){
            JOptionPane.showMessageDialog(null, "No tienes ninguna llamada para poner en espera");
        }
    }


    public int menureproduccion(){
        //menu del reproductor 
        radioc.setConectado(false);
        tel.setConectado(false);
        productivity.setConectado(false);
        repro.setConectado(true);
        respuesta = Integer.parseInt(JOptionPane.showInputDialog("Opciones del modo reproducción!\n1. Seleccionar lista de reproducción \n2. Cambiar de canción\n3. Escuchar canción\n\nQué deseas hacer?"));
        return respuesta;
    }

    public int seleccionarplaylist(){
        //escoger la playlist que quiere
        resp = "Listado de playlists:\n";
        for (int i =0; i < repro.getListadoplst().size();i++){
            resp += i + ". " + repro.getListadoplst().get(i)+"\n";
        }
        respuesta = Integer.parseInt(JOptionPane.showInputDialog(null, resp));
        return respuesta;
    }

    public int cambiarcancion(){
        //opcion si quiere skip o regresar cancion
        respuesta = Integer.parseInt(JOptionPane.showInputDialog(null, "Quieres:\n1. Skip a la siguiente\n2. Regresar a la canción anterior"));
        return respuesta;
    }

    public void cancioncambiada(){
        //indica que se cambio la cancion
        repro.cambiarCancion();
    }

    public void nohaycancion(){
        //indica que no hay canción previa
        JOptionPane.showMessageDialog(null, "No hay ninguna canción antes que esta.");
    }

    public void escucharcancion(){
        JOptionPane.showMessageDialog(null, repro.escucharCancion());
    }

    public void menuproductividad(){
        //para carro tipo c solo es ver el pronóstico del tiempo
        radioc.setConectado(false);
        tel.setConectado(false);
        productivity.setConectado(true);
        repro.setConectado(false);
        JOptionPane.showMessageDialog(null, productivity.vertiempo());
    }

    public void despedida(){
        //mensaje de despedida
        JOptionPane.showMessageDialog(null, "Gracias por utilizar nuestro simulador! Esperamos te haya gustado, hasta pronto!");
    }

}
