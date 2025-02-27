public class Barri {
    private Estanc estanc;
    private Fumardor[] fumardors;
    public Barri(){
        estanc = new Estanc();
        fumardors = new Fumardor[3];

        for(int i = 0; i < fumardors.length; i++){
            fumardors[i] = new Fumardor(estanc, i);
        }
        for(int i = 0; i < fumardors.length; i++){
            fumardors[i].start();
        }
        estanc.start();
    }
    public static void main(String[] args) {
        Barri b = new Barri();
        while (true) {
            int count = 0;
            for (Fumardor f : b.fumardors) {
                if(!f.isAlive()) count = count +1;
            }
            if(count == 3) break;
        }
        b.estanc.tencarEstanc();
    }
}
