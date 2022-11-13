package tarea3;


class NoHayBebidaException extends Exception {
    // Excepcion en caso de que no hayan bebidas en el deposito pedido o sea incorrecto/nulo el deposito.
    public NoHayBebidaException(String text) {
        super(text);
    }
}

class PagoIncorrectoException extends Exception {
    // Excepcion en caso de que se ingrese una moneda nula.
    public PagoIncorrectoException(String text) {
        super(text);
    }
}

class PagoInsuficienteException extends Exception {
    // Excepcion en caso de que el valor de la moneda no sea suficiente para comprar la bebida.
    public PagoInsuficienteException(String text) {
        super(text);
    }
}

class DepositoOcupadoException extends Exception {
    // Excepcion en caso de que el deposito que recepciona las bebidas compradas ya tenga una.
    public DepositoOcupadoException(String text) {
        super(text);
    }
}