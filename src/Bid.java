


public class Bid implements Comparable<Bid> {
	
	private User bidder;
	private double value;
	
	public Bid(User bidder, double value) {
		this.bidder = bidder;
		this.value = value;
	}
	
	protected User getBidder() {
		return bidder;
	}
	
	public double getValue() {
		return value;
	}

	@Override
	public int compareTo(Bid b) {
		return (int) (value - b.value);
	}

}
