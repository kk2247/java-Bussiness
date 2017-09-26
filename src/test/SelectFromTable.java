//package test;
//
//import sample.PersonInformation;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.Date;
//
//public class SelectFromTable {
//    private String database;
//
//    public SelectFromTable(String database) {
//        this.database = database;
//    }
//    public PersonInformation searchPersonlaInformationByID(String ID){
//        try {
//            ConnectToMysql con=new ConnectToMysql(database);
//            Connection connection=con.getCon();
//            String sql="select * from person_information where IDnumber = '"+ID+"'";
//            PreparedStatement preparedStatement=(PreparedStatement)connection.prepareStatement(sql);
//            ResultSet resultSet=preparedStatement.executeQuery();
//            int col=resultSet.getMetaData().getColumnCount();
//            while(resultSet.next()){
//                    if(col==15){
//                        PersonInformation personInformation=new PersonInformation(resultSet.getString(1),
//                                resultSet.getString(2),resultSet.getString(3),
//                                resultSet.getString(4),
//                                Integer.parseInt(resultSet.getString(5)),
//                                Integer.parseInt(resultSet.getString(6)),
//                                Integer.parseInt(resultSet.getString(7)),
//                                resultSet.getString(8),resultSet.getString(9),
//                                resultSet.getString(10),resultSet.getString(11)
//                                ,resultSet.getString(12),resultSet.getString(13)
//                                ,resultSet.getString(14),resultSet.getString(15));
//                        return personInformation;
//                    }
//            }
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//}
