public class ContaPoupanca extends Conta {
    private double taxaTransferencia;
    private double taxaSaque;
    private double rendimento;

    public ContaPoupanca(int numeroAgencia, Cliente cliente, double taxaTransferencia, double taxaSaque, double rendimento) {
        super(numeroAgencia, cliente);
        this.taxaTransferencia = taxaTransferencia;
        this.taxaSaque = taxaSaque;
        this.rendimento = rendimento;
    }

    @Override
    public void transferir(Conta contaDestino, double valor) {
        double taxa = valor * taxaTransferencia;
        super.transferir(contaDestino, valor + taxa);
    }

    @Override
    public void sacar(double valor) {
        double taxa = valor * taxaSaque;
        super.sacar(valor + taxa);
    }

    public void aplicarRendimento() {
        double rendimentoAtual = getSaldo() * rendimento;
        depositar(rendimentoAtual);
    }

    public double getTaxaSaque() {
        return taxaSaque;
    }
}
