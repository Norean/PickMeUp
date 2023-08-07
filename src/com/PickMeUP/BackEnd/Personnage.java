package com.PickMeUP.BackEnd;

import java.util.Random;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Personnage{
	/*** Enum Personnage***/

	enum Bouclier{
		/*** Initialisation ***/

		Targe("Targe", 1, 1, 5, 2.5),
		Rondache_En_Bois("Rondache En Bois", 1, 1, 5, 2.5),
		Rondache_En_Acier("Rondache En Acier", 1, 1, 5, 3),
		Ecu_En_Bois("Ecu En Bois", 2, 2, 15, 5),
		Ecu_En_Acier("Ecu En Acier", 2, 2, 15, 7.5),
		Pavois("Pavois", 10, 10, 50, 22.5),
		Bouclier_De_Desarmement("Bouclier De Desarmement", 1, 1, 5, 5);

		/*** Attributs ***/

		private String name;
		private int bonusArmure;
		private int penaliteArmure;
		private int echecSorts;
		private double poids;

		/*** Constructeurs ***/

		private Bouclier(String name, int bonusArmure, int penaliteArmure, int echecSorts, double poids){
			this.name = name;
			this.bonusArmure = bonusArmure;
			this.penaliteArmure = penaliteArmure;
			this.echecSorts = echecSorts;
			this.poids = poids;
		}

		/*** Getters et Setters ***/

		private int getBonusArmure(){ return this.bonusArmure;}

		/*** Methodes ***/
		/*** Overrides ***/
	}

	enum Armures{
		/*** Initialisation ***/

		// Armures
		// Legeres
		Armure_Matelasse("Armure Matelasse", 1, 8, 0, 5, 1, 5),
		Armure_De_Cordage("Armure Cordage", 2, 4, 2, 20, 1, 7.5),
		Armure_De_Cuir("Armure De Cuir", 2, 6, 0, 10, 1, 7.5),
		Armure_De_Bois("Armure De Bois", 3, 4, 3, 15, 1, 10),
		Armure_D_Os("Armure D Os", 3, 4, 3, 15, 1, 10),
		Armure_De_Cuir_Cloute("Armure De Cuir Cloute", 3, 5, 1, 15, 1, 10),
		Chemise_De_Maille("Chemise De Maille", 4, 4, 2, 20, 1, 12.5),
		// Intermediaires
		Armure_De_Peau("Armure De Peau", 3, 4, 3, 20, -2, 12.5),
		Armure_D_Ecaille("Armure D Ecaille", 4, 3, 4, 25, -2, 15),
		Cotte_De_Maille("Cotte De Maille", 5, 2, 5, 30, -2, 20),
		Cuirasse("Cuirasse", 5, 3, 4, 25, -2, 15),
		// Lourdes
		Clibanion("Clibanion", 6, 0, 7, 40, -3, 22.5),
		Crevice("Crevice", 6, 1, 6, 35, -3, 17.5),
		Armure_A_Plaque("Armure A Plaque", 7, 0, 7, 40, -3, 25),
		Harnois("Harnois", 8, 1, 6, 35, -3, 25);

		/*** Attributs ***/

		private String name;
		private int bonusArmure;
		private int bonusDexMax;
		private int penaliteArmure;
		private int echecSorts;
		private int bonusVitDeplacement;
		private double poids;

		/*** Constructeurs ***/

		private Armures(String name, int bonusArmure, int bonusDexMax, int penaliteArmure, int echecSorts, int bonusVitDeplacement, double poids){
			this.name = name;
			this.bonusArmure = bonusArmure;
			this.bonusDexMax = bonusDexMax;
			this.penaliteArmure = penaliteArmure;
			this.echecSorts = echecSorts;
			this.bonusVitDeplacement = bonusVitDeplacement;
			this.poids = poids;
		}

		/*** Getters et Setters ***/

		private int getBonusArmure(){ return this.bonusArmure;}

		/*** Methodes ***/
		/*** Overrides ***/
	}

	enum Armes{
		/*** Initialisation ***/

		// Armes Improvisée - Corps a corps
		// Tres Petites
		Fleche("Flèche", "TP", 0.075, Arrays.asList(4), Arrays.asList(20), 2, Arrays.asList('P'), 0),
		CarreauDArbalete("Carreau D Arbalete", "TP", 0.050, Arrays.asList(4), Arrays.asList(20), 2, Arrays.asList('P'), 0),
		// Moyennes
		JavelineCC("Javeline", "M", 1, Arrays.asList(6), Arrays.asList(20), 2, Arrays.asList('P'), 0),

		// Armes Courantes - Corps a Corps
		// Attaque a mains nues
		Attaque_A_Mains_Nues("Attaque A Mains Nues", "MN", 0, Arrays.asList(3), Arrays.asList(20), 2, Arrays.asList('C'), 0),		
		Gantelet("Gantelet", "MN", 1, Arrays.asList(3), Arrays.asList(20), 2, Arrays.asList('C'), 0),
		// Tres Petites
		Dague("Dague", "TP", 0.5, Arrays.asList(4), Arrays.asList(19, 20), 2, Arrays.asList('P'), 3),
		Katar("Katar", "TP", 1, Arrays.asList(4), Arrays.asList(20), 3, Arrays.asList('P'), 0),
		Gantelet_Cloute("Gantelet Cloute", "TP", 1, Arrays.asList(4), Arrays.asList(20), 2, Arrays.asList('P'), 0),
		// Petites
		Masse_D_Arme_Legere("Masse D Arme Legere", "P", 3, Arrays.asList(6), Arrays.asList(20), 2, Arrays.asList('C'), 0),
		Serpe("Serpe", "P", 1.5, Arrays.asList(6), Arrays.asList(20), 2, Arrays.asList('T'), 0),
		// Moyennes
		Demi_Pique("Demi Pique", "M", 1.5, Arrays.asList(6), Arrays.asList(20), 3, Arrays.asList('P'), 6),
		Gourdin("Gourdin", "M", 1.5, Arrays.asList(6), Arrays.asList(20), 2, Arrays.asList('C'), 3),
		Hoopak("Hoopak", "M", 1.5, Arrays.asList(6), Arrays.asList(20), 2, Arrays.asList('P'), 0),
		Masse_D_Arme_Lourde("Masse D Arme Lourde", "M", 6, Arrays.asList(8), Arrays.asList(20), 2, Arrays.asList('C'), 0),
		Morgenstern("Morgenstern", "M", 4, Arrays.asList(8), Arrays.asList(20), 2, Arrays.asList('C', 'P'), 0),
		// Grandes
		Baton("Baton", "G", 2, Arrays.asList(6), Arrays.asList(20), 2, Arrays.asList('C'), 0),
		Lance("Lance", "G", 2.5, Arrays.asList(8), Arrays.asList(20), 3, Arrays.asList('P'), 6),

		// Armes Courantes - Distance
		// Petites
		Arbalete_Legere("Arbalete Legere", "P", 3, Arrays.asList(8), Arrays.asList(19, 20), 2, Arrays.asList('P'), 25),
		Dard("Dard", "P", 0.25, Arrays.asList(4), Arrays.asList(20), 2, Arrays.asList('P'), 6),
		Fronde("Fronde", "P", 0.1, Arrays.asList(4), Arrays.asList(20), 2, Arrays.asList('C'), 15),
		// Moyennes
		Arbalete_Lourde("Arbalete Lourde", "M", 4.5, Arrays.asList(10), Arrays.asList(19, 20), 2, Arrays.asList('P'), 40),
		Arbalete_Lance_Grappin("Arbalete Lance Grappin", "M", 6, Arrays.asList(3), Arrays.asList(20), 2, Arrays.asList('P'), 40),
		JavelineD("Javeline", "M", 1, Arrays.asList(6), Arrays.asList(20), 2, Arrays.asList('P'), 10),
		
		// Armes de Guerres - Corps a Corps
		// Armures et Bouclier
		Ecu_En_Bois("Ecu En Bois", "M", 5, Arrays.asList(4), Arrays.asList(20), 2, Arrays.asList('C'), 0),
		Ecu_En_Acier("Ecu En Acier", "M", 7.5, Arrays.asList(4), Arrays.asList(20), 2, Arrays.asList('C'), 0),
		Rondache_En_Bois("Rondache En Bois", "M", 2.5, Arrays.asList(3), Arrays.asList(20), 2, Arrays.asList('C'), 0),
		Rondache_En_Acier("ROndache En Acier", "M", 3, Arrays.asList(3), Arrays.asList(20), 2, Arrays.asList('C'), 0),
		Pointes_Armures("Pointes Armures", "M", 5, Arrays.asList(6), Arrays.asList(20), 2, Arrays.asList('P'), 0),
		Pointes_Bouclier("Pointes Bouclier", "M", 2.5, Arrays.asList(6), Arrays.asList(20), 2, Arrays.asList('P'), 0),
		// Petites
		Baionette("Baionette", "P", 1, Arrays.asList(4), Arrays.asList(19, 20), 2, Arrays.asList('P'), 0),
		Epee_Courte("Epee Courte", "P", 1.5, Arrays.asList(6), Arrays.asList(19, 20), 2, Arrays.asList('P'), 0),
		Hache_De_Lancer("Hache De Lancer", "P", 2, Arrays.asList(6), Arrays.asList(20), 2, Arrays.asList('T'), 3),
		Hachette("Hachette", "P", 2.5, Arrays.asList(6), Arrays.asList(20), 3, Arrays.asList('T'), 0),
		Lance_D_Arcon_Legere("Lance D Arcon Legere", "P", 2.5, Arrays.asList(6), Arrays.asList(20), 3, Arrays.asList('P'), 0),
		Marteau_Leger("Marteau Leger", "P", 1, Arrays.asList(4), Arrays.asList(20), 2, Arrays.asList('C'), 6),
		Matraque("Matraque", "P", 1.5, Arrays.asList(6), Arrays.asList(20), 2, Arrays.asList('C'), 0),
		Pic_De_Guerre("Pic De Guerre", "P", 2, Arrays.asList(4), Arrays.asList(20), 4, Arrays.asList('P'), 0),
		// Moyennes
		Cimeterre("Cimeterre", "M", 2, Arrays.asList(6), Arrays.asList(18, 19, 20), 2, Arrays.asList('T'), 0),
		Epee_Longue("Epee Longue", "M", 2, Arrays.asList(8), Arrays.asList(19, 20), 2, Arrays.asList('T'), 0),
		Fleau_D_Arme_Leger("Fleau D Arme Leger", "M", 2.5, Arrays.asList(8), Arrays.asList(20), 2, Arrays.asList('C'), 0),
		Hache_D_Arme("Hache D Arme", "M", 3.5, Arrays.asList(8), Arrays.asList(20), 3, Arrays.asList('T'), 0),
		Lance_D_Arcon_Lourde("Lance D Arcon Lourde", "M", 5, Arrays.asList(8), Arrays.asList(20), 3, Arrays.asList('P'), 0),
		Marteau_De_Guerre("Marteau De Guerre", "M", 4, Arrays.asList(6), Arrays.asList(20), 3, Arrays.asList('C'), 0),
		Pic_De_Guerre_Lourd("Pic De Guerre Lourd", "M", 3, Arrays.asList(6), Arrays.asList(20), 4, Arrays.asList('P'), 0),
		Rapiere("Rapiere", "M", 1.5, Arrays.asList(6), Arrays.asList(18, 19, 20), 2, Arrays.asList('P'), 0),
		Trident("Trident", "M", 2.5, Arrays.asList(8), Arrays.asList(20), 2, Arrays.asList('P'), 0),
		// Grandes
		Cimeterre_A_Deux_Mains("Cimeterre A Deux Mains", "G", 8, Arrays.asList(4, 4), Arrays.asList(18, 19, 20), 2, Arrays.asList('T'), 0),
		Corseque("Corseque", "G", 7.5, Arrays.asList(4, 4), Arrays.asList(20), 3, Arrays.asList('P'), 0),
		Coutille("Coutille", "G", 7.5, Arrays.asList(10), Arrays.asList(20), 3, Arrays.asList('T'), 0),
		Epee_Batarde("Epee Batarde", "G", 5, Arrays.asList(10), Arrays.asList(19, 20), 2, Arrays.asList('T'), 0),
		Epee_A_Deux_Mains("Eppe A Deux Mains", "G", 7.5, Arrays.asList(6, 6), Arrays.asList(19, 20), 2, Arrays.asList('T'), 0),
		Faux("Faux", "G", 6, Arrays.asList(4, 4), Arrays.asList(20), 4, Arrays.asList('P', 'T'), 0),
		Fleau_D_Arme_Lourd("Fleau D Arme Lourd", "G", 10, Arrays.asList(10), Arrays.asList(19, 20), 2, Arrays.asList('C'), 0),
		Fourche_Militaire("Fourche Militaire", "G", 3.5, Arrays.asList(8), Arrays.asList(20), 3, Arrays.asList('P'), 3),
		Grande_Hache("Grande Hache", "G", 10, Arrays.asList(12), Arrays.asList(20), 3, Arrays.asList('T'), 0),
		Guisarme("Guisarme", "G", 7.5, Arrays.asList(4, 4), Arrays.asList(20), 3, Arrays.asList('T'), 0),
		Hallebarde("Hallebarde", "G", 7.5, Arrays.asList(10), Arrays.asList(20), 3, Arrays.asList('P', 'T'), 0),
		Massue("Massue", "G", 5, Arrays.asList(10), Arrays.asList(20), 2, Arrays.asList('C'), 0),
		Pique("Pique", "G", 4.5, Arrays.asList(8), Arrays.asList(20), 3, Arrays.asList('P'), 0),

		// Armes de Guerres - Distance
		// Moyennes
		Arc_Court("Arc Court", "M", 1, Arrays.asList(6), Arrays.asList(20), 3, Arrays.asList('P'), 20),
		Arc_Court_Composite("Arc Court Composite", "M", 1, Arrays.asList(6), Arrays.asList(20), 3, Arrays.asList('P'), 23),
		// Grandes
		Arc_Long("Arc Long", "G", 1.5, Arrays.asList(8), Arrays.asList(20), 3, Arrays.asList('P'), 30),
		Arc_Long_Composite("Arc Long Composite", "G", 1.5, Arrays.asList(8), Arrays.asList(20), 3, Arrays.asList('P'), 35),

		// Armes Exotiques - Corps a Corps
		// Attaques a mains nues
		Botte_Lame("Botte Lame", "M", 1, Arrays.asList(6), Arrays.asList(20), 2, Arrays.asList('P'), 0),
		Ceste_De_Defense("Ceste De Defense", "M", 2, Arrays.asList(3), Arrays.asList(20), 2, Arrays.asList('C'), 0),
		// Tres Petites
		Couteau_De_Moignon("Couteau De Moignon", "TP", 1, Arrays.asList(4), Arrays.asList(19, 20), 2, Arrays.asList('P'), 0),
		Dague_Triple("Dague Triple", "TP", 0.5, Arrays.asList(4), Arrays.asList(19, 20), 2, Arrays.asList('P'), 0),
		Kukri("Kukri", "TP", 1.5, Arrays.asList(4), Arrays.asList(18, 19, 20), 2, Arrays.asList('P'), 0),
		Sai("Sai", "TP", 0.25, Arrays.asList(4), Arrays.asList(20), 2, Arrays.asList('P'), 0),
		// Petites
		Couteau_Croissant("Couteau Croissant", "P", 0.5, Arrays.asList(3), Arrays.asList(20), 2, Arrays.asList('T'), 0),
		Eventail_De_Guerre("Eventail  De Guerre", "P", 1.5, Arrays.asList(6), Arrays.asList(20), 3, Arrays.asList('T'), 0),
		Gantelet_A_Lame("Gantelet A Lame", "P", 2, Arrays.asList(6), Arrays.asList(19, 20), 2, Arrays.asList('T'), 0),
		Garrot_En_Chanvre("Garrot En Chanvre", "P", 0.05, Arrays.asList(6), Arrays.asList(19, 20), 2, Arrays.asList('C'), 0),
		Garrot_Metalique("Garrot Metalique", "P", 0.5, Arrays.asList(8), Arrays.asList(18, 19, 20), 2, Arrays.asList('T'), 0),
		Garrot_A_Verrouillage("Garrot A Verrouillage", "P", 1.5, Arrays.asList(8), Arrays.asList(18, 19, 20), 2, Arrays.asList('T'), 0),
		Kama("Kama", "P", 1, Arrays.asList(6), Arrays.asList(20), 2, Arrays.asList('T'), 0),
		Lest_De_Manche("Lest De Manche", "P", 1.25, Arrays.asList(4), Arrays.asList(20), 2, Arrays.asList('C'), 0),
		Nunchaku("Nunchaku", "P", 1, Arrays.asList(6), Arrays.asList(20), 2, Arrays.asList('C'), 0),
		Siangham("Siangham", "P", 0.5, Arrays.asList(6), Arrays.asList(20), 2, Arrays.asList('P'), 0),
		// Moyennes
		Chaine_Dague("Chaine Dague", "M", 2, Arrays.asList(4), Arrays.asList(19, 20), 2, Arrays.asList('P'), 0),
		Epee_Longue_Mercurielle("Epee Longue Mercurielle", "M", 3, Arrays.asList(8), Arrays.asList(20), 4, Arrays.asList('T'), 0),
		Faux_De_Poing("Faux De Poing", "M", 2, Arrays.asList(8), Arrays.asList(20), 4, Arrays.asList('T'), 0),
		// Grandes
		Attrape_Homme("Attrape Homme", "G", 4, Arrays.asList(4), Arrays.asList(20), 2, Arrays.asList('C'), 0),
		Baton_A_Lames("Attrape A Lames", "G", 5, Arrays.asList(8, 8), Arrays.asList(20), 2, Arrays.asList('P', 'T'), 6),
		Baton_A_Trois_Segements("Baton A Trois Segement", "G", 4, Arrays.asList(8), Arrays.asList(20), 3, Arrays.asList('C'), 0),
		Chaine_Cloutee("Chaine Cloutee", "G", 7.5, Arrays.asList(4, 4), Arrays.asList(20), 2, Arrays.asList('P'), 0),
		Cimeterre_Double("Cimeterre Double", "G", 7.5, Arrays.asList(6, 6), Arrays.asList(18, 19, 20), 2, Arrays.asList('T'), 0),
		Double_Lame("Double Lame", "G", 7.5, Arrays.asList(8, 8), Arrays.asList(19, 20), 2, Arrays.asList('T'), 0),
		Duom("Duom", "G", 4, Arrays.asList(8), Arrays.asList(20), 3, Arrays.asList('P'), 0),
		Epee_A_Deux_Mains_Mercurielle("Epee A Deux Mains Mercurielle", "G", 8.5, Arrays.asList(6, 6), Arrays.asList(20), 4, Arrays.asList('T'), 0),
		Fleau_Double("Fleau Double", "G", 10, Arrays.asList(8, 8), Arrays.asList(20), 2, Arrays.asList('C'), 0),
		Grand_Cimeterre("Grand Cimeterre", "G", 8, Arrays.asList(6, 6), Arrays.asList(18, 19, 20), 2, Arrays.asList('T'), 0),
		Gyro_Pointes("Gyro Pointes", "G", 10, Arrays.asList(8, 8), Arrays.asList(19, 20), 2, Arrays.asList('C', 'T'), 0),
		Gythka("Gythka", "G", 6, Arrays.asList(8, 8), Arrays.asList(20), 2, Arrays.asList('T'), 0),
		Lajatang("Lajatang", "G", 3.5, Arrays.asList(8, 8), Arrays.asList(20), 2, Arrays.asList('T'), 0),
		Manti("Manti", "G", 4.5, Arrays.asList(8), Arrays.asList(20), 3, Arrays.asList('P'), 0),

		// Armes Exotiques - Distance
		// Tres Petites
		Arbalete_De_Poing("Arbalete De Poing", "TP", 1.5, Arrays.asList(4), Arrays.asList(19, 20), 2, Arrays.asList('P'), 10),
		Fukami_Bari("Fukami Bari", "TP", 0.5, Arrays.asList(1), Arrays.asList(20), 2, Arrays.asList('P'), 3),
		Shiruken("Shiruken", "TP", 0.05, Arrays.asList(1), Arrays.asList(20), 2, Arrays.asList('P'), 3),
		// Petites
		Arbalete_De_Poing_A_Guide_Interne("Arbalete_De_Poing_A_Guide_Interne", "P", 2, Arrays.asList(4), Arrays.asList(19, 20), 2, Arrays.asList('P'), 10),
		Bolas("Bolas", "P", 1.5, Arrays.asList(6), Arrays.asList(20), 2, Arrays.asList('C'), 3),
		Bolas_A_Deux_Boules("Bolas A Deux Boules", "P", 1, Arrays.asList(4), Arrays.asList(20), 2, Arrays.asList('C'), 3),
		Bolas_Barbelee("Bolas Barbelee", "P", 2, Arrays.asList(6), Arrays.asList(20), 2, Arrays.asList('P'), 3),
		Boomerang("Boomerang", "P", 1, Arrays.asList(4), Arrays.asList(20), 2, Arrays.asList('C'), 6),
		Chatkcha("Chatkcha", "P", 0.25, Arrays.asList(6), Arrays.asList(20), 2, Arrays.asList('T'), 6),
		Fouet("Fouet", "P", 1, Arrays.asList(2), Arrays.asList(20), 2, Arrays.asList('T'), 5),
		Fouet_A_Dague("Fouet A Dague", "P", 1.5, Arrays.asList(6), Arrays.asList(19, 20), 2, Arrays.asList('T'), 5),
		// Moyennes
		Arbalete_A_Repetition("Arbalete A Repetition", "M", 8, Arrays.asList(8), Arrays.asList(19, 20), 2, Arrays.asList('P'), 25),
		Gantelet_A_Ressort("Gantelet A Ressort", "M", 2, Arrays.asList(4), Arrays.asList(20), 2, Arrays.asList('P'), 6),
		Javeline_Filante("Javeline Filante", "M", 1, Arrays.asList(8), Arrays.asList(19, 20), 2, Arrays.asList('P'), 15),
		Trancheur_Propulse("Trancheur Propulse", "M", 3, Arrays.asList(10), Arrays.asList(20), 3, Arrays.asList('P'), 30),
		// Grandes
		Grande_Arbalete("Grande Arbalete", "G", 7.5, Arrays.asList(12), Arrays.asList(19, 20), 2, Arrays.asList('P'), 50),
		Harpon("Harpon", "G", 5, Arrays.asList(10), Arrays.asList(20), 2, Arrays.asList('P'), 10),
		Sarbacane("Sarbacane", "G", 1, Arrays.asList(3), Arrays.asList(20), 2, Arrays.asList('P'), 3);

		/*** Attributs ***/

		private String name;
		private String catTaille;
		private double poids;

		private List<Integer> degat;
		private List<Integer> critique;
		private int multiplicateurCritique;
		private List<Character> type;
		private int porter;

		/*** Constructeurs ***/

		private Armes(String name, String catTaille, double poids, List<Integer> degat, List<Integer> critique, int multiplicateurCritique, List<Character> type, int porter){
			this.name = name;
			this.catTaille = catTaille;
			this.poids = poids;

			if(degat == null){this.degat = new ArrayList<Integer>();}else{this.degat = degat;}
			if(critique == null){this.critique = new ArrayList<Integer>();}else{this.critique = critique;}
			this.multiplicateurCritique = multiplicateurCritique;
			if(type == null){this.type = new ArrayList<Character>();}else{this.type = type;}
			this.porter = porter;
		}

		/*** Getters et Setters ***/
		/*** Methodes ***/
		/*** Overrides ***/
	}

	enum Don {
		/*** Initialisation ***/

		Combat_A_Deux_Armes("Combat A Deux Armes", null, null, null, null, null, 0, 0),
		Science_Du_Combat_A_Main_Nues("Science Du Combat A Main Nues", null, null, null, null, null, 0, 0),
		Expertise_Du_Combat("Expertise Du Combat", Arrays.asList("Int"), Arrays.asList(13), null, null, null, 0, 0),
		Science_Du_Croc_En_Jambes("Science Du Croc En Jambes", Arrays.asList("Int"), Arrays.asList(13), Arrays.asList(Don.Expertise_Du_Combat), null, null, 0, 0),
		Persuasion("Persuasion", null, null, null, null, null, 0, 0),
		Robustesse("Robustesse", null, null, null, null, null, 0, 0),
		Volonte_De_Fer("Volonte De Fer", null, null, null, null, null, 0, 0),
		Reflexe_Surhumain("Reflexe Surhumain", null, null, null, null, null, 0, 0),

		Acrobate("Acrobate", null, null, null, null, null, 0, 0),
		Ambidexterity("Ambidexterity", Arrays.asList("Dex"), Arrays.asList(15), null, null, null, 0, 0),
		Main_Gauche("Main Gauche", Arrays.asList("Dex"), Arrays.asList(14),Arrays.asList(Don.Ambidexterity), null, null, 0, 0),
		Parade_Auxilliaire("Parade Auxilliaire", Arrays.asList("Dex"), Arrays.asList(13), Arrays.asList(Don.Ambidexterity, Don.Combat_A_Deux_Armes), null, null, 0, 3),
		Science_Du_Combat_A_Deux_Armes("Science Du Combat A Deux Armes", null, null, Arrays.asList(Don.Combat_A_Deux_Armes), null, null, 0, 9),
		Arme_De_Jet("Arme De Jet", Arrays.asList("For", "Dex"), Arrays.asList(13,13),null, null, null, 0, 4),
		Science_De_L_Arme_De_Jet("Science De L Arme De Jet", Arrays.asList("For", "Dex"), Arrays.asList(13,13), Arrays.asList(Don.Arme_De_Jet), null, null, 0, 4),
		Arme_De_Jet_Improvisee("Arme De Jet Improvisee",Arrays.asList("Dex"), Arrays.asList(15), null, null, null, 0, 2),
		Arme_En_Main("Arme En Main", null, null, null, null, null, 0, 1),
		Botte_Du_Fourreau("Botte Du Fourreau", Arrays.asList("Dex"), Arrays.asList(17), Arrays.asList(Don.Arme_En_Main), null, null, 0, 0),
		Arme_De_Predilection("Arme De Predilection", null, null, null, null, null, 0, 1),
		Poigne_Du_Singe("Poigne Du Singe", Arrays.asList("For"), Arrays.asList(13), Arrays.asList(Don.Arme_De_Predilection), null, null, 0, 3),
		Armure_Rapide("Armure Rapide", Arrays.asList("Dex"), Arrays.asList(13), null, null, null, 0, 0),
		Athlete("Athlete", null, null, null, null, null, 0, 0),
		Attaque_En_Puissance("Attaque En Puissance", Arrays.asList("For"), Arrays.asList(13), null, null, null, 0, 0),
		Botte_Brutale("Botte Brutale", null, null, Arrays.asList(Don.Attaque_En_Puissance), null, null, 0, 3),
		Destruction_D_Arme("Destruction D Arme", Arrays.asList("For"), Arrays.asList(13), Arrays.asList(Don.Attaque_En_Puissance), null, null, 0, 0),
		Attaque_De_La_Serre_De_L_Aigle("Attaque De La Serre De L Aigle", Arrays.asList("Dex"), Arrays.asList(15), Arrays.asList(Don.Attaque_En_Puissance, Don.Destruction_D_Arme, Don.Science_Du_Combat_A_Main_Nues), null, null, 0, 2),
		Science_De_La_Destruction_D_Arme("Science De La Destruction D Arme", null, null, Arrays.asList(Don.Attaque_En_Puissance, Don.Destruction_D_Arme), null, null, 0, 2),
		Enchainement("Enchainement", Arrays.asList("For"), Arrays.asList(13), Arrays.asList(Don.Attaque_En_Puissance), null, null, 0, 0),
		Succession_D_Enchainements("Succession D Enchainements", Arrays.asList("For"), Arrays.asList(13), Arrays.asList(Don.Attaque_En_Puissance, Don.Enchainement), null, null, 0, 0),
		Perce_Murailles("Perce Murailles", Arrays.asList("For"), Arrays.asList(13), Arrays.asList(Don.Attaque_En_Puissance), null, null, 0, 0),
		Science_De_L_Attaque_En_Puissance("Science De L Attaque En Puissance", Arrays.asList("For"), Arrays.asList(13), Arrays.asList(Don.Attaque_En_Puissance), null, null, 0, 0),
		Science_De_La_Charge_A_Main_Nues("Science De La Charge A Main Nues", Arrays.asList("For"), Arrays.asList(13), Arrays.asList(Don.Attaque_En_Puissance), null, null, 0, 0),
		Science_Du_Renversement("Science Du Renversement", Arrays.asList("For"), Arrays.asList(13), Arrays.asList(Don.Attaque_En_Puissance, Don.Science_De_La_Charge_A_Main_Nues, Don.Expertise_Du_Combat, Don.Science_Du_Croc_En_Jambes), null, null, 0, 0),
		Science_Du_Coup_De_Bouclier("Science Du Coup De Bouclier", Arrays.asList("For"), Arrays.asList(13), null, null, null, 0, 0),
		Charge_Au_Bouclier("Charge Au Bouclier", Arrays.asList("For"), Arrays.asList(13), Arrays.asList(Don.Attaque_En_Puissance, Don.Science_Du_Coup_De_Bouclier), null, null, 0, 0),
		Attaque_Reflexe("Attaque Reflexe", null, null, null, null, null, 0, 0),
		Binome_De_Combat("Binome De Combat", null, null, Arrays.asList(Don.Attaque_Reflexe), null, null, 0, 3),
		Expertise_Tactique("Expertise Tactique", Arrays.asList("Dex"), Arrays.asList(13), Arrays.asList(Don.Attaque_Reflexe), null, null, 0, 2),
		Maintien_De_Position("Maintien De Position", null, null, Arrays.asList(Attaque_Reflexe), null, null, 0, 2),
		Botte_Secrete("Botte Secrete", null, null, null, null, null, 0, 1),
		Botte_Surprise("Botte Surprise", Arrays.asList("Dex"), Arrays.asList(19), null, null, null, 0, 0),
		Bouclier_Vivant("Bouclier Vivant", null, null, null, null, null, 0, 0),
		Cavalier_Impetueux("Cavalier Impetueux", null, null, null, Arrays.asList(Competence.Dressage, Competence.Equitation), null, 0, 0),
		Chance_Heroique("Chance Heroique", null, null, null, null, null, 0, 0),
		Char_De_Guerre("Char De Guerre", null, null, null, Arrays.asList(Competence.Dressage), null, 0, 0),
		Archer_Sur_Char("Archer Sur Char", null, null, Arrays.asList(Don.Char_De_Guerre), Arrays.asList(Competence.Dressage), null, 0, 0),
		Char_Culbuteur("Char Culbuteur", null, null, Arrays.asList(Don.Char_De_Guerre), Arrays.asList(Competence.Dressage), null, 0, 0),
		Char_Faucheur("Char Faucheur", null, null, Arrays.asList(Don.Char_De_Guerre), Arrays.asList(Competence.Dressage), null, 0, 0),
		Char_devastateur("Char devastateur", null, null, Arrays.asList(Don.Char_De_Guerre, Don.Char_Faucheur), Arrays.asList(Competence.Dressage), null, 0, 0),
		Charlatan("Charlatan", null, null, null, null, null, 0, 0),
		Combat_En_Aveugle("Combat En Aveugle", null, null, null, null, null, 0, 0),
		Vision_Aveugle("Vision Aveugle", Arrays.asList("Sag"), Arrays.asList(19), Arrays.asList(Don.Combat_En_Aveugle), null, null, 0, 4),
		Blocage_De_Bouclier("Blocage De Bouclier", null, null, Arrays.asList(Don.Combat_A_Deux_Armes), null, null, 0, 4),
		Combat_Monte("Combat Monte", null, null, null, Arrays.asList(Competence.Equitation), null, 0, 0),
		Attaque_Au_Galop("Attaque Au Galop", null, null, Arrays.asList(Don.Combat_Monte), Arrays.asList(Competence.Equitation), null, 0, 0),
		Charge_devastatrice("Charge devastatrice", null, null, Arrays.asList(Don.Combat_Monte, Don.Attaque_Au_Galop), Arrays.asList(Competence.Equitation), null, 0, 0),
		Pietinement("Pietinement", null, null, Arrays.asList(Don.Combat_Monte), Arrays.asList(Competence.Equitation), null, 0, 0),
		Tir_Monte("Tir Monte", null, null, Arrays.asList(Don.Combat_Monte), Arrays.asList(Competence.Equitation), null, 0, 0),
		Science_Du_Tir_Monte("Science Du Tir Monte", null, null, Arrays.asList(Don.Combat_Monte, Don.Tir_Monte), Arrays.asList(Competence.Equitation), null, 0, 0),
		Combat_Rapproche("Combat_Rapproche", null, null, null, null, null, 0, 3),
		Confident("Confident", null, null, null, null, null, 0, 0),
		Seduction("Seduction", null, null, Arrays.asList(Don.Persuasion), null, null, 0, 0),
		Corruption("Corruption", null, null, null, null, null, 0, 0),
		Coup_Bas("Coup Bas", null, null, null, null, null, 0, 2),
		Science_Des_Coups_Bas("Science Des Coups Bas", null, null, Arrays.asList(Don.Coup_Bas), null, null, 0, 6),
		Course("Course", null, null, null, null, null, 0, 0),
		Course_Aerienne("Course Aerienne", Arrays.asList("Dex"), Arrays.asList(15), Arrays.asList(Don.Course), null, null, 0, 0),
		Rapide_Comme_L_Eclair("Rapide_Comme_L_Eclair", null, null, Arrays.asList(Don.Course), null, null, 0, 0),
		Crapule("Crapule", null, null, null, null, null, 0, 0),
		Endurance("Endurance", null, null, null, null, null, 0, 0),
		Conscience_Prolonge("Conscience Prolonge", null, null, Arrays.asList(Don.Robustesse, Don.Volonte_De_Fer), null, null, 0, 2),
		Stoicisme_Martial("Stoicisme Martial", Arrays.asList("Con"), Arrays.asList(13), Arrays.asList(Don.Robustesse), null, null, 0, 0),
		Esquive("Esquive", Arrays.asList("Dex"), Arrays.asList(13), null, null, null, 0, 0),
		Agilite_Au_Combat("Agilite Au Combat", null, null, Arrays.asList(Don.Esquive, Don.Reflexe_Surhumain), null, null, 0, 0),
		Feinte_A_Distance("Feinte A Distance", null, null, Arrays.asList(Don.Esquive), Arrays.asList(Competence.Bluff), Arrays.asList(4), 0, 0),
		Souplesse_Du_Serpent("Souplesse Du Serpent", Arrays.asList("Dex"), Arrays.asList(13), Arrays.asList(Don.Esquive), null, null, 0, 0),
		Attaque_Eclair("Attaque Eclair", Arrays.asList("Dex"), Arrays.asList(13), Arrays.asList(Don.Esquive, Don.Souplesse_Du_Serpent), null, null, 0, 4),
		Attaque_En_Rotation("Attaque En Rotation", Arrays.asList("Dex", "Int"), Arrays.asList(13,13), Arrays.asList(Don.Esquive, Don.Souplesse_Du_Serpent, Don.Attaque_Eclair, Don.Expertise_Du_Combat), null, null, 0, 4),
		Traitrise_Au_Combat("Traitrise Au Combat", null, null, Arrays.asList(Don.Esquive), null, null, 0, 0),
		Etudes_Des_Armures("Etudes Des Armures", null, null, Arrays.asList(Don.Expertise_Du_Combat), null, null, 0, 0),
		Mise_Au_Tapis("Mise Au Tapis", Arrays.asList("For"), Arrays.asList(15), Arrays.asList(Don.Expertise_Du_Combat, Don.Science_Du_Croc_En_Jambes), null, null, 0, 2),
		Science_Du_Desarmement("Science Du Desarmement", Arrays.asList("Int"), Arrays.asList(13), Arrays.asList(Don.Expertise_Du_Combat), null, null, 0, 0),
		Prise_D_Arme("Prise_D_Arme", null, null, Arrays.asList(Don.Science_Du_Desarmement, Don.Expertise_Du_Combat), null, null, 0, 0),
		Voie_De_L_Expertise_Du_Combat("Voie De L Expertise Du Combat", Arrays.asList("Int"), Arrays.asList(13), Arrays.asList(Don.Expertise_Du_Combat), null, null, 0, 0),
		Filature("Filature", null, null, null, null, null, 0, 0),
		Guerrier_Des_Colines("Guerrier Des Colines", null, null, null, null, null, 0, 2),
		Leche_Botte("Leche Botte", null, null, null, null, null, 0, 0),
		Maniement_Des_Armes_Courantes("Maniement Des Armes Courantes", null, null, null, null, null, 0, 0),
		Maniement_Des_Armes_Exotiques("Maniement Des Armes Exotiques", null, null, null, null, null, 0, 1),
		Maniement_Des_Armes_De_Guerre("Maniement Des Armes De Guerre", null, null, null, null, null, 0, 0),
		Maniement_Du_Bouclier("Maniement Du Bouclier", null, null, null, null, null, 0, 0),
		Expertise_Du_Bouclier("Expertise_Du_Bouclier", null, null, Arrays.asList(Don.Maniement_Du_Bouclier), null, null, 0, 3),
		Spécialisation_Au_Bouclier("Spécialisation Au Bouclier", null, null, Arrays.asList(Don.Maniement_Du_Bouclier), null, null, 0, 0),
		Nul_N_Est_Idiot("Nul N Est Idiot", Arrays.asList("Sag"), Arrays.asList(13), null, null, null, 0, 0),
		Passe_Mercantile("Passe Mercantile", null, null, null, null, null, 0, 0),
		Pistage("Pistage", null, null, null, null, null, 0, 0),
		Port_D_Armure_Legere("Port D Armure Legere", null, null, null, null, null, 0, 0),
		Port_D_Armure_Intermediaire("Port D Armure Intermediaire", null, null, Arrays.asList(Don.Port_D_Armure_Legere), null, null, 0, 0),
		Port_D_Armure_Lourde("Port D Armure Lourde", null, null, Arrays.asList(Don.Port_D_Armure_Legere, Don.Port_D_Armure_Intermediaire), null, null, 0, 0),
		Prestige("Prestige", null, null, null, null, null, 6, 0),
		Pyromane("Pyromane", null, null, null, null, null, 0, 0),
		Rechargement_Rapide("Rechargement Rapide", null, null, null, null, null, 0, 2),
		Attaque_Au_Sol("Attaque Au Sol", Arrays.asList("Dex"), Arrays.asList(15), Arrays.asList(Don.Reflexe_Surhumain), null, null, 0, 2),
		Solide_Comme_Le_Roc("Solide Comme Le Roc", null, null, Arrays.asList(Don.Robustesse), null, null, 0, 0),
		Coup_De_Pied_Circulaire("Coup De Pied Circulaire", Arrays.asList("Dex"), Arrays.asList(15), Arrays.asList(Don.Science_Du_Combat_A_Main_Nues), null, null, 0, 3),
		Faiblesse_Feinte("Faiblesse Feinte", null, null, Arrays.asList(Don.Science_Du_Combat_A_Main_Nues), null, null, 0, 2),
		Parade_De_Projectile("Parade De Projectile", Arrays.asList("Dex"), Arrays.asList(13), Arrays.asList(Don.Science_Du_Combat_A_Main_Nues), null, null, 0, 0),
		Saisie_De_Projectile("Saisie De Projectile", Arrays.asList("Dex"), Arrays.asList(15), Arrays.asList(Don.Science_Du_Combat_A_Main_Nues, Don.Parade_De_Projectile), null, null, 0, 3),
		Poing_De_Fer("Poing De Fer", null, null, Arrays.asList(Don.Science_Du_Combat_A_Main_Nues), null, null, 0, 2),
		Science_De_La_Lutte("Science De La Lutte", null, null, Arrays.asList(Don.Science_Du_Combat_A_Main_Nues), null, null, 0, 0),
		Uppercut("Uppercut", Arrays.asList("Dex", "Sag"), Arrays.asList(13,13), Arrays.asList(Don.Science_Du_Combat_A_Main_Nues), null, null, 0, 8),
		Science_Du_Critique("Science Du Critique", null, null, null, null, null, 0, 8),
		Art_Du_Critique("Art Du Critique", null, null, Arrays.asList(Don.Science_Du_Critique), null, null, 0, 8),
		Science_De_La_Feinte("Science De La Feinte", null, null, null, Arrays.asList(Competence.Bluff), Arrays.asList(4), 0, 3),
		Voie_De_La_Feinte("Voie De La Feinte", null, null, Arrays.asList(Don.Science_De_La_Feinte), Arrays.asList(Competence.Bluff), Arrays.asList(7), 0, 7),
		Science_De_La_Guerison("Science De La Guerison", null, null, null, null, null, 0, 0),
		Science_De_L_Initiative("Science De L Initiative", null, null, null, null, null, 0, 0),
		Coup_Mortel("Coup Mortel", null, null, Arrays.asList(Don.Science_De_L_Initiative), null, null, 0, 2),
		Talent("Talent", null, null, null, null, null, 0, 0),
		Talon_D_Achille("Talon_D_Achille", null, null, null, null, null, 0, 1),
		Tir_A_Bout_Portant("Tir A Bout Portant", null, null, null, null, null, 0, 0),
		Tir_De_Loin("Tir De Loin", null, null, Arrays.asList(Don.Tir_A_Bout_Portant), null, null, 0, 0),
		Tir_Meurtrier("Tir Meurtrier", Arrays.asList("Dex"), Arrays.asList(13), Arrays.asList(Don.Tir_A_Bout_Portant), null, null, 0, 0),
		Tir_Rapide("Tir Rapide", Arrays.asList("Dex"), Arrays.asList(13), Arrays.asList(Don.Tir_A_Bout_Portant), null, null, 0, 0),
		Tir_En_Mouvement("Tir En Mouvement", Arrays.asList("Dex"), Arrays.asList(13), Arrays.asList(Don.Esquive, Don.Souplesse_Du_Serpent, Don.Tir_A_Bout_Portant), null, null, 0, 0),
		Tir_De_Precision("Tir De Precision", null, null, Arrays.asList(Don.Tir_A_Bout_Portant), null, null, 0, 0),
		Science_Du_Tir_Meurtrier("Science Du Tir Meurtrier", Arrays.asList("Dex"), Arrays.asList(13), Arrays.asList(Don.Tir_A_Bout_Portant, Don.Tir_Meurtrier, Don.Tir_Rapide), null, null, 0, 0),
		Tir_D_Elite("Tir D Elite", null, null, Arrays.asList(Don.Tir_A_Bout_Portant, Don.Tir_De_Precision), null, null, 0, 3),
		Science_Du_Tir_Rapide("Science Du Tir Rapide", Arrays.asList("Dex"), Arrays.asList(13), Arrays.asList(Don.Tir_A_Bout_Portant, Don.Tir_Rapide), null, null, 0, 2),
		Tireur_Zen("Tireur zen", Arrays.asList("Dex"), Arrays.asList(13), null, null, null, 0, 3),
		Touche_A_Tout("Touche A Tout", null, null, null, null, null, 8, 0),
		Tyran("Tyran", null, null, null, null, null, 6, 0),
		Vigilence("Vigilence", null, null, null, null, null, 0, 0),
		Sixieme_Sens("Sixieme Sens", Arrays.asList("Sag"), Arrays.asList(13), Arrays.asList(Don.Vigilence), null, null, 0, 0),
		Vigueur_Surhumaine("Vigueur Surhumaine", null, null, null, null, null, 0, 0),
		Vitesse("Vitesse", null, null, null, null, null, 0, 0);

		/*** Attributs ***/

		private String name;
			// Conditions
		private List<String> carac; // représente avec 3 lettre quel caracteristique est concerne par les conditions peut concerner la BBA
		private List<Integer> valeurCarac; // attention a respecter l'ordre
		private List<Don> don;
		private List<Competence> competence;
		private List<Integer> degreMaitriseCompetence;
		private int bba;
		private int niveau;

		/*** Constructeurs ***/

		private Don(String name, List<String> cara, List<Integer> valeurCara, List<Don> don, List<Competence> competence, List<Integer> degreMaitriseCompetence, int niveau, int bba){
			this.name = name;
			if(cara == null){this.carac = new ArrayList<String>();}else{this.carac = cara;}
        	if(valeurCara == null){this.valeurCarac = new ArrayList<Integer>();}else{this.valeurCarac = valeurCara;}
        	if(don == null){this.don = new ArrayList<Don>();}else{this.don = don;}
        	if(competence == null){this.competence = new ArrayList<Competence>();}else{this.competence = competence;}
        	if(degreMaitriseCompetence == null){this.degreMaitriseCompetence = new ArrayList<Integer>();}else{this.degreMaitriseCompetence = degreMaitriseCompetence;}
        	this.niveau = niveau;
        	this.bba = bba;
		}

		/*** Getters et Setters ***/

		private String getName(){ return this.name; } 
		private List<String> getCarac(){ return this.carac; }
		private List<Integer> getValeurCarac(){ return this.valeurCarac; }
		private List<Don> getDon(){ return this.don; }
		private List<Competence> getCompetence(){ return this.competence; }
		private List<Integer> getDegreMaitriseCompetence(){ return this.degreMaitriseCompetence; }
		private int getBBA(){ return this.bba; }
		private int getNiveau(){ return this.niveau; }

		/*** Methodes ***/
		/*** Overrides ***/
	}

	enum Competence {
		/*** Initialisation ***/

		Acrobatie("Acrobatie","Dex"),
		Alchimie("Alchimie","Int"),
		Artisanat("Artisanat","Int"),
		Bluff("Bluff","Cha"),
		Concentration("Concentration","Con"),
		Connaissance_Architecture_Et_Ingenierie("Connaissance Architecture_Et_Ingenierie","Int"),
		Connaissance_Armement("Connaissance Armement","Int"),
		Connaissance_Astrologie("Connaissance Astrologie","Int"),
		Connaissance_Bas_Fonds("Connaissance Bas Fonds","Int"),
		Connaissance_Climats("Connaissance Climats","Int"),
		Connaissance_Du_Code_De_L_Honneur_Martial("Connaissance Du Code De L Honneur Martial","Int"),
		Connaissance_Culture_Humanoide("Connaissance Culture Humanoide","Int"),
		Connaissance_Demonologie("Connaissance Demonologie","Int"),
		Connaissance_Folklore_Local("Connaissance Folklore Local","Int"),
		Connaissance_Geographie("Connaissance Geographie","Int"),
		Connaissance_Geologie("Connaissance Geologie","Int"),
		Connaissance_Guerre("Connaissance Guerre","Int"),
		Connaissance_Heraldique("Connaissance Heraldique","Int"),
		Connaissance_Histoire("Connaissance Histoire","Int"),
		Connaissance_Litterature("Connaissance Litterature","Int"),
		Connaissance_Loi("Connaissance Loi","Int"),
		Connaissance_Mathématique("Connaissance Mathématique","Int"),
		Connaissance_Morts_Vivants("Connaissance Morts Vivants","Int"),
		Connaissance_Mystere("Connaissance Mystere","Int"),
		Connaissance_Nature("Connaissance Nature","Int"),
		Connaissance_Noblesse_Royaute("Connaissance Noblesse Royaute","Int"),
		Connaissance_Plan("Connaissance Plan","Int"),
		Connaissance_Politique("Connaissance Politique","Int"),
		Connaissance_Religion("Connaissance Religion","Int"),
		Connaissance_Sagesse_Populaire("Connaissance Sagesse Populaire","Int"),
		Connaissance_Des_Sorts("Connaissance Des Sorts","Int"),
		Connaissance_Sombre_Terre("Connaissance Sombre Terre","Int"),
		Contrefacon("Contrefacon","Int"),
		Crochetage("Crochetage","Dex"),
		Decryptage("Decryptage","Int"),
		Deguisement("Deguisement","Cha"),
		Deplacement_Silencieux("Deplacement Silencieux","Dex"),
		Desamorcage_Sabotage("Desamorcage Sabotage","Int"),
		Detection("Detection","Sag"),
		Diplomatie("Diplomatie","Cha"),
		Discretion("Discretion","Dex"),
		Dressage("Dressage","Cha"),
		Equilibre("Equilibre","Dex"),
		Equitation("Equitation","Dex"),
		Escalade("Escalade","For"),
		Escamotage("Escamotage","Dex"),
		Estimation("Estimation","Int"),
		Evasion("Evasion","Dex"),
		Fouille("Fouille","Int"),
		Intimidation("Intimidation","Cha"),
		Langage_Secret("Langage Secret","Int"),
		Langue("Langue","Int"),
		Lecture_Sur_Les_Levres("Lecture Sur Les Levres","Sag"),
		Maitrise_Des_Cordes("Maitrise Des Cordes","Dex"),
		Natation("Natation","For"),
		Perception_Auditive("Perception Auditive","Sag"),
		Premier_Secours("Premier Secours","Sag"),
		Profession("Profession","Sag"),
		Psychologie("Psychologie","Sag"),
		Renseignements("Renseignements","Cha"),
		Representation("Representation","Cha"),
		Saut("Saut","For"),
		Survie("Survie","Sag");

		/*** Attributs ***/

		private String name;
		private String caracAssocier;
		private int modCarac;
		private int degresMaitrise;
		private int bonusDivers;
		private int bonusSynergie;

		private int total;

		/*** Constructeurs ***/

		private Competence(String name, String carac){
			this.name = name;
			this.caracAssocier = carac;
			this.modCarac = 0;
			this.degresMaitrise = 0;
			this.bonusDivers = 0;
			this.bonusSynergie = 0;

			this.total = 0;
		}

		/*** Getters et Setters ***/

		private String getName(){return this.name;}
		private String getCaracAsso(){return this.caracAssocier;}
		private int getTotalBonus(){return this.total;}
		private int getDegreMaitrise(){return this.degresMaitrise;}
		private void SetModCarac(int modCarac){ this.modCarac = modCarac;}
		private void incrementDegreMaitrise(){ this.degresMaitrise++;}
		private void setTotalBonus(){this.total = this.modCarac + this.degresMaitrise + this.bonusDivers + this.bonusSynergie;}

		/*** Methodes ***/
		/*** Overrides ***/
	}

	enum Classe {
		/*** Initialisation ***/

		Barbare(12, 4, Arrays.asList("For", "Dex", "Con", "\0"), Arrays.asList(Competence.Artisanat, Competence.Dressage, Competence.Equitation, Competence.Escalade, Competence.Intimidation, Competence.Natation, Competence.Perception_Auditive, Competence.Saut, Competence.Survie), "CC", 1, 0, 2, 0),
		Barde(6, 4, Arrays.asList("Cha", "Dex", "Int", "\0"), Arrays.asList(Competence.Acrobatie, Competence.Alchimie, Competence.Artisanat, Competence.Bluff, Competence.Concentration, Competence.Connaissance_Architecture_Et_Ingenierie, Competence.Connaissance_Armement, Competence.Connaissance_Astrologie, Competence.Connaissance_Bas_Fonds, Competence.Connaissance_Climats, Competence.Connaissance_Du_Code_De_L_Honneur_Martial, Competence.Connaissance_Culture_Humanoide, Competence.Connaissance_Demonologie, Competence.Connaissance_Folklore_Local, Competence.Connaissance_Geographie, Competence.Connaissance_Guerre, Competence.Connaissance_Heraldique, Competence.Connaissance_Histoire, Competence.Connaissance_Litterature, Competence.Connaissance_Loi, Competence.Connaissance_Mathématique, Competence.Connaissance_Morts_Vivants, Competence.Connaissance_Mystere, Competence.Connaissance_Nature, Competence.Connaissance_Noblesse_Royaute, Competence.Connaissance_Plan, Competence.Connaissance_Politique, Competence.Connaissance_Religion, Competence.Connaissance_Sagesse_Populaire, Competence.Connaissance_Sombre_Terre, Competence.Decryptage, Competence.Deguisement, Competence.Deplacement_Silencieux, Competence.Diplomatie, Competence.Discretion, Competence.Equilibre, Competence.Escalade, Competence.Escamotage, Competence.Estimation, Competence.Evasion, Competence.Langue, Competence.Natation, Competence.Perception_Auditive, Competence.Profession, Competence.Psychologie, Competence.Renseignements, Competence.Representation, Competence.Saut, Competence.Survie), "SC", 0, 2, 0, 2),
		Druide(8, 4, Arrays.asList("Sag", "Dex", "\0", "\0"), Arrays.asList(Competence.Artisanat, Competence.Concentration, Competence.Connaissance_Des_Sorts, Competence.Connaissance_Nature, Competence.Diplomatie, Competence.Dressage, Competence.Natation, Competence.Premier_Secours, Competence.Profession, Competence.Survie), "SC", 0, 0, 2, 2),
		Ensorceleur(4, 2, Arrays.asList("Cha", "Dex", "Con", "\0"), Arrays.asList(Competence.Alchimie, Competence.Artisanat, Competence.Concentration, Competence.Connaissance_Des_Sorts, Competence.Connaissance_Mystere, Competence.Profession), "NC", 0, 0, 0, 2),
		Guerrier(10, 2, Arrays.asList("For", "Con", "Dex", "\0"), Arrays.asList(Competence.Artisanat, Competence.Dressage, Competence.Equitation, Competence.Escalade, Competence.Natation, Competence.Saut), "CC", 1, 0, 2, 0),
		Habitant(6, 4, Arrays.asList("\0", "\0", "\0", "\0"), Arrays.asList(Competence.values()), "NC", 0, 0, 0, 0),
		Magicien(4, 2, Arrays.asList("Int", "Dex", "Con", "\0"), Arrays.asList(Competence.Alchimie, Competence.Artisanat, Competence.Concentration, Competence.Connaissance_Architecture_Et_Ingenierie, Competence.Connaissance_Armement, Competence.Connaissance_Astrologie, Competence.Connaissance_Bas_Fonds, Competence.Connaissance_Climats, Competence.Connaissance_Du_Code_De_L_Honneur_Martial, Competence.Connaissance_Culture_Humanoide, Competence.Connaissance_Demonologie, Competence.Connaissance_Folklore_Local, Competence.Connaissance_Geographie, Competence.Connaissance_Guerre, Competence.Connaissance_Heraldique, Competence.Connaissance_Histoire, Competence.Connaissance_Litterature, Competence.Connaissance_Loi, Competence.Connaissance_Mathématique, Competence.Connaissance_Morts_Vivants, Competence.Connaissance_Mystere, Competence.Connaissance_Nature, Competence.Connaissance_Noblesse_Royaute, Competence.Connaissance_Plan, Competence.Connaissance_Politique, Competence.Connaissance_Religion, Competence.Connaissance_Sagesse_Populaire, Competence.Connaissance_Sombre_Terre, Competence.Profession), "NC", 0, 0, 0, 2),
		Moine(8, 4, Arrays.asList("Sag", "Dex", "For", "\0"), Arrays.asList(Competence.Acrobatie, Competence.Artisanat, Competence.Concentration, Competence.Connaissance_Mystere, Competence.Deplacement_Silencieux, Competence.Diplomatie, Competence.Discretion, Competence.Equilibre, Competence.Escalade, Competence.Evasion, Competence.Natation, Competence.Perception_Auditive, Competence.Profession, Competence.Representation, Competence.Saut), "SC", 0, 2, 2, 2),
		Paladin(10, 2, Arrays.asList("Cha", "For", "Sag", "\0"), Arrays.asList(Competence.Artisanat, Competence.Concentration, Competence.Connaissance_Religion, Competence.Diplomatie, Competence.Dressage, Competence.Equitation, Competence.Premier_Secours, Competence.Profession), "CC", 1, 0, 2, 0),
		Pretre(8, 2, Arrays.asList("Sag", "Con", "Cha", "\0"), Arrays.asList(Competence.Artisanat, Competence.Concentration, Competence.Connaissance_Des_Sorts, Competence.Connaissance_Mystere, Competence.Connaissance_Religion, Competence.Diplomatie, Competence.Premier_Secours, Competence.Profession), "SC", 0, 0, 2, 2),
		Rodeur(10, 4, Arrays.asList("Dex", "For", "Sag", "\0"), Arrays.asList(Competence.Artisanat, Competence.Concentration, Competence.Connaissance_Nature, Competence.Deplacement_Silencieux, Competence.Detection, Competence.Discretion, Competence.Dressage, Competence.Equitation, Competence.Escalade, Competence.Fouille, Competence.Maitrise_Des_Cordes, Competence.Natation, Competence.Perception_Auditive, Competence.Premier_Secours, Competence.Profession, Competence.Saut, Competence.Survie), "CC", 1, 0, 2, 0),
		Roublard(6, 8, Arrays.asList("Dex", "Int", "Sag", "\0"), Arrays.asList(Competence.Acrobatie, Competence.Artisanat, Competence.Bluff, Competence.Contrefacon, Competence.Crochetage, Competence.Decryptage, Competence.Deguisement, Competence.Deplacement_Silencieux, Competence.Desamorcage_Sabotage, Competence.Detection, Competence.Diplomatie, Competence.Discretion, Competence.Equilibre, Competence.Escalade, Competence.Escamotage, Competence.Estimation, Competence.Evasion, Competence.Fouille, Competence.Intimidation, Competence.Langage_Secret, Competence.Lecture_Sur_Les_Levres, Competence.Maitrise_Des_Cordes, Competence.Natation, Competence.Perception_Auditive, Competence.Profession, Competence.Psychologie, Competence.Renseignements, Competence.Representation, Competence.Saut, Competence.Survie), "SC", 0, 2, 0, 0);

		/*** Attributs ***/

		private int dv;
		private int modCompetence; //nombre qui determine les point de competence en fonction de la classe
		private List<String> listCaracteristiquePrioritaire;
		private List<Competence> listCompetences;
		private String typeClasse;
		private int bba;
		private int reflexe;
		private int vigueur;
		private int volonte;

		/*** Constructeurs ***/

		private Classe(int dv, int modComp, List<String> listCaraPrio, List<Competence> listComp, String typecl, int bba, int ref, int vig, int vol){
			this.dv = dv;
			this.modCompetence = modComp;
			this.listCaracteristiquePrioritaire = listCaraPrio;
			this.listCompetences = listComp;
			this.typeClasse = typecl;
			this.bba = bba;
			this.reflexe = ref;
			this.vigueur = vig;
			this.volonte = vol;
		}

		/*** Getters et Setters ***/

		private int getDV(){return this.dv;}
		private int getModCompetence(){return this.modCompetence;}
		private List<Competence> getCompetence(){return this.listCompetences;}
		private List<String> getCaracteristiquePrioritaire(){return this.listCaracteristiquePrioritaire;}
		private void getMonterNiveau(int niveau){MonterDeNiveau(niveau);}
		private int getBBA(){return this.bba;}
		private int getReflexe(){return this.reflexe;}
		private int getVigueur(){return this.vigueur;}
		private int getVolonte(){return this.volonte;}

		/*** Methodes ***/

		private void MonterDeNiveau(int niveau){
			switch(this.typeClasse){
				case "CC":
				this.bba = niveau;
				break;
				case "SC":
				this.bba = (int) (niveau*3) / 4;
				break;
				case "NC":
				this.bba = (int) niveau / 2;
				break;
				default:
				System.out.println("Classe -> MonterDeNiveau -> Switch : typeClasse");
				break;
			}

			if (this.reflexe == 0) { this.reflexe += niveau/3; }else{ this.reflexe += niveau/2; }
			if (this.vigueur == 0) { this.vigueur += niveau/3; }else{ this.vigueur += niveau/2; }
			if (this.volonte == 0) { this.volonte += niveau/3; }else{ this.volonte += niveau/2; }
		} 

		private Competence chercherCompetence(String nomCompetence){
			try{
				return Competence.valueOf(nomCompetence);
			}catch(IllegalArgumentException e){
				System.out.println("Erreur Classe -> chercherCompetence -> try : " + nomCompetence);
				return null;
			}
		}
		/*** Overrides ***/
	}

	/*** Attributs Personnage ***/

	private String name;
	private Classe classe;
	private int nbStar;
	private int niveau, niveauMax;

	private int pv;
	private int blessures;
	private int ca;

	private String alignement; //L N C -> B N M

	private int force, modFor;
	private int dexterite, modDex;
	private int constitution, modCon;
	private int intelligence, modInt;
	private int sagesse, modSag;
	private int charisme, modCha;

	private int reflexe;
	private int vigueur;
	private int volonte;

	private int bba;
	private int lutte;
	private int initiative;

	private double vitDeplacement;

	private List<Armes> armes;

	private Armures armure;
	private Bouclier bouclier;

	private List<Don> listDons;

	// Deplacements

	private int posX;
	private int posY;

	private int dimension;

	/*** Constructeurs Personnage ***/

	public Personnage(){
		this.name = null;
		this.nbStar = Alea(1,5);
		this.classe = tirerClasse();
		this.niveau = 1;
		this.niveauMax = CalculerNiveauMax();

		this.alignement = ChoixAlignementDepart();

		this.force = 0;
		this.dexterite = 0;
		this.constitution = 0;
		this.intelligence = 0;
		this.sagesse = 0;
		this.charisme = 0;
		AttributionCaracteristique();
		this.modFor = CalculModCarac(this.force);
		this.modDex = CalculModCarac(this.dexterite);
		this.modCon = CalculModCarac(this.constitution);
		this.modInt = CalculModCarac(this.intelligence);
		this.modSag = CalculModCarac(this.sagesse);
		this.modCha = CalculModCarac(this.charisme);

		this.pv = CalculPV();
		this.blessures = 0;
		this.ca = 10 + CalculCA();
		this.vitDeplacement = 9;

		CalculReflexe(0,0);
		CalculVigueur(0,0);
		CalculVolonte(0,0);

		this.bba = this.classe.getBBA();
		CalculLutte(0);
		CalculInitiative(0);

		AttributionPointCompetenceAtLvl1();
		this.listDons = new ArrayList<Don>();
		TirerUnDon();

		this.armes = new ArrayList<Armes>();
		this.armure = null;
		this.bouclier = null;

		this.posX = 110;
		this.posY = 550;
		this.dimension = 4;

		AfficherPersonnage();
	}

	/*** Getters et Setters ***/

	public int getPosX(){return this.posX;}
	public int getPosY(){return this.posY;}
	public int getDimension(){return this.dimension;}

	public void setPosition(int x, int y){
		this.posX = x;
		this.posY = y;
	}

	/*** Methodes ***/

	private void AttributionPointCompetenceAtLvl1(){

		int nbPtComp = (this.classe.getModCompetence() + this.modInt) * 4;

		for(int i = 0; i<nbPtComp; i++){
			int j = Alea(0,this.classe.getCompetence().size()-1);
			this.classe.getCompetence().get(j).incrementDegreMaitrise();
		}

		for(Competence comp : this.classe.getCompetence()){
			switch(comp.getCaracAsso()){
				case "For":
				comp.SetModCarac(this.modFor);
				break;
				case "Dex":
				comp.SetModCarac(this.modDex);
				break;
				case "Con":
				comp.SetModCarac(this.modCon);
				break;
				case "Int":
				comp.SetModCarac(this.modInt);
				break;
				case "Sag":
				comp.SetModCarac(this.modSag);
				break;
				case "Cha":
				comp.SetModCarac(this.modCha);
				break;
				default:
				System.out.println("AttributionPointCompetence -> switch caracAssocier");
				break;
			}
			comp.setTotalBonus();
		}
	}

	private void AttributionCaracteristique(){
		List<Integer> tmp = new ArrayList<Integer>();
		tmp.add(tirerCarac());
		tmp.add(tirerCarac());
		tmp.add(tirerCarac());
		tmp.add(tirerCarac());
		tmp.add(tirerCarac());
		tmp.add(tirerCarac());
		Collections.sort(tmp, Collections.reverseOrder()); // Trie de plus grand au plus petit
        
        int cpt = 0;
		for(int i=0;i<6;i++){
			int j = i<4 ? i : 3;
			switch(this.classe.getCaracteristiquePrioritaire().get(j)){
				case "For": 
					this.force = tmp.get(i);
					cpt++;
				break;
				case "Dex":	
					this.dexterite = tmp.get(i);
					cpt++;
				break;
				case "Con": 
					this.constitution = tmp.get(i);
					cpt++;
				break;
				case "Int": 
					this.intelligence = tmp.get(i);
					cpt++;
				break;
				case "Sag": 
					this.sagesse = tmp.get(i);
					cpt++;
				break;
				case "Cha": 
					this.charisme = tmp.get(i);
					cpt++;
				break;
				case "\0":
					if(this.force == 0){
						cpt++;
						int aleatTmp = Alea(cpt-1,5);
						this.force = tmp.get(aleatTmp);
						Collections.swap(tmp, cpt-1, aleatTmp);
					}
					if(this.dexterite == 0){
						cpt++;
						int aleatTmp = Alea(cpt-1,5);
						this.dexterite = tmp.get(aleatTmp);
						Collections.swap(tmp, cpt-1, aleatTmp);
					}
					if(this.constitution == 0){
						cpt++;
						int aleatTmp = Alea(cpt-1,5);
						this.constitution = tmp.get(aleatTmp);
						Collections.swap(tmp, cpt-1, aleatTmp);
					}
					if(this.intelligence == 0){
						cpt++;
						int aleatTmp = Alea(cpt-1,5);
						this.intelligence = tmp.get(aleatTmp);
						Collections.swap(tmp, cpt-1, aleatTmp);
					}
					if(this.sagesse == 0){
						cpt++;
						int aleatTmp = Alea(cpt-1,5);
						this.sagesse = tmp.get(aleatTmp);
						Collections.swap(tmp, cpt-1, aleatTmp);
					}
					if(this.charisme == 0){
						cpt++;
						int aleatTmp = Alea(cpt-1,5);
						this.charisme = tmp.get(aleatTmp);
						Collections.swap(tmp, cpt-1, aleatTmp);
					}
				break;
				default:
				System.out.println(" AttributionCaracteristique -> selectionCara1");
				break;
			}
		}
	}

	private int tirerCarac(){
		List<Integer> tmp = new ArrayList<Integer>();
		tmp.add(Alea(1,6));
		tmp.add(Alea(1,6));
		tmp.add(Alea(1,6));
		tmp.add(Alea(1,6));
		Collections.sort(tmp); // Trie du plus petit au plus grand

		return tmp.get(1) + tmp.get(2) + tmp.get(3);
	}

	private void TirerUnDon(){
        Don[] dons = Don.values();
        boolean test = true;

        do{
        	test = true;
        	Don don = dons[Alea(0,dons.length-1)];
        
        	for(String carac : don.getCarac()){
   				switch(carac){
     				case "For":
      					if(this.force < don.getValeurCarac().get(0))
       						test = false;
       				break;
       				case "Dex":
       					if(this.dexterite < don.getValeurCarac().get(0))
       						test = false;
       				break;
       				case "Con":
       					if(this.constitution < don.getValeurCarac().get(0))
       						test = false;
       				break;
       				case "Int":
       					if(this.intelligence < don.getValeurCarac().get(0))
       						test = false;
       				break;
       				case "Sag":
       					if(this.sagesse < don.getValeurCarac().get(0))
       						test = false;
       				break;
       				case "Cha":
       					if(this.charisme < don.getValeurCarac().get(0))
       						test = false;
       				break;
       				default:
       					System.out.println("TirerUnDon -> don.getCarac().get(1) -> erreur selection carac : " + don.getCarac().get(1));
       				break;
   				}
   			}

   			if(test){
   				int j = 0;
   				for(Don tmp : don.getDon()){
   					if(this.listDons.isEmpty()){
   						test = false;
   					}else{
   						if(chercherDon(this.listDons.get(j).name()) == null){
   							test = false;
   						}
   					}
   					j++;
   				}		
   				if(test){
   					int i = 0;
   					if(!don.getCompetence().isEmpty()){
   						for(Competence tmp : don.getCompetence()){
   							if(this.classe.chercherCompetence(tmp.name()) == null){
   								test = false;
   							}else{
   								if(this.classe.chercherCompetence(tmp.name()).getDegreMaitrise() < don.getDegreMaitriseCompetence().get(i)){
   									test = false;
   									i++;
   								}
   							}
   						}
   					}
					if(test){
						if(this.bba < don.getBBA()){
							test = false;
						}
						if(test){
							if(this.niveau < don.getNiveau()){
								test = false;
							}
						}
					}	
   				}
   			}

   			if(test)
   				this.listDons.add(don);

        }while(!test);
	}

	private Don chercherDon(String nomDon){
		for(Don don : this.listDons){
			if (don.name().equals(nomDon)) {
				return don;
			}
		}
		return null;
	}

	private String ChoixAlignementDepart(){
		int nb = Alea(1, 1000);
		int nb2 = Alea(1, 1000);

		String ali = "";

		if(nb2 < 333){
			ali += "L";
		}else if((nb2 >= 333)&&(nb2 < 666)){
			ali += "N";
		}else if((nb2 >= 666)&&(nb2 < 1000)){
			ali += "C";
		}

		if(nb < 333){
			ali += "B";
		}else if((nb >= 333)&&(nb < 666)){
			ali += "N";
		}else if((nb >= 666)&&(nb < 1000)){
			ali += "M";
		}

		return ali;
	}

	private int CalculModCarac(int caracteristique){
    	return caracteristique>=10 ? ((int) (caracteristique - 10) / 2 ) : ((int) (caracteristique -11) / 2 );
    }

	private Classe tirerClasse() {
        Classe[] classes = Classe.values();
        return classes[Alea(0,classes.length-1)];
    }

    private int CalculerNiveauMax(){
    	return this.nbStar * 4;
    }

    private void CalculReflexe(int bonusDiversReflexe, int modMagiqueReflexe){
		this.reflexe = this.classe.getReflexe() + this.modDex + bonusDiversReflexe + modMagiqueReflexe;
	}

	private void CalculVigueur(int bonusDiversVigueur, int modMagiqueVigueur){
		this.vigueur = this.classe.getVigueur() + this.modCon + bonusDiversVigueur + modMagiqueVigueur;
	}

	private void CalculVolonte(int bonusDiversVolonte, int modMagiqueVolonte){
		this.volonte = this.classe.getVolonte() + this.modSag + bonusDiversVolonte + modMagiqueVolonte;
	}

	private void CalculLutte(int modDiversLutte){
		this.lutte = this.bba + this.modFor + modDiversLutte;
	}

	private void CalculInitiative(int modDiversInitiative){
		this.initiative = this.modDex + modDiversInitiative;
	}

    private int CalculPV(){
    	return Alea(1,this.classe.getDV()) + this.modCon;
    }

    private int CalculCA(){
    	int bArm = 0;
    	int bBou = 0;
    	if(this.armure == null)
    		bArm = 0;
    	else
    		bArm = this.armure.getBonusArmure();
    	if(this.bouclier == null)
    		bBou = 0;
    	else
    		bBou = this.bouclier.getBonusArmure();

    	return bArm + bBou + this.modDex;
    }

    	/**** Methodes Deplacements ****/

    	public void Avancer(){this.posY --;}
    	public void Reculer(){this.posY ++;}
    	public void Droite(){this.posX ++;}
    	public void Gauche(){this.posX --;}

    	public void Deplacer(){
    		int choix = Alea(1,4);
    		switch(choix){
    			case 1:
    				Avancer();
    			break;
    			case 2:
    				Reculer();
    			break;
    			case 3:
    				Droite();
    			break;
    			case 4:
    				Gauche();
    			break;
    			default:
    			System.out.println("Deplacer -> Choix inconnue : " + choix);
    			break;
    		}
    	}

    	/**** Methodes Utilitaires ****/

	private int Alea(int min, int max){
		Random random = new Random();
        int randomNumber = random.nextInt((max - min)+1) + min;
        return randomNumber;
	}

	private void AfficherPersonnage(){
		System.out.println("Classe : " + this.classe + " Niveau : " + this.niveau + "\\" + this.niveauMax + "\nStars : " + this.nbStar);
		System.out.println("\nPV : " + this.pv + "\nCA : " + this.ca);
		System.out.println("\nAlignement : " + this.alignement);
		System.out.println("\nFor : " + this.force + " mod : " + this.modFor + "\nDex : " + this.dexterite +  " mod : " + this.modDex + "\nCon : " + this.constitution +  " mod : " + this.modCon + "\nInt : " + this.intelligence +  " mod : " + this.modInt + "\nSag : " + this.sagesse +  " mod : " + this.modSag + "\nCha : " + this.charisme + " mod : " + this.modCha);
		System.out.println("\nReflexe : " + this.reflexe + "\nVigueur : " + this.vigueur + "\nVolonte : " + this.volonte);
		System.out.println("\n" + "BBA : " + this.bba + "\nLutte : " + this.lutte + "\nInitiative : " + this.initiative + "\n");

		System.out.println("Dons : ");
		for(Don don : this.listDons){
			System.out.println(don.getName());
		}

		System.out.println("\nCompetence : ");

		for(Competence comp : this.classe.getCompetence()){
			System.out.println(comp.getName() + " : " + comp.getTotalBonus());
		}
	}

	/*** Overrides ***/
}