import java.util.Scanner;

public abstract class Conta {
    private int numero;
    private Cliente titular;
    protected double saldo;

    public Conta(int numero, Cliente titular, double saldo){
        this.numero = numero;
        this.titular = titular;
        this.saldo = saldo;

    }
    public Conta(int numero, Cliente titular){
        this.numero = numero;
        this.titular = titular;
        this.saldo = 0;
    }
    public Conta(int numero, String nomeTitular, String cpfTitular){
        this.numero = numero;
        this.titular = new Cliente(nomeTitular, cpfTitular);
        saldo = 0;
    }

  
    public void depositar(double valor){
        this.saldo = this.getSaldo() + valor;
    }
    public abstract boolean sacar(double valor);

    public double getSaldo(){
        return saldo;
    }

    public int getNumero(){
        return numero;
    }

    public Cliente getTitular(){
        return titular;
    }

    public void setTitular(Cliente titular){
        this.titular = titular;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
            
        System.out.println("Digite o tipo de conta que deseja criar:");
        System.out.println("1 - Conta Especial");
        System.out.println("2 - Conta Poupança");
        int opcao = input.nextInt();
            
        System.out.println("Digite o número da conta:");
        int numero = input.nextInt();
            
        System.out.println("Digite o nome do titular:");
        String nome_titular = input.next();
    
        System.out.println("Digite o CPF do titular:");
        String cpf_titular = input.next();
        Cliente titular = new Cliente(nome_titular, cpf_titular);
            
        if (opcao == 1) {
            System.out.println("Digite o limite da conta especial:");
            double limite = input.nextDouble();
            ContaEspecial conta_especial = new ContaEspecial(numero, titular, limite);
            System.out.println("Conta Especial criada: " + conta_especial);
        } else if (opcao == 2) {
            ContaPoupanca conta_poupanca = new ContaPoupanca(numero, titular);
            System.out.println("Conta Poupança criada: " + conta_poupanca);
        } else {
            System.out.println("Opção inválida!");
        }
            
        input.close();
    }
    

}