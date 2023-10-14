import java.util.*;
import java.util.stream.Collectors;

public class TorneoVoleibol {
    private List<Jugador> jugadores = new ArrayList<>();

    public void addJugador(Jugador jugador) {
        jugadores.add(jugador);
    }

    public void showJugadores() {
        for (Jugador jugador : jugadores) {
            System.out.println(jugador.nombre + " - " + jugador.pais);
        }
    }

    public List<Libero> getTopLiberos() {
        List<Libero> liberos = jugadores.stream()
                .filter(player -> player instanceof Libero)
                .map(player -> (Libero) player)
                .sorted(Comparator.comparingDouble(Libero::calcularEfectividad).reversed())
                .limit(3)
                .collect(Collectors.toList());
        return liberos;
    }

    public int eficienciaPasadores() {
        int count = 0;
        for (Jugador jugador : jugadores) {
            if (jugador instanceof Pasador) {
                Pasador pasador = (Pasador) jugador;
                double efectividad = pasador.calcularEfectividad();
                if (efectividad > 80) {
                    count++;
                }
            }
        }
        return count;
    }
}