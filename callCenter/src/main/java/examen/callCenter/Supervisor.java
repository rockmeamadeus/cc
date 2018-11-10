package examen.callCenter;

public class Supervisor extends Empleado {


    public Supervisor() {
        priority = 2;
        queue.add(priority);
        queue.add(priority);
    }
}
