package simulation;

public class Refree {

	// returns number of player removed
	public void checkPlayersForfaults(Player player) {
		for (Player currentplayer : Game.players) {
			if (currentplayer != player && currentplayer.getState() == 0) {
				// if current player is a different player and not blocked
				// check distance
				if (player.getPos().getSqrdDistance(currentplayer.getPos()) <= Game.minSqrdDistance) {
					System.out.println(player.getName()+ " reached near "+currentplayer.getName());
					player.blockPlayer();
					if (player.getState() == 2) {
						//System.out.println("Removed Player : " + player +"  due to player : "+currentplayer);
						Game.players.remove(player);
						Game.latch.countDown();
					}
					break;
				}
			}

		}
	}
}
