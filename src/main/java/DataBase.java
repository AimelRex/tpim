import java.sql.*;
import java.util.ArrayList;

public class DataBase {
    //DB de base pour gérer les biens
    private static final String DB_URL = "jdbc:mysql://172.19.0.38/tpImmo";
    private static final String USER = "tpImmo";
    private static final String PASS = "v@$4E27q!tNfbTgo";

    //DB de logs
    private static final String LOGS_DB_URL = "jdbc:mysql://172.19.0.38/logsTpImmo";
    private static final String LOGS_USER = "logsTpImmo";
    private static final String LOGS_PASS = "qtv532ERaRnA2p22";

    //les biens affichés
    private ArrayList<Biens> lesBiens = new ArrayList<Biens>();

    public void init(){
        //load les 5 premiers biens
        try{
            loadBiens(0);
        } catch (SQLLogException e){
            System.out.println(e.getMessage());
        }
    }

    //on va load les biens selon un offset et limit
    //et on load récursivement
    public void loadBiens(int offset) throws SQLLogException{
        //on cherche les x premiers biens
        //on load les photos des biens qu'on attribue aux pièces
        // on load les pièces de chaque bien, les équipements de chaque pièce
        //une fois tout chargé, on dl la première image de chaque bien
        //Qu'on affiche

        //Bien penser à delete tout quand on quitte le,
        // ou meme mieux, on delete tout quand on arrive et après on load

        try{

            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
            String str = "SELECT * FROM biens LIMIT " + offset + ", "+ (offset+5);
            ResultSet rs = stmt.executeQuery(str);
            while (rs.next()) {
                //Ici on fait un bien
                Biens b = new Biens(rs.getInt("id"),rs.getString("rue"),rs.getString("cp"),rs.getString("ville"),rs.getFloat("prix"),rs.getInt("anneeConstru"),rs.getString("description"),rs.getBoolean("libre"));

                //faut chopper les pièces du bien
                Statement stmtPiece = conn.createStatement();
                ResultSet rsPiece = stmtPiece.executeQuery("SELECT * FROM pieces WHERE id_biens="+b.getId());
                while(rsPiece.next()){
                    //pièces du bien
                    Piece p = new Piece(rsPiece.getInt("id"),rsPiece.getFloat("surface"),rsPiece.getString("libelle"), rsPiece.getInt("id_biens"));

                    //mtn faut les équipements de la pièce
                    Statement stmtEquipement = conn.createStatement();
                    ResultSet rsEquipement = stmtEquipement.executeQuery("SELECT * FROM equipements WHERE id_pieces="+p.getId());
                    while(rsEquipement.next()){
                        //équipements de la pièce
                        Equipements equ = new Equipements(rsEquipement.getInt("id"),rsEquipement.getString("libelle"),rsEquipement.getInt("id_pieces"));

                        p.addEquipement(equ);
                    }

                    //on peut enfin ajouter la pièce au bien
                    b.addPiece(p);
                }
                lesBiens.add(b);
            }

        } catch (SQLException e) {
            throw new SQLLogException("Erreur lors du chargement des biens. " + e.getMessage());
        }
        //les photos, on recup les photos d'un bien, on check si id_pièce est nul si oui on l'ajoute juste au bien, si non on check si id_equipement....
        //genre SELECT ... WHERE id_biens = id   genre on prend que ceux de la liste !
    }

    //ordre Bien>piece>equipement   photos
    public void uploadBien(Biens b) throws SQLLogException{
        if(b.getId() != -1){
            //le bien a déja été upload, il a déjà un id
            throw new SQLLogException("Erreur : tentative d'upload d'un bien ayant déjà un id. ");

            // peut être dans ce cas, l'update ??
        } else {
            try {
                Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                //on ajoute le bien
                PreparedStatement pstmt = conn.prepareStatement("INSERT INTO `biens`(`rue`, `cp`, `ville`, `prix`, `anneeConstru`, `description`, `libre`) VALUES ( ? , ? , ? , ? , ? , ? , ? )");
                pstmt.setString(1, b.getRue());
                pstmt.setString(2, b.getCp());
                pstmt.setString(3, b.getVille());
                pstmt.setDouble(4, b.getPrix());
                pstmt.setInt(5, b.getAnneeConstru());
                pstmt.setString(6, b.getDescription());
                pstmt.setBoolean(7, b.isLibre());
                pstmt.execute();

                //mtn récupe de l'id du bien pour add les pièces
                pstmt = conn.prepareStatement("SELECT id FROM biens WHERE rue = ? AND cp = ? AND ville = ?");
                pstmt.setString(1, b.getRue());
                pstmt.setString(2, b.getCp());
                pstmt.setString(3, b.getVille());
                ResultSet rs = pstmt.executeQuery();
                rs.next();
                b.setId(rs.getInt("id"));

            } catch (SQLException e) {
                throw new SQLLogException("Erreur lors de l'upload d'un bien. " + e.getMessage());
            }
        }
    }


    public void uploadPiece(Piece p) throws SQLLogException{
        //on prend le bien en param
        if(p.getId() != -1){
            //la pièce a déja été upload, il a déjà un id
            throw new SQLLogException("Erreur : tentative d'upload d'une pièce ayant déjà un id. ");

            // peut être dans ce cas, l'update ??
        } else {
            try{
                Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                //on ajoute le bien
                PreparedStatement pstmt = conn.prepareStatement("INSERT INTO `biens`(`rue`, `cp`, `ville`, `prix`, `anneeConstru`, `description`, `libre`) VALUES ( ? , ? , ? , ? , ? , ? , ? )");


            } catch (SQLException e){
                throw new SQLLogException("Erreur lors de l'upload d'un bien. " + e.getMessage());
            }
        }
    }


    //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! A REVOIR !!!!
    //pour upload un bien
    //
    //on créer un bien (on l'upload)
    //on créer ses pièces (on les upload grâce à l'id du bien)
    //pour chaque pièce on créer les équipements (qu'on upload grâce à l'id de la pièce)
    //
    //
    //
    //ce qui implique qu'on peut update/delete/add
    //
    //update pour chaque ez
    //
    //add pour chaque ez
    //
    //delete : delete récursif, on recupe les equipements qu'on supprime après les pièces après le bats


















    //Faut que je me mette d'accord sur la méthode
    //soit : on créer chaque un bien qu'on upload on récupe son id, après on créer une pièce du bien





}
