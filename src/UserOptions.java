
public class UserOptions {
	
	private boolean notifyReservePriceReached;
	private boolean notifyCancelledAuction;
	private boolean notifyUserBidSurpassed;
	
	public UserOptions() {
		this.notifyReservePriceReached = true;
		this.notifyCancelledAuction = true;
		this.notifyUserBidSurpassed = true;
	}
	
	// not used
	public UserOptions(boolean notifyReservePriceReached, boolean notifyCancelledAuction, boolean notifyUserBidSurpassed) {
		this.notifyReservePriceReached = notifyReservePriceReached;
		this.notifyCancelledAuction = notifyCancelledAuction;
		this.notifyUserBidSurpassed = notifyUserBidSurpassed;
	}
	
	public boolean isNotifyReservePriceReached() {
		return notifyReservePriceReached;
	}
	public void setNotifyReservePriceReached(boolean notifyReservePriceReached) {
		this.notifyReservePriceReached = notifyReservePriceReached;
	}
	public boolean isNotifyCancelledAuction() {
		return notifyCancelledAuction;
	}
	public void setNotifyCancelledAuction(boolean notifyCancelledAuction) {
		this.notifyCancelledAuction = notifyCancelledAuction;
	}
	public boolean isNotifyUserBidSurpassed() {
		return notifyUserBidSurpassed;
	}
	public void setNotifyUserBidSurpassed(boolean notifyUserBidSurpassed) {
		this.notifyUserBidSurpassed = notifyUserBidSurpassed;
	}

}
