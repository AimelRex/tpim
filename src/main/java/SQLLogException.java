import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDateTime;

public class SQLLogException extends Exception{

    private LocalDateTime date;
    private int id;


    public SQLLogException(String message) {
        super(message);
        this.date = LocalDateTime.now();
        this.uploadLog();
    }

    private void uploadLog(){
        //DB de logs
        String LOGS_DB_URL = "jdbc:mysql://172.19.0.38/logsTpImmo";
        String LOGS_USER = "logsTpImmo";
        String LOGS_PASS = "qtv532ERaRnA2p22";

        try {
            Connection conn = DriverManager.getConnection(LOGS_DB_URL, LOGS_USER, LOGS_PASS);
            Statement stmt = conn.createStatement();
            String str = "INSERT INTO `Logs`(`message`, `stackTrace`, `date`) VALUES ('"+this.getMessage()+"','"+this.getStackTrace().toString()+"','"+this.getDate()+"')";
            stmt.execute(str);
        } catch (Exception e){
            System.out.println("L'upload de la log s'est mal passé : "+e.getMessage());
            e.printStackTrace();
        }
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setId(int _id){
        this.id = _id;
    }

    public int getId(){
        return this.id;
    }


}
