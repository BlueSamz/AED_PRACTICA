package ej_pt1;

public interface Operable<N extends Number> {
    N suma(N operando1, N operando2);
    N resta(N operando1, N operando2);
    N producto(N operando1, N operando2);
    N division(N operando1, N operando2);
    N potencia(N base, N exponente);
    N raizCuadrada(N operando);
    N raizCubica(N operando);
}
