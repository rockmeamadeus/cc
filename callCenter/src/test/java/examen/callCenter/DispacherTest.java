package examen.callCenter;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static junit.framework.TestCase.assertTrue;

public class DispacherTest {

    @Test
    public void atender2LLamadasNoSimultaneas() {

        Dispatcher dispatcher = new Dispatcher();

        System.out.println("Cliente llamando ...");
        dispatcher.dispatchCall();
        System.out.println("Cliente llamando ...");
        dispatcher.dispatchCall();

    }


    /**
     * El call center recibe 10 llamadas simultaneas,
     * siendo el mismo numero de empleados disponibles.
     *
     * @throws InterruptedException the interruptedException thrown.
     */
    @Test
    public void atender10LLamadasSimultaneas() throws InterruptedException, ExecutionException {

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        Dispatcher dispatcher = new Dispatcher();

        List<Future<?>> futures = new ArrayList<>();


        for (int i = 0; i < 10; i++) {
            Runnable task1 = () -> {
                System.out.println("Cliente llamando ...");
                dispatcher.dispatchCall();
            };
            Future<?> f = executorService.submit(task1);
            futures.add(f);

        }

        // A) Await all runnables to be done (blocking)
        for (Future<?> future : futures)
            future.get(); // get will block until the future is done

        // B) Check if all runnables are done (non-blocking)
        boolean allDone = true;
        for (Future<?> future : futures) {
            allDone &= future.isDone(); // check if future is done
        }

        assertTrue(allDone);

    }

    /**
     * El call center recibe 11 llamadas simultaneas.
     * El ultimo llamado queda a la espera
     * de la finalizacion de algun proceso anterior.
     *
     * @throws InterruptedException the interruptedException thrown.
     */
    @Test
    public void atender11LLamadasSimultaneas() throws InterruptedException, ExecutionException {

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        Dispatcher dispatcher = new Dispatcher();

        List<Future<?>> futures = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Runnable task1 = () -> {
                System.out.println("Cliente llamando ...");
                dispatcher.dispatchCall();
            };
            Future<?> f = executorService.submit(task1);
            futures.add(f);
        }

        // A) Await all runnables to be done (blocking)
        for (Future<?> future : futures)
            future.get(); // get will block until the future is done

        // B) Check if all runnables are done (non-blocking)
        boolean allDone = true;
        for (Future<?> future : futures) {
            allDone &= future.isDone(); // check if future is done
        }

        assertTrue(allDone);

    }
}