package lab2;

/**
 * Registra e controla o tempo investido online para uma determinada disciplina.
 *
 * @author Vitória Galdino
 */
public class RegistroTempoOnline {
    private String nomeDisciplina;
    private int tempoOnlineGasto;
    private int tempoOnlineEsperado;

    /**
     * Constrói o registro com tempo esperado padrão de 120 horas.
     *
     * @param nomeDisciplina Nome da disciplina.
     */
    public RegistroTempoOnline(String nomeDisciplina) {
        this(nomeDisciplina, 120);
    }

    /**
     * Constrói o registro definindo o tempo esperado.
     *
     * @param nomeDisciplina Nome da disciplina.
     * @param tempoOnlineEsperado Horas esperadas online.
     */
    public RegistroTempoOnline(String nomeDisciplina, int tempoOnlineEsperado) {
        this.nomeDisciplina = nomeDisciplina;
        this.tempoOnlineEsperado = tempoOnlineEsperado;
        this.tempoOnlineGasto = 0;
    }

    /**
     * Adiciona horas de estudo online para a disciplina.
     *
     * @param tempo Horas a adicionar.
     */
    public void adicionaTempoOnline(int tempo) {
        this.tempoOnlineGasto += tempo;
    }

    /**
     * Verifica se o aluno atingiu a meta de tempo esperada.
     *
     * @return true se atingiu ou ultrapassou a meta; false caso contrário.
     */
    public boolean atingiuMetaTempoOnline() {
        return this.tempoOnlineGasto >= this.tempoOnlineEsperado;
    }

    /**
     * Retorna a representação textual do registro tempo online.
     *
     * @return String no formato "NomeDisciplina TempoGasto/TempoEsperado".
     */
    @Override
    public String toString() {
        return this.nomeDisciplina + " " + this.tempoOnlineGasto + "/" + this.tempoOnlineEsperado;
    }
}