import com.teamtreehouse.model.Player;
import com.teamtreehouse.model.Players;
import com.teamtreehouse.model.Team;
import com.teamtreehouse.model.Teams;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LeagueManager {

	public static List<Team> teams = new ArrayList<Team>();
	public static Player[] players = Players.load();
	
  public static void main(String[] args) {
    Prompter prompter = new Prompter();
    teams = Teams.load();
    int teamCount = teams.size();
    System.out.println("There are currently " + teamCount + " teams.");
    System.out.printf("There are currently %d registered players.%n", players.length);
    prompter.displayMenu();
  }
}
