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
		System.out.println("Neste jogo você receberá uma lista de palavras embaralhadas(uma por vez)");
		System.out.println("Organize as letras para descobrir a palavra correta. ");	
		System.out.println();
		System.out.println("Escolha o nível do jogo");
		System.out.println("1 - fácil - tentativas ilimitadas por palavra, deve acertar todas as palavras e cada acerto vale 7 pontos");
		System.out.println("2 - difícil - até 3 tentativas por palavra, deve acertar a maioria(metade + 1) das palavras e cada acerto vale 15 pontos");
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
			
			System.out.println("Opção inválida");
		}
		
		BancoDePalavras bdp = new BancoDePalavras();
		FabricaEmbaralhadores fabricaEmbaralhadores = new FabricaEmbaralhadores(); 
		Embaralhador embaralhador = fabricaEmbaralhadores.getEmbaralhadorAleatorio();
		
		while (!(mecanicaDoJogo.jogoDeveAcabar())) {
			System.out.println("Sorteamos uma nova palavra para você. ");
			System.out.println();
			String palavra = bdp.sorteiaPalavra(); 		
			System.out.println(embaralhador.embaralhar(palavra));
			System.out.print("Digite a palavra correta? ");
			String palavraUsuario = in.next(); 
			boolean tentarNovamente = true; 
			while (tentarNovamente) {
				if (mecanicaDoJogo.acertouPalavra(palavra, palavraUsuario)) {
					tentarNovamente = false; 
					System.out.println("Parabéns, você acertou!");
					System.out.println("Sua pontuação final foi " + mecanicaDoJogo.pontuacaoFinal());
				}
				else {
					System.out.println("Que pena, você errou");
					System.out.print("Tente novamente: ");
					palavraUsuario = in.next(); 
					tentarNovamente = mecanicaDoJogo.tentarDeNovo(); 
				}
			}
		}
		
		System.out.println("Sua pontuação final foi " + mecanicaDoJogo.pontuacaoFinal());
		

		in.close();
	}

}
