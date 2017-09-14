package com.teamtreehouse.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Team implements Comparable<Team>, Serializable {

	public String teamName;
	public String coachName;

	public Team(String teamName, String coachName) {
		this.teamName = teamName;
		this.coachName = coachName;
	}

	@Override
	public int compareTo(Team object) {
		Team other = (Team) object;
		// We always want to sort by last name then first name
		if (equals(other)) {
			return 0;
		}
		return teamName.toUpperCase().compareTo(other.teamName.toUpperCase());
	}

	private List<Player> playerList = new ArrayList<Player>();
	private static final long serialVersionUID = 7146681148113043748L;

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getCoachName() {
		return coachName;
	}

	public void setCoachName(String coachName) {
		this.coachName = coachName;
	}

	public List<Player> getPlayerList() {
		return playerList;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Team))
			return false;

		Team team = (Team) o;

		if (teamName != team.teamName)
			return false;
		if (coachName != team.coachName)
			return false;
		if (!playerList.equals(team.playerList))
			return false;
		return teamName.equals(team.teamName);
	}

	public void setPlayerList(Player player) {
		this.playerList.add(player);
	}

	public void removePlayerList(Player player) {
		this.playerList.remove(player);
	}

}