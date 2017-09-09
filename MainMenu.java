import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

import com.teamtreehouse.model.Player;
import com.teamtreehouse.model.Team;
import com.teamtreehouse.model.Teams;

public class MainMenu{

public static Scanner sc = new Scanner(System.in);

public static void displayMenu(){

  System.out.println("Menu Options\n");
  System.out.println("1. Create new team");
  System.out.println("2. Add player to team");
  System.out.println("3. Remove player from team");
  System.out.println("4. Team Balance Report - Heights");
  System.out.println("5. Team Balance Report - Experience");
  System.out.println("6. Print Team Roster\n");
  System.out.println("Please choose an option:");
  
  int menuChoice = sc.nextInt();
  sc.nextLine(); //fires blank to consume & allow following nextline 

    String teamNew;
	switch(menuChoice) {
    case 1: System.out.println("What is the new team name?");
            teamNew = sc.nextLine();
            System.out.println(teamNew);
            System.out.println("What is the coach's name?");
            String coach = sc.nextLine();
            Team teamr = new Team(teamNew,coach);
            LeagueManager.teams.add(teamr);
            System.out.println("There are now " + LeagueManager.teams.size() + " teams.");
            Teams.save(LeagueManager.teams);
   
    break;
    case 2: System.out.println("Choose a player to add:");
    			Arrays.sort(LeagueManager.players);
    			int i;
    			for(i=0; i<LeagueManager.players.length; i++) {
    				
    				System.out.println(
    				i+1 + ": " +
    				LeagueManager.players[i].getLastName() 
    				+ " " +
    				LeagueManager.players[i].getFirstName());
    			}
                System.out.println("Which player would you like to add?");
                int playerToAdd = sc.nextInt() - 1;
                
                System.out.println("You chose: " 
                + LeagueManager.players[playerToAdd].getLastName() + ", "
                + LeagueManager.players[playerToAdd].getFirstName()
                + "\nSelect a team to add to:");
                
                for(i=0; i<LeagueManager.teams.size(); i++) {
                System.out.println(
                		i+1 +": " +
                		LeagueManager.teams.get(i).getTeamName());
                int teamChoice = sc.nextInt() -1;
                	}
    break;
    case 3: System.out.println("Remove player from team.");
    // Who is the player
    // You've selected xxx who is on xxx team / unassigned. 
    // Select a team to remove from.
    break;
    case 4: System.out.println("Team balance report - Height");
    // Below is a list of teams sorted by height
    break;
    case 5: System.out.println("Team balance report - Experience");
    // Below is a list of teams sorted by experience
    break;
    case 6: System.out.println("Print Team Roster");
    // Attached is a list of all teams alphabetized
    break;
  }

}  
  
/*Menu Options: 
  1. Create new team
  2. Add players to team
  3. Remove players from team
  4. Team report / height
  5. Teamm Report / balance
  6. Print Roster
  */
  
}