package com.example.bibli0tech.bean;

public class Oeuvre {
    private int pk;
    private String nom;
    private String auteur;
    public Oeuvre(String xml) {
        String[] pkPlus = xml.split("</pk_oeuvre><nom>");
        this.pk = Integer.parseInt(pkPlus[0]);
        String[] nomPlus = pkPlus[1].split("</nom><auteur>");
        this.nom = nomPlus[0];
        String[] auteur = nomPlus[1].split("<");
        this.auteur = auteur[0];
    }

    public int getPk() {
        return pk;
    }

    public String getNom() {
        return nom;
    }

    public String getAuteur() {
        return auteur;
    }
}
