import java.util.ArrayList;

public class Conta {
    private static int proximoNumeroConta = 1;

    private int numeroConta;
    private int numeroAgencia;
    private double saldo;
    private Cliente cliente;
    private ArrayList<String> extrato;

    public Conta(int numeroAgencia, Cliente cliente) {
        this.numeroConta = proximoNumeroConta++;
        this.numeroAgencia = numeroAgencia;
        this.cliente = cliente;
        this.saldo = 0;
        this.extrato = new ArrayList<>();
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public int getNumeroAgencia() {
        return numeroAgencia;
    }

    public double getSaldo() {
        return saldo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            extrato.add("Depósito: +$" + valor);
            notificacao("Depósito de $" + valor + " realizado.");
        }
    }

    public void sacar(double valor) {
        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
            extrato.add("Saque: -$" + valor);
            notificacao("Saque de $" + valor + " realizado.");
        } else {
            notificacao("Tentativa de saque inválida.");
        }
    }

    public void transferir(Conta contaDestino, double valor) {
        if (valor > 0 && saldo >= valor) {
            saldo -= valor;
            contaDestino.depositar(valor);
            extrato.add("Transferência: -$" + valor);
            notificacao("Transferência de $" + valor + " realizada para conta " + contaDestino.getNumeroConta() + ".");
        } else {
            notificacao("Tentativa de transferência inválida.");
        }
    }

    public void extrato() {
        for (String transacao : extrato) {
            System.out.println(transacao);
        }
    }

    public void notificacao(String mensagem) {
        System.out.println("Notificação: " + mensagem);
    }
}
