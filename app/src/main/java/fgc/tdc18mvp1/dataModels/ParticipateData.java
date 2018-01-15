package fgc.tdc18mvp1.dataModels;

/**
 * Created by Aditya on 12/29/2017.
 */

public class ParticipateData {
    public int part_pic_step_vector, part_pic_status_icon, part_status_color, part_status_flag, part_string_step_no;
    public String part_string_step_name, part_string_step_desc;

    public ParticipateData(int part_pic_step_vector, int part_pic_status_icon, int part_status_color, int part_status_flag, int part_string_step_no, String part_string_step_name, String part_string_step_desc) {
        this.part_pic_step_vector = part_pic_step_vector;
        this.part_pic_status_icon = part_pic_status_icon;
        this.part_status_color = part_status_color;
        this.part_status_flag = part_status_flag;   //1 - No data, 2- Submision in progress, 3 - Submiteed, 4- Sent to cloud, 5- Acceptedo
        this.part_string_step_no = part_string_step_no;
        this.part_string_step_name = part_string_step_name;
        this.part_string_step_desc = part_string_step_desc;
    }

    public int getPart_pic_step_vector() {
        return part_pic_step_vector;
    }

    public void setPart_pic_step_vector(int part_pic_step_vector) {
        this.part_pic_step_vector = part_pic_step_vector;
    }

    public int getPart_pic_status_icon() {
        return part_pic_status_icon;
    }

    public void setPart_pic_status_icon(int part_pic_status_icon) {
        this.part_pic_status_icon = part_pic_status_icon;
    }

    public int getPart_status_color() {
        return part_status_color;
    }

    public void setPart_status_color(int part_status_color) {
        this.part_status_color = part_status_color;
    }

    public int getPart_status_flag() {
        return part_status_flag;
    }

    public void setPart_status_flag(int part_status_flag) {
        this.part_status_flag = part_status_flag;
    }

    public int getPart_string_step_no() {
        return part_string_step_no;
    }

    public void setPart_string_step_no(int part_string_step_no) {
        this.part_string_step_no = part_string_step_no;
    }

    public String getPart_string_step_name() {
        return part_string_step_name;
    }

    public void setPart_string_step_name(String part_string_step_name) {
        this.part_string_step_name = part_string_step_name;
    }

    public String getPart_string_step_desc() {
        return part_string_step_desc;
    }

    public void setPart_string_step_desc(String part_string_step_desc) {
        this.part_string_step_desc = part_string_step_desc;
    }
}
