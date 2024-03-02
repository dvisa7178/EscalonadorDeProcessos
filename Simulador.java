import java.util.Queue;
import java.util.LinkedList;
import java.util.Scanner;

public class Simulador {
    public static void main(String[] args) {
        // 1 = csv, criar processos
        Queue<Processo> listaDeProcessos = new LinkedList<>();

        listaDeProcessos.add(new Processo(12, 0, 5000, 3, 0));
        listaDeProcessos.add(new Processo(22,1,3000,1,3));
        listaDeProcessos.add(new Processo(34,3,4780,2,0));
        listaDeProcessos.add(new Processo(57,0,10000,5,7));
        listaDeProcessos.add(new Processo(59,2,9000,8,2));

        // 2  - Setar as cpus -
        CPU core1 = new CPU();
        core1.setVelocidade(2);
        core1.setEstadoAtual(0);

        CPU core2 = new CPU();
        core2.setVelocidade(4);
        core2.setEstadoAtual(0);

        CPU core3 = new CPU();
        core2.setVelocidade(3);
        core2.setEstadoAtual(0);

        CPU core4 = new CPU();
        core2.setVelocidade(1);
        core2.setEstadoAtual(0);

        // 4 = memoria disponivel na maquina
        core1.setRamDispositivo(16);
        core2.setRamDispositivo(16);
        core3.setRamDispositivo(16);
        core4.setRamDispositivo(16);

        // 5 = quantum
        core1.setQuantum(0);
        core2.setQuantum(0);
        core3.setQuantum(0);
        core4.setQuantum(0);



        System.out.print("Escolha qual core deseja usar (são 4!): ");

        Scanner scanner = new Scanner(System.in);
        int escolha = scanner.nextInt();

        Kernel kernel = new Kernel();

        switch (escolha){
            case 1:
                kernel.runKernel(listaDeProcessos,core1);
                break;
            case 2:
                kernel.runKernel(listaDeProcessos,core2);
                break;
            case 3:
                kernel.runKernel(listaDeProcessos,core3);
                break;
            case 4:
                kernel.runKernel(listaDeProcessos,core4);
                break;
        }

    }
}
