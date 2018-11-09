package examen.callCenter;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Supervisor extends Empleado {

    BlockingQueue<Integer> queue = new ArrayBlockingQueue(2, true);

    public Supervisor() {
        queue.add(1);
        queue.add(1);
    }

    @Override
    public boolean puedeTomarLaLLamada() {
        return queue.poll()  != null;
    }

    @Override
    public void disponibilizarEmpleadoNuevamente() {
        queue.add(1);
    }
}
