package exceptions;

public class PropagationExeption extends Exception{

	/*
	 * Attributs
	 */
	private static final long serialVersionUID = 821318648434205285L;
	private Exception exception;
	
	
	/*
	 * Constructeur
	 */
	public PropagationExeption() {
		super();
	}
	
	public PropagationExeption(Exception exception) {
		super();
		this.exception = exception;
	}


	@Override
	public String toString() {
		return "PropagationExeption [exception=" 
				+ exception 
				+ "]";
	}
	
	public Exception getException() {
		return this.exception;
	}
}
