

import java.util.*;


public class AuctionManager {

	private static AuctionsContainer auctionsContainer;
	
	public AuctionManager() {
		auctionsContainer = new AuctionsContainer();
	}
	
	public static void bid(Auction au, Bid b) throws InvalidBidException {
		if (validBid(au, b)) {
			au.setHighestBid(b);
		} else {
			throw new InvalidBidException();
		}
	}

	public static void publishAuction(Auction au) throws ForbiddenAuctionOperationException {
		if (validAuctionPublication(au)) {
			auctionsContainer.add(au);
			au.setState(AuctionState.PUBLISHED);
		} else {
			throw new ForbiddenAuctionOperationException();
		}
	}
	
	public static void cancelAuction(Auction au) throws ForbiddenAuctionOperationException {
		if (auctionsContainer.hasAuction(au)
				&& au.getState().equals(AuctionState.PUBLISHED)
				&& !au.highestBidOverReservePrice()) {
			au.setState(AuctionState.CANCELLED);
		} else {
			throw new ForbiddenAuctionOperationException();
		}
	}
	
	/* 
	 * NOT MEANT TO BE USED
	 * The server is supposed to run an event loop that takes care of the auctions coming to an end
	 */
	public static void refreshAllAuctions() {
		Date now = new Date();
		Auction au;
		for (Iterator<Auction> it = auctionsContainer.getIterator(); it.hasNext();) {
			au = it.next();
			if (au.getState().equals(AuctionState.PUBLISHED)
					&& au.highestBidOverMinPrice()
					&& now.after(au.getEndDate())) {
				au.setState(AuctionState.COMPLETED);
			}
		}
	}
	
	private static boolean validBid(Auction au, Bid b) {
		return auctionsContainer.hasAuction(au)
				&& au.getState().equals(AuctionState.PUBLISHED)
				&& !au.getSeller().equals(b.getBidder())
				&& b.getValue() > au.getHighestBid().getValue();
	}
	
	private static boolean validAuctionPublication(Auction au) {
		return au.getMinPrice() >= 0
				&& au.getReservePrice() >= au.getMinPrice()
				&& au.getEndDate().after(new Date())
				&& au.getState().equals(AuctionState.CREATED)
				&& !auctionsContainer.hasItem(au.getItem());
	}
	
}
