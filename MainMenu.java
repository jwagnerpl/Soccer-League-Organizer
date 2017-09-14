import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import com.teamtreehouse.model.Player;
import com.teamtreehouse.model.Players;
import com.teamtreehouse.model.Team;
import com.teamtreehouse.model.Teams;

public class MainMenu {

	public static Scanner sc = new Scanner(System.in);
	private static Team team;

	private static Team chooseTeam() {
		int i = 0;
		Collections.sort(LeagueManager.teams);
		for (i = 0; i < LeagueManager.teams.size(); i++) {
			System.out.println(i + 1 + ": " + LeagueManager.teams.get(i).getTeamName());
		}

		return LeagueManager.teams.get(sc.nextInt() - 1);
	}

	public static void displayMenu() {
		LeagueManager.players = Players.load();
		LeagueManager.teams = Teams.load();
		System.out.println("Menu Options\n");
		System.out.println("1. Create new team");
		System.out.println("2. Add player to team");
		System.out.println("3. Remove player from team");
		System.out.println("4. Team Balance Report - Heights");
		System.out.println("5. Team Balance Report - Experience");
		System.out.println("6. Print Team Roster");
		System.out.println("7. Exit Application\n");
		System.out.println("Please choose an option:");

		int menuChoice = sc.nextInt();
		sc.nextLine(); // fires blank to consume & allow following nextline

		String teamNew;
		switch (menuChoice) {
		case 1:
			if (LeagueManager.players.size() <= LeagueManager.teams.size()) {
				System.out.println("Sorry, there are too many teams already.");
				displayMenu();
				break;
			}
			System.out.println("What is the new team name?");
			teamNew = sc.nextLine();
			System.out.println(teamNew);
			System.out.println("What is the coach's name?");
			String coach = sc.nextLine();
			Team teamr = new Team(teamNew, coach);
			LeagueManager.teams.add(teamr);
			System.out.println("There are now " + LeagueManager.teams.size() + " teams.\n");
			Teams.save(LeagueManager.teams);
			displayMenu();

			break;
		case 2:
			System.out.println("Choose a player to add:");
			Collections.sort(LeagueManager.players);
			int i;
			for (i = 0; i < LeagueManager.players.size(); i++) {

				Player player = LeagueManager.players.get(i);
				if (player.getCurrentTeam() == null) {
					System.out.println(i + 1 + ": " + player.getLastName() + ", " + player.getFirstName()
							+ " | Current Team: " + player.getCurrentTeamName(player) + " | Height: "
							+ player.getHeightInInches() + " | Experienced: " + player.isPreviousExperience());
				}
			}
			System.out.println("Which player would you like to add?");
			Player playerToAdd = LeagueManager.players.get(sc.nextInt() - 1);

			System.out.println("You chose: " + playerToAdd.getLastName() + ", " + playerToAdd.getFirstName()
					+ "\nSelect a team to add to:");
			Team chosenTeam = chooseTeam();

			chosenTeam.setPlayerList(playerToAdd);
			playerToAdd.setCurrentTeam(chosenTeam);
			System.out.println(playerToAdd.getFirstName() + " " + playerToAdd.getLastName()
					+ " has been assigned to the " + playerToAdd.getCurrentTeam().getTeamName() + ".\n");
			Players.save(LeagueManager.players);
			Teams.save(LeagueManager.teams);
			displayMenu();
			break;
		case 3:

			System.out.println("Choose a player to remove:");
			Collections.sort(LeagueManager.players);
			int i1;
			for (i1 = 0; i1 < LeagueManager.players.size(); i1++) {

				Player player = LeagueManager.players.get(i1);
				if (player.getCurrentTeamName(player) != "unassigned") {
					System.out.println(i1 + 1 + ": " + player.getLastName() + ", " + player.getFirstName()
							+ " | Current Team: " + player.getCurrentTeamName(player) + " | Height: "
							+ player.getHeightInInches() + " | Experienced: " + player.isPreviousExperience());
				}
			}
			System.out.println("Which player would you like to remove?");
			Player playerToRemove = LeagueManager.players.get(sc.nextInt() - 1);

			System.out.println("You chose: " + playerToRemove.getLastName() + ", " + playerToRemove.getFirstName());
			Team chosenTeamRemove = playerToRemove.getCurrentTeam();

			chosenTeamRemove.removePlayerList(playerToRemove);
			playerToRemove.setCurrentTeam(null);
			System.out.println(
					playerToRemove.getFirstName() + " " + playerToRemove.getLastName() + " has been removed. \n");
			Players.save(LeagueManager.players);
			Teams.save(LeagueManager.teams);
			displayMenu();
			break;

		case 4:
			System.out.println("Team balance report - Height");

			System.out.println("Select a team to get height report");
			team = chooseTeam();
			team.getPlayerList();

			List<Player> height3540 = new ArrayList<Player>();
			List<Player> height4146 = new ArrayList<Player>();
			List<Player> height4750 = new ArrayList<Player>();

			for (Player player : team.getPlayerList()) {
				int playerHeight = player.getHeightInInches();
				if (playerHeight >= 35 && playerHeight <= 40) {
					height3540.add(player);
				} else if (playerHeight >= 41 && playerHeight <= 46) {
					height4146.add(player);
				} else if (playerHeight >= 47 && playerHeight <= 50) {
					height4750.add(player);
				}
			}

			Collections.sort(height3540, Player.playerHeightComparator);
			Collections.sort(height4146, Player.playerHeightComparator);
			Collections.sort(height4750, Player.playerHeightComparator);

			System.out.printf("There are %s players between 35 and 40 inches.\n\n", height3540.size());
			for (Player player : height3540) {
				System.out.printf("- %s, %s, %s inches \n", player.getLastName(), player.getFirstName(),
						player.getHeightInInches());
			}
			System.out.println("\n");

			System.out.printf("There are %s players between 41 and 46 inches.\n\n", height4146.size());
			for (Player player : height4146) {
				System.out.printf("- %s, %s, %s inches \n", player.getLastName(), player.getFirstName(),
						player.getHeightInInches());
			}
			System.out.println("\n");

			System.out.printf("There are %s players between 47 and 50 inches.\n\n", height4750.size());
			for (Player player : height4750) {
				System.out.printf("- %s, %s, %s inches \n", player.getLastName(), player.getFirstName(),
						player.getHeightInInches());
			}
			System.out.println("\n");
			displayMenu();

			// Below is a list of teams sorted by height
			// Choose a team
			// Show heights for that specific team players in following ranges:
			// 35-40, 41-46, 47-50
			// Shows count for each player in each respective height range
			break;
		case 5:
			System.out.println("Team balance report - Experience");

			System.out.println("Select a team to get an experience report");
			team = chooseTeam();

			List<Player> experiencedPlayers = new ArrayList<Player>();
			List<Player> inexperiencedPlayers = new ArrayList<Player>();

			for (Player player : team.getPlayerList()) {
				if (player.isPreviousExperience() == "yes") {
					experiencedPlayers.add(player);
				} else {
					inexperiencedPlayers.add(player);
				}
			}
			float eSize = experiencedPlayers.size();
			float iSize = inexperiencedPlayers.size();
			float tPlayers = eSize + iSize;
			float percent;
			if (eSize > 0) {
				percent = eSize / tPlayers * 100;
			} else {
				percent = 0;
			}
			int count = 1;
			System.out.printf("%s has %s percent experienced players.\n", team.getTeamName(), percent);
			System.out.println("Experienced players:\n");
			for (Player player : experiencedPlayers) {

				System.out.printf("%s. %s, %s\n", count, player.getFirstName(), player.getLastName());
				count++;
			}
			count = 1;
			System.out.println("\nInexperienced players:\n");
			for (Player player : inexperiencedPlayers) {
				System.out.printf("%s. %s, %s\n", count, player.getFirstName(), player.getLastName());
				count++;
			}
			System.out.println("\n");
			displayMenu();
			// Below is a list of teams sorted by experience
			// Choose a team
			// Show experience for that specific team with lists of experienced and
			// inexperienced players
			// Shows percentage of experienced vs inexperienced
			break;
		case 6:
			System.out.println("\nPrint Team Roster\n");
			// System.out.println("\nChoose a team:");
			// team = chooseTeam();
			Collections.sort(LeagueManager.teams);
			for (Team team : LeagueManager.teams) {
				System.out.printf("Team: %s\nCoach: %s\n", team.getTeamName(), team.getCoachName());
				count = 1;
				Collections.sort(team.getPlayerList());
				for (Player player : team.getPlayerList()) {

					System.out.printf("%s. %s, %s, %s inches, Experienced: %s\n", count, player.getLastName(),
							player.getFirstName(), player.getHeightInInches(), player.isPreviousExperience());
					count++;
				}
				System.out.println("\n");
			}
			displayMenu();
			break;
		case 7:
			System.exit(0);
			break;
		}
	}
}