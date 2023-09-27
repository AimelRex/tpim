import java.util.ArrayList;

public class Equipements {
    private int id;
    private String libelle;
    private int id_typeEquipement;
    private int id_pieces;

    private ArrayList<Photo> photosEquipements;

    public Equipements(int id, String libelle, int id_typeEquipement, int id_pieces, ArrayList<Photo> photosEquipements) {
        this.id = id;
        this.libelle = libelle;
        this.id_typeEquipement = id_typeEquipement;
        this.id_pieces = id_pieces;
        this.photosEquipements = photosEquipements;
    }


    public int getId() {
        return id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public int getId_typeEquipement() {
        return id_typeEquipement;
    }

    public void setId_typeEquipement(int id_typeEquipement) {
        this.id_typeEquipement = id_typeEquipement;
    }

    public int getId_pieces() {
        return id_pieces;
    }

    public void setId_pieces(int id_pieces) {
        this.id_pieces = id_pieces;
    }


    public ArrayList<Photo> getPhotosEquipements() {
        return photosEquipements;
    }

    public void setPhotosEquipements(ArrayList<Photo> photosEquipements) {
        this.photosEquipements = photosEquipements;
    }
}
