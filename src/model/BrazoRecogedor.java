package model;

public class BrazoRecogedor extends Thread {
    private final Recipient recipient;

    public BrazoRecogedor(Recipient recipient) {
        this.recipient = recipient;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            recipient.retirarMuestra();
            try {
                Thread.sleep(500); // Simula el tiempo de trabajo
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
