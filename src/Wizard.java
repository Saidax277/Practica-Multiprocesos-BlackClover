public class Wizard {
    
    //Cada mago tiene un nombre, un poder base y una afinidad mágica, por ejemplo: Asta, 500 y antimagia

    private String nombre;
    private int poderBase;
    private String afinidad;

    // Constructor de la clase Wizard

    public Wizard(String nombre, int poderBase, String afinidad) {
        this.nombre = nombre;
        this.poderBase = poderBase;
        this.afinidad = afinidad;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPoderBase() {
        return poderBase;
    }

    public String getAfinidad() {
        return afinidad;
    }

    // Getters

    @Override
    public String toString() {
        return nombre + " (" + afinidad + ", poder " + poderBase + ")";
    }
}
