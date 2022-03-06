package application;

import java.util.Scanner;

import entities.BancoDePalavras;
import entities.FabricaEmbaralhadores;
import entities.FabricaMecanicaDoJogo;
import interfaces.Embaralhador;
import interfaces.MecanicaDoJogo;

public class Principal {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("BEM VINDO AO JOGO DAS PALAVRAS EMBARALHADAS");
		System.out.println();
		System.out.println("Neste jogo voc� receber� uma lista de palavras embaralhadas(uma por vez)");
		System.out.println("Organize as letras para descobrir a palavra correta. ");	
		System.out.println();
		System.out.println("Escolha o n�vel do jogo");
		System.out.println("1 - f�cil - tentativas ilimitadas por palavra, deve acertar todas as palavras e cada acerto vale 7 pontos");
		System.out.println("2 - dif�cil - at� 3 tentativas por palavra, deve acertar a maioria(metade + 1) das palavras e cada acerto vale 15 pontos");
		int opcao = 0;
		
		FabricaMecanicaDoJogo fabricaMecanicaDoJogo = new FabricaMecanicaDoJogo();
		MecanicaDoJogo mecanicaDoJogo = null; 
		
		while (!(opcao == 1 || opcao == 2)) {
		
			System.out.print("1 ou 2? ");	
			opcao = in.nextInt();
			
			if (opcao == 1) {
				mecanicaDoJogo = fabricaMecanicaDoJogo.criarMecanicaAlternativa();
				break;
			}
			if (opcao == 2) {
				mecanicaDoJogo = fabricaMecanicaDoJogo.criarMecanicaPadrao(); 
				break;
			}
			
			System.out.println("Op��o inv�lida");
		}
		
		BancoDePalavras bdp = new BancoDePalavras();
		FabricaEmbaralhadores fabricaEmbaralhadores = new FabricaEmbaralhadores(); 
		Embaralhador embaralhador = fabricaEmbaralhadores.getEmbaralhadorAleatorio();
		
		while (!(mecanicaDoJogo.jogoDeveAcabar())) {
			System.out.println("Sorteamos uma nova palavra para voc�. ");
			System.out.println();
			String palavra = bdp.sorteiaPalavra(); 		
			System.out.println(embaralhador.embaralhar(palavra));
			System.out.print("Digite a palavra correta? ");
			String palavraUsuario = in.next(); 
			boolean tentarNovamente = true; 
			while (tentarNovamente) {
				if (mecanicaDoJogo.acertouPalavra(palavra, palavraUsuario)) {
					tentarNovamente = false; 
					System.out.println("Parab�ns, voc� acertou!");
					System.out.println("Sua pontua��o final foi " + mecanicaDoJogo.pontuacaoFinal());
				}
				else {
					System.out.println("Que pena, voc� errou");
					System.out.print("Tente novamente: ");
					palavraUsuario = in.next(); 
					tentarNovamente = mecanicaDoJogo.tentarDeNovo(); 
				}
			}
		}
		
		System.out.println("Sua pontua��o final foi " + mecanicaDoJogo.pontuacaoFinal());
		

		in.close();
	}

}
