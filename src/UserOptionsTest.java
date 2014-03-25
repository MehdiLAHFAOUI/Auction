
import static org.junit.Assert.*;

import org.junit.Test;


public class UserOptionsTest {

	@Test
	public final void testUserOptions() {
		UserOptions uo = new UserOptions();
		assertTrue(uo.isNotifyCancelledAuction());
		assertTrue(uo.isNotifyReservePriceReached());
		assertTrue(uo.isNotifyUserBidSurpassed());
	}

	@Test
	public final void testUserOptionsBooleanBooleanBoolean() {
		UserOptions uo = new UserOptions(false,false,false);
		assertFalse(uo.isNotifyCancelledAuction());
		assertFalse(uo.isNotifyReservePriceReached());
		assertFalse(uo.isNotifyUserBidSurpassed());
	}

	
	@Test
	public final void testSetNotifyReservePriceReached() {
		boolean test = false;
		UserOptions uo = new UserOptions();
		uo.setNotifyReservePriceReached(test);
		assertEquals(test,uo.isNotifyReservePriceReached());
	}

	
	@Test
	public final void testSetNotifyCancelledAuction() {
		boolean test = false;
		UserOptions uo = new UserOptions();
		uo.setNotifyCancelledAuction(test);
		assertEquals(test,uo.isNotifyCancelledAuction());
	}

	
	@Test
	public final void testSetNotifyUserBidSurpassed() {
		boolean test = false;
		UserOptions uo = new UserOptions();
		uo.setNotifyUserBidSurpassed(test);
		assertEquals(test,uo.isNotifyUserBidSurpassed());
	}

}
