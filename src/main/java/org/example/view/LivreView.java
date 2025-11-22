package org.example.view;

import org.example.model.Livre;
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
        bibliothequeService.ajouterLivre(new Livre(nomAutheur,titreLivre,datePublication));
    }
    public void modifyLivre(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Entrer ID du livre:");
        int id = Integer.parseInt(sc.nextLine());
        System.out.print("Entrer le nouveau titre du livre: ");
        String titreLivre = sc.nextLine();
        System.out.print("Entrer le nouveau nom de l'auteur: ");
        String nomAuteur = sc.nextLine();
        System.out.print("Entrer la nouvelle date de publication (yyyy-MM-dd): ");
        String input = sc.nextLine();
        bibliothequeService.modifierLivre(new Livre(id,titreLivre,nomAuteur,LocalDate.parse(input)));
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
