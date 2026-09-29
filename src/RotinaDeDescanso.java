public class RotinaDeDescanso {
    private int generalStatus = 26;
    private int weeklyRestHours = 0;

    // Construtor opcional
    public RotinaDeDescanso() {}

    // Método que RECEBE horas e RETORNA o novo total atualizado (int)
    public int registrarHoras(int horasNovas) {
        this.weeklyRestHours += horasNovas;
        return this.weeklyRestHours;
    }

    // Método Getter que RETORNA o status geral (int)
    public int getGeneralStatus() {
        return this.generalStatus;
    }
}