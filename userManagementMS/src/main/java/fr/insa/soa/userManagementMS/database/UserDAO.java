package fr.insa.soa.userManagementMS.database;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.UUID;

import fr.insa.soa.userManagementMS.User;

public interface UserDAO {

    public void add(User user) throws SQLException;

    public void delete(UUID id) throws SQLException;

    public User getUser(UUID id) throws SQLException;

    public User getUser(String username) throws SQLException;

    public boolean checkLogin(String username, String password) throws SQLException;


    public ArrayList<User> getAllUsers() throws SQLException;

    public void update(User user) throws SQLException;

}