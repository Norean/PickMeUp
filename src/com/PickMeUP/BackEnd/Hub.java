package com.PickMeUP.BackEnd;

import java.util.List;
import java.util.ArrayList;

public class Hub{
	/*** Enum ***/

	public enum Batiments{
		/*** Initialisations ***/
		
		Auberge("Auberge", null, 720, 110, 100, 40),
		Autel_Des_Sacrifice("Autel Des Sacrifice", null, 60, 60, 100, 40),
		Bibliotheque("Bibliotheque", null, 0, 0, 0, 0),
		Forge("Forge", null, 0, 0, 0, 0),
		Portail_Invocation("Portail D Invocation", null, 60, 560, 100, 40),
		Portail_Mission("Portail De Mission", null, 365, 60, 120, 40),
		Terrain_Entrainement("Terrain d Entrainement", null, 0, 0, 0, 0),
		Taverne("Taverne", null, 720, 60, 100, 40),
		Sanctuaire("Sanctuaire", null, 0, 0, 0, 0);

		/*** Attributs ***/

		private String name;
		private List<Personnage> listPersonnel;

		private int posX;
		private int posY;

		private int dimensionX;
		private int dimensionY;

		/*** Constructeurs ***/

		private Batiments(String name, List<Personnage> listPersonnel, int posX, int posY, int dimX, int dimY){
			this.name = name;
			if(this.listPersonnel == null){this.listPersonnel = new ArrayList<Personnage>();}else{this.listPersonnel = listPersonnel;}
			this.posX = posX;
			this.posY = posY;
			this.dimensionX = dimX;
			this.dimensionY = dimY;
		}

		/*** Getters et Setters ***/

		public String getName(){return this.name;}
		private void AjouterUnPersonnage(Personnage pj){this.listPersonnel.add(pj);}
		public int getPosX(){return this.posX;}
		public int getPosY(){return this.posY;}
		public int getDimensionX(){return this.dimensionX;}
		public int getDimensionY(){return this.dimensionY;}

		/*** Methodes ***/
		/*** Overrides ***/
	}

	/*** Attributs Hub***/

	private String name;
	private List<Batiments> batiments;
	private List<Personnage> listPerso;

	/*** Constructeurs Hub ***/

	public Hub(){
		this.name = null;
		this.batiments = new ArrayList<Batiments>();
		this.listPerso = new ArrayList<Personnage>();

		this.batiments.add(Batiments.Autel_Des_Sacrifice);
		this.batiments.add(Batiments.Portail_Mission);
		this.batiments.add(Batiments.Portail_Invocation);
		this.batiments.add(Batiments.Taverne);
		this.batiments.add(Batiments.Auberge);

		InvoquerUnPersonnage();
	}

	/*** Getters et Setters Hub ***/

	public List<Batiments> getBatiments(){return this.batiments;}
	public List<Personnage> getListPerso(){return this.listPerso;}

	/*** Methodes Hub ***/

	public void InvoquerUnPersonnage(){
		this.listPerso.add(new Personnage());
	}

	/*** Overrides Hub ***/
}