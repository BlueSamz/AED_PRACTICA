package ej_pt1;

public class OperacionesMatInteger implements Operable<Integer> {
    @Override
    public Integer suma(Integer operando1, Integer operando2) {
        return operando1 + operando2;
    }

    @Override
    public Integer resta(Integer operando1, Integer operando2) {
        return operando1 - operando2;
    }

    @Override
    public Integer producto(Integer operando1, Integer operando2) {
        return operando1 * operando2;
    }

    @Override
    public Integer division(Integer operando1, Integer operando2) {
        if (operando2 == 0) {
            throw new ArithmeticException("No se puede dividir por cero");
        }
        return operando1 / operando2;
    }

    @Override
    public Integer potencia(Integer base, Integer exponente) {
        return (int) Math.pow(base, exponente);
    }

    @Override
    public Integer raizCuadrada(Integer operando) {
        return (int) Math.sqrt(operando);
    }

    @Override
    public Integer raizCubica(Integer operando) {
        return (int) Math.cbrt(operando);
    }
}
