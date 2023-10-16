class Auxiliares extends Jugador {
    private int ataques;
    private int bloqueosEfectivos;
    private int bloqueosFallidos;

    public Auxiliares(String nombre, String pais, int errores, int aces, int totalServicios, int ataques,
            int bloqueosEfectivos, int bloqueosFallidos) {
        super(nombre, pais, errores, aces, totalServicios);
        this.ataques = ataques;
        this.bloqueosEfectivos = bloqueosEfectivos;
        this.bloqueosFallidos = bloqueosFallidos;
    }

    @Override
    public double calcularEfectividad() {
        return ((ataques + bloqueosEfectivos - bloqueosFallidos - errores) * 100.0)
                / (ataques + bloqueosEfectivos + bloqueosFallidos + errores) + (aces * 100.0 / totalServicios);
    }
}
