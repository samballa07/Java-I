package fighters;

import framework.BattleField;
import framework.Random131;


public class BasicSoldier {
	public final static int INITIAL_HEALTH = 10; 
	public final static int ARMOR = 20;   
	public final static int STRENGTH = 30; 
	public final static int SKILL = 40;
	
	public final static int UP = 0;
	public final static int RIGHT = 1;
	public final static int DOWN = 2;
	public final static int LEFT = 3;
	public final static int UP_AND_RIGHT = 4;
	public final static int DOWN_AND_RIGHT = 5;
	public final static int DOWN_AND_LEFT = 6;
	public final static int UP_AND_LEFT = 7;
	public final static int NEUTRAL = -1;
	
	public final BattleField grid;
	public int row, col;
	public int health;
	public final int team;
	
	public BasicSoldier(BattleField gridIn, int teamIn, int rowIn, int colIn) {
		grid = gridIn;
		team = teamIn;
		row = rowIn;
		col = colIn;
		health = INITIAL_HEALTH;
	}
	
	public boolean canMove() {
		boolean canMove = false;
		int upMove = grid.get(row - 1, col);
		int downMove = grid.get(row + 1, col);
		int rightMove = grid.get(row, col + 1);
		int leftMove = grid.get(row, col - 1);
		
		if (upMove == BattleField.EMPTY || downMove == BattleField.EMPTY ||
			rightMove == BattleField.EMPTY || leftMove == BattleField.EMPTY) {
			canMove = true;
		}
		return canMove;
	}	 
	
	public int numberOfEnemiesRemaining() {
		int numRows = grid.getRows();
		int numCols = grid.getCols();
		int numEnemies = 0;
		int enemyTeam;
		
		if (team == BattleField.BLUE_TEAM) { 
			enemyTeam = BattleField.RED_TEAM;
		} else { 
			enemyTeam = BattleField.BLUE_TEAM;
		}
		
		for (int row = 0; row < numRows; row++) {
			for (int col = 0; col < numCols; col++) {
				if (grid.get(row, col) == enemyTeam) {
					numEnemies++;
				}
			}
		}
		return numEnemies;
		
	}
	public int getDistance(int destinationRow, int destinationCol) {
		int tempRow = row;
		int tempCol = col;
		int moves = 0;
		while(tempRow != destinationRow || tempCol != destinationCol) {
			if (destinationRow > tempRow) {
				tempRow++;
				moves++;
			} else if (destinationRow < tempRow){
				tempRow--;
				moves++;
			}
			if (destinationCol > tempCol) {
				tempCol++;
				moves++;
			} else if (destinationCol < tempCol) {
				tempCol--;
				moves++;
			}
		}
		return moves;
	}
	public int getDirection(int destinationRow, int destinationCol) {
		int exit = -2;
		
		if (destinationRow > row && destinationCol == col) {
			return DOWN;
		} else if (destinationRow < row && destinationCol == col) {
			return UP;
		} else if (destinationRow == row && destinationCol > col) {
			return RIGHT;
		} else if (destinationRow == row && destinationCol < col) {
			return LEFT;
		} else if(destinationRow < row && destinationCol > col) {
			return UP_AND_RIGHT;
		} else if (destinationRow > row && destinationCol > col) {
			return DOWN_AND_RIGHT;
		} else if (destinationRow > row && destinationCol < col) {
			return DOWN_AND_LEFT;
		} else if (destinationRow < row && destinationCol < col) {
			return UP_AND_LEFT;
		} else if (destinationRow == row && destinationCol == col) {
			return NEUTRAL;
		}
		return exit;
	}
	public int getDirectionOfNearestFriend() {
		int numRows = grid.getRows();
		int numCols = grid.getCols();
		int minDistance = 1000;
		int countFriends = 0;
		int direction = -2;
		
		for (int currRow = 0; currRow < numRows; currRow++) {
			for (int currCol = 0; currCol < numCols; currCol++) {
				if (getDistance(currRow, currCol) == 0) {
					continue;
				} else if (grid.get(currRow, currCol) == team) {
					int tempDistance = getDistance(currRow, currCol);
					countFriends++;
					if (tempDistance < minDistance) {
					direction = getDirection(currRow, currCol);
					minDistance = tempDistance;
					} 
				}
			}
		}
		if (countFriends == 0) {
			return NEUTRAL;
		}
		return direction;
	}
	
	public int countNearbyFriends(int radius) {
		int numRows = grid.getRows();
		int numCols = grid.getCols();
		int countFriends = 0;
		int moves;
		
		for (int row = 0; row < numRows; row++) {
			for (int col = 0; col < numCols; col++) {
				moves = getDistance(row, col);
				if (moves <= radius && grid.get(row, col) == team) {
					countFriends++;
				}
			}
		}
		return countFriends - 1;
	}
	
	public int getDirectionOfNearestEnemy(int radius) {
		int enemyTeam;
		if (team == BattleField.BLUE_TEAM) { 
			enemyTeam = BattleField.RED_TEAM;
		} else { 
			enemyTeam = BattleField.BLUE_TEAM;
		}
		int numRows = grid.getRows();
		int numCols = grid.getCols();
		int minMoves = 1000;
		int direction = -2;
		int enemyCount = 0;
		
		for (int row = 0; row < numRows; row++) {
			for (int col = 0; col < numCols; col++) {
				int tempMoves = getDistance(row, col);
				if (tempMoves <= radius && grid.get(row, col) == enemyTeam) {
					enemyCount++;
					if (tempMoves < minMoves) {
						minMoves = tempMoves;
						direction = getDirection(row, col);
					}
				}
			}
		}
		if (enemyCount == 0) {
			return NEUTRAL;
		}
		return direction;
	}
	
	public void performMyTurn() {
		int direction = getDirectionOfNearestEnemy(1);
		
		if (direction != NEUTRAL) {
			if (direction == UP){
				grid.attack(row - 1, col);
			} else if (direction == DOWN) {
				grid.attack(row + 1, col);
			} else if (direction == RIGHT) {
				grid.attack(row, col + 1);
			} else if (direction == LEFT) {
				grid.attack(row, col - 1);
			}	
		} else if (canMove() == true) {
			if (grid.get(row - 1, col) == BattleField.EMPTY) {
				row--;
			} else if(grid.get(row + 1, col) == BattleField.EMPTY) {
				row++;
			} else if (grid.get(row, col + 1) == BattleField.EMPTY) {
				col++;
			} else if (grid.get(row, col - 1) == BattleField.EMPTY) {
				col--;
			}
		}
	}
}
