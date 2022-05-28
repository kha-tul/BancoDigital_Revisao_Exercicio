package dio.bancodigital.exercicio;

public class Main {
    public static void main(String[] args) {

        Cliente Nathally = new Cliente();
        Nathally.setNome("Nathally");

        Conta cc = new ContaCorrente(Nathally);
        cc.depositar(100);
        Conta cp = new ContaPoupanca(Nathally);
        cc.transferir(100, cp);

        cc.imprimirAtributoseInfosComuns();
        cp.imprimirAtributoseInfosComuns();
    }
}
