package com.PickMeUP.Game;

import com.PickMeUP.BackEnd.Hub;
import com.PickMeUP.BackEnd.Joueur;
import com.PickMeUP.BackEnd.Personnage;
import com.PickMeUP.FrontEnd.GUI;

import java.util.List;

public class GameManager{
	/*** Enum ***/
	/*** Attributs ***/

	private GUI gui;

	private Joueur player;

	private long lastUpdateTime;
	private final int UPDATE_INTERVAL_MS = 16;

	/*** Constructeurs ***/

	public GameManager(){
		this.player = new Joueur("Naerya");//askNamePlayer()
		this.gui = new GUI(this.player.getHub());
		this.lastUpdateTime = System.currentTimeMillis();

		Game();
	}

	/*** Getters et Setters ***/
	/*** Methodes ***/

	public void Game(){
		while(true){
			long currentTime = System.currentTimeMillis();
			long elapsedTime = currentTime - lastUpdateTime;

			if(elapsedTime >= UPDATE_INTERVAL_MS){
				update();
				render();
				lastUpdateTime = currentTime;
			}
		}
	}

	private void RegulMouvement(Personnage perso) {
		int prevPosX = perso.getPosX();
		int prevPosY = perso.getPosY();

		int i = 0;
		while (Collision() != null) {
			switch (i) {
            	case 0:
            		perso.Reculer();
            		break;
            	case 1:
            		perso.Avancer();
            		perso.Avancer();
            		break;
            	case 2:
            		perso.Reculer();
            		perso.Droite();
            		break;
            	case 3:
            		perso.Gauche();
            		perso.Gauche();
            		break;
            	default:
            		System.out.println("RegulMouvement -> Switch i -> incorrect tentative : " + i);
            		break;
			}

        if (Collision() != null) {
            perso.setPosition(prevPosX, prevPosY);
        }

        i++;
		}
	}

	private Personnage Collision() {
        List<Personnage> personnages = this.player.getHub().getListPerso();
        List<Hub.Batiments> batiments = this.player.getHub().getBatiments();

        for (Personnage perso : personnages) {
            int persoX = perso.getPosX();
            int persoY = perso.getPosY();
            int persoWidth = perso.getDimension();
            int persoHeight = perso.getDimension();

            for (Hub.Batiments batiment : batiments) {
                int batimentX = batiment.getPosX();
                int batimentY = batiment.getPosY();
                int batimentWidth = batiment.getDimensionX();
                int batimentHeight = batiment.getDimensionY();

                if (persoX < batimentX + batimentWidth &&
                    persoX + persoWidth > batimentX &&
                    persoY < batimentY + batimentHeight &&
                    persoY + persoHeight > batimentY) {
                    return perso; // On retourne le personnage en collision avec le bâtiment
                }
            }

            for (Personnage otherPerso : personnages) {
                if (otherPerso != perso) {
                    int otherPersoX = otherPerso.getPosX();
                    int otherPersoY = otherPerso.getPosY();
                    int otherPersoWidth = otherPerso.getDimension();
                    int otherPersoHeight = otherPerso.getDimension();

                    if (persoX < otherPersoX + otherPersoWidth &&
                        persoX + persoWidth > otherPersoX &&
                        persoY < otherPersoY + otherPersoHeight &&
                        persoY + persoHeight > otherPersoY) {
                        return perso; // On retourne le personnage en collision avec un autre personnage
                    }
                }
            }

            int borderThickness = 20; // Épaisseur de la bordure en pixels
            int windowWidth = gui.getWidth();
            int windowHeight = gui.getHeight();

            if (persoX < borderThickness) {return perso;}
            if (persoX + persoWidth > windowWidth - borderThickness) {return perso;}
            if (persoY < borderThickness) {return perso;}
            if (persoY + persoHeight > windowHeight - borderThickness) {return perso;}
        }

        return null;
    }

	/*** UPDATES ***/

	public void update(){
		gui.DrawCharacter(this.player.getHub());

		Personnage pj = Collision();
		if(pj != null){
			RegulMouvement(pj);
		}

		for(Personnage perso : this.player.getHub().getListPerso()){
			perso.Deplacer();
		}
		
	}

	/*** RENDER ***/

	public void render(){

	}
}