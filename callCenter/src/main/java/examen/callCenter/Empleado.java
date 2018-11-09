package examen.callCenter;

import java.util.concurrent.ThreadLocalRandom;

public abstract class Empleado implements EmpleadoChain {

    private EmpleadoChain empleadoChain;

    public void atenderLLamada() {

        if (this.puedeTomarLaLLamada()) {
            this.responderConsultasAlCliente();
        } else {
            empleadoChain.atenderLLamada();
        }
    }

    void responderConsultasAlCliente() {

        try {
            System.out.println(this.getClass().getSimpleName() + " atendiendo llamada...");
            Thread.sleep(ThreadLocalRandom.current().nextInt(5000, 10000 + 1));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            this.disponibilizarEmpleadoNuevamente();
            System.out.println(this.getClass().getSimpleName() + " disponible de nuevo para recibir llamadas.");
        }
    }

    public void setNextChain(EmpleadoChain nextChain) {
        empleadoChain = nextChain;
    }

    abstract public boolean puedeTomarLaLLamada();

    abstract public void disponibilizarEmpleadoNuevamente();

}
