class Libero extends Jugador {
     private int recepciones;

    public Libero(String nombre, String pais, int errores, int aces, int totalServicios, int recepciones) {
        super(nombre, pais, errores, aces, totalServicios);
        this.recepciones = recepciones;
    }

    @Override
    public double calcularEfectividad() {
        return ((recepciones - errores) * 100.0) / (recepciones + errores) + (aces * 100.0 / totalServicios);
    }
}
