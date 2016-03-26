package enums;

public enum TipoListado {
	
	INVITADOS("Invitados"),
    PROVEEDORES("Proveedores");

    private final String value;

    TipoListado(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
