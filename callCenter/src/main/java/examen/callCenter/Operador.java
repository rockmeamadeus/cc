package examen.callCenter;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Operador extends Empleado {

    private BlockingQueue<Integer> queue = new ArrayBlockingQueue(7, true);

    public Operador() {
        queue.add(1);
        queue.add(1);
        queue.add(1);
        queue.add(1);
        queue.add(1);
        queue.add(1);
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
