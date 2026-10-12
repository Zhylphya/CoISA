package lab2;

/**
 * Encapsula o tema e o conteúdo de um resumo de estudos.
 *
 * @author Vitória Galdino
 */
public class Resumo {
    private String tema;
    private String conteudo;

    /**
     * Constrói um objeto Resumo com tema e conteúdo.
     *
     * @param tema Tema do resumo.
     * @param conteudo Texto explicativo do resumo.
     */
    public Resumo(String tema, String conteudo) {
        this.tema = tema;
        this.conteudo = conteudo;
    }

    /**
     * Retorna o tema do resumo.
     *
     * @return Tema em String.
     */
    public String getTema() {
        return this.tema;
    }

    /**
     * Retorna o conteúdo do resumo.
     *
     * @return Conteúdo em String.
     */
    public String getConteudo() {
        return this.conteudo;
    }

    /**
     * Retorna a representação formatada do resumo.
     *
     * @return String no formato "Tema: Conteúdo".
     */
    @Override
    public String toString() {
        return this.tema + ": " + this.conteudo;
    }
}