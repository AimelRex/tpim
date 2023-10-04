import java.util.ArrayList;

public class Equipements {
    private int id;
    private String libelle;

    private int id_pieces;

    private ArrayList<Photo> photosEquipements = new ArrayList<Photo>();

    public Equipements(int id, String libelle, int id_pieces) {
        this.id = id;
        this.libelle = libelle;
        this.id_pieces = id_pieces;
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

    //---------méthodes--------

    public void addPhoto(Photo p){
        this.photosEquipements.add(p);
    }
}
