public class Edificio {
    private String nombre;
    private TipoEdificio tipo;
    private int seguridad, incendio, felicidad, precio;

    public Edificio(String nombre, TipoEdificio tipo, int seguridad, int incendio, int felicidad, int precio) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.seguridad = seguridad;
        this.incendio = incendio;
        this.felicidad = felicidad;
        this.precio = precio;
    }

    public void mostrarDatos(){
        System.out.print(nombre + " Tipo: " + tipo + " seguridad: " + seguridad + " incendio: " + incendio + " felicidad: " + felicidad +  " precio: $" + precio + "\n");
    }

    public String getNombre() {
        return nombre;
    }

    public TipoEdificio getTipo() {
        return tipo;
    }

    public int getSeguridad() {
        return seguridad;
    }

    public int getIncendio() {
        return incendio;
    }

    public int getFelicidad() {
        return felicidad;
    }

    public int getPrecio() {
        return precio;
    }
}
