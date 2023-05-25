/**
 * classe Semaoforo per gestire la risorsa condivisa tra i thread
 */
public class Semaforo {
    /**
     * valore che avrà il semaforo
     */
    private int valore;

    /**
     * costruttore del Semaforo
     * @param valore valore del semaforo
     */
    public Semaforo(int valore){
        this.valore = valore;
    }

    /**
     * guardo se la risorsa condivisa è libera oppure no, se non lo è metto in attesa il thread
     */
    public synchronized void P(){
        while(valore == 0){
            try{
                System.out.println("--------" + Thread.currentThread().getName() + " in attesa al box---------");
                wait();
            }
            catch(Exception e){
                System.out.println(e.getMessage());
            }
        }

        valore = 0;
    }

    /**
     * metto il via libera alla risorsa e do una notifica agli altri thread per fargli usare la risorsa
     */
    public synchronized void V(){
        valore = 1;
        notify();
    }
}
