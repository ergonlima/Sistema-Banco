package model;

import javax.swing.JOptionPane;

public class Conta {
	// Foi utilizada a classe 2
	private int numero;
	private String dono;
	private double saldo;
	private double limite;
	
	public Conta(int numero, String dono, double saldo, double limite) {
		super();
		this.numero = numero;
		this.dono = dono;
		this.saldo = saldo;
		this.limite = limite;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getDono() {
		return dono;
	}
	public void setDono(String dono) {
		this.dono = dono;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	public double getLimite() {
		return limite;
	}
	public void setLimite(double limite) {
		this.limite = limite;
	}
	
	// M�todo Saque
	public boolean saca(double valor) {
		// quando n�o tiver saldo ter� que conultar o limite e caso n�o tenha retornar� a mensagem abaixo.
		if((saldo+limite)<valor) {
			JOptionPane.showMessageDialog(null, "SALDO INSUFICIENTE PARA SAQUE");
			System.out.println("Saldo Insuficiente para Saque");
		}
		else {
			// Aqui ser� usado o limite
			if(saldo<valor) {
				// Atualizando valor do limite
				this.limite=limite+(saldo-valor);
				System.out.println("Foi utilizado do LIMITE nesta transa��o");
				this.saldo = saldo-valor;
				System.out.println("Saldo Atualizado: 0.0");
				System.out.println("Saldo do Limite: "+this.limite);
				
			}else {
				this.saldo = saldo-valor;
				System.out.println("Saldo Atualizado: "+ this.saldo);
			}
			
		}
		return true;
	}
	
	// M�todo Dep�sito
	public void deposita(double valor) {
		this.saldo = saldo+valor;
		System.out.println("Saldo Atualizado: "+ this.saldo);
	}
	
	// M�todo Transfer�ncia
	public boolean transfere(Conta destino,double valor) {
		if((saldo+limite)<valor) {
			JOptionPane.showMessageDialog(null, "SALDO INSUFICIENTE PARA TRANSFER�NCIA");
			System.out.println("Saldo Insuficiente para Transfer�ncia");
		}
		else {	
			System.out.println("_____________________________________");
			System.out.println(" Realizado transfer�ncia com sucesso");
			System.out.println("_____________________________________");
			System.out.println("Conta Depositante: ");
			saca(valor);
			System.out.println("");
			System.out.println("Conta Destino: ");
			destino.deposita(valor);
		}
		
		return true; 
	}
	// M�todo Imprime 
	public void ImprimeConta() {
		System.out.println("");
		System.out.println("N�mero da Conta: "+ this.numero);
		System.out.println("Dono: "+ this.dono);
		System.out.println("Saldo: "+ this.saldo);
		System.out.println("Limite: "+ this.limite);
	}
}
