package visiteur;

import exceptions.PropagationExeption;

/**
 * Interface qui permet à une classe d'etre visitable par un visiteur
 * 
 * @author Robin LOUARN
 *
 */
public interface Visitable {

	/**
	 * Methode qui permet d'appliquer un visiteur à une expression
	 * 
	 * @param visiteur Visiteur appliqer à l'expression
	 */
	public void accept(Visiteur visiteur) throws PropagationExeption;
}
