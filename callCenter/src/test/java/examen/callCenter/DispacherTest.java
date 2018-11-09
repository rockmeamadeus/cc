package examen.callCenter;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class DispacherTest {

    @Test
    public void atender2LLamadasNoSimultaneas() {

        Dispatcher dispatcher = new Dispatcher();

        System.out.println("Cliente llamando ...");
        dispatcher.dispatch();
        System.out.println("Cliente llamando ...");
        dispatcher.dispatch();

    }


    /**
     * El call center recibe 10 llamadas simultaneas,
     * siendo el mismo numero de empleados disponibles.
     *
     * @throws InterruptedException the interruptedException thrown.
     */
    @Test
    public void atender10LLamadasSimultaneas() throws InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        Dispatcher dispatcher = new Dispatcher();

        for (int i = 0; i < 10; i++) {
            Runnable task1 = () -> {
                System.out.println("Cliente llamando ...");
                dispatcher.dispatch();
            };
            executorService.execute(task1);
        }

        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.HOURS);

    }

    /**
     * El call center recibe 11 llamadas simultaneas.
     * El ultimo llamado queda a la espera
     * de la finalizacion de algun proceso anterior.
     *
     * @throws InterruptedException the interruptedException thrown.
     */
    @Test
    public void atender11LLamadasSimultaneas() throws InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        Dispatcher dispatcher = new Dispatcher();

        for (int i = 0; i < 11; i++) {
            Runnable task1 = () -> {
                System.out.println("Cliente llamando ...");
                dispatcher.dispatch();
            };
            executorService.execute(task1);
        }

        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.HOURS);

    }
}