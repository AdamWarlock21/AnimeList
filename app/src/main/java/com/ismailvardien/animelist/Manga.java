package com.ismailvardien.animelist;


public class Manga {

    int image;
    String name, team;

    public Manga(int image, String name, String team) {
        this.image = image;
        this.name = name;
        this.team = team;
    }

    public int getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public String getTeam() {
        return team;
    }
}