public class Main {

    public static void main(String[] args) {

        CuentaFidelidad cuenta = new CuentaFidelidad("S-2045");

        System.out.println("=== Estado inicial ===");
        System.out.println(cuenta.obtenerInformacion());

        System.out.println("\n=== Compras ===");
        cuenta.acumularPuntos(30000);
        cuenta.acumularPuntos(20000);

        System.out.println("\n=== Compras inválidas o sin puntos ===");
        cuenta.acumularPuntos(-500);
        cuenta.acumularPuntos(0);
        cuenta.acumularPuntos(Double.NaN);
        cuenta.acumularPuntos(50);

        System.out.println("\n=== Canjes de premios ===");
        cuenta.canjearPremio(400);
        cuenta.canjearPremio(1000);
        cuenta.canjearPremio(0);
        cuenta.canjearPremio(-50);

        System.out.println("\n=== Más compras con nuevo nivel ===");
        cuenta.acumularPuntos(40000);
        cuenta.acumularPuntos(30000);

        System.out.println("\n=== Canje tras acumular ===");
        cuenta.canjearPremio(1000);

        System.out.println("\n=== Estado final ===");
        System.out.println(cuenta.obtenerInformacion());
        System.out.println("Puntos consultados con getter: " + cuenta.getPuntos());
    }
}