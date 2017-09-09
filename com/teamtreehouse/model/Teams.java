package com.teamtreehouse.model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Teams {
	
	public static List<Team> teamList = new ArrayList<Team>();
	
  public static void save(List<Team> teams) {
    try (
      FileOutputStream fos = new FileOutputStream("teams.ser");
      ObjectOutputStream oos = new ObjectOutputStream(fos);
    ) {
    		System.out.println("it was success");
      oos.writeObject(teams);
    } catch(IOException ioe) {
      System.out.println("Problem saving teams");
      ioe.printStackTrace();
    }
  }
  
  public static List<Team> load() {
    List<Team> teams = new ArrayList<Team>();
    try (
      FileInputStream fis = new FileInputStream("teams.ser");
      ObjectInputStream ois = new ObjectInputStream(fis);
    ) {
      teams = (List<Team>) ois.readObject(); 
    } catch(IOException ioe) {
      System.out.println("Error reading file");
      ioe.printStackTrace();
    } catch(ClassNotFoundException cnfe) {
      System.out.println("Error loading teams");
      cnfe.printStackTrace();
    }
    return teams;
  }
  
}