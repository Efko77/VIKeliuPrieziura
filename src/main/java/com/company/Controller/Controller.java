package com.company.Controller;

import com.company.Main.DBSingleton;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;


public class Controller {

    public Button button1;
    public TextArea isvedimoLaukas;


    public void handleButton1(ActionEvent actionEvent) {
        String uzklausa = "SELECT * FROM `done_jobs`\n" +
                "WHERE `road_length` is not null\n" +
                "order by `done_job_data`";
        String atsakymas = DBSingleton.getInstance().printQueryResult(uzklausa);
        isvedimoLaukas.appendText(atsakymas + "\n");

    }

    public void handleButton2(ActionEvent actionEvent) {
        String uzklausa = "SELECT * FROM `road_section` LEFT JOIN `done_jobs`\n" +
                "ON `road_section`.`section_id` = `done_jobs`.`section_id`\n" +
                "LEFT JOIN `done_jobs`\n" +
                "ON `road_section`.`section_id` = `done_jobs`.`section_id`\n" +
                "WHERE `note` is null\n" +
                "order by `job_name`";
        String atsakymas = DBSingleton.getInstance().printQueryResult(uzklausa);
        isvedimoLaukas.appendText(atsakymas + "\n");

    }


}