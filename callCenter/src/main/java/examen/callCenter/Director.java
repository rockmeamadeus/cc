package examen.callCenter;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Director extends Empleado {

    private BlockingQueue<Integer> queue = new ArrayBlockingQueue(1, true);

    public Director() {
        queue.add(1);
    }

    @Override
    public boolean puedeTomarLaLLamada() {
        return queue.poll() != null;
    }

    @Override
    public void disponibilizarEmpleadoNuevamente() {
        queue.add(1);
    }

}
