public class controlador {
    view v = new view();
    boolean simulador = true;
    int choice;
    int innerchoice;

    public void menu (){
        while (simulador == true){
            //ver menu principal
            choice = v.menu();
            if (choice == 1){
                //acciones de la radio
                innerchoice = v.menuradio();
                if (innerchoice ==1){
                    //cambiar de banda
                    if (v.radioc.getBanda().equals("AM")){
                        v.radioc.setEmosoractual(v.radioc.getFM().get(0));
                        v.radioc.setBanda(v.radioc.getEmosoractual().getBandaemisora());
                        v.bandacambio();
                    }
                    else if (v.radioc.getBanda().equals("FM")){
                        v.radioc.setEmosoractual(v.radioc.getAM().get(0));
                        v.radioc.setBanda(v.radioc.getEmosoractual().getBandaemisora());
                        v.bandacambio();
                    }
                }
                else if (innerchoice == 2){
                    //cambiar a la siguiente emisora

                    if (v.radioc.getBanda().equals("AM")){
                        boolean cambio = false;
                        int next=0;
                        int actual=0;
                        for (int i = 0; i <v.radioc.getAM().size();i++){
                            if (v.radioc.getAM().get(i).getNombreemisora().equals(v.radioc.getEmosoractual().getNombreemisora())){
                               cambio = true;
                               next = i +1;
                               actual = i;
                               break;
                            }
                            else{
                                cambio = false;
                                continue;
                            }
                        }
                        while (cambio == true){
                            if (v.radioc.getAM().get(actual).getNombreemisora().equals(v.radioc.getEmosoractual().getNombreemisora())&&next < v.radioc.getAM().size()){
                                //si aun cabe en el tamano del array, pasa al siguiente
                                v.radioc.setEmosoractual(v.radioc.getAM().get(next));
                                v.emisoracambiada();
                                break;
                            }
                            else if (v.radioc.getAM().get(actual).getNombreemisora().equals(v.radioc.getEmosoractual().getNombreemisora())&&next >= v.radioc.getAM().size()){
                                //si no cabe entonces regresa a la primera de la lista
                                v.radioc.setEmosoractual(v.radioc.getAM().get(0));
                                v.emisoracambiada();
                                break;
                            }
                        }
                    }
                    else if (v.radioc.getBanda().equals("FM")){
                        boolean cambio = false;
                        int next=0;
                        int actual=0;
                        for (int i = 0; i <v.radioc.getFM().size();i++){
                            if (v.radioc.getFM().get(i).getNombreemisora().equals(v.radioc.getEmosoractual().getNombreemisora())){
                               cambio = true;
                               next = i +1;
                               actual = i;
                               break;
                            }
                            else{
                                cambio = false;
                                continue;
                            }
                        }
                        while (cambio == true){
                            if (v.radioc.getFM().get(actual).getNombreemisora().equals(v.radioc.getEmosoractual().getNombreemisora())&&next < v.radioc.getFM().size()){
                                //si aun cabe en el tamano del array, pasa al siguiente
                                v.radioc.setEmosoractual(v.radioc.getFM().get(next));
                                v.emisoracambiada();
                                break;
                            }
                            else if (v.radioc.getFM().get(actual).getNombreemisora().equals(v.radioc.getEmosoractual().getNombreemisora())&&next >= v.radioc.getFM().size()){
                                //si no cabe entonces regresa a la primera de la lista
                                v.radioc.setEmosoractual(v.radioc.getFM().get(0));
                                v.emisoracambiada();
                                break;
                            }
                        }
                    }

                }
                else if (innerchoice == 3){
                    //guardar emisora actual
                    v.radioc.getGuardadas().add( v.radioc.getEmosoractual());
                    v.guardaremisora();
                }
                else if (innerchoice ==4){
                    //cargar emisoras favoritas
                    innerchoice = v.cargaremisora();
                    if ( innerchoice <= v.radioc.getGuardadas().size()){
                        v.radioc.setEmosoractual(v.radioc.getGuardadas().get(innerchoice));
                        v.cargadaexitosa();
                    }
                    else {
                        v.invalido();
                    }
                }
                else{
                    v.invalido();
                }

            }
            else if (choice == 2){
                //menu telefono
                innerchoice = v.menutelefono();
                if (innerchoice == 1){
                    //conectar telefono
                    v.conectartel();
                }
                else if (innerchoice ==2){
                    //desconectar telefono
                    v.desconectartel();
                }
                else if (innerchoice == 3){
                    //mostrar contactos
                    v.mostrarcontactos();
                }
                else if ( innerchoice == 4){
                    //realizar llamada
                    innerchoice =v.llamada();
                    if (innerchoice <= v.tel.getContactosn().size() && v.tel.isLlamadaactiva() == false){
                        //si si esta dentro del rango
                        v.tel.setLlamadaactiva(true);
                        v.tel.setLlamadaactivada(v.tel.getContactosn().get(innerchoice).getNombre());
                        v.llamadaactivada();
                    }
                    else if (innerchoice <= v.tel.getContactosn().size() && v.tel.isLlamadaactiva() == true){
                        v.llamadaenaccion();
                    }
                    else {
                        v.invalido();
                    }
                }
                else if (innerchoice ==5){
                    //finalizar llamada
                    v.cortarllamada();

                }
                else if (innerchoice == 6){
                    //cambiar a llamada en espera
                    v.llamadaenespera();
                }  
                else {
                    v.invalido();
                } 

            }
            else if (choice == 3){
                //menu reproducción
                innerchoice = v.menureproduccion();
                if ( innerchoice == 1){
                    innerchoice = v.seleccionarplaylist();
                    if ( innerchoice ==0){
                        v.repro.setCancionactual(v.repro.getChillpList().get(1));
                        v.repro.setCualplaylist(v.repro.getChillpList().get(1).getTipoplaylist());
                    }
                    else if (innerchoice == 1){
                        v.repro.setCancionactual(v.repro.getReggaetonpList().get(1));
                        v.repro.setCualplaylist(v.repro.getReggaetonpList().get(1).getTipoplaylist());
                    }
                    else{
                        v.invalido();
                    }
                }
                else if ( innerchoice == 2){
                    //cambiar de canción
                    int choice2 = v.cambiarcancion();
                    if (choice2 == 1){
                        //hacia adelante
                        if (v.repro.getCancionactual().getTipoplaylist().equals("chill")){
                            boolean cambio = false;
                            int next=0;
                            int actual=0;
                            for (int i = 0; i <v.repro.getChillpList().size();i++){
                                if (v.repro.getCancionactual().getSongname().equals(v.repro.getChillpList().get(i).getSongname())){
                                   cambio = true;
                                   next = i +1;
                                   actual = i;
                                   break;
                                }
                                else{
                                    cambio = false;
                                    continue;
                                }
                            }
                            while (cambio == true){
                                if (v.repro.getChillpList().get(actual).getSongname().equals(v.repro.getCancionactual().getSongname())&&next < v.repro.getChillpList().size()){
                                    //si aun cabe en el tamano del array, pasa al siguiente
                                    v.repro.setCancionactual(v.repro.getChillpList().get(next));
                                    v.cancioncambiada();
                                    break;
                                }
                                else if (v.repro.getChillpList().get(actual).getSongname().equals(v.repro.getCancionactual().getSongname())&&next >= v.repro.getChillpList().size()){
                                    //si no cabe entonces regresa a la primera de la lista
                                    v.repro.setCancionactual(v.repro.getChillpList().get(0));
                                    v.cancioncambiada();
                                    break;
                                }
                            }


                        }
                        else if (v.repro.getCancionactual().getTipoplaylist().equals("reggaeton")){
                            boolean cambio = false;
                            int next=0;
                            int actual=0;
                            for (int i = 0; i <v.repro.getReggaetonpList().size();i++){
                                if (v.repro.getCancionactual().getSongname().equals(v.repro.getReggaetonpList().get(i).getSongname())){
                                   cambio = true;
                                   next = i +1;
                                   actual = i;
                                   break;
                                }
                                else{
                                    cambio = false;
                                    continue;
                                }
                            }
                            while (cambio == true){
                                if (v.repro.getReggaetonpList().get(actual).getSongname().equals(v.repro.getCancionactual().getSongname())&&next < v.repro.getReggaetonpList().size()){
                                    //si aun cabe en el tamano del array, pasa al siguiente
                                    v.repro.setCancionactual(v.repro.getReggaetonpList().get(next));
                                    v.cancioncambiada();
                                    break;
                                }
                                else if (v.repro.getReggaetonpList().get(actual).getSongname().equals(v.repro.getCancionactual().getSongname())&&next >= v.repro.getReggaetonpList().size()){
                                    //si no cabe entonces regresa a la primera de la lista
                                    v.repro.setCancionactual(v.repro.getReggaetonpList().get(0));
                                    v.cancioncambiada();
                                    break;
                                }
                            }


                        }
                    }
                    else if (choice2 ==2){
                        //hacia atras
                        if (v.repro.getCancionactual().getTipoplaylist().equals("chill")){
                            boolean cambio = false;
                            int past=0;
                            int actual=0;
                            for (int i = 0; i <v.repro.getChillpList().size();i++){
                                if (v.repro.getCancionactual().getSongname().equals(v.repro.getChillpList().get(i).getSongname())){
                                   cambio = true;
                                   past = i -1;
                                   actual = i;
                                   break;
                                }
                                else{
                                    cambio = false;
                                    continue;
                                }
                            }
                            while (cambio == true){
                                if (v.repro.getChillpList().get(actual).getSongname().equals(v.repro.getCancionactual().getSongname())&&past <= v.repro.getChillpList().size()&&past>=0){
                                    //si es del mismo tamano del array o menor, pero no 0 regresa
                                    v.repro.setCancionactual(v.repro.getChillpList().get(past));
                                    v.cancioncambiada();
                                    break;
                                }
                                else if (v.repro.getChillpList().get(actual).getSongname().equals(v.repro.getCancionactual().getSongname())&&past < 0){
                                    //si no cabe entonces indica que no hay canción anterior
                                    v.nohaycancion();
                                    break;
                                }
                            }


                        }
                        else if (v.repro.getCancionactual().getTipoplaylist().equals("reggaeton")){
                            boolean cambio = false;
                            int next=0;
                            int actual=0;
                            for (int i = 0; i <v.repro.getReggaetonpList().size();i++){
                                if (v.repro.getCancionactual().getSongname().equals(v.repro.getReggaetonpList().get(i).getSongname())){
                                   cambio = true;
                                   next = i +1;
                                   actual = i;
                                   break;
                                }
                                else{
                                    cambio = false;
                                    continue;
                                }
                            }
                            while (cambio == true){
                                if (v.repro.getReggaetonpList().get(actual).getSongname().equals(v.repro.getCancionactual().getSongname())&&next < v.repro.getReggaetonpList().size()){
                                    //si aun cabe en el tamano del array, pasa al siguiente
                                    v.repro.setCancionactual(v.repro.getReggaetonpList().get(next));
                                    v.cancioncambiada();
                                    break;
                                }
                                else if (v.repro.getReggaetonpList().get(actual).getSongname().equals(v.repro.getCancionactual().getSongname())&&next >= v.repro.getReggaetonpList().size()){
                                    //si no cabe entonces regresa a la primera de la lista
                                    v.repro.setCancionactual(v.repro.getReggaetonpList().get(0));
                                    v.cancioncambiada();
                                    break;
                                }
                            }


                        }
                    }

                    else{
                        v.invalido();
                    }
                }
                else if ( innerchoice == 3){
                    //escuchar canción
                    v.escucharcancion();

                }
                else{
                    v.invalido();
                }

            }
            else if (choice == 4){
                //para carro tipo C solo presenta el pronóstico del tiempo
                v.menuproductividad();

            }
            else if (choice ==5){
                //salir
                v.despedida();
                simulador = false;

            }
            else {
                //respuesta inválida
                v.invalido();

            }

        }
    }
    
    }

