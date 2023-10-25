import java.util.ArrayList;

public class ContaCorrente extends Conta {
    private double chequeEspecial;
    private int transferenciasRealizadas;

    public ContaCorrente(int numeroAgencia, Cliente cliente, double chequeEspecial) {
        super(numeroAgencia, cliente);
        this.chequeEspecial = chequeEspecial;
        this.transferenciasRealizadas = 0;
    }

    @Override
    public void transferir(Conta contaDestino, double valor) {
        if (transferenciasRealizadas < 2) {
            super.transferir(contaDestino, valor);
            transferenciasRealizadas++;
        } else {
            double taxa = valor * 0.1;
            super.transferir(contaDestino, valor + taxa);
        }
    }

    public double getChequeEspecial() {
        return chequeEspecial;
    }
}
