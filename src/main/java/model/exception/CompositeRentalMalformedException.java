package model.exception;

public class CompositeRentalMalformedException extends Exception {

	private static final long serialVersionUID = 5007162923296589429L;

	public CompositeRentalMalformedException(){
		super("Family Rental must have between 3 and 5 rental compositions");
	}
}
