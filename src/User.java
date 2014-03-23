

import java.util.Date;


public class User {
	
	private String login;
	private String lastName;
	private String firstName;
	
	private UserOptions notificationsOptions;
	
	public User(String login, String firstName, String lastName) {
		this.login = login;
		this.lastName = lastName;
		this.firstName = firstName;
		
		// All notification options set to true (notify) by default
		notificationsOptions = new UserOptions();
	}
	
	public int hashCode() {
		return login.hashCode();
	}
	
	public String getLogin() {
		return login;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public UserOptions getOptions() {
		return notificationsOptions;
	}
	
	public void bid(Auction auction, double value) {
		Bid b = new Bid(this, value);
		try {
			AuctionManager.bid(auction, b);
		} catch (InvalidBidException e) {
			// TODO notify the end-user over the web
			System.out.println(e.getMessage());
		}
	}
	
	public Auction makeAuction(Item item, Date endDate, double minPrice, double reservePrice) {
		return new Auction(item, this, endDate, minPrice, reservePrice);
	}
	
	public void publishAuction(Auction au) {
		try {
			AuctionManager.publishAuction(au);
		} catch (ForbiddenAuctionOperationException e) {
			// TODO notify the end-user over the web
			System.out.println(e.getMessage());
		}
	}
	
	public void cancelAuction(Auction au) {
		try {
			AuctionManager.cancelAuction(au);
		} catch (ForbiddenAuctionOperationException e) {
			// TODO notify the end-user over the web
			System.out.println(e.getMessage());
		}
	}

}
