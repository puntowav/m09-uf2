import java.util.Random;

public class Barber extends Thread{
    Random r = new Random();
    public Barber(String nom){
        super(nom);
    }
    @Override
    public void run(){
        while (true) {
            Client clienteConMelena = Barberia.barberia.seguentClient();
            if(clienteConMelena == null){
                synchronized(Barberia.barberia.condBarber){
                    try {
                        System.out.println("Ningú en espera");
                        System.out.println("Barber "+ this.getName() +" dormint");
                        Barberia.barberia.condBarber.wait();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }else{
                System.out.println("Li toca al client " + clienteConMelena.getNom());
                clienteConMelena.tallarseElCabell();
                try {
                    Thread.sleep(900 + r.nextInt(100));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}