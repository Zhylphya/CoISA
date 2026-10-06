package lab2;

public class RegistroResumos {
    private String[] temas;
    private String[] conteudos;
    private int quantidade;
    private int posicaoAtual;

    public RegistroResumos(int numeroDeResumos) {
        this.temas = new String[numeroDeResumos];
        this.conteudos = new String[numeroDeResumos];
        this.quantidade = 0;
        this.posicaoAtual = 0;
    }

    public void adiciona(String tema, String conteudo) {
        this.temas[this.posicaoAtual] = tema;
        this.conteudos[this.posicaoAtual] = conteudo;

        // Comportamento circular para sobrescrever se atingir o limite
        this.posicaoAtual = (this.posicaoAtual + 1) % this.temas.length;

        // Mantém a contagem de elementos reais (limitado ao tamanho máximo)
        if (this.quantidade < this.temas.length) {
            this.quantidade++;
        }
    }

    public int conta() {
        return this.quantidade;
    }

    public String[] pegaResumos() {
        String[] resumosFormatados = new String[this.quantidade];
        for (int i = 0; i < this.quantidade; i++) {
            resumosFormatados[i] = this.temas[i] + ": " + this.conteudos[i];
        }
        return resumosFormatados;
    }

    public String imprimeResumos() {
        String saida = "- " + this.quantidade + " resumo(s) cadastrado(s)\n- ";
        for (int i = 0; i < this.quantidade; i++) {
            saida += this.temas[i];
            if (i < this.quantidade - 1) {
                saida += " | ";
            }
        }
        return saida;
    }

    public boolean temResumo(String tema) {
        for (int i = 0; i < this.quantidade; i++) {
            if (this.temas[i].equalsIgnoreCase(tema)) {
                return true;
            }
        }
        return false;
    }
}