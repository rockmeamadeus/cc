package examen.callCenter;

public class Supervisor extends Empleado {


    public Supervisor() {
        queue.add(2);
        queue.add(2);
    }

    @Override
    public boolean puedeTomarLaLLamada() {
        return queue.poll() != null;
    }

    @Override
    public void disponibilizarEmpleadoNuevamente() {
        queue.add(2);
    }
}
