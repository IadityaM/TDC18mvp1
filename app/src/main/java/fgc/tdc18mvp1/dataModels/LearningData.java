package fgc.tdc18mvp1.dataModels;

/**
 * Created by Aditya on 12/26/2017.
 */

public class LearningData {
    public int learn_pic_header, learn_pic_endorse;
    public String learn_string_title, learn_string_description, learn_string_duration, learn_string_action;

    public LearningData(int learn_pic_header, int learn_pic_endorse, String learn_string_title, String learn_string_description, String learn_string_duration, String learn_string_action) {
        this.learn_pic_header = learn_pic_header;
        this.learn_pic_endorse = learn_pic_endorse;
        this.learn_string_title = learn_string_title;
        this.learn_string_description = learn_string_description;
        this.learn_string_duration = learn_string_duration;
        this.learn_string_action = learn_string_action;
    }

    public int getLearn_pic_header() {
        return learn_pic_header;
    }

    public void setLearn_pic_header(int learn_pic_header) {
        this.learn_pic_header = learn_pic_header;
    }

    public int getLearn_pic_endorse() {
        return learn_pic_endorse;
    }

    public void setLearn_pic_endorse(int learn_pic_endorse) {
        this.learn_pic_endorse = learn_pic_endorse;
    }

    public String getLearn_string_title() {
        return learn_string_title;
    }

    public void setLearn_string_title(String learn_string_title) {
        this.learn_string_title = learn_string_title;
    }

    public String getLearn_string_description() {
        return learn_string_description;
    }

    public void setLearn_string_description(String learn_string_description) {
        this.learn_string_description = learn_string_description;
    }

    public String getLearn_string_duration() {
        return learn_string_duration;
    }

    public void setLearn_string_duration(String learn_string_duration) {
        this.learn_string_duration = learn_string_duration;
    }

    public String getLearn_string_action() {
        return learn_string_action;
    }

    public void setLearn_string_action(String learn_string_action) {
        this.learn_string_action = learn_string_action;
    }
}
