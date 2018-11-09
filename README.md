# call center
examen tecnico de almundo.com

Para la resolucion del ejercicio se utilizo el patron de diseño chain of responsability, usando como condicion la disponibilidad de empleados.
En caso de recibir una llamada y no tener empleados disponibiles,la llamada queda en espera(en el pool de threads) y los empleados empiezan a delegarse entre si la llamada hasta que alguno se libera.
