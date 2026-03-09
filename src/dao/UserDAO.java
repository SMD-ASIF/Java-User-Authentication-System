package dao;

import database.DBConnection;
import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {
    //inserting users
    public boolean registerUser(User user){
        String sql = "Insert into users(username,email,password)values(?,?,?)";
        try{
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, user.getUsername());
            ps.setString(2,user.getEmail());
            ps.setString(3,user.getPassword());

            ps.executeUpdate();

            return true;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    //check if user exists
    public boolean loginUser(String username ,String password){
        String sql = "Select * from users where username=? AND password=?";
        try{
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1,username);
            ps.setString(2,password);

            ResultSet rs = ps.executeQuery();

            return rs.next();
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public boolean emailExists(String email){
        String sql = "Select * from users where email=?";
        try{
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, email);

            ResultSet rs = ps.executeQuery();

            return rs.next();

        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

}
