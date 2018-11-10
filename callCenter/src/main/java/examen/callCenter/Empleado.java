package examen.callCenter;

import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadLocalRandom;

public abstract class Empleado implements EmpleadoChain {

    protected PriorityBlockingQueue<Integer> queue = new PriorityBlockingQueue<>();

    protected Integer priority;

    private EmpleadoChain empleadoChain;

    public void atenderLLamada() {

        if (puedoResponderLlamada()) {
            responderConsultasAlCliente();
        } else {
            empleadoChain.atenderLLamada();
        }
    }


    void responderConsultasAlCliente() {

        try {
            System.out.println(getClass().getSimpleName() + " atendiendo llamada...");
            Thread.sleep(ThreadLocalRandom.current().nextInt(5000, 10001));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            this.disponibilizarEmpleadoNuevamente();
            System.out.println(getClass().getSimpleName() + " disponible de nuevo para recibir llamadas.");
        }
    }


    public void setNextChain(EmpleadoChain nextChain) {
        empleadoChain = nextChain;
    }

    public boolean puedoResponderLlamada() {
        return priority.equals(queue.peek()) && queue.poll() != null;
    }

    public void disponibilizarEmpleadoNuevamente() {
        queue.add(priority);
    }
}
