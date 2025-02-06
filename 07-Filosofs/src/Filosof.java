import java.util.Random;

public class Filosof extends Thread{
    private static Random r = new Random();

    private Forquilla forquillaDreta;
    private Forquilla forquillaEsquerra;
    private int gana;
    public Filosof(String nom, Forquilla forquillaDreta, Forquilla forquillaEsquerra, int gana){
        super(nom);
        this.forquillaDreta = forquillaDreta;
        this.forquillaEsquerra = forquillaEsquerra;
        this.gana = gana;
    }
    public void setForquillaDreta(Forquilla forquillaDreta) {
        this.forquillaDreta = forquillaDreta;
    }
    public void setForquillaEsquerra(Forquilla forquillaEsquerra) {
        this.forquillaEsquerra = forquillaEsquerra;
    }
    public void setGana(int gana) {
        this.gana = gana;
    }
    public Forquilla getForquillaDreta() {
        return forquillaDreta;
    }
    public Forquilla getForquillaEsquerra() {
        return forquillaEsquerra;
    }
    public int getGana() {
        return gana;
    }
    public void menjar()throws InterruptedException{
        while (true) {
            if(!forquillaEsquerra.getEnUs()){
                forquillaEsquerra.setEnUs(true);
                if(!forquillaDreta.getEnUs()){
                    System.err.printf("%nFilòsof: %s menja", getName());
                    forquillaDreta.setEnUs(true);
                    Thread.sleep(r.nextInt(2000 - 1000 + 1));
                    setGana(0);
                    forquillaEsquerra.setEnUs(false);
                    forquillaDreta.setEnUs(false);
                    System.out.printf("%nFilòsof: %s ha acabat de menjar", getName());
                    break;
                }else{
                    forquillaEsquerra.setEnUs(false);
                    System.out.printf("%nFilòsof: %s deixa l'esquerra(%d) i espera (dreta ocupada)", getName(), forquillaEsquerra.getIndex());
                    gana++;
                    System.out.printf("%nFilòsof: %s gana=%d", getName(), getGana());
                }
            }else{
                gana++;
                System.out.printf("%nFilòsof: %s gana=%d", getName(), getGana());
            }
            Thread.sleep(r.nextInt(1000 - 500 + 1));
        }
    }
    public void pensar()throws InterruptedException{
        Thread.sleep(r.nextInt(2000 - 1000 + 1));
        System.out.printf("%nFilòsof: %s pensat", getName());
    }
    @Override
    public void run(){
        while (true) {
            try {
                menjar();
                pensar();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
