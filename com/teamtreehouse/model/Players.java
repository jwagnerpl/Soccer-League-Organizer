package com.teamtreehouse.model;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.teamtreehouse.model.Player;

public class Players {

	public static List<Player> players = new ArrayList<Player>();

	public static void save(List<Player> players) {
		try (FileOutputStream fos = new FileOutputStream("players.ser");
				ObjectOutputStream oos = new ObjectOutputStream(fos);) {
			oos.writeObject(players);
		} catch (IOException ioe) {
			System.out.println("Problem saving teams");
			ioe.printStackTrace();
		}
	}

	public static List<Player> load() {
		List<Player> players = new ArrayList<Player>();
		try (FileInputStream fis = new FileInputStream("players.ser");
				ObjectInputStream ois = new ObjectInputStream(fis);) {
			players = (List<Player>) ois.readObject();
		} catch (IOException ioe) {
			ArrayList<Player> playerList = new ArrayList<Player>(Arrays.asList(createPlayerList()));
			save(playerList);
			System.out.println("Error reading file");
			// ioe.printStackTrace();
		} catch (ClassNotFoundException cnfe) {
			System.out.println("Error loading teams");
			cnfe.printStackTrace();
		}
		return players;
	}

	public static Player[] createPlayerList() {
		return new Player[] { new Player("Joe", "Smith", 42, true), new Player("Jill", "Tanner", 36, true),
				new Player("Bill", "Bon", 43, true), new Player("Eva", "Gordon", 45, false),
				new Player("Matt", "Gill", 40, false), new Player("Kimmy", "Stein", 41, false),
				new Player("Sammy", "Adams", 45, false), new Player("Karl", "Saygan", 42, true),
				new Player("Suzane", "Greenberg", 44, true), new Player("Sal", "Dali", 41, false),
				new Player("Joe", "Kavalier", 39, false), new Player("Ben", "Finkelstein", 44, false),
				new Player("Diego", "Soto", 41, true), new Player("Chloe", "Alaska", 47, false),
				new Player("Arfalseld", "Willis", 43, false), new Player("Phillip", "Helm", 44, true),
				new Player("Les", "Clay", 42, true), new Player("Herschel", "Krustofski", 45, true),
				new Player("Andrew", "Chalklerz", 42, true), new Player("Pasan", "Membrane", 36, true),
				new Player("Kenny", "Lovins", 35, true), new Player("Alena", "Sketchings", 45, false),
				new Player("Carling", "Seacharpet", 40, false), new Player("Joseph", "Freely", 41, false),
				new Player("Gabe", "Listmaker", 45, false), new Player("Jeremy", "Smith", 42, true),
				new Player("Ben", "Droid", 44, true), new Player("James", "Dothnette", 41, false),
				new Player("Nick", "Grande", 39, false), new Player("Will", "Guyam", 44, false),
				new Player("Jason", "Seaver", 41, true), new Player("Johnny", "Thunder", 47, false),
				new Player("Ryan", "Creedson", 43, false) };
	}
}
