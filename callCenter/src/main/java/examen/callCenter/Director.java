package examen.callCenter;

public class Director extends Empleado {


    public Director() {
        queue.add(3);
    }

    @Override
    public boolean puedeTomarLaLLamada() {
        return queue.poll() != null;
    }

    @Override
    public void disponibilizarEmpleadoNuevamente() {
        queue.add(3);
    }

}
