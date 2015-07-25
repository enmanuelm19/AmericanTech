//Created by: Enmanuel Medina, Team: O'Sullivan
package service;

import models.Club;

public class ClubService {
	
	static int id=0;
	static Club club = new Club(id++, "J-XXXXXXXX-X", "Centro Atletico America", "Lara-Barquisimeto", "04XX-XXXXXXXX", "Mision Aqui","Vision Aqui",null,"0251-XXXXXXX");
	public static Club getClub() {
		return club;
	}
	public static void setClub(Club club) {
		ClubService.club = club;
	}
	

}
