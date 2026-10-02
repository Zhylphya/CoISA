package lab2;

public class RegistroTempoOnline {
    private String nomeDisciplina;
    private int tempoOnlineEsperado;
    private int tempoOnlineUsado;

    // Construtor 1: Apenas o nome da disciplina (padrão de 60h de aula = 120h online esperadas)
    public RegistroTempoOnline(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
        this.tempoOnlineEsperado = 120; // 60 * 2 por padrão
        this.tempoOnlineUsado = 0;
    }

    // Construtor 2: Recebe o nome e o tempo online esperado explicitamente
    public RegistroTempoOnline(String nomeDisciplina, int tempoOnlineEsperado) {
        this.nomeDisciplina = nomeDisciplina;
        this.tempoOnlineEsperado = tempoOnlineEsperado;
        this.tempoOnlineUsado = 0;
    }

    // Adiciona tempo online utilizado (pode ultrapassar o tempo esperado)
    public void adicionaTempoOnline(int tempo) {
        if (tempo > 0) {
            this.tempoOnlineUsado += tempo;
        }
    }

    // Verifica se a meta de tempo foi atingida
    public boolean atingiuMetaTempoOnline() {
        return this.tempoOnlineUsado >= this.tempoOnlineEsperado;
    }

    // Retorna a representação textual do objeto
    @Override
    public String toString() {
        return this.nomeDisciplina + " " + this.tempoOnlineUsado + "/" + this.tempoOnlineEsperado;
    }
}