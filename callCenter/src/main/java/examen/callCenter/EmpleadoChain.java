package examen.callCenter;

public interface EmpleadoChain {

    void setNextChain(EmpleadoChain nextChain);

    void atenderLLamada();

}
