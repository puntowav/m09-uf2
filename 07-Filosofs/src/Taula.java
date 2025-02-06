public class Taula {
    private Forquilla[] forquillas;
    private Filosof[] filosofs;
    public Taula(int numeroForquillas, int numeroFilosofs){
        forquillas = new Forquilla[numeroForquillas];
        for(int i = 0; i < numeroForquillas; i++){
            forquillas[i] = new Forquilla(i, false);
        }
        filosofs = new Filosof[numeroFilosofs];
        for(int i = 0; i < numeroFilosofs; i++){
            filosofs[i] = new Filosof(String.format("fil%d", i), forquillas[i], (i == numeroFilosofs-1)? forquillas[0] : forquillas[i+1], 0);
        }
    }
    public Filosof[] getFilosofs() {
        return filosofs;
    }
    public Forquilla[] getForquillas() {
        return forquillas;
    }
    public void showTaula(){
        for (Filosof f : filosofs) {
            System.out.printf("Comensal:%s esq:%d dret:%d", f.getName(), f.getForquillaDreta().getIndex(), f.getForquillaEsquerra().getIndex());
        }
    }
    public void cridaTaula(){
        for (Filosof f : filosofs) {
            f.start();
        }

        for (Filosof f : filosofs) {
            f.start();
        }
    }
    public static void main(String[] args) {
        Taula t = new Taula(4, 4);
        t.showTaula();
        t.cridaTaula();        
    }
}