package org.example.view;

import org.example.model.Emprunt;
import org.example.model.Livre;
import org.example.model.Utilisateur;

import org.example.service.BibliothequeService;

import javax.swing.plaf.BorderUIResource;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class EmpruntView {
    private BibliothequeService bibliothequeService;
    public EmpruntView(BibliothequeService bibliothequeService) {
        this.bibliothequeService = bibliothequeService;
    }
    public void ajouterEmprunt() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Entrez l'ID du livre : ");
        int livreId = Integer.parseInt(sc.nextLine());
        System.out.print("Entrez l'ID de l'utilisateur : ");
        int utilisateurId = Integer.parseInt(sc.nextLine());
        System.out.print("Entrez la date d'emprunt (yyyy-MM-dd) : ");
        String dateStr = sc.nextLine();
        LocalDate dateEmprunt = LocalDate.parse(dateStr);
        bibliothequeService.ajouterEmprunt(livreId,utilisateurId,dateEmprunt);
    }
    public void listerEmprunt() {
        List<Emprunt>emprunts=bibliothequeService.listerEmprunts();
        System.out.println("Liste des emprunts");
        for (Emprunt emprunt : emprunts) {
            System.out.println(emprunt.toString());
        }
    }
    public void modifyEmprunt() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Entrez l'ID de l'emprunt  : ");
        int emId= Integer.parseInt(sc.nextLine());
        System.out.print("Entrez l'ID du livre :");
        int livreId = Integer.parseInt(sc.nextLine());
        System.out.print("Entrez l'ID de l'utilisateur : ");
        int utilisateurId = Integer.parseInt(sc.nextLine());
        System.out.print("Entrez la date d'emprunt (yyyy-MM-dd) : ");
        LocalDate dateEmprunt = LocalDate.parse(sc.nextLine());
        System.out.print("Entrez la date du Retour (yyyy-MM-dd) : ");
        LocalDate dateRetour = LocalDate.parse(sc.nextLine());

        bibliothequeService.modifierEmprunt(emId,utilisateurId,livreId,dateEmprunt,dateRetour);
    }
    public void supprimerEmprunt() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Entrez l'ID de l'emprunt : ");
        int IdEmprint=Integer.parseInt(sc.nextLine());
        if (bibliothequeService.supprimerEmprunt(IdEmprint)){
            System.out.println("Emprunt supprimer");
        }else {
            System.out.println("Emprunt non trouver");
        }
    }
}
