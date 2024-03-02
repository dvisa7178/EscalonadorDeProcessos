//politica de escalonamento

import java.util.Queue;
public class FIFO extends Escalonamento {

    private int tempoDeExe;

    public FIFO() {
        super(new CPU());

    }
    public FIFO(CPU cpu){
        super(cpu);
    }


    @Override
    public void selecionarCPU(CPU cpu){
        cpu.setEstadoAtual(0); //colocando a cpu em uso
    }

    @Override
    public void executar(Queue<Processo> listaDeProcessos, CPU cpu){
        //1: travar a cpu, dizer que ela sera ocupada
        //2: Politica fifo! enquanto houverem processos ir retirando e executando
        //3: chamar o execute do proprio processo

        selecionarCPU(cpu);

        while(!listaDeProcessos.isEmpty()){
            Processo processoAtual = listaDeProcessos.poll();
            processoAtual.executeProcess(cpu);

        }
        cpu.setEstadoAtual(1); //cpu livre
    }


}
