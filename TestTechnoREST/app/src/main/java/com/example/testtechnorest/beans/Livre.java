package com.example.testtechnorest.beans;

import java.sql.Date;

public class Livre {
    private int pk_livre;
    private String nom;
    private int fk_oeuvre;
    private int fk_debiteur;
    private Date dateEmprunt;
    private String commentaire;

    public Livre(int pk_livre, String nom, int fk_oeuvre, int fk_debiteur, Date dateEmprunt, String commentaire) {
        this.pk_livre = pk_livre;
        this.nom = nom;
        this.fk_oeuvre = fk_oeuvre;
        this.fk_debiteur = fk_debiteur;
        this.dateEmprunt = dateEmprunt;
        this.commentaire = commentaire;
    }


}
