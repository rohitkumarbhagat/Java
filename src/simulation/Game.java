package simulation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Game {

	public static final int field_length = 10;
	public static final int field_width = 10;

	public static final int noOfPlayers = 10;

	public static CountDownLatch latch = new CountDownLatch(noOfPlayers - 1);

	public static List<Player> players = new ArrayList<Player>(noOfPlayers);

	public static final Refree refree = new Refree();
	public static Lock synchronizationLock = new ReentrantLock();
	public static final int minSqrdDistance = 2;
	public static final int penaltyTimeInSec = 10;
	public static final int playerSpeed = 1;

	public static void main(String[] args) throws InterruptedException {

		Set<Position> uniquePositions = new HashSet<Position>();
		Position tempPosition;
		// Create Players
		for (int i = 0; i < noOfPlayers; i++) {
			while (true) {
				tempPosition = Position.generaterandomPosition();
				if (uniquePositions.add(tempPosition)) {
					// add position only when unique
					players.add(new Player("Player_" + i, tempPosition));
					break;
				}
			}

		}

		ExecutorService executor = Executors.newCachedThreadPool();
		for (Player player : players) {
			executor.execute(player);
		}

		// Start the game

		latch.await();
		executor.shutdownNow();

		System.out.println("Winner is : " + players.get(0));

	}

}
