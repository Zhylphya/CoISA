package lab2;

import java.util.Arrays;

/**
 * Representa uma disciplina cursada, gerenciando notas, horas de estudo e médias.
 *
 * @author Vitória Galdino
 */
public class Disciplina {
    private String nomeDisciplina;
    private int horasEstudo;
    private double[] notas;
    private int[] pesos;

    /**
     * Constrói uma disciplina padrão de 4 notas sem pesos (média aritmética).
     *
     * @param nomeDisciplina Nome da disciplina.
     */
    public Disciplina(String nomeDisciplina) {
        this(nomeDisciplina, 4);
    }

    /**
     * Constrói uma disciplina informando a quantidade de notas.
     *
     * @param nomeDisciplina Nome da disciplina.
     * @param numNotas Quantidade de provas/notas da disciplina.
     */
    public Disciplina(String nomeDisciplina, int numNotas) {
        this.nomeDisciplina = nomeDisciplina;
        this.horasEstudo = 0;
        this.notas = new double[numNotas];
        this.pesos = null;
    }

    /**
     * Constrói uma disciplina com quantidade de notas e pesos definidos para cada nota.
     *
     * @param nomeDisciplina Nome da disciplina.
     * @param numNotas Quantidade de provas/notas.
     * @param pesos Array contendo o peso associado a cada nota.
     */
    public Disciplina(String nomeDisciplina, int numNotas, int[] pesos) {
        this(nomeDisciplina, numNotas);
        this.pesos = Arrays.copyOf(pesos, pesos.length);
    }

    /**
     * Cadastra/acumula horas dedicadas ao estudo da disciplina.
     *
     * @param horas Horas a serem somadas.
     */
    public void cadastraHoras(int horas) {
        this.horasEstudo += horas;
    }

    /**
     * Cadastra ou atualiza o valor de uma nota específica (1-indexed).
     *
     * @param nota Índice de 1 a N da nota.
     * @param valorNota Valor atribuído à nota.
     */
    public void cadastraNota(int nota, double valorNota) {
        if (nota >= 1 && nota <= this.notas.length) {
            this.notas[nota - 1] = valorNota;
        }
    }

    /**
     * Calcula a média aritmética ou ponderada da disciplina.
     *
     * @return Valor da média calculada.
     */
    private double calculaMedia() {
        double soma = 0.0;
        if (this.pesos == null) {
            for (double n : this.notas) {
                soma += n;
            }
            return soma / this.notas.length;
        } else {
            int somaPesos = 0;
            for (int i = 0; i < this.notas.length; i++) {
                soma += this.notas[i] * this.pesos[i];
                somaPesos += this.pesos[i];
            }
            return somaPesos == 0 ? 0.0 : soma / somaPesos;
        }
    }

    /**
     * Indica se o aluno foi aprovado (média >= 7.0).
     *
     * @return true se aprovado, false caso contrário.
     */
    public boolean aprovado() {
        return calculaMedia() >= 7.0;
    }

    /**
     * Retorna a representação em texto da disciplina.
     *
     * @return String contendo nome, horas, média e notas.
     */
    @Override
    public String toString() {
        return this.nomeDisciplina + " " + this.horasEstudo + " " + calculaMedia() + " " + Arrays.toString(this.notas);
    }
}