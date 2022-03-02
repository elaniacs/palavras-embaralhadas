package application;

import java.util.Scanner;

import entities.BancoDePalavras;
import entities.EmbaralhadorAlternativo;

public class Principal {

	public static void main(String[] args) {
		
		/*Scanner sc = new Scanner(System.in);
		
		
		
		sc.close();*/
		
		
		BancoDePalavras bdp = new BancoDePalavras();
		EmbaralhadorAlternativo ea = new EmbaralhadorAlternativo();
		String palavra = bdp.sorteiaPalavra(); 
		
		
		System.out.println(palavra);
		System.out.println(ea.embaralhar(palavra));
	}

}
