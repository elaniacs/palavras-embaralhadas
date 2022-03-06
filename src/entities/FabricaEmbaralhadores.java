package entities;

import interfaces.Embaralhador;

public class FabricaEmbaralhadores {
	
	public EmbaralhadorPadrao criarEmbaralhadorPadrao() {
		EmbaralhadorPadrao ep = new EmbaralhadorPadrao(); 
		return ep;
	}

	public EmbaralhadorAlternativo criarEmbaralhadorAlternativo() {
		EmbaralhadorAlternativo ep = new EmbaralhadorAlternativo(); 
		return ep;
	}
	
	public Embaralhador getEmbaralhadorAleatorio()
	{
		int random = (int) (Math.random()*2);
		if (random == 0) {
			return  criarEmbaralhadorPadrao();
		} 
		else {
				return criarEmbaralhadorAlternativo();
			}
			
	}
	

}


