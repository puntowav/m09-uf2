import java.util.Random;

public class Treballador extends Thread{
    private int sou_anual_brut;
    private int edat_inici_treball;
    private int edat_fi_treball;
    private int edat_actual;
    private float cobrat;
    private Random rnd;
    public Treballador(String nom, int sou_anual_brut, int edat_inici_treball, int edat_fi_treball){
        super(nom);
        this.sou_anual_brut = sou_anual_brut;
        this.edat_inici_treball = edat_inici_treball;
        this.edat_fi_treball = edat_fi_treball;
        this.edat_actual = 0; 
        this.cobrat = 0.0f;
        rnd = new Random();
    }
    public float getCobrat(){return cobrat;}
    public int getEdat(){return edat_actual;}
    public void cobra(){
        cobrat += sou_anual_brut / 12;
    }
    public void pagaImpostos(){
        cobrat -= cobrat * 0.24f;
    }
    @Override
    public void run(){
        try {
            for(edat_actual = edat_inici_treball; edat_actual < edat_fi_treball; edat_actual++){
                cobra();
                pagaImpostos();
                Thread.sleep(rnd.nextInt(100));
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}