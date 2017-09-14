import com.teamtreehouse.model.Player;
import com.teamtreehouse.model.Players;
import com.teamtreehouse.model.Team;
import com.teamtreehouse.model.Teams;

import java.util.ArrayList;
import java.util.List;

public class LeagueManager {

	public static List<Team> teams = new ArrayList<Team>();
	public static List<Player> players = Players.load();

	public static void main(String[] args) {
		teams = Teams.load();
		int teamCount = teams.size();
		System.out.println("There are currently " + teamCount + " teams.");
		System.out.printf("There are currently %d registered players.%n", players.size());
		MainMenu.displayMenu();
	}
}
