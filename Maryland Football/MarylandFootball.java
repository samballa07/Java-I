import java.util.Scanner;

public class MarylandFootball {

	public static void main(String[] args) {
		
		final int MCFARLAND_NUM = 5;
		final int JACKSON_NUM = 17;
		final int BROOKS_NUM = 25;
		final int ELLIS_NUM = 7;
		
		final String MCFARLAND_NAME = "McFarland";
		final String JACKSON_NAME = "Jackson";
		final String BROOKS_NAME = "Brooks";
		final String ELLIS_NAME = "Ellis";
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("Type 1 to enter a number or 2 to enter a name: ");
		int userChoice = input.nextInt();
		
		if (userChoice == 1) {
			System.out.print("Enter player number: ");
			int jerseyNum = input.nextInt();
			
			if (jerseyNum == JACKSON_NUM) {
				System.out.print("Which player wears number " + 
								 jerseyNum + " on his jersey? ");
				String userPlayer = input.nextLine();
				userPlayer = input.nextLine();
				
				if (userPlayer.equals(JACKSON_NAME)) {
					System.out.println("Correct!");
				}else {
					System.out.print("Incorrect!");
				}
				
			} else if (jerseyNum == BROOKS_NUM) {
				System.out.print("Which player wears number " + jerseyNum 
								 + " on his jersey? ");
				String userPlayer = input.nextLine();
				userPlayer = input.nextLine();
				
				if (userPlayer.equals(BROOKS_NAME)) {
					System.out.println("Correct!");
				}else {
					System.out.print("Incorrect!");
				}
				
			} else if (jerseyNum == MCFARLAND_NUM) {
				System.out.print("Which player wears number " + jerseyNum + 
									" on his jersey? ");
				String userPlayer = input.nextLine();
				userPlayer = input.nextLine();
				
				if (userPlayer.equals(MCFARLAND_NAME)) {
					System.out.println("Correct!");
				}else {
					System.out.print("Incorrect!");
				}
				
			} else if (jerseyNum == ELLIS_NUM) {
				System.out.print("Which player wears number " + jerseyNum + 
									" on his jersey? ");
				String userPlayer = input.nextLine();
				userPlayer = input.nextLine();
				
				if (userPlayer.equals(ELLIS_NAME)) {
					System.out.println("Correct!");
				}else {
					System.out.print("Incorrect!");
				}
			} else {
				System.out.print("Invalid Choice.");
			}
			
		} else if (userChoice == 2) {
			System.out.print("Choose a name: ");
			String playerName = input.next();
			
			if (playerName.equals(JACKSON_NAME)) {
				System.out.print("What number does " + playerName 
									+ " wear? ");
				int userNum = input.nextInt();
				
				if (userNum == JACKSON_NUM) {
					System.out.print("Correct!");
				} else {
					System.out.print("Incorrect!");
				}
				
			} else if (playerName.equals(BROOKS_NAME)) {
				System.out.print("What number does " + playerName 
									+ " wear? ");
				int userNum = input.nextInt();
				
				if (userNum == BROOKS_NUM) {
					System.out.print("Correct!");
				} else {
					System.out.print("Incorrect!");
				}
				
			} else if (playerName.equals(MCFARLAND_NAME)) {
				System.out.print("What number does " + playerName 
									+ " wear? ");
				int userNum = input.nextInt();
				
				if (userNum == MCFARLAND_NUM) {
					System.out.print("Correct!");
				} else {
					System.out.print("Incorrect!");
				}
				
			} else if (playerName.equals(ELLIS_NAME)) {
				System.out.print("What number does " + playerName +
									" wear? ");
				int userNum = input.nextInt();
				
				if (userNum == ELLIS_NUM) {
					System.out.print("Correct!");
				} else {
					System.out.print("Incorrect!");
				}
				
			} else {
				System.out.println("Invalid Choice.");
			}	
		} 
		input.close();
	}
}
