//SOBRE ESCALONAMENTO
//É a classe que ira escolher qual processo deve ser executado
import java.util.Queue;
public abstract class Escalonamento {

    //é a classe que escolhe qual sera a politica de escalonamento a ser utilizada, FIFO/Priority
    private CPU cpu;
    private Queue<Processo> listaDeProcessos;

    public Escalonamento(CPU cpu) {
        this.cpu = cpu;
    }

    abstract public void executar(Queue<Processo> listaDeProcessos, CPU cpu);

    abstract public void selecionarCPU(CPU cpu);

    //tomara a decisao de qual processo usara qual cpu (podemos usar apenas 1 cpu)
}
