

import java.util.Date;


public class Auction {

	private static int numInstances = 0;
	
	private Item item;
	private User seller;
	private Date endDate;
	private AuctionState state;
	
	private double minPrice;
	private double reservePrice;
	private Bid highestBid;

	private int id;
	
	/*
	 * Auction instances can be created at will but that doesn't mean that they are
	 * correct. You can effectively create two Auction instances referencing the same
	 * Item instance. Such coherence verifications are performed in the
	 * AuctionRoom class.
	 */
	public Auction(Item item, User seller, Date endDate, double minPrice, double reservePrice) {
		this.item = item;
		this.seller = seller;
		this.endDate = endDate;
		this.state = AuctionState.CREATED;
		
		this.minPrice = minPrice;
		this.reservePrice = reservePrice;
		this.highestBid = null;
		
		this.id = Auction.numInstances;
		++Auction.numInstances;
	}
	
	public int hashCode() {
		return id;
	}
	
	public Item getItem() {
		return item;
	}
	
	public User getSeller() {
		return seller;
	}

	public Date getEndDate() {
		return endDate;
	}

	public AuctionState getState() {
		return state;
	}
	
	protected void setState(AuctionState state) {
		this.state = state;
	}

	public double getMinPrice() {
		return minPrice;
	}

	protected double getReservePrice() {
		return reservePrice;
	}
	
	public double userGetReservePrice(User user) throws UnauthorizedUserAccessException {
		if (user.equals(seller)) {
			return getReservePrice();
		} else {
			throw new UnauthorizedUserAccessException();
		}
	}
	
	public boolean highestBidOverReservePrice() {
		return highestBid.getValue() >= reservePrice;
	}
	
	public boolean highestBidOverMinPrice() {
		return highestBid.getValue() >= minPrice;
	}
	
	public Bid getHighestBid() {
		return highestBid;
	}
	
	protected void setHighestBid(Bid b) {
		this.highestBid = b;
	}
	
}
