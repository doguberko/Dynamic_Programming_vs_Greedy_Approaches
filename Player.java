
public class Player {

	String name;
	int position, rating, price;

	public Player(String name, int position, int rating, int price) {
		super();
		this.setName(name);
		this.setPosition(position);
		this.setRating(rating);
		this.setPrice(price);

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}
