
public class Approaches {

	public void greedy(Player[] marketpls, int x, int n, int k) {
		Player tempp;
		Player[] ppls = new Player[n];

		for (int i = 0; i < marketpls.length; i++) {
			for (int j = 0; j < marketpls.length; j++) {
				if (i < j) {
					if (marketpls[i].getRating() < marketpls[j].getRating()) {
						tempp = marketpls[i];
						marketpls[i] = marketpls[j];
						marketpls[j] = tempp;
					} else if (marketpls[i].getRating() == marketpls[j].getRating()
							&& marketpls[i].getPrice() > marketpls[j].getPrice()) {
						tempp = marketpls[i];
						marketpls[i] = marketpls[j];
						marketpls[j] = tempp;
					}
				} else if (j < i) {
					if (marketpls[j].getRating() < marketpls[i].getRating()) {
						tempp = marketpls[j];
						marketpls[j] = marketpls[i];
						marketpls[i] = tempp;
					} else if (marketpls[i].getRating() == marketpls[j].getRating()
							&& marketpls[i].getPrice() < marketpls[j].getPrice()) {
						tempp = marketpls[j];
						marketpls[j] = marketpls[i];
						marketpls[i] = tempp;
					}
				}
			}
		}

		System.out.print("\n\n***CONCATENATED PLAYERS TEMPER TO RATING");
		listPlayers(marketpls);

		int count = -1;		
		for (int i = 0; i < marketpls.length; i++) {
			if (marketpls[i] != null) {
				if (marketpls[i].getPrice() <= x) {
					count++;
					ppls[count] = marketpls[i];
					x -= marketpls[i].getPrice();
					deletePosition(marketpls, marketpls[i].getPosition());/////

				} else if (marketpls[i].getPrice() > x) {
					marketpls[i] = null;
				}
			}
		}
		
		System.out.print("\n\n***PURCHASED PLAYERS");
		listPlayers(ppls);

	}

	public void deletePosition(Player[] pls, int position) {
		for (int i = 0; i < pls.length; i++) {
			if (pls[i] != null && pls[i].getPosition() == position) {
				pls[i] = null;
			}
		}
	}

	public void listPlayers(Player[] pls) {
		int totalrating = 0, totalcost = 0;

		for (int i = 0; i < pls.length; i++) {
			if (pls[i] != null) {
				totalrating += pls[i].getRating();
				totalcost += pls[i].getPrice();

				System.out.print("\n " + (i + 1) + " [" + pls[i].getName() + "] - Position(" + pls[i].getPosition()
						+ ") - Rating(" + pls[i].getRating() + ") - Price(" + pls[i].getPrice() + ")");
			}

		}

		System.out.println("\n---TOTAL RATING(" + totalrating + ") - TOTAL COST(" + totalcost + ")---------");
	}
}
