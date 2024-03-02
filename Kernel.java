import java.util.Queue;
import java.util.Scanner;

import java.util.Random;
public class Kernel {
    private CPU CPUs;
    private int RAM;
    private RelogioGlobal DataAtual;
    private Queue<Processo> listaDeProcessos;

    public Kernel() {
    }

    //arrumar o kernel, ele não deve usar processos, mas sim escalonamento

    public void runKernel(Queue<Processo> listaDeProcessos, CPU cpu) {

        //o kerner deve chamar uma politica de escalonamento para executar os processos
        //usar um switch case para que possa ser escolhida no main a politica a ser utilizada

        RelogioGlobal.setData_atual(0); //inicializando o relogio global

        System.out.println("Escolha um metodo de escalonamento: ");
        System.out.println("1: FIFO");
        System.out.println("2: Priority");

        Scanner scanner = new Scanner(System.in);
        int escolha = scanner.nextInt();

        if (escolha == 1) {
            FIFO fifo = new FIFO();
            fifo.executar(listaDeProcessos, cpu);
        }
        if(escolha == 2){
            Priority prioridade = new Priority(cpu);
            prioridade.executar(listaDeProcessos,cpu);
        }
        if(escolha != 1 && escolha != 2){
            System.out.println("Erro, valor invalido");
        }

        System.out.println();
        System.out.println(">>>> Apresentando estatísticas <<<<");
        System.out.println("Tempo total de execução dos processos: "+cpu.getTotalExe());
        System.out.println("Tempo total de ocupação da CPU: "+cpu.getTotalOcupado());
        System.out.println("Tempo total de ociosidade da CPU: "+cpu.getTotalOcioso());
    }



}