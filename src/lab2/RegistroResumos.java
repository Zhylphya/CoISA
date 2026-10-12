package lab2;

import java.util.Arrays;

/**
 * Gerencia uma coleção de resumos de estudos com capacidade limitada,
 * utilizando substituição circular e suporte a busca por palavra-chave.
 *
 * @author Vitória Galdino
 */
public class RegistroResumos {
    private Resumo[] resumos;
    private int capacidade;
    private int qtdCadastrada;
    private int proximaPosicao;

    /**
     * Constrói o registro delimitando a capacidade máxima de resumos.
     *
     * @param numeroDeResumos Capacidade máxima de armazenamento.
     */
    public RegistroResumos(int numeroDeResumos) {
        this.capacidade = numeroDeResumos;
        this.resumos = new Resumo[numeroDeResumos];
        this.qtdCadastrada = 0;
        this.proximaPosicao = 0;
    }

    /**
     * Adiciona um novo resumo ou atualiza se o tema já existir.
     * Substitui resumos de forma circular (FIFO) caso atinja a capacidade.
     *
     * @param tema Tema do resumo.
     * @param conteudo Texto explicativo do resumo.
     */
    public void adiciona(String tema, String conteudo) {
        for (int i = 0; i < this.qtdCadastrada; i++) {
            if (this.resumos[i].getTema().equalsIgnoreCase(tema)) {
                this.resumos[i] = new Resumo(tema, conteudo);
                return;
            }
        }

        this.resumos[this.proximaPosicao] = new Resumo(tema, conteudo);

        if (this.qtdCadastrada < this.capacidade) {
            this.qtdCadastrada++;
        }

        this.proximaPosicao = (this.proximaPosicao + 1) % this.capacidade;
    }

    /**
     * Método alternativo para adição de resumos mantido para compatibilidade.
     *
     * @param tema Tema do resumo.
     * @param conteudo Conteúdo do resumo.
     */
    public void adicionaResumo(String tema, String conteudo) {
        this.adiciona(tema, conteudo);
    }

    /**
     * Retorna um array contendo as representações em String ("Tema: Conteudo") de todos os resumos válidos.
     *
     * @return Array de Strings com os resumos cadastrados.
     */
    public String[] pegaResumos() {
        String[] listaResumos = new String[this.qtdCadastrada];
        for (int i = 0; i < this.qtdCadastrada; i++) {
            listaResumos[i] = this.resumos[i].toString();
        }
        return listaResumos;
    }

    /**
     * Retorna o total de resumos cadastrados até o momento.
     *
     * @return Quantidade de resumos.
     */
    public int conta() {
        return this.qtdCadastrada;
    }

    /**
     * Método alternativo equivalente a conta().
     *
     * @return Quantidade de resumos.
     */
    public int contaResumos() {
        return this.conta();
    }

    /**
     * Imprime a quantidade de resumos cadastrados e a lista de temas formatada.
     *
     * @return String formatada com contagem e temas.
     */
    public String imprimeResumos() {
        StringBuilder sb = new StringBuilder();
        sb.append("- ").append(this.qtdCadastrada).append(" resumo(s) cadastrado(s)\n- ");

        for (int i = 0; i < this.qtdCadastrada; i++) {
            sb.append(this.resumos[i].getTema());
            if (i < this.qtdCadastrada - 1) {
                sb.append(" | ");
            }
        }
        return sb.toString();
    }

    /**
     * Verifica se existe um resumo cadastrado para determinado tema.
     *
     * @param tema Tema a ser verificado.
     * @return true se o tema existe, false caso contrário.
     */
    public boolean temResumo(String tema) {
        for (int i = 0; i < this.qtdCadastrada; i++) {
            if (this.resumos[i].getTema().equalsIgnoreCase(tema)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Busca temas cujos resumos contenham a chave informada em seu conteúdo.
     * A busca ignora diferenças entre maiúsculas/minúsculas e os temas retornados
     * são ordenados alfabeticamente (lexicograficamente).
     *
     * @param chaveDeBusca Termo a procurar no conteúdo.
     * @return Array de temas ordenados lexicograficamente.
     */
    public String[] busca(String chaveDeBusca) {
        String chave = chaveDeBusca.toLowerCase();
        int contagem = 0;

        for (int i = 0; i < this.qtdCadastrada; i++) {
            if (this.resumos[i].getConteudo().toLowerCase().contains(chave)) {
                contagem++;
            }
        }

        String[] resultados = new String[contagem];
        int idx = 0;
        for (int i = 0; i < this.qtdCadastrada; i++) {
            if (this.resumos[i].getConteudo().toLowerCase().contains(chave)) {
                resultados[idx++] = this.resumos[i].getTema();
            }
        }

        Arrays.sort(resultados);
        return resultados;
    }
}