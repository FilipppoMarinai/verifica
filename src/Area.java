public class Area {
    private String nome;

    public Area(String nome){
        this.nome = nome;
    }

    public int secondi(){
        return (int) (Math.random() * 5) + 1;
    }

    public void cambioGomme(String nome){
        System.out.println("PIT-STOP " + nome + " cambio gomme in corso");
        try{
            Thread.sleep(secondi());
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
