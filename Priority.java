// NAO FUNCIONA  -  ARRUMAR

import java.util.Queue;
public class Priority extends Escalonamento{

    public Priority(CPU cpu){
        super(cpu);
    }

    @Override
    public void selecionarCPU(CPU cpu){
        cpu.setEstadoAtual(0); //colocando a cpu em uso
    }

    public int maiorPrioridade (Queue<Processo> listaDeProcessos){
        Processo processoAnterior = null;
        int maiorPri = 0;

        while (!listaDeProcessos.isEmpty()){
            Processo processoAtual = listaDeProcessos.peek();
            maiorPri = processoAtual.getPri();
            if(maiorPri < processoAnterior.getPri()){
                maiorPri = processoAnterior.getPri();
            }
            processoAnterior = processoAtual;
        }

        return maiorPri;
    }
    @Override
    public void executar(Queue<Processo> listaDeProcessos, CPU cpu){
        //1: travar a cpu, dizer que ela sera ocupada
        //2: Politica priority! enquanto houverem processos ir retirando e executando
        //3: chamar o execute do proprio processo

        selecionarCPU(cpu);

        while (!listaDeProcessos.isEmpty()){
            Processo processo = listaDeProcessos.peek();
            int pri = maiorPrioridade(listaDeProcessos);
            if(processo.getPri() == pri){
                processo = listaDeProcessos.poll();
                processo.executeProcess(cpu);
            }
        }
        cpu.setEstadoAtual(1); //cpu livre

    }
}