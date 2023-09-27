public class Photo {
    private int id;
    private int id_pieces;
    private int id_biens;
    private int id_equipements;
    private String chemin;

    public Photo(int id, int id_pieces, int id_biens, int id_equipements, String chemin) {
        this.id = id;
        this.id_pieces = id_pieces;
        this.id_biens = id_biens;
        this.id_equipements = id_equipements;
        this.chemin = chemin;
    }

    public int getId() {
        return id;
    }

    public int getId_pieces() {
        return id_pieces;
    }

    public void setId_pieces(int id_pieces) {
        this.id_pieces = id_pieces;
    }

    public int getId_biens() {
        return id_biens;
    }

    public void setId_biens(int id_biens) {
        this.id_biens = id_biens;
    }

    public int getId_equipements() {
        return id_equipements;
    }

    public void setId_equipements(int id_equipements) {
        this.id_equipements = id_equipements;
    }

    public String getChemin() {
        return chemin;
    }

    public void setChemin(String chemin) {
        this.chemin = chemin;
    }
}
