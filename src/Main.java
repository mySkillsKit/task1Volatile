public class Main {

    public static void main(String[] args) {
        SwitchToy switchToy = new SwitchToy();
        System.out.println("The game started...");

        Thread user = new Thread(null, switchToy::switchOn, "USER");
        Thread toy = new Thread(null, switchToy::switchOff, "TOY");
        user.start();
        toy.start();

        try {
            user.join();
        } catch (InterruptedException exc) {
            exc.printStackTrace();
        }
        toy.interrupt();
        System.out.println("Game over");
    }
}
