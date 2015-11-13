package com.example.android.buktogo;

/**
 * Created by jan on 11/10/15.
 */
public class RowItem {

    private String title;
    private String description;
    private int icon;

    public RowItem(String title, String description, int icon) {
        this.title = title;
        this.description = description;
        this.icon = icon;

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

}