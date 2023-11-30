package edu.example.uplant.data.data_sources.category.models;

import java.util.ArrayList;

public class NapPlantModel {
    private int plantid;
    private String idemail;
    private int idcateg;
    private String plantname;
    private String desc;

    public String getIdemail() {
        return idemail;
    }

    public void setIdemail(String idemail) {
        this.idemail = idemail;
    }

    private long time;

    public int getPlantid() {
        return plantid;
    }

    public int getIdcateg() {
        return idcateg;
    }

    public String getPlantname() {
        return plantname;
    }

    public String getDesc() {
        return desc;
    }

    public long getTime() {
        return time;
    }



    public NapPlantModel(int plantid, String idemail, int idcateg, String plantname, String desc, long time) {
        this.idemail=idemail;
        this.plantid = plantid;
        this.idcateg = idcateg;
        this.plantname = plantname;
        this.desc = desc;
        this.time = time;
    }
    public NapPlantModel() { }
}
