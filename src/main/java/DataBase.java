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
        try{
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            //on ajoute le bien
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO `biens`(`rue`, `cp`, `ville`, `prix`, `anneeConstru`, `description`, `libre`) VALUES ( ? , ? , ? , ? , ? , ? , ? )");
            pstmt.setString(1,b.getRue());
            pstmt.setString(2,b.getCp());
            pstmt.setString(3,b.getVille());
            pstmt.setDouble(4,b.getPrix());
            pstmt.setInt(5,b.getAnneeConstru());
            pstmt.setString(6,b.getDescription());
            pstmt.setBoolean(7,b.isLibre());
            pstmt.execute();

            //mtn récupe de l'id du bien pour add les pièces
            Statement stmt = conn.createStatement();
            String str = "SELECT * FROM biens LIMIT "; //rue cp ville
            ResultSet rs = stmt.executeQuery(str);






        } catch (SQLException e){
            throw new SQLLogException("Erreur lors de l'upload d'un bien. " + e.getMessage());
        }
    }





}
