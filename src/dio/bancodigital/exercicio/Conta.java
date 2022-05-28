package dio.bancodigital.exercicio;

public abstract class Conta implements iConta { //uma classe abstrata não pode ser instanciada, isso é,
    //não cria objeto (new)

    //Polimorfismo: Capacidade de um objeto poder ser referenciado de várias formas, ou seja, a capacidade
   //de tratar objetos criados a partir das classes específicas como objetos de uma classe genérica.
    //não quer dizer que o objeto fica mudando!! ao contrário, nasce de um tipo, morre do mesmo tipo.

    // atributos

    private static final int AGENCIA_PADRAO = 1; //criado para manter padrao nas contas

    private static int SEQUENCIAL = 1; //criado para manter a sequencia

    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;

    //Construtor da Conta - Método Padrão
    public Conta(Cliente cliente) {
        this.agencia = AGENCIA_PADRAO; //cria a constante pra sempre ser 1 no campo agencia.
        this.numero = SEQUENCIAL++; //criar uma váriavel para armazenar;
        this.cliente = cliente; //cliente criado aqui
    }

// implementacao Iconta:

    @Override
    public void sacar(double valor) {
        saldo = saldo - valor; //saldo é igual a ele - o valor que retirar (sacar)
    }

    @Override
    public void depositar(double valor) {
        saldo = saldo + valor; //saldo é igual a ele + o valor que entrar (deposito)

    }

    @Override
    public void transferir(double valor, Conta contaDestino) {
        this.sacar(valor);
        contaDestino.depositar(valor);
    }

    //
    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    //Método criado com Refrector - Metodos Comuns para impressão de extrato
    protected void imprimirAtributoseInfosComuns() {
        System.out.println(String.format("Titular: %s", this.cliente.getNome()));
        System.out.println(String.format("Numero: %d", this.agencia));
        System.out.println(String.format("Conta: %d", this.numero));
        System.out.println(String.format("Saldo: %.2f", this.saldo));
    }
}
