package br.com.codenation.calculadora;


public class CalculadoraSalario {

	public long calcularSalarioLiquido(double salarioBase) {
		//Use o Math.round apenas no final do método para arredondar o valor final.
		//Documentação do método: https://docs.oracle.com/javase/8/docs/api/java/lang/Math.html#round-double-
		if (salarioBase < 1039) return (long) 0.0;
		
		double salarioMenosINSS = calcularInss(salarioBase);
		double salarioLiquido = descontarIRPF(salarioMenosINSS);
		
		return Math.round(salarioLiquido);
	}
	
	
	//Exemplo de método que pode ser criado para separar melhor as responsábilidades de seu algorítmo
	private double calcularInss(double salarioBase) {
		if (salarioBase < 1500.01) return salarioBase - (salarioBase * 0.08);
		if (salarioBase < 4000.01) return salarioBase - (salarioBase * 0.09);
		return salarioBase - (salarioBase * 0.11);
	}
	
	private double descontarIRPF(double salarioReferencia) {
		if (salarioReferencia < 3000.01) return salarioReferencia;
		if (salarioReferencia < 6000.01) return salarioReferencia - (salarioReferencia * 0.075);
		return salarioReferencia - (salarioReferencia * 0.15);
	}

}
/*Dúvidas ou Problemas?
Manda e-mail para o meajuda@codenation.dev que iremos te ajudar! 
*/