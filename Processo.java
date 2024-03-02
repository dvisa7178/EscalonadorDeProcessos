//SOBRE PROCESSO :
//1: Processo em primeiro plano = tem io
//2: Processo em segundo plano = nao tem io

import java.util.Random;
public class Processo {
    private int timeStamp;
    private int pri;
    private int mi;
    private int ram;
    private int io;
    private CPU cpu;
    private int estado; //0 pronto, 1 em espera

    public Processo(int timeStamp, int pri, int mi, int ram, int io){
        this.timeStamp = timeStamp;
        this.pri = pri;
        this.mi = mi;
        this.ram = ram;
        this.io = io;

    } //construtor
    public void setPri(int pri) {
        this.pri = pri;
    }
    public void setMi(int mi) {
        this.mi = mi;
    }
    public void setIo(int io) {
        this.io = io;
    }
    public int getIo() {
        return io;
    }
    public void setEstado(int estado) {
        this.estado = estado;
    }
    public int getEstado() {
        return estado;
    }
    public int getPri() {
        return pri;
    }
    public int getMi() {
        return mi;
    }

    public int getRam() {
        return ram;
    }

    public int getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(int timeStamp) {
        this.timeStamp = timeStamp;
    }

    public void executeProcess(CPU cpu){
        if (getIo() == 0) {
            setEstado(0);
        } else {

            while(getIo() != 0){
                    setEstado(1);
                    setIo(getIo()-1); //se o valor nao foi sorteado, diminui em um o numero de valores
                    cpu.increaseQuantum();
                    RelogioGlobal.setData_atual(RelogioGlobal.getData_atual()+cpu.getQuantum());
                    System.out.println("Aguarde...");
                    cpu.executaProcesso(getTimeStamp(),getRam(),getMi(), getEstado());

            }
            setEstado(0);

        }
        if(getEstado() == 0){
            System.out.println("\n-------------Executando processo com timeStamp "+ getTimeStamp()+"----------------");
            cpu.executaProcesso(getTimeStamp(),getRam(),getMi(), getEstado());
            System.out.println("----------------------------------------------------------------------------------\n");
        }
    }
}