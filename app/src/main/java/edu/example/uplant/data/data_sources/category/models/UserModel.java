package edu.example.uplant.data.data_sources.category.models;

public class UserModel {

    private String email;
    private String pass;

    public String getEmail() {return email;}

    public void setEmail(String email) {this.email = email;}

    public String getPass() {return pass;}

    public void setPass(String pass) {this.pass = pass;}


    public UserModel(String email, String pass) {
        this.email = email;
    }


}
