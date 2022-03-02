package entities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BancoDePalavras {
	
	List<String> listaDePalavras = new ArrayList<String>(); 

	public BancoDePalavras() {
		String todasAsPalavras = lerArquivo(); 
		listaDePalavras = new ArrayList<String>(Arrays.asList(todasAsPalavras.split(", ")));
	}

	public String lerArquivo() {

		FileReader fr = null; 
		BufferedReader br = null; 
		
		try {
			fr = new FileReader("C:\\Users\\caren\\Documents\\Dev\\Java\\ws-eclipse\\ITA\\jogo-das-palavras-embaralhadas\\jogo-palavras-embaralhadas.txt");
			br = new BufferedReader(fr);
			
			String line = br.readLine(); 
			return line;
		}
		catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		finally {
			try {
				if (br != null) {
					br.close();
				}
				if (fr != null) {
					fr.close();
				}
			}
			catch (IOException e) {
				e.printStackTrace();
			}
		}
		return "";
	}
	
	public String sorteiaPalavra() {
		int randPicker = (int) (Math.random() * listaDePalavras.size());
		String palavra = listaDePalavras.remove(randPicker);
		return palavra; 
	}
}

