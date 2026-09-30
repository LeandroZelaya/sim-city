public class Main {
    public static void main(String[] args) {
        Jugador jugador;
        Entrada entrada = new Entrada();

        System.out.println("Bienvenidos al sim city");
        jugador = crearJugador(entrada);
        ingresarTienda(jugador, entrada);
        mostrarDatosGenerales(jugador);
        entrada.cerrarScanner();
    }

    private static void mostrarDatosGenerales(Jugador jugador) {
        jugador.mostrarDatos();
        jugador.mostrarDatosCiudad();
        mostrarPromedioSeguridad(jugador);
        mostrarPromedioIncendio(jugador);
        mostrarPromedioFelicidad(jugador);
        mostrarEdificioMayorMenorValor(jugador);
        mostrarDineroTotalCiudad(jugador);
    }

    private static void mostrarDineroTotalCiudad(Jugador jugador) {
        System.out.println("Dinero total invertido en la ciudad: $" + jugador.getCiudad().getTotalDinero());
    }

    private static void mostrarEdificioMayorMenorValor(Jugador jugador) {
        System.out.println("Edificio de menor valor:");
        jugador.getCiudad().getEdificioMenorValor().mostrarDatos();
        System.out.println("Edificio de mayor valor:");
        jugador.getCiudad().getEdificioMayorValor().mostrarDatos();
    }

    private static void mostrarPromedioFelicidad(Jugador jugador) {
        System.out.println("Promedio de felicidad: " + calcularPromedio(jugador.getCiudad().getTotalFelicidad(), jugador.getCiudad().getCantEdificios()));
    }

    private static void mostrarPromedioIncendio(Jugador jugador) {
        System.out.println("Promedio de incendio: " + calcularPromedio(jugador.getCiudad().getTotalIncendios(), jugador.getCiudad().getCantEdificios()));
    }

    private static void mostrarPromedioSeguridad(Jugador jugador) {
        System.out.println("Promedio de seguridad: " + calcularPromedio(jugador.getCiudad().getTotalSeguridad(), jugador.getCiudad().getCantEdificios()));
    }

    private static double calcularPromedio(int total, int cantidad) {
        return cantidad > 0 ? (double) total / cantidad : 0;
    }

    private static void ingresarTienda(Jugador jugador, Entrada entrada) {
        Tienda tienda = new Tienda();
        int precioEdificioMin = tienda.getEdificioMinPrecio().getPrecio();
        boolean finCompra = false;
        System.out.println("Bienvenido a la tienda");
        do {
            jugador.mostrarDatos();
            if (precioEdificioMin <= jugador.getDinero()){
                System.out.println("Ingrese un edificio de la lista o 0 para salir");
                tienda.mostrarCatalogo();
                int opc = entrada.ingresarEntero(0, tienda.getCantEdificios());
                if (opc == 0) {
                    finCompra = salirTienda();
                } else {
                    Edificio edificio = tienda.getEdificio(opc);
                    if (edificio.getPrecio() <= jugador.getDinero()) {
                        System.out.println("Compraste el edificio " + edificio.getNombre());
                        jugador.adquirirEdificio(edificio);
                    } else {
                        System.out.println("No tienes suficiente dinero para comprar ese edificio");
                    }
                }
            } else {
                System.out.println("No tienes suficiente dinero para comprar ningun edificio");
                finCompra = salirTienda();
            }
        } while(!finCompra);
    }

    private static boolean salirTienda() {
        boolean finCompra;
        System.out.println("Saliendo de la tienda");
        mostrarPuntitosEspera();
        finCompra = true;
        return finCompra;
    }

    private static void mostrarPuntitosEspera() {
        for (int i = 0; i < 5; i++) {
            esperar(300);
            System.out.print(".");
        }
    }

    private static void esperar(int milis){
        try {
            Thread.sleep(milis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static Jugador crearJugador(Entrada entrada) {
        System.out.println("Ingrese su nombre");
        String nombre = entrada.ingresarTexto();
        return new Jugador(nombre, crearCiudad(entrada));
    }

    private static Ciudad crearCiudad(Entrada entrada) {
        System.out.println("Ingrese el nombre de la ciudad");
        String nombreCiudad = entrada.ingresarTexto();
        return new Ciudad(nombreCiudad);
    }
}