package com.company;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Pratama Agung on 6/23/2017.
 */
public class DetailPanel extends JPanel {
    private JTextArea detail;
    private JLabel title;

    public DetailPanel(){
        this.setLayout(new GridLayout(3,1));
        title = new JLabel("", JLabel.CENTER);
        this.add(title);

        detail = new JTextArea();
        detail.setEditable(false);
        JScrollPane scroll = new JScrollPane(detail);
        this.add(scroll);
        this.setBackground(Color.WHITE);
        this.setBorder(BorderFactory.createEmptyBorder(15,15,15,15));
    }

    public void setResult(String username, Repo[] repos) {
        title.setText("This is the list of repository owned by " + username);
        for(int i = 0; i < repos.length; i++){
            detail.append(Integer.toString(i) + ".\n");
            detail.append("Name: " + repos[i].getName() + "\n");
            detail.append("Description: " + repos[i].getDescription() + "\n");
            detail.append("URL: " + repos[i].getUrl() + "\n");
            detail.append("\n");
        }
    }
}
