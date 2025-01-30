public class Organitzador {
    private Esdeveniment esdeveniment;

    public Organitzador(int qty){
        esdeveniment = new Esdeveniment(qty);
    }

    public static void main(String[] args) {
        Organitzador organitzador = new Organitzador(5);
        
        Assistent[] assistents = new Assistent[10];

        for (int i = 0; i < 10; i++) {
            assistents[i] = new Assistent(String.valueOf(i), organitzador.esdeveniment);
        }

        for (Assistent assistent : assistents) {
            assistent.start();
        }
    }
}
