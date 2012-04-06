package simulation;

import java.util.Random;

public class Position {
	private int x;
	private int y;
	private static Random randomgenerator = new Random();

	public Position(int x, int y) {
		this.x = x;
		this.y = y;

	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public static Position generaterandomPosition() {
		return new Position(randomgenerator.nextInt(Game.field_length),
				randomgenerator.nextInt(Game.field_width));

	}

	@Override
	public boolean equals(Object obj) {
		if (obj != null) {
			Position pos = (Position) obj;
			if (pos.x == this.x && pos.y == pos.y) {
				return true;
			}
		}
		return false;
	}

	public int getSqrdDistance(Position p) {
		int xDiff = this.x - p.x;
		int yDiff = this.y - p.y;
		return xDiff * xDiff + yDiff * yDiff;
	}

	public void update() {
		int new_direction = randomgenerator.nextInt(4);
		// loop till new correct direction is not achieved
		while (validate(new_direction) == false) {
			new_direction = randomgenerator.nextInt(4);
		}

	}

	private boolean validate(int direction) {
		boolean isValidPosition = false;
		int oldX = this.x;
		int oldY = this.y;
		switch (direction) {
		case 0:
			// move north
			y = y + 1 >= Game.field_width ? y : y + 1;
			break;
		case 1:
			// move east
			x = x + 1 >= Game.field_length ? x : x + 1;
			break;
		case 2:
			// move south
			y = y - 1 < 0 ? y : y - 1;
			break;
		case 3:
			// move west
			x = x - 1 < 0 ? x : x - 1;

		}

		if ((Math.abs(oldX - x) + Math.abs(oldY - y)) > 0) {
			isValidPosition = true;
		}
		return isValidPosition;

	}

	@Override
	public int hashCode() {
		return x * 7 + y * 49 + 17;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "( " + x + ", " + y + " )";
	}
}
