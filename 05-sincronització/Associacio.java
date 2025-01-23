public class Associacio {
    private int numSocies = 100;
    private Soci[] socis = new Soci[numSocies];
    public Associacio(){
        for(int i = 0; i < numSocies; i++){
            socis[i] = new Soci(String.valueOf(i));
        }
    }

    public void iniciaCompteTempsSocis(){
        for (Soci soci : socis) {
            soci.start();
        }
    }

    public void esperaPeriodeSocis()throws InterruptedException{
        for (Soci soci : socis) {
            soci.join();
        }
    }

    public String mostraBalancComptes(Soci soci){
        return String.format("%nSoci: %s Saldo: %.2f", soci.getName(), soci.getCompte().getSaldo());
    }

    public static void main(String[] args){
        Associacio a = new Associacio();
        try {
            a.iniciaCompteTempsSocis();
            a.esperaPeriodeSocis();
            for (Soci soci : a.socis) {
                System.out.print(a.mostraBalancComptes(soci));
                break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
