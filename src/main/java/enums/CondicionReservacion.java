package enums;


public enum CondicionReservacion {
	PENDIENTE('P'),
    CANCELADA('C'),
    ALQUILADA('A');

    private final char value;

    CondicionReservacion(char value) {
        this.value = value;
    }

    public char getValue() {
        return value;
    }

}
