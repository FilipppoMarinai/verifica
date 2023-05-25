public class App {
    public static void main(String[] args) throws Exception {
        Semaforo semaforo = new Semaforo(1);
        Area area = new Area("box1");

        Pilota p1 = new Pilota("Marco");
        Pilota p2 = new Pilota("Giorgio");
        Pilota p3 = new Pilota("Mario");

        Monoposto m1 = new Monoposto(1, "Ferrari", p1, area, semaforo);
        Monoposto m2 = new Monoposto(1, "RedBull", p2, area, semaforo);
        Monoposto m3 = new Monoposto(1, "Mercedes", p3, area, semaforo);

        m1.start();
        m2.start();
        m3.start();

        m1.join();
        m2.join();
        m3.join();

        System.out.println("Gara Finita");
    }
}
