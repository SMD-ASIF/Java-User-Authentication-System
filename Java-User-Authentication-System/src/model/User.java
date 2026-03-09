package model;

public class User {
    private int id;
    private String username;
    private String email;
    private String password;

    public User(String username,String email,String password){
        this.username=username;
        this.email=email;
        this.password=password;
    }

    public String getUsername(){
        return username;
    }
    public String getPassword(){
        return password;
    }
    public String getEmail(){
        return email;
    }

}
