public class ContaPoupanca extends Conta {
   
    public ContaPoupanca(int numero, Cliente titular){
        super(numero, titular);
    }
    
    public void reajustar(double percentual){
        double saldoAtual = this.getSaldo();
        double reajuste = saldoAtual * percentual;
        this.depositar(reajuste);
    }

    @Override
    public boolean sacar(double valor){
        if(this.getSaldo() >= valor){
            this.saldo -= valor;
            return true;
        } else {
            return false;
        }
    }
}
