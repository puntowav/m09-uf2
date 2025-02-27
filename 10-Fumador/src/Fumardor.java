import java.util.Random;

public class Fumardor extends Thread {
    private static Random r = new Random();
    private Estanc estancDeConfiança;
    private int Id;
    private Tabac tabac;
    private Llumi llumi;
    private Paper paper;
    private int fumades = 0;
    public Fumardor(Estanc estancDeConfiança, int Id){
        this.estancDeConfiança = estancDeConfiança;
        this.Id = Id;
    }
    public void fuma() throws InterruptedException {
        if (tabac != null && llumi != null && paper != null) {
            tabac = null;
            llumi = null;
            paper = null;
            fumades = fumades + 1;
            System.out.println("Fuamdor " + Id + " fumant");
            Thread.sleep(500 + r.nextInt(501));
        }
    }
    public void compraTabac()throws InterruptedException{
        tabac = estancDeConfiança.venTabac();
        System.out.println("Fuamdor " + Id + " comprant tabac");
    }
    public void compraLlumi()throws InterruptedException{
        llumi = estancDeConfiança.venLlumi();
        System.out.println("Fuamdor " + Id + " comprant llumi");
    }
    public void compraPaper()throws InterruptedException{
        paper = estancDeConfiança.venPaper();
        System.out.println("Fuamdor " + Id + " comprant paper");
    }
    @Override
    public void run() {
        while (fumades < 3) {
            try {
                compraTabac();
                compraLlumi();
                compraPaper();
                fuma();
                System.out.println("Fumador " + Id + " ha fumat " + fumades);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
