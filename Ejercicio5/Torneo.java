import java.util.List;
import java.util.Scanner;

public class Torneo {
    public static void main(String[] args) {
        TorneoVoleibol torneo = new TorneoVoleibol();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Agregar jugador");
            System.out.println("2. Mostrar todos los jugadores");
            System.out.println("3. Mostrar los 3 mejores líberos");
            System.out.println("4. Contar pasadores con más del 80% de efectividad");
            System.out.println("5. Salir");
            
            int eleccion = scanner.nextInt();
            scanner.nextLine();

            switch (eleccion) {
                case 1:
                    System.out.println("Ingrese el tipo de jugador (Libero, Setter, AuxiliaresOpuestos):");
                    String tipoJugador = scanner.nextLine().toLowerCase();

                    System.out.println("Ingrese el nombre del jugador:");
                    String nombre = scanner.nextLine();

                    System.out.println("Ingrese el país del jugador:");
                    String pais = scanner.nextLine();

                    System.out.println("Ingrese la cantidad de errores del jugador:");
                    int errores = scanner.nextInt();

                    System.out.println("Ingrese la cantidad de aces del jugador:");
                    int aces = scanner.nextInt();

                    System.out.println("Ingrese el total de servicios del jugador:");
                    int totalServicios = scanner.nextInt();

                    if (tipoJugador.equals("libero")) {
                        System.out.println("Ingrese la cantidad de recepciones efectivas del Libero:");
                        int recepciones = scanner.nextInt();
                        torneo.addJugador(new Libero(nombre, pais, errores, aces, totalServicios, recepciones));
                    } else if (tipoJugador.equals("pasador")) {
                        System.out.println("Ingrese la cantidad de pases del Pasador:");
                        int pases = scanner.nextInt();
                        System.out.println("Ingrese la cantidad de fintas del Pasador:");
                        int fintas = scanner.nextInt();
                        torneo.addJugador(new Pasador(nombre, pais, errores, aces, totalServicios, pases, fintas));
                    } else if (tipoJugador.equals("auxiliares")) {
                        System.out.println("Ingrese la cantidad de ataques del Auxiliares/Opuestos:");
                        int ataques = scanner.nextInt();
                        System.out.println("Ingrese la cantidad de bloqueos efectivos del Auxiliares/Opuestos:");
                        int bloqueosEfectivos = scanner.nextInt();
                        System.out.println("Ingrese la cantidad de bloqueos fallidos del Auxiliares/Opuestos:");
                        int bloqueosFallidos = scanner.nextInt();
                        torneo.addJugador(new Auxiliares(nombre, pais, errores, aces, totalServicios, ataques, bloqueosEfectivos, bloqueosFallidos));
                    } else {
                        System.out.println("Tipo de jugador no válido. Intente nuevamente.");
                    }

                    break;
                case 2:
                    torneo.showJugadores();
                    break;
                case 3:
                    List<Libero> topLiberos = torneo.getTopLiberos();
                    System.out.println("Los 3 mejores líberos son:");
                    for (Libero libero : topLiberos) {
                        System.out.println(libero.nombre + " - " + libero.pais);
                    }
                    break;
                case 4:
                    int efficientSetters = torneo.eficienciaPasadores();
                    System.out.println("La cantidad de pasadores con más del 80% de efectividad es: " + efficientSetters);
                    break;
                case 5:
                    System.out.println("Saliendo del programa.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        }
    }
}
