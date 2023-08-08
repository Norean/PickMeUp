package com.PickMeUP.Game;

import com.PickMeUP.BackEnd.Hub;
import com.PickMeUP.BackEnd.Joueur;
import com.PickMeUP.BackEnd.Personnage;
import com.PickMeUP.FrontEnd.GUI;

import java.util.List;
import java.util.ArrayList;

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

	private void SuperCollide() {
		List<Personnage> perso = this.player.getHub().getListPerso();
		List<Hub.Batiments> batiments = this.player.getHub().getBatiments();
		
		for(Personnage pj : perso) {
			int pjx = pj.getPosX();
			int pjy = pj.getPosY();
			for(Personnage pjs : perso) {
				if(pj != pjs) {
					if((pjx + 1) == (pjs.getPosX() - pjs.getDimension())){pj.Gauche();} // Droite
					if((pjx - 1) == (pjs.getPosX() + pjs.getDimension())){pj.Droite();} // Gauche
					if((pjy + 1) == (pjs.getPosY() - pjs.getDimension())){pj.Avancer();} // Derriere
					if((pjy - 1) == (pjs.getPosY() + pjs.getDimension())){pj.Reculer();} // Devant
				}
				for(Hub.Batiments bat : batiments) {
					if((pjx + 1) == bat.getPosX()-1){pj.Gauche();} // Droite
					if((pjx - 1) == (bat.getPosX() + bat.getDimensionX()+1)){pj.Droite();} // Gauche
					if((pjy + 1) == bat.getPosY()-1){pj.Avancer();} // Derriere
					if((pjy - 1) == (bat.getPosY() + bat.getDimensionY()+1)){pj.Reculer();} // Devant
				}
			}
			if((pjx + 1) >= 850){pj.Gauche();} // Droite
			if((pjx - 1) <= 50){pj.Droite();} // Gauche
			if((pjy + 1) >= 650){pj.Avancer();} // Derriere
			if((pjy - 1) <= 50){pj.Reculer();} // Devant
		}
	}

	/*** UPDATES ***/

	public void update(){
		gui.DrawCharacter(this.player.getHub());

		SuperCollide();

		for(Personnage perso : this.player.getHub().getListPerso()){
			perso.Deplacer();
		}
		
	}

	/*** RENDER ***/

	public void render(){

	}
}
