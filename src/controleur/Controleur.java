package controleur;

import java.util.*;
import models.*;
import util.*;
import view.*;

public class Controleur {

	private NivEau nivEau;
	private Grille grille;
	private VueAventurier vueAventurier;
	private VueGrille vueGrille;
	private ArrayList<Joueur> joueurs = new ArrayList();
	private ArrayList<Aventurier> aventuriers = new ArrayList();
	private ArrayList<CarteTresor> deft = new ArrayList();
	private ArrayList<CarteTresor> pilet = new ArrayList();
	private ArrayList<CarteInondation> defi = new ArrayList();
	private ArrayList<CarteInondation> pilei = new ArrayList();
	private ArrayList<Tresor> tresors;

        public Controleur() {
        }

	public CarteTresor tirerCT() {
		// TODO - implement Controleur.tirerCT
		throw new UnsupportedOperationException();
	}

	public CarteInondation tirerCI() {
		// TODO - implement Controleur.tirerCI
		throw new UnsupportedOperationException();
	}

	public NivEau getNiv() {
		// TODO - implement Controleur.getNiv
		throw new UnsupportedOperationException();
	}
        
        public void nouveauJoueur(String nom) {
            getJoueurs().add(new Joueur(nom));
        }
        
        public void initGrille() {
            int i;
            ArrayList<Tuile> at = new ArrayList();
            at.add(new Tuile("Le Pont des abimes",0));
            at.add(new Tuile("La Porte de bronze",1));
            i = at.size()-1;
            for (Joueur j : getJoueurs()) {
                if (j.getAventurier() instanceof Ingenieur) {
                    at.get(i).ajouterAv(j.getAventurier());
                    j.getAventurier().setPos(at.get(i));
                }
            }
            at.add(new Tuile("La Caverne des ombres",0));
            i = at.size()-1;
            at.get(i).setTresor(Tresor.Cristal);
            at.add(new Tuile("La Porte de fer",0));
            i = at.size()-1;
            for (Joueur j : getJoueurs()) {
                if (j.getAventurier() instanceof Plongeur) {
                    at.get(i).ajouterAv(j.getAventurier());
                    j.getAventurier().setPos(at.get(i));
                }
            }
            at.add(new Tuile("La Porte d'or",0));
            i = at.size()-1;
            for (Joueur j : getJoueurs()) {
                if (j.getAventurier() instanceof Navigateur) {
                    at.get(i).ajouterAv(j.getAventurier());
                    j.getAventurier().setPos(at.get(i));
                }
            }
            at.add(new Tuile("Les Falaises de l'oubli",0));
            at.add(new Tuile("Le Palais de corail",0));
            i = at.size()-1;
            at.get(i).setTresor(Tresor.Calice);
            at.add(new Tuile("La Porte d'argent",0));
            i = at.size()-1;
            for (Joueur j : getJoueurs()) {
                if (j.getAventurier() instanceof Messager) {
                    at.get(i).ajouterAv(j.getAventurier());
                    j.getAventurier().setPos(at.get(i));
                }
            }
            at.add(new Tuile("Les Dunes de l'illusion",2));
            at.add(new Tuile("Heliport",0));
            i = at.size()-1;
            for (Joueur j : getJoueurs()) {
                if (j.getAventurier() instanceof Pilote) {
                    at.get(i).ajouterAv(j.getAventurier());
                    j.getAventurier().setPos(at.get(i));
                }
            }
            at.add(new Tuile("La Porte de cuivre",0));
            i = at.size()-1;
            for (Joueur j : getJoueurs()) {
                if (j.getAventurier() instanceof Explorateur) {
                    at.get(i).ajouterAv(j.getAventurier());
                    j.getAventurier().setPos(at.get(i));
                }
            }
            at.add(new Tuile("Le Jardin des hurlements",0));
            i = at.size()-1;
            at.get(i).setTresor(Tresor.Statue);
            at.add(new Tuile("La Foret pourpre",0));
            at.add(new Tuile("Le Lagon perdu",1));
            at.add(new Tuile("Le Marais brumeux",2));
            at.add(new Tuile("Observatoire",1));
            at.add(new Tuile("Le Rocher fantôme",2));
            at.add(new Tuile("La Caverne du brasier",1));
            i = at.size()-1;
            at.get(i).setTresor(Tresor.Cristal);
            at.add(new Tuile("Le Temple du soleil",0));
            i = at.size()-1;
            at.get(i).setTresor(Tresor.Pierre);
            at.add(new Tuile("Le Temple de la lune",2));
            i = at.size()-1;
            at.get(i).setTresor(Tresor.Pierre);
            at.add(new Tuile("Le Palais des marées",0));
            i = at.size()-1;
            at.get(i).setTresor(Tresor.Calice);
            at.add(new Tuile("Le Val du crepuscule",0));
            at.add(new Tuile("La Tour du guet",0));
            at.add(new Tuile("Le Jardin des murmures",1));
            i = at.size()-1;
            at.get(i).setTresor(Tresor.Statue);
            //Collections.shuffle(at);
            grille = new Grille(at);
        }
        
        public Grille getGrille() {
            return grille;
        }
        
        public void initAventuriers() {
            aventuriers.add(new Pilote());
            aventuriers.add(new Navigateur());
            aventuriers.add(new Plongeur());
            aventuriers.add(new Explorateur());
            aventuriers.add(new Ingenieur());
            aventuriers.add(new Messager());
            Collections.shuffle(aventuriers);
        }
        
        public void initJoueurs() {
            int i = 0;
            for (Joueur j : getJoueurs()) {
                j.setAventurier(aventuriers.get(i));
                if (j.getAventurier() instanceof Pilote)
                    System.out.println(j.getNom() + " jouera le pilote.");
                if (j.getAventurier() instanceof Navigateur)
                    System.out.println(j.getNom() + " jouera le navigateur.");
                if (j.getAventurier() instanceof Plongeur)
                    System.out.println(j.getNom() + " jouera le plongeur.");
                if (j.getAventurier() instanceof Explorateur)
                    System.out.println(j.getNom() + " jouera l'explorateur.");
                if (j.getAventurier() instanceof Ingenieur)
                    System.out.println(j.getNom() + " jouera l'ingénieur.");
                if (j.getAventurier() instanceof Messager)
                    System.out.println(j.getNom() + " jouera le messager.");
                i++;
            }
            System.out.println("");
        }
        
        public void init() {
            initAventuriers();
            initJoueurs();
            initGrille();
        }
        
        public void tourJoueur(Joueur j) {
            Scanner sa = new Scanner(System.in);
            if (j.getAventurier() instanceof Pilote)
                System.out.println("Au tour de " + j.getNom() + " (Pilote) de jouer.");
            if (j.getAventurier() instanceof Navigateur)
                System.out.println("Au tour de " + j.getNom() + " (Navigateur) de jouer.");
            if (j.getAventurier() instanceof Plongeur)
                System.out.println("Au tour de " + j.getNom() + " (Plongeur) de jouer.");
            if (j.getAventurier() instanceof Explorateur)
                System.out.println("Au tour de " + j.getNom() + " (Explorateur) de jouer.");
            if (j.getAventurier() instanceof Ingenieur)
                System.out.println("Au tour de " + j.getNom() + " (Ingénieur) de jouer.");
            if (j.getAventurier() instanceof Messager)
                System.out.println("Au tour de " + j.getNom() + " (Messager) de jouer.");
            while(j.getAventurier().getNbactions()<3) {
                if (j.getAventurier() instanceof Navigateur)
                    System.out.println("Choisissez une action parmis : \n- 1 : se deplacer \n- 2 : assecher une tuile \n- 3 : deplacer un joueur");
                else
                    System.out.println("Choisissez une action parmis : \n- 1 : se deplacer \n- 2 : assecher une tuile");
                int action = sa.nextInt(); 
                if (action == 1) {
                    j.getAventurier().seDeplacer(grille);
                }
                else if (action == 2) {
                    j.getAventurier().assecher(grille);
                }
                else if (j.getAventurier() instanceof Navigateur && action == 3) {
                    j.getAventurier().deplacer(grille);
                }
            }
            if (j.getAventurier() instanceof Pilote)
                j.getAventurier().setHelico(false);
        }

        /**
         * @return the joueurs
         */
        public ArrayList<Joueur> getJoueurs() {
            return joueurs;
        }

}