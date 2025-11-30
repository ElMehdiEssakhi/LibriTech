package org.example.view;

import org.example.model.Livre;
import org.example.model.ManuelScolaire;
import org.example.model.Roman;
import org.example.model.Utilisateur;
import org.example.service.BibliothequeService;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class LivreView {
    BibliothequeService bibliothequeService;
    public LivreView(BibliothequeService bibService) {
        bibliothequeService = bibService;
    }
    public void addLivre(){
        System.out.println("entrer le titre du livre:");
        Scanner sc = new Scanner(System.in);
        String titreLivre = sc.nextLine();
        System.out.println("entrer le nom de lautheur:");
        String nomAutheur = sc.nextLine();
        System.out.println("entrer le date de publication:");
        LocalDate datePublication = LocalDate.parse(sc.nextLine());
        System.out.println("entrer le type du livre:");
        String typeLivre = sc.nextLine();
        if (typeLivre.equals("Roman")){
            System.out.println("entrer le genre du roman:");
            String genre = sc.nextLine();
            bibliothequeService.ajouterLivre(new Roman(titreLivre, nomAutheur, datePublication, genre));
        }else if (typeLivre.equals("ManuelScolaire")){
            System.out.println("entrer le niveau scolaire du manuel:");
            String niveauScolaire = sc.nextLine();
            bibliothequeService.ajouterLivre(new ManuelScolaire(titreLivre, nomAutheur, datePublication, niveauScolaire));
        }
    }
    public void modifyLivre(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Entrer ID du livre:");
        int livreId = Integer.parseInt(sc.nextLine());
        System.out.print("Entrer le nouveau Titre:  ");
        String titre = sc.nextLine();
        System.out.println("Entrer le nouveau prenom de l'auteur: ");
        String Auteur = sc.nextLine();
        System.out.println("entrer la nouvelle date de publication:");
        LocalDate datePublication = LocalDate.parse(sc.nextLine());
        System.out.println("entrer le nouveau type du livre:");
        String typeLivre = sc.nextLine();
        if (typeLivre.equals("Roman")){
            System.out.println("entrer le nouveau genre du roman:");
            String genre = sc.nextLine();
            bibliothequeService.modifierLivre(new Roman(livreId,titre, Auteur, datePublication, genre));
        }else if (typeLivre.equals("ManuelScolaire")){
            System.out.println("entrer le nouveau niveau scolaire du manuel:");
            String niveauScolaire = sc.nextLine();
            bibliothequeService.modifierLivre(new ManuelScolaire(livreId,titre, Auteur, datePublication, niveauScolaire));
        }
    }
    public void listerLivres() {
        List<Livre> livres=bibliothequeService.listerLivres();
        System.out.println("Liste des livres:");
        for (Livre livre : livres) {
            System.out.println(livre.toString());
        }
    }
    public void supprimerLivre(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Entrez l'ID du livre à supprimer : ");
        int livreId = sc.nextInt();
        if (bibliothequeService.supprimerLivre(livreId)) {
            System.out.println("Livre supprimé avec succès.");
        } else {
            System.out.println("Livre non trouvé.");
        }
    }
}
