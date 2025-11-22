package org.example.view;

import org.example.model.Utilisateur;
import org.example.service.BibliothequeService;
import java.util.List;
import java.util.Scanner;


public class UtilisateurView {
    private BibliothequeService bibliothequeService;
    public UtilisateurView(BibliothequeService bibliothequeService) {
        this.bibliothequeService = bibliothequeService;
    }

    public void ajouterUser() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Entrer le nom d'utilisateur");
        String nom = sc.nextLine();
        System.out.println("Entrer le prénom de l'utilisateur");
        String prenom = sc.nextLine();
        bibliothequeService.ajouterUtilisateur(new Utilisateur(nom, prenom));
    }
    public void listerUsers() {
        List<Utilisateur> utilisateurs=bibliothequeService.listerUtilisateur();
        System.out.println("Liste des utilisateurs:");
        for (Utilisateur utilisateur : utilisateurs) {
            System.out.println(utilisateur.toString());
        }
    }
    public void modifyUser() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Entrer ID du utilisateur:");
        int utilisateurId = sc.nextInt();
        System.out.print("Entrer le nouveau nom de l'auteur:  ");
        String nom = sc.nextLine();
        System.out.println("Entrer le nouveau prenom de l'auteur: ");
        String prenom = sc.nextLine();
        bibliothequeService.modifierUtilisateur(new Utilisateur(utilisateurId,nom,prenom));
    }
    public void supprimerUser() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Entrer ID du utilisateur:");
        int utilisateurId = sc.nextInt();
        if (bibliothequeService.supprimerUtilisateur(utilisateurId)) {
            System.out.println("Utilisateur supprimé avec succès.");

        }else {
            System.out.println("Utilisateur non trouvé.");
        }
    }
}
