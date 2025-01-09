public class Personeel extends Personen {
    private String rol;

    public Personeel(String name, int age, String address) {
        super(name, age, address); // Aanroepen van de constructor van Personen
        this.rol = rol;
    }

    // Getter en setter voor 'rol'
    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    // Je kunt nu de variabelen van Personen benaderen via de getter-methoden

    }









