package org.example.view;

import org.example.model.Livre;
import org.example.model.Utilisateur;
import org.example.service.BibliothequeService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class BiblioView {
    LivreView livreView;
    UtilisateurView utilisateurView;
    EmpruntView empruntView;
    public BiblioView(LivreView livreView, UtilisateurView utilisateurView, EmpruntView empruntView) {
        this.livreView=livreView;
        this.utilisateurView=utilisateurView;
        this.empruntView=empruntView;
    }
    public void start(){
        while (true) {
            System.out.println("Welcome to LIBRITECH");
            System.out.println("1. Ajouter un livre");
            System.out.println("2. Lister les livres");
            System.out.println("3. Supprimer un livre");
            System.out.println("4. Ajouter un utilisateur");
            System.out.println("5. Lister les utilisateurs");
            System.out.println("6. modifier un utilisateur");
            System.out.println("7. Supprimer un utilisateur");
            System.out.println("8. emprunt un livre");
            System.out.println("9. Lister les emprunts");
            System.out.println("10. Modifier l'emprunt");
            System.out.println("11. Supprimer l'emprunt");
            System.out.println("12. Quitter");
            System.out.print("Veuillez choisir une option : ");
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:livreView.addLivre();break;
                case 2:livreView.listerLivres();break;
                case 3:livreView.supprimerLivre();break;
                case 4:utilisateurView.ajouterUser();break;
                case 5:utilisateurView.listerUsers();break;
                case 6:utilisateurView.modifyUser();break;
                case 7:utilisateurView.supprimerUser();break;
                case 8:empruntView.ajouterEmprunt();break;
                case 9:empruntView.listerEmprunt();break;
                case 10:empruntView.modifyEmprunt();break;
                case 11:empruntView.supprimerEmprunt();break;
                case 12:System.out.println("Thank you for using LIBRITECH. Goodbye!");return;
                default:
                    System.out.println("Choix Invalide.Ressayez");
            }
        }
    }
}
