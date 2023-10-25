import java.util.ArrayList;

public class SistemaBancario {
    private ArrayList<Conta> contas;

    public SistemaBancario() {
        this.contas = new ArrayList<>();
    }

    public void adicionarConta(Conta conta) {
        contas.add(conta);
    }
}
