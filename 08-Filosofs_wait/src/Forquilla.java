public class Forquilla {
    private int index;
    private int numeroPropietari;
    private static final int LLIURE = -1;

    public Forquilla(int index){
        setIndex(index);
        setNumeroPropietari(LLIURE);
    }

    public int getIndex() {
        return index;
    }

    public static int getLliure() {
        return LLIURE;
    }

    public int getNumeroPropietari() {
        return numeroPropietari;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public void resetNumeroPropietari() {
        this.numeroPropietari = LLIURE;
        notifyAll();
    }
    
    public void setNumeroPropietari(int numeroPropietari) {
        this.numeroPropietari = numeroPropietari;
    }
}