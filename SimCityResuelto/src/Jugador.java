public class Jugador {

    private String nombre;
    private int dinero = 1000000;
    private Ciudad ciudad;

    public Jugador(String nombre, Ciudad ciudad) {
        this.nombre = nombre;
        this.ciudad = ciudad;
    }

    public void mostrarDatos(){
        System.out.println("Jugador: " + nombre + " Dinero: $" + dinero);
    }

    public void mostrarDatosCiudad(){
        ciudad.mostrarDatos();
    }

    public void adquirirEdificio(Edificio edificio) {
        boolean capacidadMaximaAlcanzada = ciudad.adquirirEdificio(edificio);
        if(capacidadMaximaAlcanzada) {
            System.out.println("Edificio adquirido con exito");
            this.dinero -= edificio.getPrecio();
        } else {
            System.out.println("No se pudo adquirir el edificio");
        }
    }

    public int getDinero() {
        return dinero;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }
}
