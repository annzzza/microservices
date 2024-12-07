package fr.insa.soa.userManagementMS.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.UUID;

import fr.insa.soa.userManagementMS.User;

public class UserDAOImplementation implements UserDAO {

    static Connection con = Database.getDBConnection();
    static String table = "user";


    @Override
    public void add(User user) throws SQLException {

        String query = "INSERT INTO " + table + "(id, username, email, status, password) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, user.getId().toString());
        ps.setString(2, user.getUsername());
        ps.setString(3, user.getEmail());
        ps.setString(4, user.getStatus().toString());
        ps.setString(5, user.getPassword());
        ps.executeUpdate();
     }


    @Override
    public void delete(UUID id) throws SQLException {
        String query = "DELETE FROM " + table + " WHERE id_user =?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, id.toString());
        ps.executeUpdate();
    }


    @Override
    public User getUser(UUID id) throws SQLException {
        String query = "SELECT * FROM " + table + " WHERE id_user =?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, id.toString());
        User user = new User("","",User.Status.HELPEE,"");
        ResultSet res = ps.executeQuery();
        boolean check = false;
        while (res.next()){
            check = true;
            user.setId(id);
            user.setUsername(res.getString("username"));
            user.setEmail(res.getString("email"));
            user.setPassword(res.getString("password"));
            user.setStatus(User.Status.valueOf(res.getString("status").toUpperCase()));
        }
        if (check){
            return user;
        } else {
            return null;
        }
    }

    @Override
    public User getUser(String username) throws SQLException {
        String query = "SELECT * FROM " + table + " WHERE username =?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, username);
        User user = new User("","",User.Status.HELPEE,"");
        ResultSet res = ps.executeQuery();
        boolean check = false;
        System.out.println(res);
        while (res.next()){
            check = true;
            user.setId(UUID.fromString(res.getString("id_user")));
            user.setUsername(username);
            user.setEmail(res.getString("email"));
            user.setPassword(res.getString("password"));
            user.setStatus(User.Status.valueOf(res.getString("status").toUpperCase()));
        }
        if (check){
            return user;
        } else {
            return null;
        }
    }


    @Override
    public boolean checkLogin(String username, String password) throws SQLException{
        String query = "SELECT * FROM " + table + " WHERE username =? AND password=?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, username);
        ps.setString(2, password);
        ResultSet res = ps.executeQuery();
        boolean check = false;
        // System.out.println(res);
        while (res.next()){
            check = true;
        }
        return check;
    }


    
    
    @Override
    public ArrayList<User> getAllUsers() throws SQLException {

        String query = "SELECT * FROM " + table;
        PreparedStatement ps = con.prepareStatement(query);
        ArrayList<User> ls = new ArrayList<>();
        ResultSet res = ps.executeQuery();

        while (res.next()){
            User user = new User("","",User.Status.HELPEE,"");
            user.setEmail(res.getString("email"));
            user.setUsername(res.getString("username"));
            user.setPassword(res.getString("password"));
            user.setStatus(User.Status.valueOf(res.getString("status").toUpperCase()));
            ls.add(user);
        }
        return ls;
    }

    @Override
    public void update(User user) throws SQLException {
        String query = "UPDATE " + table + " SET username = ?, email = ?, status = ?, password = ? WHERE id_user = ?";

        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, user.getUsername());
        ps.setString(2, user.getEmail());
        ps.setString(3, user.getStatus().toString());
        ps.setString(4, user.getPassword());
        ps.setString(5, user.getId().toString());
        ps.executeUpdate();
    }
}