import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        // Criamos a instância da rotina para usar seus métodos
        RotinaDeDescanso descanso = new RotinaDeDescanso();

        System.out.println("Escolha uma das opções:\n1) Registrar horas de descanso;\n2) Consultar status;\n3) Sair;");
        int input = reader.nextInt();

        if (input == 1) {
            System.out.print("Digite as horas descansadas: ");
            int horas = reader.nextInt();

            // CHAMADA + RETORNO: O método calcula e devolve o total para a variável 'totalAtual'
            int totalAtual = descanso.registrarHoras(horas);

            System.out.println("Sucesso! Seu total acumulado agora é: " + totalAtual + " horas.");

        } else if (input == 2) {
            // Captura o retorno do método que pega o status
            int status = descanso.getGeneralStatus();
            System.out.println("Seu status geral é: " + status);

        } else {
            System.out.println("Saindo do programa...");
        }

        reader.close();
    }
}