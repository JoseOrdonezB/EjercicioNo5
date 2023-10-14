abstract class Jugador {
    protected String nombre;
    protected String pais;
    protected  int errores;
    protected int aces;
    protected int totalServicios;

    public Jugador(String nombre, String pais, int errores, int aces, int totalServicios) {
        this.nombre = nombre;
        this.pais = pais;
        this.errores = errores;
        this.aces = aces;
        this.totalServicios = totalServicios;
    }

    public abstract double calcularEfectividad();
}
