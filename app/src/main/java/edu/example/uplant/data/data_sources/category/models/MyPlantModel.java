package edu.example.uplant.data.data_sources.category.models;

public class MyPlantModel {
    private int plantid;

    public String getPeresadka() {
        return peresadka;
    }

    private int idcateg;
    private String plantname;
    private String descr;
    private String poliv;
    private String peresadka;
    private String udobr;
    private String vlaga;
    private String descrplant;
    private String polivplant;
    private String peresadkaplant;
    private String udobrplant;
    private String nameimage;
    private boolean favorite;
    private String razmnozh;
    private String obrez;
    private String zash;
    private String svet;
    private String tempa;

    public String getRazmnozh() {return razmnozh;}

    public void setRazmnozh(String razmnozh) {this.razmnozh = razmnozh;}

    public String getObrez() {return obrez;}

    public void setObrez(String obrez) {this.obrez = obrez;}

    public String getZash() {return zash;}

    public void setZash(String zash) {this.zash = zash;}

    public String getSvet() {return svet;}

    public void setSvet(String svet) {this.svet = svet;}

    public String getTempa() {return tempa;}

    public void setTempa(String tempa) {this.tempa = tempa;}

    public String getVlaga() {return vlaga;}

    public void setVlaga(String vlaga) {this.vlaga = vlaga;}

    public int getPlantid() {return plantid;}

    public int getIdcateg() {return idcateg;}

    public String getPlantname() {return plantname;}

    public String getDescr() {return descr;}

    public String getPoliv() {return poliv;}

    public String getUdobr() {return udobr;}

    public String getDescrplant() {return descrplant;}

    public String getPolivplant() {return polivplant;}

    public String getPeresadkaplant() {return peresadkaplant;}

    public String getUdobrplant() {return udobrplant;}

    public String getNameimage() {return nameimage;}

    public boolean isFavorite() {return favorite;}


    public MyPlantModel(int plantid, int idcateg, String plantname, String descr, String poliv, String peresadka, String udobr, String razmnozh, String obrez, String zash, String svet, String tempa, String vlaga, String descrplant, String polivplant, String peresadkaplant, String udobrplant, String nameimage, boolean favorite) {
        this.plantid = plantid;
        this.idcateg = idcateg;
        this.plantname = plantname;
        this.descr = descr;
        this.poliv = poliv;
        this.peresadka=peresadka;
        this.udobr = udobr;
        this.razmnozh=razmnozh;
        this.obrez=obrez;
        this.zash=zash;
        this.svet=svet;
        this.tempa=tempa;
        this.vlaga=vlaga;




        this.descrplant = descrplant;
        this.polivplant = polivplant;
        this.peresadkaplant = peresadkaplant;
        this.udobrplant = udobrplant;
        this.nameimage = nameimage;
        this.favorite = favorite;
    }


}
