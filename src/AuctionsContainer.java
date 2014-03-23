

import java.util.*;


public class AuctionsContainer {

	private static Collection<Auction> auctions;
	
	public AuctionsContainer() {
		auctions = new HashSet<Auction>();
	}
	
	public boolean hasAuction(Auction au) {
		return auctions.contains(au);
	}
	
	public boolean hasItem(Item item) {
		Iterator<Auction> it = auctions.iterator();
		Auction au;
		while (it.hasNext()) {
			au = it.next();
			if (au.getItem().equals(item)) return true;
		}
		return false;
	}
	
	public void add(Auction au) {
		auctions.add(au);
	}
	
	// not used, everything stays in memory, nothing is persisted
	public void remove(Auction au) {
		auctions.remove(au);
	}
	
	public Iterator<Auction> getIterator() {
		return auctions.iterator();
	}
	
}
