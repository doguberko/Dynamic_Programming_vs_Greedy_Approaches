
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class Test {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception {

		Player[] inputpls = new Player[3000];/////
		String str;
		String[] properties = new String[4];
		Scanner sc = new Scanner(System.in);
		int x, n, k, counter = -1;
		Approaches app = new Approaches();

		File file = new File("C:\\Users\\Monster\\Desktop\\input2.txt");/////
		BufferedReader br = new BufferedReader(new FileReader(file));

		while ((str = br.readLine()) != null) {
			counter++;
			properties = str.split("	");

			Player player = new Player(properties[0], Integer.parseInt(properties[1]), Integer.parseInt(properties[2]),
					Integer.parseInt(properties[3]));

			inputpls[counter] = player;
		}

		// app.listPlayers(inputpls);

		System.out.print("\n Enter the amount to spend (X): ");
		x = sc.nextInt();
		System.out.print(" Enter the number of the positions (N): ");
		n = sc.nextInt();
		System.out.print(" Enter the number of the available inputplayers for each position (K): ");
		k = sc.nextInt();
		System.out.println();

		Player[] marketpls = new Player[n * k];
		counter = -1;

		for (int i = 0; i < n; i++) {

			for (int j = 0; j < k; j++) {
				counter++;
				marketpls[counter] = inputpls[i * 150 + j];/////
			}
		}
		
		System.out.print("\n***PLAYERS IN MARKET");
		app.listPlayers(marketpls);
		app.greedy(marketpls, x, n, k);

	}
}
