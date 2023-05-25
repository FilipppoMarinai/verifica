public class Monoposto extends Thread{
    private int id;
    private String scuderia;
    Pilota pilota;
    Area area;
    Semaforo semaforo;

    public Monoposto(int id, String scuderia, Pilota pilota, Area area, Semaforo semaforo){
        this.setName(pilota.getNome());
        this.id = id;
        this.scuderia = scuderia;
        this.pilota = pilota;
        this.area = area;
        this.semaforo = semaforo;
    }

    public int tempo(){
        return (int) (Math.random() * 4) + 1;
    }

    @Override
    public void run(){
        for(int i = 1; i < 11; i++){
            try{
                sleep(tempo());
            }
            catch(Exception e){
                System.out.println(e.getMessage());
            }
            System.out.println("GIRO-" + i + " Completato " + pilota.getNome() + "\n");
    
            if(i % 3 == 0){
                semaforo.P();
                semaforo.setPosti(semaforo.getPosti() + 1);
                area.cambioGomme(pilota.getNome());
                System.out.println("PIT-STOP " + pilota.getNome() + " FINITO");
                semaforo.setPosti(semaforo.getPosti() - 1);
                semaforo.V();
            }
        }
    }
}
