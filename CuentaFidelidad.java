public class CuentaFidelidad {

    private static final double MONTO_POR_PUNTO = 100.0;
    private static final int PUNTOS_HISTORICOS_PLATA = 500;
    private static final int PUNTOS_HISTORICOS_ORO = 1500;

    private final String numeroSocio;
    private String nivelMembresia;
    private int puntos;
    private int puntosHistoricos;

    public CuentaFidelidad(String numeroSocio) {
        if (numeroSocio == null || numeroSocio.trim().isEmpty()) {
            throw new IllegalArgumentException("El número de socio no puede estar vacío.");
        }
        this.numeroSocio = numeroSocio;
        this.nivelMembresia = "BRONCE";
        this.puntos = 0;
        this.puntosHistoricos = 0;
    }

    public String getNumeroSocio() {
        return numeroSocio;
    }

    public String getNivelMembresia() {
        return nivelMembresia;
    }

    public int getPuntos() {
        return puntos;
    }

    public boolean acumularPuntos(double montoCompra) {
        if (Double.isNaN(montoCompra) || Double.isInfinite(montoCompra)) {
            System.out.println("Error: el monto ingresado no es un número válido.");
            return false;
        }
        if (montoCompra <= 0) {
            System.out.println("Error: el monto de la compra debe ser mayor a 0 (se ingresó " + montoCompra + ").");
            return false;
        }
        int puntosGanados = calcularPuntos(montoCompra);
        if (puntosGanados == 0) {
            System.out.println("Compra de $" + montoCompra + " registrada: no alcanza para sumar puntos. Total: "
                    + puntos + ".");
            return true;
        }
        puntos += puntosGanados;
        puntosHistoricos += puntosGanados;
        System.out.println("Compra de $" + montoCompra + " registrada: +" + puntosGanados
                + " puntos. Total: " + puntos + ".");
        actualizarNivel();
        return true;
    }

    public boolean canjearPremio(int puntosRequeridos) {
        if (puntosRequeridos <= 0) {
            System.out.println("Error: los puntos requeridos deben ser mayores a 0.");
            return false;
        }
        if (puntosRequeridos > puntos) {
            System.out.println("Error: puntos insuficientes. Requeridos: " + puntosRequeridos
                    + " | Disponibles: " + puntos + ".");
            return false;
        }
        puntos -= puntosRequeridos;
        System.out.println("Premio canjeado: -" + puntosRequeridos + " puntos. Saldo: " + puntos + ".");
        return true;
    }

    public String obtenerInformacion() {
        return "Socio: " + numeroSocio + " | Nivel: " + nivelMembresia + " | Puntos: " + puntos;
    }

    private int calcularPuntos(double montoCompra) {
        return (int) (montoCompra / MONTO_POR_PUNTO * obtenerMultiplicador());
    }

    private double obtenerMultiplicador() {
        switch (nivelMembresia) {
            case "PLATA":
                return 1.5;
            case "ORO":
                return 2.0;
            default:
                return 1.0;
        }
    }

    private void actualizarNivel() {
        String nuevoNivel;
        if (puntosHistoricos >= PUNTOS_HISTORICOS_ORO) {
            nuevoNivel = "ORO";
        } else if (puntosHistoricos >= PUNTOS_HISTORICOS_PLATA) {
            nuevoNivel = "PLATA";
        } else {
            nuevoNivel = "BRONCE";
        }
        if (!nuevoNivel.equals(nivelMembresia)) {
            nivelMembresia = nuevoNivel;
            System.out.println("¡Subiste de nivel! Ahora sos " + nivelMembresia + ".");
        }
    }
}