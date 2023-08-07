package com.PickMeUP.FrontEnd;

import com.PickMeUP.BackEnd.Hub;
import com.PickMeUP.BackEnd.Personnage;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.JButton;

import java.util.List;

import java.awt.Graphics;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame{
	/*** Enum ***/
	/*** Attributs ***/

	private final int TAILLE_BORDER = 50;
	private final int WINDOW_WIDTH = 800 + (TAILLE_BORDER * 2);
	private final int WINDOW_HEIGHT = 600 + (TAILLE_BORDER * 2);

	private DessinPanel dessinPanel;

	private boolean portailInvocation;

	/*** Constructeurs ***/

	public GUI(Hub hub){

		this.portailInvocation = false;

		setTitle("Pick Me UP");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
		setLocationRelativeTo(null);
		setResizable(false);

		this.dessinPanel = new DessinPanel(hub);

		this.add(this.dessinPanel);
		pack();
		this.setVisible(true);
	}

	/*** Getters et Setters ***/

	private boolean getPortailInvocation(){return this.portailInvocation;}

	/*** Methodes ***/

    public void DrawCharacter(Hub hub){
        this.dessinPanel.setCharacterToDraw(hub.getListPerso());
        repaint();
    }

    private void DrawBuildingButton(String batimentName, Hub hub){
    	JPanel panel = new JPanel();
    	panel.setBounds(50, 615, 785, 40);
    	panel.setBackground(Color.GRAY);

		switch(batimentName){
			case "Portail D Invocation":
				this.portailInvocation = true;
				JButton invoc = new JButton("Invocation");
                invoc.setBounds(5, 5, 100, 30);
                invoc.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        hub.InvoquerUnPersonnage();
                    }
                });
                panel.add(invoc);
			break;
			default:
				System.out.println("GUI -> DessinPanel -> DrawBuildingButton -> batimentName inconnue : " + batimentName);
			break;
		}
		this.dessinPanel.add(panel);
		repaint();
	}

	/*** Overrides ***/

	private class DessinPanel extends JPanel{
		/*** Enum ***/
		/*** Attributs ***/

		private List<Hub.Batiments> buildingsToDraw;
        private List<Personnage> listPersoToDraw;

		/*** Constructeurs ***/

		private DessinPanel(Hub hub){
			setLayout(null);
			DrawBuildings(hub);

			this.setBorder(new LineBorder(Color.BLACK, TAILLE_BORDER));
		}

		/*** Getters et Setters ***/

		private void setCharacterToDraw(List<Personnage> listPerso){
			this.listPersoToDraw = listPerso;
		}

		/*** Methodes ***/

		private void DrawBuildings(Hub hub){
			this.buildingsToDraw = hub.getBatiments();

			if(buildingsToDraw != null){
                for(Hub.Batiments batiment : buildingsToDraw){
                    JButton button = new JButton(batiment.getName());
                    button.setBounds(batiment.getPosX(), batiment.getPosY(), batiment.getDimensionX(), batiment.getDimensionY());
                    button.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            DrawBuildingButton(batiment.getName(), hub);
                        }
                    });

                    Font buttonFont = new Font("Arial", Font.PLAIN, 8);
                    button.setFont(buttonFont);

                    add(button);
                }
            }
		}

		/*** Overrides ***/

		@Override
		protected void paintComponent(Graphics g){
			super.paintComponent(g);

			if(listPersoToDraw != null){
                for(Personnage perso : listPersoToDraw){
                    g.setColor(Color.RED);
                    g.fillOval(perso.getPosX(), perso.getPosY(), perso.getDimension(), perso.getDimension());
                }
            }
		}
	}
}