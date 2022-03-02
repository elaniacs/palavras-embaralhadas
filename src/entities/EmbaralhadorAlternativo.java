package entities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import interfaces.Embaralhador;

public class EmbaralhadorAlternativo implements Embaralhador {
	
	public String inverterPalavra(String palavra) {
		String palavraInvertida = new StringBuilder(palavra).reverse().toString();
		return palavraInvertida;
	}

	public String permutacao(String palavra) {
		List<Character> characters = new ArrayList<Character>();
		for (char c : palavra.toCharArray()) {
			characters.add(c);
		}
		StringBuilder permutacao = new StringBuilder(palavra.length());
		while (characters.size() != 0) {
			int randPicker = (int) (Math.random() * characters.size());
			permutacao.append(characters.remove(randPicker));
		}
		return permutacao.toString();
	}

	public String ordemAlfabetica(String palavra) {
		char[] chars = palavra.toCharArray();

		Arrays.sort(chars);
		String sorted = new String(chars);
		return sorted; 
	}

	public String embaralhar(String palavra) {
		String embaralhado = palavra; 
		embaralhado = ordemAlfabetica(embaralhado);
		embaralhado = permutacao(embaralhado);
		embaralhado = inverterPalavra(embaralhado);
		return embaralhado; 	
	}

}
