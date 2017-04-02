/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dbcon;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Ravi
 */
public class dbCon {
    public static Connection con;
    public static Statement st;
    public static PreparedStatement addUser;
     public static PreparedStatement checkAdmin;
      public static PreparedStatement getUser;
       public static PreparedStatement updateUser;
        public static PreparedStatement deleteUser;
         public static PreparedStatement getUserLikeN;
          public static PreparedStatement getUserLikeG;
           public static PreparedStatement getUserLikeA;
            public static PreparedStatement getUserLikeC;
             public static PreparedStatement getUserLikeS;
             public static PreparedStatement getTable;
             public static PreparedStatement getUsers;
             static{
                 try{
                     Class.forName("oracle.jdbc.driver.OracleDriver");
                     con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","ravip1","ravip1");
                     st=con.createStatement();
                     addUser=con.prepareStatement("insert into register (name,gen,dob,adr,"
                     +"skills,country )values(?,?,?,?,?,?)");
                     getUser=con.prepareStatement("select * from register where id like ?");
                     getUsers=con.prepareStatement("select * from register order by id asc");
                     
                     getUserLikeN=con.prepareStatement("select * from register where (lower(name) like ? )or (upper(name) like ? )order by id asc");
                     getUserLikeG=con.prepareStatement("select * from register where (lower(gen) like ? )or (upper(gen) like ? )order by id asc");
                     getUserLikeA=con.prepareStatement("select * from register where (lower(adr) like ? )or (upper(adr) like ? )order by id asc");
                     getUserLikeC=con.prepareStatement("select * from register where (lower(country) like ? )or (upper(country) like ? )order by id asc");
                     getUserLikeS=con.prepareStatement("select * from register where (lower(skills) like ? )or (upper(skills) like ? )order by id asc");
                     //similarly we can use more prepared statements to search for thr the difffernet atributes
                     
                     updateUser=con.prepareStatement("update userinfo set name=?,gen=?,dob=?,adr=?,skills=?,country=? where userid=?");
                     deleteUser=con.prepareStatement("delete from userinfo where userid=?");
                     checkAdmin=con.prepareStatement("select * from admin_login where name=? and pass=?");
                     getTable=con.prepareStatement("select * from userinfo where userid=1");
                 }
                 catch(Exception e){
                     JOptionPane.showMessageDialog(null,e);
                    e.printStackTrace();
                 }
             }
             
             
}
