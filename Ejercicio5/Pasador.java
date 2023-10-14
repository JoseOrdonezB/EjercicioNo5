class Pasador extends Jugador {
    int pases; // Cantidad de pases
    int fintas; // Cantidad de fintas

    public Pasador(String nombre, String pais, int errores, int aces, int totalServicios, int pases, int fintas) {
        super(nombre, pais, errores, aces, totalServicios);
        this.pases = pases;
        this.fintas = fintas;
    }

    @Override
    public double calcularEfectividad() {
        return ((pases + fintas - errores) * 100.0) / (pases + fintas + errores) + (aces * 100.0 / totalServicios);
    }
}
