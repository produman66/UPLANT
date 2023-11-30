package edu.example.uplant.data.data_sources.category.models;

public class MomentModel {
    private int id;

    private int idcateg;


    private String desc;
    private String date;
    private long time;
    private String url;


    public int getId() {
        return id;
    }

    public int getIdcateg() {
        return idcateg;
    }

    public String getDesc() {
        return desc;
    }

    public String getDate() {
        return date;
    }

    public long getTime() {
        return time;
    }

    public String getUrl() {
        return url;
    }

    public MomentModel(int id, int idcateg, String desc, String date, long time, String url) {
        this.id = id;
        this.idcateg = idcateg;
        this.desc = desc;
        this.date = date;
        this.time = time;
        this.url = url;
    }





}
