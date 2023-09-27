import java.util.ArrayList;

public class Biens {
    private int id;
    private String rue;
    private String cp;
    private String ville;
    private double prix;
    private int anneeConstru;
    private String description;
    private boolean libre;

    private ArrayList<Photo> photosBiens;

    public Biens(int id, String rue, String cp, String ville, double prix, int anneeConstru, String description, boolean libre, ArrayList<Photo> photosBiens) {
        this.id = id;
        this.rue = rue;
        this.cp = cp;
        this.ville = ville;
        this.prix = prix;
        this.anneeConstru = anneeConstru;
        this.description = description;
        this.libre = libre;
        this.photosBiens = photosBiens;
    }

    public int getId() {
        return id;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public int getAnneeConstru() {
        return anneeConstru;
    }

    public void setAnneeConstru(int anneeConstru) {
        this.anneeConstru = anneeConstru;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isLibre() {
        return libre;
    }

    public void setLibre(boolean libre) {
        this.libre = libre;
    }

    public ArrayList<Photo> getPhotosBiens() {
        return photosBiens;
    }

    public void setPhotosBiens(ArrayList<Photo> photosBiens) {
        this.photosBiens = photosBiens;
    }



}
