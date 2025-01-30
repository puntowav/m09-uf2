import java.util.ArrayList;
import java.util.List;

public class Esdeveniment {
    private List<Assistent> assistents;
    private int palcesDisponibles;
    
    public Esdeveniment(int palcesDisponibles){
        assistents = new ArrayList<>();
        setPalcesDisponibles(palcesDisponibles);
    }

    public void setPalcesDisponibles(int palcesDisponibles) {
        if(palcesDisponibles <= 0) this.palcesDisponibles = palcesDisponibles;
        else this.palcesDisponibles = 10;
    }
    public synchronized void ferReserva(Assistent assistent){
        while (palcesDisponibles == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        if(palcesDisponibles > 0){
            assistents.add(assistent);
            palcesDisponibles--;
            System.out.printf("%nAssistent-%s ha fet una reserva. Places disponibles: %d", assistent.getName(), palcesDisponibles);
        }
    }

    public synchronized void eliminaReserva(Assistent assistent){
        if(assistents.contains(assistent)){
            assistents.remove(assistent);
            notifyAll();
            palcesDisponibles++;
            System.out.printf("%nAssistent-%s ha cancel·lat una reserva. Places disponibles: %d", assistent.getName(), palcesDisponibles);
        }
        System.out.printf("%nAssistent-%s no ha pogut cancel·lar una reserva inexistent. Places disponibles: %d", assistent.getName(), palcesDisponibles);
    }
}