package com.PickMeUP.BackEnd;

public class Joueur{
	/*** Enum ***/
	/*** Attributs ***/

	private String name;
	private Hub hub;

	/*** Constructeurs ***/

	public Joueur(String name){
		this.name = name;
		this.hub = new Hub();
	}

	/*** Getters et Setters ***/

	public Hub getHub(){return this.hub;}

	/*** Methodes ***/
	/*** Overrides ***/
}