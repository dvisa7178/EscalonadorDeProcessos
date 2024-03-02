public class RelogioGlobal {
    private static int data_atual;

    public RelogioGlobal(){
        data_atual = 0;
    }

    public static void setData_atual(int data_atual) {
        RelogioGlobal.data_atual = data_atual;
    }

    public static int getData_atual() {
        return data_atual;
    }
}

