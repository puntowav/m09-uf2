public class Forquilla {
    private int index;
    private int numeroPropietari;
    private static final int LLIURE = -1;

    public Forquilla(int index){
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public static int getLliure() {
        return LLIURE;
    }

    public synchronized int getNumeroPropietari() {
        return numeroPropietari;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public synchronized void resetNumeroPropietari() {
        this.numeroPropietari = LLIURE;
    }
    
    public synchronized void setNumeroPropietari(int numeroPropietari) {
        this.numeroPropietari = numeroPropietari;
    }
}