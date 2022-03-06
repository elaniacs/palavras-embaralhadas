package entities;

import interfaces.MecanicaDoJogo;

public class MecanicaAlternativa implements MecanicaDoJogo {
	
	int qtdeDeAcertos = 0; 
	int numeroDeErros = 0; 
	double pontuacaoFinal = 0; 


	@Override
	public boolean jogoDeveAcabar() {
		if (qtdeDeAcertos == 21) {
			return true; 
		}
		return false;
	}

	@Override
	public boolean acertouPalavra(String palavraLista, String PalavraUsuario) {
		double totalParcial = 7; 
		boolean acertou = palavraLista.equals(PalavraUsuario); 
		if (acertou) {
			numeroDeErros = 0;
			pontuacaoFinal = pontuacaoFinal + totalParcial; 
		}
		else {
			numeroDeErros++;
		}
		
		return acertou; 
	}

	@Override
	public boolean tentarDeNovo() {
		return true;
	}

	@Override
	public String pontuacaoFinal() {
		return String.valueOf(pontuacaoFinal); 
	}

	
}
