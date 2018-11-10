package examen.callCenter;

public class Operador extends Empleado {


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
