package fgc.tdc18mvp1.dataModels;

import android.content.Intent;

/**
 * Created by Aditya on 1/21/2018.
 */

public class NavDrawData {

    public int nav_pic_icon;
    public String nav_string_title;
    public Intent nav_drawer_intent;


    public NavDrawData(int nav_pic_icon, String nav_string_title, Intent nav_drawer_intent) {
        this.nav_pic_icon = nav_pic_icon;
        this.nav_string_title = nav_string_title;
        this.nav_drawer_intent = nav_drawer_intent;
    }

    public int getNav_pic_icon() {
        return nav_pic_icon;
    }

    public void setNav_pic_icon(int nav_pic_icon) {
        this.nav_pic_icon = nav_pic_icon;
    }

    public String getNav_string_title() {
        return nav_string_title;
    }

    public void setNav_string_title(String nav_string_title) {
        this.nav_string_title = nav_string_title;
    }

    public Intent getNav_drawer_intent() {
        return nav_drawer_intent;
    }

    public void setNav_drawer_intent(Intent nav_drawer_intent) {
        this.nav_drawer_intent = nav_drawer_intent;
    }
}
