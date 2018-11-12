package meta.modele.block;

import exceptions.PropagationExeption;
import meta.modele.programme.Programme;
import visiteur.Visiteur;

public class Block extends Programme {
	/*
	 * Attributs
	 */
	private String idBlock;
	
	/*
	 * Constructeurs
	 */
	public Block() {
		super();
	}
	
	/*
	 * Methodes
	 */
	
	@Override
	public void accept(Visiteur visiteur) throws PropagationExeption {
		visiteur.visite(this);
	}

	/*
	 * Accesseurs
	 */
	public String getIdBlock() {
		return idBlock;
	}

	public void setIdBlock(String idBlock) {
		this.idBlock = idBlock;
	}
}
