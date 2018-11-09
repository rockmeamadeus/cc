package examen.callCenter;


public class Dispatcher {

    private Empleado empleado;

    public Dispatcher() {

        empleado = new Operador();
        Empleado supervisor = new Supervisor();
        Empleado director = new Director();

        empleado.setNextChain(supervisor);
        supervisor.setNextChain(director);
        director.setNextChain(empleado);
    }

    public void dispatchCall() {
        empleado.atenderLLamada();
    }


}
