public class main {
    public static void main(String[] args){

        DataBase db = new DataBase();

        db.init();

        Biens b = new Biens ("4f rue des arabesques", "974", "Poitiers", 2033.99,1752, "Beau batiment hein, oeoe", false);
        //b.createNAddPiece(15,"Salon");

        try{
            db.uploadBien(b);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}
