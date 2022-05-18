public class SwitchToy {

    private final int REPEAT = 4; //number of iterations on - off toggle switch
    int count;
    volatile int volatileSwitch = 0; // switch off = 0 / switch on = 1;
    int timeOn = 3000; //switch on time
    int timeOff = 2000; //switch off time

    public void switchOn() {

        while (count != REPEAT) {

            try {
                if (volatileSwitch == 0) {
                    volatileSwitch = 1;
                    count++;
                    System.out.println("Turning on the toggle switch / " + Thread.currentThread().getName());
                    Thread.sleep(timeOn);
                } else {
                    break;
                }

            } catch (InterruptedException exc) {
                exc.printStackTrace();
            }
        }

    }

    public void switchOff() {

        while (!Thread.currentThread().isInterrupted()) {

            try {
                Thread.sleep(timeOff);
                if (volatileSwitch == 1) {
                    volatileSwitch = 0;
                    System.out.println("Turning off the toggle switch / " + Thread.currentThread().getName());
                } else {
                    break;
                }

            } catch (InterruptedException exc) {
                exc.printStackTrace();
            }
        }
    }

}
