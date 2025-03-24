package ejercicio;

public class OperacionesMat {

    // Método genérico para Suma (solo admite Integer y Double)
    static <T extends Number> T suma(T operando1, T operando2) {
        // Verifica si ambos operandos son Integer
        if (operando1 instanceof Integer && operando2 instanceof Integer) {
            return (T) Integer.valueOf(operando1.intValue() + operando2.intValue());
        }
        // Verifica si ambos operandos son Double
        else if (operando1 instanceof Double && operando2 instanceof Double) {
            return (T) Double.valueOf(operando1.doubleValue() + operando2.doubleValue());
        }
        // Si no son ni Integer ni Double, lanza una excepción
        else {
            throw new IllegalArgumentException("Solo se permiten Integer o Double");
        }
    }

    // Método genérico para Resta (solo admite Integer y Double)
    static <T extends Number> T resta(T operando1, T operando2) {
        if (operando1 instanceof Integer && operando2 instanceof Integer) {
            return (T) Integer.valueOf(operando1.intValue() - operando2.intValue());
        } else if (operando1 instanceof Double && operando2 instanceof Double) {
            return (T) Double.valueOf(operando1.doubleValue() - operando2.doubleValue());
        } else {
            throw new IllegalArgumentException("Solo se permiten Integer o Double");
        }
    }

    // Método genérico para clacular el producto
    static <T extends Number> T producto(T operando1, T operando2) {
        if (operando1 instanceof Integer && operando2 instanceof Integer) {
            return (T) Integer.valueOf(operando1.intValue() * operando2.intValue());
        } else if (operando1 instanceof Double && operando2 instanceof Double) {
            return (T) Double.valueOf(operando1.doubleValue() * operando2.doubleValue());
        } else {
            throw new IllegalArgumentException("Solo se permiten Integer o Double");
        }
    }

    // Método genérico para División (con validación de división por cero)
    static <T extends Number> T division(T operando1, T operando2) {
        // Evita la división por cero
        if (operando2.doubleValue() == 0) {
            throw new ArithmeticException("No se puede dividir por cero");
        }
        if (operando1 instanceof Integer && operando2 instanceof Integer) {
            return (T) Integer.valueOf(operando1.intValue() / operando2.intValue());
        } else if (operando1 instanceof Double && operando2 instanceof Double) {
            return (T) Double.valueOf(operando1.doubleValue() / operando2.doubleValue());
        } else {
            throw new IllegalArgumentException("Solo se permiten Integer o Double");
        }
    }

    // Método genérico para Potencia (base y exponente)
    static <T extends Number> T potencia(T base, T exponente) {
        if (base instanceof Integer && exponente instanceof Integer) {
            return (T) Integer.valueOf((int) Math.pow(base.intValue(), exponente.intValue()));
        } else if (base instanceof Double && exponente instanceof Double) {
            return (T) Double.valueOf(Math.pow(base.doubleValue(), exponente.doubleValue()));
        } else {
            throw new IllegalArgumentException("Solo se permiten Integer o Double");
        }
    }

    // Método genérico para calcular la raiz cuadrada
    static <T extends Number> T raizCuadrada(T operando) {
        if (operando instanceof Integer) {
            return (T) Integer.valueOf((int) Math.sqrt(operando.intValue()));
        } else if (operando instanceof Double) {
            return (T) Double.valueOf(Math.sqrt(operando.doubleValue()));
        } else {
            throw new IllegalArgumentException("Solo se permiten Integer o Double");
        }
    }

    // Método genérico para calcular la raiz cubica
    static <T extends Number> T raizCubica(T operando) {
        if (operando instanceof Integer) {
            return (T) Integer.valueOf((int) Math.cbrt(operando.intValue()));
        } else if (operando instanceof Double) {
            return (T) Double.valueOf(Math.cbrt(operando.doubleValue()));
        } else {
            throw new IllegalArgumentException("Solo se permiten Integer o Double");
        }
    }
}
