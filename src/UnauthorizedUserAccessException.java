
public class UnauthorizedUserAccessException extends Exception {

	private static final long serialVersionUID = -4996172882198022417L;
	
	public UnauthorizedUserAccessException() {
		super("User does not qualify to access data");
	}
	
}