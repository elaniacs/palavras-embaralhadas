package interfaces;

public interface MecanicaDoJogo {
	
	public boolean jogoDeveAcabar();
	public boolean acertouPalavra(String palavraLista, String PalavraUsuario);
	public boolean tentarDeNovo();
	public String pontuacaoFinal();

}
