package com.teamtreehouse.model;

import java.io.Serializable;
import java.util.Comparator;

public class Player implements Comparable<Player>, Serializable {
	private static final long serialVersionUID = 1L;

	private String firstName;
	private String lastName;
	private Team currentTeam;

	public static Comparator<Player> playerHeightComparator = new Comparator<Player>() {
		public int compare(Player p1, Player p2) {
			Integer playerHeight1 = p1.getHeightInInches();
			Integer playerHeight2 = p2.getHeightInInches();
			return playerHeight1.compareTo(playerHeight2);
		}
	};

	public static Comparator<Player> playerLastNameComparator = new Comparator<Player>() {
		public int compare(Player p1, Player p2) {
			String playerName1 = p1.getLastName();
			String playerName2 = p2.getLastName();
			return playerName1.compareTo(playerName2);
		}
	};

	public Team getCurrentTeam() {
		return currentTeam;
	}

	public void setCurrentTeam(Team currentTeam) {
		this.currentTeam = currentTeam;
	}

	public String getCurrentTeamName(Player player) {
		if (player.getCurrentTeam() == null) {
			return "unassigned";
		} else {
			return getCurrentTeam().getTeamName();
		}
	}

	private int heightInInches;
	private boolean previousExperience;

	public Player(String firstName, String lastName, int heightInInches, boolean previousExperience) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.heightInInches = heightInInches;
		this.previousExperience = previousExperience;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public int getHeightInInches() {
		return heightInInches;
	}

	public String isPreviousExperience() {
		if (previousExperience == true) {
			return "yes";
		} else {
			return "no";
		}
	}

	@Override
	public int compareTo(Player object) {
		Player other = (Player) object;
		// We always want to sort by last name then first name
		if (equals(other)) {
			return 0;
		}
		return lastName.compareTo(other.lastName);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Player))
			return false;

		Player player = (Player) o;

		if (heightInInches != player.heightInInches)
			return false;
		if (previousExperience != player.previousExperience)
			return false;
		if (!firstName.equals(player.firstName))
			return false;
		return lastName.equals(player.lastName);

	}

	@Override
	public int hashCode() {
		int result = firstName.hashCode();
		result = 31 * result + lastName.hashCode();
		result = 31 * result + heightInInches;
		result = 31 * result + (previousExperience ? 1 : 0);
		return result;
	}
}
