


public class Item {

	private String description;
	
	public Item(String description) {
		this.description = description;
	}
	
	public int getId() {
		return this.hashCode();
	}
	
	public String getDescription() {
		return description;
	}
	
}
