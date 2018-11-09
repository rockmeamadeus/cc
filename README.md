# call center
examen tecnico de almundo.com

Para la resolucion del ejercicio se utilizo el patron de diseño chain of responsability, usando como condicion la disponibilidad de empleados.
En caso de recibir una llamada y no tener empleados disponibles,la llamada queda en espera (en el pool de threads).
En caso de llegar al limite de empleados de cierta jerarquia, se avanza al proximo nivel.
