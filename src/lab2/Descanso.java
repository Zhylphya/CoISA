package lab2;

public class Descanso {
    private int horasDescanso;
    private int numeroSemanas;

    public Descanso() {
        this.horasDescanso = 0;
        this.numeroSemanas = 0;
    }

    public void defineHorasDescanso(int valor) {
        this.horasDescanso = valor;
    }

    public void defineNumeroSemanas(int valor) {
        this.numeroSemanas = valor;
    }

    public String getStatusGeral() {
        if (this.numeroSemanas > 0 && (this.horasDescanso / this.numeroSemanas) >= 26) {
            return "descansado";
        }
        return "cansado";
    }
}