package com.company.view;

import com.company.model.Repo;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Pratama Agung on 6/23/2017,
 * berfungsi untuk menampilkan view info detail suatu user.
 */
public class DetailPanel extends JPanel {
    private JTextArea detail;
    private JLabel title;

    /**
     * Constructor untuk kelas detailPanel.
     */
    public DetailPanel(){
        this.setLayout(new GridLayout(3,1));
        title = new JLabel("", SwingConstants.CENTER);
        this.add(title);

        detail = new JTextArea();
        detail.setEditable(false);
        JScrollPane scroll = new JScrollPane(detail);
        this.add(scroll);
        this.setBackground(Color.WHITE);
        this.setBorder(BorderFactory.createEmptyBorder(15,15,15,15));
    }

    /**
     * Method untuk menampilkan detail user.
     * @param username username yang dimiliki user tersebut.
     * @param repos list repository dari user tersebut.
     */
    public void setResult(String username, Repo[] repos) {
        title.setText("<html>This is the list of repository owned by " + username + "<br>Repo count: " + repos.length
            + "</html");
        for(int i = 0; i < repos.length; i++){
            detail.append(Integer.toString(i) + ".\n");
            detail.append("Name: " + repos[i].getName() + "\n");
            detail.append("Description: " + repos[i].getDescription() + "\n");
            detail.append("URL: " + repos[i].getUrl() + "\n");
            detail.append("\n");
        }
        detail.setCaretPosition(0);
    }
}
