public class Client{
    private String nom;
    public Client(int id){
        nom = "Client-"+ id;
    }
    public String getNom(){return nom;}
    public void tallarseElCabell(){
        System.out.println("Tallant cabell a "+nom);
    }
}
