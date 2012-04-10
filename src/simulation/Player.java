package simulation;

public class Player implements Runnable {

	private Position pos;
	private int state = 0;
	private String name;

	private int noOfYellowCards = 0;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNoOfYellowCards() {
		return noOfYellowCards;
	}

	public void setNoOfYellowCards(int noOfYellowCards) {
		this.noOfYellowCards = noOfYellowCards;
	}

	public Position getPos() {
		return pos;
	}

	public void setPos(Position pos) {
		this.pos = pos;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public Player(String name, Position position) {
		this.pos = position;
		this.name = name;
		System.out.println("Created Player  :  " + this);
	}

	public void blockPlayer() {
		noOfYellowCards++;
		System.out.println(name + " got Yellow card. Yellow Card Count = "
				+ noOfYellowCards);
		if (noOfYellowCards == 3) {
			state = 2;
		} else if (noOfYellowCards == 2) {
			// block people and updated blocked status
			state = 1;
		}
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		StringBuilder playerDetails = new StringBuilder();
		playerDetails
				.append("Player Name : ")
				.append(name)
				.append("  Position : ")
				.append(pos.toString())
				.append("  State : ")
				.append(state==0 ? "Active" : state==1 ? "Suspended" : state==2 ? "Left The Game"
						: "").append(" Yellow card count : ")
				.append(noOfYellowCards);
		return playerDetails.toString();
	}

	@Override
	public void run() {
		while (true) {
			Game.synchronizationLock.lock();

			// Move player
			System.out.print( name + " moved from old position : " + pos+ " to ");
			this.pos.update();
			System.out.println(" New position : " + pos);

			Game.refree.checkPlayersForfaults(this);

			Game.synchronizationLock.unlock();

			try {
				if (state == 0) {
					Thread.sleep(1000 / Game.playerSpeed);
				} else if (state == 1) {
					System.out.println(name + "  suspended for "
							+ Game.penaltyTimeInSec + " sec");
					Thread.sleep(Game.penaltyTimeInSec * 1000);
					// reinvoke after sleep
					state = 0;
				} else if (state == 2) {
					// End this thread and task;
					System.out.println(name + "  Left the Game.");
					break;
				}
			} catch (InterruptedException e) {
				// e.printStackTrace();
				break;
			}

		}
	}

}
