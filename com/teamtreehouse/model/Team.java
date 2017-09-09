package com.teamtreehouse.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Team implements Serializable{

  public String teamName;
  public String coachName;
  
public Team(String teamName, String coachName){
  this.teamName = teamName;
  this.coachName = coachName;
}


public int compareTo(Team object) {
	  Team other = (Team) object;
	  // We always want to sort by last name then first name
	if(equals(other)) {
  return 0;
	}
	return teamName.compareTo(other.teamName);
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

  public void setPlayerList(List<Player> playerList) {
	this.playerList = playerList;
  }


}