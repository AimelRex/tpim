import java.util.ArrayList;

public class Piece {
    private int id;
    private double surface;
    private String libelle;
    private int id_biens;
    private ArrayList<Photo> photosPieces = new ArrayList<Photo>();
    private ArrayList<Equipements> equipementsPiece = new ArrayList<Equipements>();

    //for when you load
    public Piece(int id, double surface, String libelle, int id_biens) {
        this.id = id;
        this.surface = surface;
        this.libelle = libelle;
        this.id_biens = id_biens;
    }

    //for when
    public Piece(double surface, String libelle, int id_biens) {
        this.surface = surface;
        this.libelle = libelle;
        this.id_biens = id_biens;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSurface() {
        return surface;
    }

    public void setSurface(double surface) {
        this.surface = surface;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public int getId_biens() {
        return id_biens;
    }

    public void setId_biens(int id_biens) {
        this.id_biens = id_biens;
    }

    public ArrayList<Photo> getPhotosPieces() {
        return photosPieces;
    }

    public void setPhotosPieces(ArrayList<Photo> photosPieces) {
        this.photosPieces = photosPieces;
    }

    public ArrayList<Equipements> getEquipementsPiece() {
        return equipementsPiece;
    }

    public void setEquipementsPiece(ArrayList<Equipements> equipementsPiece) {
        this.equipementsPiece = equipementsPiece;
    }

    //---------------méthodes------------------

    public void addEquipement(Equipements e){
        this.equipementsPiece.add(e);
    }

    public void createNAddEquipement(String libelle){
        this.equipementsPiece.add(new Equipements(libelle, this.id));
    }

    public void deleteEquipement(Equipements e){this.equipementsPiece.remove(e);}
    public void deleteAllEquipement(){this.equipementsPiece.clear();}

    public void addPhoto(Photo p){
        this.photosPieces.add(p);
    }
}
