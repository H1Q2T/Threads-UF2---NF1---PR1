package model;

public class Recipient {
    private Integer muestra = null; // La muestra actual (null si está vacío)

    // Método sincronizado para colocar una muestra en el recipiente
    public synchronized void colocarMuestra(int id) {
        while (muestra != null) { // Espera si ya hay una muestra
            try {
                System.out.println("[BrazoColocador] Esperando... el recipiente está lleno.");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        muestra = id;
        System.out.println("[BrazoColocador] Mostra " + id + " posada al recipient.");
        notify(); // Notifica al otro thread que ya hay una muestra disponible
    }

    // Método sincronizado para retirar una muestra del recipiente
    public synchronized int retirarMuestra() {
        while (muestra == null) { // Espera si el recipiente está vacío
            try {
                System.out.println("[BrazoRecogedor] Esperando... el recipiente está vacío.");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        int id = muestra;
        muestra = null;
        System.out.println("[BrazoRecogedor] Mostra " + id + " agafada del recipient.");
        notify(); // Notifica al otro thread que el recipiente está vacío
        return id;
    }
}