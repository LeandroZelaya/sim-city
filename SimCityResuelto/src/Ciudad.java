public class Ciudad {

    private String nombre;
    private Edificio[] edificios = new Edificio[10];
    private int cantEdificios;
    private int totalSeguridad, totalIncendios, totalFelicidad, totalDinero;

    public Ciudad(String nombre) {
        this.nombre = nombre;
    }

    public boolean adquirirEdificio(Edificio edificio){
        boolean capacidadMaximaAlcanzada = cantEdificios >= edificios.length;

        if(!capacidadMaximaAlcanzada){
            edificios[cantEdificios] = edificio;
            cantEdificios++;
            totalSeguridad += edificio.getSeguridad();
            totalIncendios += edificio.getIncendio();
            totalFelicidad += edificio.getFelicidad();
            totalDinero += edificio.getPrecio();
        } else {
            System.out.println("No se pueden adquirir mas edificios, la ciudad esta llena");
        }
        return capacidadMaximaAlcanzada;
    }


    public void mostrarDatos() {
        System.out.println("Ciudad: " + nombre);
        System.out.println("Edificios:");
        for (int i = 0; i < cantEdificios; i++) {
            edificios[i].mostrarDatos();
        }
    }

    public Edificio getEdificioMenorValor(){
        Edificio edificioMin = edificios[0];
        for (int i = 1; i < this.cantEdificios; i++) {
            if(edificios[i].getPrecio()<edificioMin.getPrecio()){
                edificioMin = edificios[i];
            }
        }
        return edificioMin;
    }

    public Edificio getEdificioMayorValor(){
        Edificio edificioMax = edificios[0];
        for (int i = 1; i < this.cantEdificios; i++) {
            if(edificios[i].getPrecio()>edificioMax.getPrecio()){
                edificioMax = edificios[i];
            }
        }
        return edificioMax;
    }


    public int getTotalSeguridad() {
        return totalSeguridad;
    }

    public int getTotalIncendios() {
        return totalIncendios;
    }

    public int getTotalFelicidad() {
        return totalFelicidad;
    }

    public int getTotalDinero() {
        return totalDinero;
    }

    public int getCantEdificios() {
        return cantEdificios;
    }
}
