package lab2;

/**
 * Acompanha a rotina de descanso do aluno.
 * Para ser considerado descansado, é necessário acumular 26 horas ou mais por semana.
 *
 * @author Vitória Galdino
 */
public class Descanso {
    private int horasDescanso;
    private int numeroSemanas;

    /**
     * Constrói o registro de descanso com valores padrão (0 horas e 0 semanas).
     */
    public Descanso() {
        this.horasDescanso = 0;
        this.numeroSemanas = 0;
    }

    /**
     * Define a quantidade total de horas de descanso acumuladas.
     *
     * @param valor Horas de descanso.
     */
    public void defineHorasDescanso(int valor) {
        this.horasDescanso = valor;
    }

    /**
     * Define o número total de semanas decorridas.
     *
     * @param valor Número de semanas.
     */
    public void defineNumeroSemanas(int valor) {
        this.numeroSemanas = valor;
    }

    /**
     * Retorna o status geral do descanso do aluno ("descansado" ou "cansado").
     *
     * @return String contendo o statuss geral.
     */
    public String getStatusGeral() {
        if (this.numeroSemanas == 0) {
            return "cansado";
        }
        int media = this.horasDescanso / this.numeroSemanas;
        if (media >= 26) {
            return "descansado";
        }
        return "cansado";
    }
}