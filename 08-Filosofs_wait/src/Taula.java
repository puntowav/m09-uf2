public class Taula {
    private Filosof[] comensals;
    private Forquilla[] forquilles;

    public Taula(int numeroComensals, int numeroForquilles){
        forquilles = new Forquilla[numeroForquilles];
        for(int i = 0; i < numeroForquilles; i++){
            forquilles[i] = new Forquilla(i);
        }
        comensals = new Filosof[numeroComensals];
        for(int i = 0; i < numeroComensals; i++){
            comensals[i] = new Filosof(i, forquilles[i], (i == numeroComensals-1)?forquilles[0]:forquilles[i+1]);
        }
    }

    public void showTaula(){
        for (Filosof f : comensals) {
            System.out.printf("Comensal:%s esq:%d dret:%d", f.getName(), f.getForquillaDreta().getIndex(), f.getForquillaEsquerra().getIndex());
        }
    }
    public void cridaTaula(){
        for (Filosof f : comensals) {
            f.start();
        }
    }
    public static void main(String[] args) {
        Taula t = new Taula(4, 4);

        t.showTaula();
        t.cridaTaula();
    }
}
