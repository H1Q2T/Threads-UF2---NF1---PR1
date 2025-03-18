import model.*;

public class Main {
    public static void main(String[] args) {
        Recipient recipient = new Recipient();
        BrazoColocador colocador = new BrazoColocador(recipient);
        BrazoRecogedor recogedor = new BrazoRecogedor(recipient);

        // Iniciar los threads
        colocador.start();
        recogedor.start();

        // Esperar a que ambos terminen antes de finalizar el programa
        try {
            colocador.join();
            recogedor.join();
        } catch (InterruptedException e) {
            System.err.println("Error: La ejecución de los threads fue interrumpida.");
            Thread.currentThread().interrupt(); // Restablecer el estado de interrupción
        }

        System.out.println("Proceso finalizado correctamente.");
    }
}
