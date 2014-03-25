
import java.util.Date;

import junit.framework.TestCase;

import org.junit.Test;

public class UserTest extends TestCase {
	
	@Test
	public final void testHashCode() {
		String login="test";
		User u = new User("test","","");
		assertTrue(login.hashCode()==u.hashCode());
	}

	@Test
	public final void testEndDate(){
		User u = new User("login1","firstname1","lastname1");
		Item i = new Item("desc") ;
		@SuppressWarnings("deprecation")
		Date d = new Date(90,02,15);
		double minp = 10;
		double reservep = 50;
		try {Auction a = new Auction(i,u,d,minp,reservep);
		u.publishAuction(a);}catch(Exception e){System.out.println("Invalid dates"+e);}
	}
	
	
@Test
	public final void testGetLogin() {
		String login = "test";
		User u = new User(login,"","");
		assertEquals(login,u.getLogin());
	}
	
	public final void testGetLastName() {
		 String lastname = "test";
		User u = new User("","",lastname);
		assertEquals(lastname,u.getLastName());
	}
	
	public final void testGetFirstName() {
		 String firstname = "test";	
		User u = new User("",firstname,"");
		assertEquals(firstname,u.getFirstName());
	}
	
	public final void testGetOptions() {
		UserOptions uo = new UserOptions();
		User u = new User("","","");
		assertEquals(uo,u.getOptions());
	}
	
	@Test
	public final void testBid() throws InvalidBidException {
		User u1 = new User("login1","firstname1","lastname1");
		User u2 = new User("login2","firstname2","lastname2");
		Item i = new Item("desc") ;
		Date d = new Date();
		double minp = 10;
		double reservep = 50;
		try{Auction a = new Auction(i,u1,d,minp,reservep);
		u2.bid(a,15);}catch(Exception e){System.out.println("Auction not available"+e);}
	}

	@Test
	public final void testMakeAuction() throws InvalidBidException{
		User u = new User("login","firstname","lastname");
		Item i = new Item("desc") ;
		Date d = new Date();
		double minp = 10;
		double reservep = 50;
		try{Auction a = new Auction(i,u,d,minp,reservep);
		u.publishAuction(a);
		u.bid(a,15);}catch(Exception e){System.out.println("User can't make a bid on his own auction"+e);}
	}

	@Test
	public final void testMinPrice() {
		User u1 = new User("login1","firstname1","lastname1");
		User u2 = new User("login2","firstname2","lastname2");
		Item i = new Item("desc") ;
		Date d = new Date();
		double minp = 10;
		double reservep = 50;
		try{Auction a = new Auction(i,u1,d,minp,reservep);
		u1.publishAuction(a);
		u2.bid(a,5);}catch(Exception e){System.out.println("too low price"+e);}
	}
	

	@Test
	public final void testCancelAuction() {
		User u1 = new User("login1","firstname1","lastname1");
		User u2 = new User("login2","firstname2","lastname2");
		Item i = new Item("desc") ;
		Date d = new Date();
		double minp = 10;
		double reservep = 50;
		try{Auction a = new Auction(i,u1,d,minp,reservep);
		u1.publishAuction(a);
		u2.bid(a,55);
		u1.cancelAuction(a);
		}catch(Exception e){System.out.println("Auction can't be Canceled"+e);}
	}

	
	
	@Test
	public final void testGetId() {
		String desc="test";
		Item i = new Item(desc);
		assertTrue(desc.hashCode()==i.hashCode());
	}

	@Test
	public final void testGetDescription() {
		String desc = "test";
		Item i = new Item(desc);
		assertEquals(desc,i.getDescription());
	}
	
	@Test
	public final void testGetItem() {
		String desc = "test";
		Item i = new Item(desc);
		User u = new User("","","");
		Date d = new Date();
		double minp = 5;
		double resp = 10;
		Auction a = new Auction(i,u,d,minp,resp);
		assertEquals(desc,a.getItem());
	}

	@Test
	public final void testGetSeller() {
		String desc = "test";
		Item i = new Item(desc);
		User u = new User("test","test","test");
		Date d = new Date();
		double minp = 5;
		double resp = 10;
		Auction a = new Auction(i,u,d,minp,resp);
		assertEquals(u,a.getSeller());
	}

	@Test
	public final void testGetEndDate() {
		String desc = "test";
		Item i = new Item(desc);
		User u = new User("test","test","test");
		Date d = new Date(10/02/2001);
		double minp = 5;
		double resp = 10;
		Auction a = new Auction(i,u,d,minp,resp);
		assertEquals(d,a.getEndDate());
	}

	@Test
	public final void testGetMinPrice() {
		String desc = "test";
		Item i = new Item(desc);
		User u = new User("test","test","test");
		Date d = new Date();
		double minp = 5;
		double resp = 10;
		Auction a = new Auction(i,u,d,minp,resp);
		assertTrue(minp == a.getMinPrice());
	}

	@Test
	public final void testGetReservePrice() {
		String desc = "test";
		Item i = new Item(desc);
		User u = new User("test","test","test");
		Date d = new Date();
		double minp = 5;
		double resp = 10;
		Auction a = new Auction(i,u,d,minp,resp);
		assertTrue(resp == a.getReservePrice());
	}
}
