public class Main {
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente("Nome do Cliente", "12345678900", "01/01/1990", "Endereço do Cliente");
        Conta corrente = new ContaCorrente(1, cliente1, 1000.0);
        Conta poupanca = new ContaPoupanca(2, cliente1, 0.1, 0.05, 0.1);

        corrente.depositar(1000);
        corrente.sacar(500);
        corrente.transferir(poupanca, 300);

        poupanca.depositar(2000);
        poupanca.aplicarRendimento();
    }
}
