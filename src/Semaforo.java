/**
 * classe Semaoforo per gestire la risorsa condivisa tra i thread
 */
public class Semaforo {
    /**
     * valore che avrà il semaforo
     */
    private int valore;
    /**
     * posti auto occupati al box
     */
    private int postiAuto;

    /**
     * costruttore del Semaforo
     * @param valore valore del semaforo
     * @param postiAuto posti auto occupati al box
     */
    public Semaforo(int valore, int postiAuto){
        this.valore = valore;
        this.postiAuto = postiAuto;
    }

    /**
     * setto i posti del box in base a quanti sono occupati
     * @param posti posti disponibili al box
     */
    public void setPosti(int posti){
        postiAuto = posti;
    }

    /**
     * vado prendere i posti auto occupati
     * @return posti auto occupati
     */
    public int getPosti(){
        return postiAuto;
    }

    /**
     * guardo se la risorsa condivisa è libera oppure no, se non lo è metto in attesa il thread
     */
    public synchronized void P(){
        while(valore == 0 && postiAuto == 2){
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
