package testes;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import entities.BancoDePalavras;
import entities.EmbaralhadorAlternativo;
import entities.EmbaralhadorPadrao;
import interfaces.Embaralhador;

public class Teste {

	@Test
	public void testLerArquivo() {
		BancoDePalavras bdp = new BancoDePalavras(); 
		assertFalse("" == bdp.lerArquivo());
	
	}
	
	@Test
	public void testSorteiaPalavra() {
		BancoDePalavras bdp = new BancoDePalavras(); 
		assertFalse(null == bdp.sorteiaPalavra());
	}
	
	@Test
	public void testPermutacaoPadrão() {
		Embaralhador emb = new EmbaralhadorPadrao(); 
		assertEquals(7, emb.permutacao("ligeiro").length());
		
	}
	
	@Test
	public void testPermutacaoAlternativo() {
		Embaralhador emb = new EmbaralhadorAlternativo(); 
		assertEquals(7, emb.permutacao("ligeiro").length());
	}
	
	@Test
	public void testOrdemAlfabeticaPadrao() {
		Embaralhador emb = new EmbaralhadorPadrao(); 
		assertEquals("elnot", emb.ordemAlfabetica("lento"));
	}
	
	@Test
	public void testOrdemAlfabeticaAlternativo() {
		Embaralhador emb = new EmbaralhadorAlternativo(); 
		assertEquals("elnot", emb.ordemAlfabetica("lento"));
	}
	
	
	@Test
	public void testEmbaralhar() {
		Embaralhador emb = new EmbaralhadorPadrao();
		boolean existe = false; 
		boolean esperado = true; 
		char[] resultado = emb.permutacao("ligeiro").toCharArray();
		for (char c : "ligeiro".toCharArray()) {
			for (int i = 0; i < resultado.length; i++) {
				if (c == resultado[i]) {
					existe = true;
				}
			}
			if (existe == false) {
				esperado = false; 
				break;
			}
			existe = false; 
		}
		assertTrue(esperado);
		
		
	}
	
	@Test
	public void testEmbaralharAlternativo() {
		Embaralhador emb = new EmbaralhadorAlternativo();
		boolean existe = false; 
		boolean esperado = true; 
		char[] resultado = emb.permutacao("ligeiro").toCharArray();
		for (char c : "ligeiro".toCharArray()) {
			for (int i = 0; i < resultado.length; i++) {
				if (c == resultado[i]) {
					existe = true;
				}
			}
			if (existe == false) {
				esperado = false; 
				break;
			}
			existe = false; 
		}
		assertTrue(esperado);
		
		
	}
	
}

	
