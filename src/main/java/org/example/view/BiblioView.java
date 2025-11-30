package org.example.view;
import org.example.service.BibliothequeService;
import java.util.Scanner;

public class BiblioView {
    LivreView livreView;
    UtilisateurView utilisateurView;
    EmpruntView empruntView;
    public BiblioView(LivreView livreView, UtilisateurView utilisateurView, EmpruntView empruntView) {
        this.livreView = livreView;
        this.utilisateurView = utilisateurView;
        this.empruntView = empruntView;
    }
    public void start(){
        while (true) {
            System.out.println("Welcome to LIBRITECH");
            System.out.println("1. Ajouter un livre");
            System.out.println("2. Lister les livres");
            System.out.println("3. Supprimer un livre");
            System.out.println("4 Modifier un livre");
            System.out.println("5. Ajouter un utilisateur");
            System.out.println("6. Lister les utilisateurs");
            System.out.println("7. modifier un utilisateur");
            System.out.println("8. Supprimer un utilisateur");
            System.out.println("9. emprunt un livre");
            System.out.println("10. Lister les emprunts");
            System.out.println("11. Modifier l'emprunt");
            System.out.println("12. Supprimer l'emprunt");
            System.out.println("13. Quitter");
            System.out.print("Veuillez choisir une option : ");
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:livreView.addLivre();break;
                case 2:livreView.listerLivres();break;
                case 3:livreView.supprimerLivre();break;
                case 4:livreView.modifyLivre();break;
                case 5:utilisateurView.ajouterUser();break;
                case 6:utilisateurView.listerUsers();break;
                case 7:utilisateurView.modifyUser();break;
                case 8:utilisateurView.supprimerUser();break;
                case 9:empruntView.ajouterEmprunt();break;
                case 10:empruntView.listerEmprunt();break;
                case 11:empruntView.modifyEmprunt();break;
                case 12:empruntView.supprimerEmprunt();break;
                case 13:System.out.println("Thank you for using LIBRITECH. Goodbye!");return;
                default:
                    System.out.println("Choix Invalide.Ressayez");
            }
        }
    }
}
