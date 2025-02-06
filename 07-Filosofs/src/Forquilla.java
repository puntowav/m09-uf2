public class Forquilla {
    private int index;
    private boolean enUs;
    public Forquilla(int index, boolean enUs){
        this.index = index;
        this.enUs = enUs;
    }
    public void setEnUs(boolean enUs) {
        this.enUs = enUs;
    }
    public boolean getEnUs() {
       return enUs;
    }
    public void setIndex(int index) {
        this.index = index;
    }
    public int getIndex() {
        return index;
    }
}