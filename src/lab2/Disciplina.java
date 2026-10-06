package lab2;

import java.util.Arrays;

public class Disciplina {
    private String nomeDisciplina;
    private int horasEstudo;
    private double[] notas;

    // Construtor: recebe o nome e inicializa o array com 4 notas
    public Disciplina(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
        this.horasEstudo = 0;
        this.notas = new double[4];
    }

    // Acumula as horas registradas
    public void cadastraHoras(int horas) {
        this.horasEstudo += horas;
    }

    // Cadastra uma nota em uma posição de 1 a 4
    public void cadastraNota(int nota, double valorNota) {
        // Ajusta o índice de 1..4 para 0..3 do array
        this.notas[nota - 1] = valorNota;
    }

    // Calcula e retorna a média aritmética das 4 notas
    private double calculaMedia() {
        double soma = 0.0;
        for (double n : this.notas) {
            soma += n;
        }
        return soma / this.notas.length;
    }

    // Retorna true se a média for maior ou igual a 7.0
    public boolean aprovado() {
        return this.calculaMedia() >= 7.0;
    }

    // Retorna o estado da disciplina formatado
    @Override
    public String toString() {
        return this.nomeDisciplina + " " + this.horasEstudo + " " + this.calculaMedia() + " " + Arrays.toString(this.notas);
    }
}
