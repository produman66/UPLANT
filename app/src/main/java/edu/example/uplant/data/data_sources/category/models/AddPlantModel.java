package edu.example.uplant.data.data_sources.category.models;

public class AddPlantModel {
    private int id;
    private String iduser;
    private String name;
    private String desc;

    public int getId() {return id;}

    public void setId(int id) {this.id = id;}

    private String poliv;
    private String peresad;
    private String udobr;
    private String nameimage;
    private String zametky;

    public String getIduser() {
        return iduser;
    }

    public void setIduser(String iduser) {
        this.iduser = iduser;
    }

    public String getName() {return name;}

    public String getDesc() {return desc;}

    public String getPoliv() {return poliv;}

    public String getPeresad() {return peresad;}

    public String getUdobr() {return udobr;}

    public String getNameimage() {
        return nameimage;
    }

    public String getZametky() {return zametky;}


    public AddPlantModel(int id, String iduser, String name, String desc, String poliv, String peresad, String udobr, String nameimage, String zametky) {
        this.id = id;
        this.iduser = iduser;
        this.name=name;
        this.desc=desc;
        this.poliv=poliv;
        this.peresad=peresad;
        this.udobr=udobr;
        this.nameimage=nameimage;
        this.zametky=zametky;
    }
}
