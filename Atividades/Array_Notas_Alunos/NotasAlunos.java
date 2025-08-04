package notas;
import java.util.Iterator;
import java.util.Scanner;

public class NotasAlunos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		
	System.out.println("Quantos Alunos^");
	int totalAlunos = scanner.nextInt();
	
	double[] notas = new double[totalAlunos];
	double soma = 0;
	double maior = Double.MAX_VALUE;
	double menor = Double.MIN_VALUE;
	
	for (int i = 0; i < totalAlunos; i++){
		System.out.println("Digite a nota do aluno" + (i+1) + ": ");
		notas[i] = scanner.nextDouble();
		soma += notas[i];
	}
	}

}
