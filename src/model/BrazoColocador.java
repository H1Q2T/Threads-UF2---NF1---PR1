package model;

public class BrazoColocador extends Thread {
    private final Recipient recipient;

    public BrazoColocador(Recipient recipient) {
        this.recipient = recipient;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            recipient.colocarMuestra(i);
            try {
                Thread.sleep(500); // Simula el tiempo de trabajo
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
