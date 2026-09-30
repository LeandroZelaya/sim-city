public class Tienda {

    private Edificio[] catalogo = new Edificio[30];

    public Tienda(){
        catalogo[0] = new Edificio("Rascascielos", TipoEdificio.MARAVILLA, 0, 0, 10, 900000);
        catalogo[1] = new Edificio("Torre Eiffel", TipoEdificio.MARAVILLA, 0, 0, 10, 850000);
        catalogo[2] = new Edificio("Arco del triunfo", TipoEdificio.MARAVILLA, 0, 0, 9, 700000);
        catalogo[3] = new Edificio("Pirámide", TipoEdificio.MARAVILLA, 0, 0, 9, 600000);
        catalogo[4] = new Edificio("Obelisco", TipoEdificio.MARAVILLA, 0, 0, 8, 450000);
        catalogo[5] = new Edificio("Planta de energía eólica", TipoEdificio.PLANTA_ENERGETICA, 0, 0, 10, 500000);
        catalogo[6] = new Edificio("Planta de energía solar", TipoEdificio.PLANTA_ENERGETICA, 0, 0, 9, 400000);
        catalogo[7] = new Edificio("Planta de energía hidroeléctrica", TipoEdificio.PLANTA_ENERGETICA, 0, 0, 8,
                300000);
        catalogo[8] = new Edificio("Planta de energía de carbón", TipoEdificio.PLANTA_ENERGETICA, 0, 0, 4,
                150000);
        catalogo[9] = new Edificio("Empresa de agua corriente", TipoEdificio.PLANTA_AGUA, 0, 0, 10, 750000);
        catalogo[10] = new Edificio("Obras de cañerías para agua potable", TipoEdificio.PLANTA_AGUA, 0, 0, 9,
                500000);
        catalogo[11] = new Edificio("Tanques de agua por manzana", TipoEdificio.PLANTA_AGUA, 0, 10, 9, 350000);
        catalogo[12] = new Edificio("Pozos de agua", TipoEdificio.PLANTA_AGUA, 0, 0, 7, 200000);
        catalogo[13] = new Edificio("Mega estación de policía", TipoEdificio.SEGURIDAD, 10, 0, 10, 400000);
        catalogo[14] = new Edificio("Estación de policía grande", TipoEdificio.SEGURIDAD, 9, 0, 9, 300000);
        catalogo[15] = new Edificio("Estación de policía mediana", TipoEdificio.SEGURIDAD, 7, 0, 5, 200000);
        catalogo[16] = new Edificio("Estación de policía chica", TipoEdificio.SEGURIDAD, 5, 0, 2, 100000);
        catalogo[17] = new Edificio("Mega estación de bomberos", TipoEdificio.INCENDIO, 0, 10, 10, 450000);
        catalogo[18] = new Edificio("Estación de bomberos grande", TipoEdificio.INCENDIO, 0, 8, 8, 350000);
        catalogo[19] = new Edificio("Estación de bomberos mediana", TipoEdificio.INCENDIO, 0, 7, 6, 250000);
        catalogo[20] = new Edificio("Estación de bomberos chica", TipoEdificio.INCENDIO, 0, 6, 5, 150000);
        catalogo[21] = new Edificio("Rutas", TipoEdificio.CAMINOS, 0, 0, 10, 400000);
        catalogo[22] = new Edificio("Autopistas", TipoEdificio.CAMINOS, 0, 0, 9, 300000);
        catalogo[23] = new Edificio("Avenidas", TipoEdificio.CAMINOS, 0, 0, 8, 200000);
        catalogo[24] = new Edificio("Calles de asfalto", TipoEdificio.CAMINOS, 0, 0, 6, 150000);
        catalogo[25] = new Edificio("Calles de tierra", TipoEdificio.CAMINOS, 0, 0, 1, 50000);
        catalogo[26] = new Edificio("Reserva natural", TipoEdificio.ECOLOGIA, 0, 0, 10, 500000);
        catalogo[27] = new Edificio("Parque polideportivo", TipoEdificio.ECOLOGIA, 0, 0, 9, 300000);
        catalogo[28] = new Edificio("Parque grande", TipoEdificio.ECOLOGIA, 0, 0, 8, 200000);
        catalogo[29] = new Edificio("Plaza", TipoEdificio.ECOLOGIA, 0, 0, 7, 100000);
    }

    public void mostrarCatalogo(){
        for (int i = 0; i < catalogo.length; i++) {
            System.out.print((i+1)+". ");
            catalogo[i].mostrarDatos();
        }
    }

    public Edificio getEdificio(int opc){
        Edificio edificioAux = catalogo[opc-1];
        return new Edificio(edificioAux.getNombre(),edificioAux.getTipo(), edificioAux.getSeguridad(), edificioAux.getIncendio(), edificioAux.getFelicidad(), edificioAux.getPrecio());
    }

    public Edificio getEdificioMinPrecio(){
        Edificio edificioMin = catalogo[0];
        for (int i = 1; i < catalogo.length; i++) {
            if(catalogo[i].getPrecio()<edificioMin.getPrecio()){
                edificioMin = catalogo[i];
            }
        }
        return edificioMin;
    }

    public int getCantEdificios(){
        return catalogo.length;
    }

}
