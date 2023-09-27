import java.sql.*;
public class DataBase {
    static final String DB_URL = "jdbc:mysql://172.19.0.38/tpImmo";
    static final String USER = "tpImmo";
    static final String PASS = "v@$4E27q!tNfbTgo";

    public void init(){
        //load les 5 premiers biens

        loadBiens(0);

    }

    //on va load les biens selon un offset et limit
    //et on load récursivement
    public void loadBiens(int offset){
        //on cherche les x premiers biens
        //on load les photos des biens qu'on attribue aux pièces
        // on load les pièces de chaque bien, les équipements de chaque pièce
        //une fois tout chargé, on dl la première image de chaque bien
        //Qu'on affiche

        //Bien penser à delete tout quand on quitte le,
        // ou meme mieux, on delete tout quand on arrive et après on load

        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM biens LIMIT");) {

            while (rs.next()) {

                System.out.print("ID: " + rs.getInt("id"));
                System.out.print(", Prénom: " + rs.getString("Prenom"));
                System.out.println(", Nom: " + rs.getString("Nom"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



}
