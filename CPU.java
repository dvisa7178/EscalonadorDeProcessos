//O que a Cpu precisa fazer?
//excecutar o preocesso escolhido pelo escalonador

public class CPU {
    private int velocidade;
    private int estadoAtual; //0 = em uso, 1 = livre
    private int tempoOcioso;
    private int tempoOcupado;
    private int quantum;
    private int  ramDispositivo;
    private int totalExe;
    private int totalOcioso;
    private int totalOcupado;

    public CPU() {
       this.velocidade = 0;
       this.estadoAtual = 0;
       this.tempoOcioso = 0;
       this.tempoOcupado = 0;
       this.ramDispositivo = 0;
       this.totalExe = 0;
       this.totalOcioso = 0;
       this.totalOcupado = 0;
    }

    public void setVelocidade(int velocidade) {
        this.velocidade = velocidade;
    }

    public int getVelocidade() {
        return velocidade;
    }

    public int getEstadoAtual() {
        return estadoAtual;
    }

    public void setEstadoAtual(int estadoAtual) {
        this.estadoAtual = estadoAtual;
    }

    public int getTempoOcioso() {
        return tempoOcioso;
    }

    public int getTempoOcupado() {
        return tempoOcupado;
    }

    public void setTempoOcioso(int tempoOcioso) {
        this.tempoOcioso = tempoOcioso;
    }

    public void setTempoOcupado(int tempoOcupado) {
        this.tempoOcupado = tempoOcupado;
    }

    public void setQuantum(int quantum) {
        this.quantum = quantum;
    }

    public void increaseQuantum(){
        this.quantum++;
    }

    public int getQuantum() {
        return quantum;
    }

    public void setRamDispositivo(int ramDispositivo) {
        this.ramDispositivo = ramDispositivo;
    }

    public int getRamDispositivo() {
        return ramDispositivo;
    }

    public int getTotalExe() {
        return totalExe;
    }

    public void setTotalExe(int totalExe) {
        this.totalExe = totalExe;
    }

    public int getTotalOcioso() {
        return totalOcioso;
    }

    public void setTotalOcioso(int totalOcioso) {
        this.totalOcioso = totalOcioso;
    }

    public int getTotalOcupado() {
        return totalOcupado;
    }

    public void setTotalOcupado(int totalOcupado) {
        this.totalOcupado = totalOcupado;
    }

    public void executaProcesso(int timeStamp, int ram, int mi, int estadoProcesso){
        //1: checar se o processo esta pronto para ser excecutado
        //   sim: Executar o processo, alocar ram para realiza-lo, atualizando o relogio global
             //implemantar metodo para avançar o relogio e retorna-lo atualizado
        //   nao: Nao fazer nada, apenas retornar o tempo (deve ser ocioso!)

        int ramTotal;
        ramTotal = ramDispositivo + (ramDispositivo/2);

        if(estadoProcesso == 0){
            int tempoExe = (mi/velocidade);
            tempoExe = tempoExe + tempoOcioso;
            RelogioGlobal.setData_atual(tempoExe+timeStamp);
            setTempoOcupado(tempoExe);
            System.out.println("Processo finalizado.");
            System.out.println("Tempo de Ocupação da CPU: "+ getTempoOcupado());

            totalExe += getTempoOcupado();
            totalOcupado += getTempoOcupado();

        }else{
            setTempoOcioso(timeStamp+getQuantum());
            System.out.println("Processo não realizado.");
            System.out.println("Tempo ocioso da CPU: "+getTempoOcioso());

            totalOcioso += getTempoOcioso();
        }
    }
}