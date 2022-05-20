public class SwitchToy {

    private final int REPEAT = 4; //number of iterations on - off toggle switch
    private int count;
    private volatile boolean volatileSwitch = false; // switch off = false / switch on = true;
    private final int timeOn = 5000; //switch on time

    public void switchOn() {

        while (count != REPEAT) {
            try {
                if (!volatileSwitch) {
                    count++;
                    volatileSwitch = true;
                    System.out.println("Turning on the toggle switch / " + Thread.currentThread().getName());
                } else {
                    break;
                }
                Thread.sleep(timeOn);
            } catch (InterruptedException exc) {
                exc.printStackTrace();
            }
        }
    }

    public void switchOff() {

        while (!Thread.currentThread().isInterrupted()) {

            if (volatileSwitch) {
                volatileSwitch = false;
                System.out.println("Turning off the toggle switch / " + Thread.currentThread().getName());
            }

        }

    }

}
