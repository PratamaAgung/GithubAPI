package com.company.view;

import com.company.model.User;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Pratama Agung on 6/18/2017,
 * berfungsi untuk menampilkan view hasil pencarian.
 */
public class ResultPanel extends JPanel {
    private JLabel [] result;
    private JButton [] viewButton;
    private JButton backButton;

    /**
     * Constructor untuk kelas ResultPanel.
     */
    public ResultPanel(){
        this.setLayout(new GridLayout(3,1));
        JLabel title = new JLabel("Result", JLabel.CENTER);
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
        this.add(title);

        JPanel contentPanel = new JPanel(new GridLayout(5,2));
        contentPanel.setBorder(BorderFactory.createEmptyBorder(5,25,5,25));
        result = new JLabel[5];
        viewButton = new JButton[5];
        for(int i = 0; i < 5; i++){
            result[i] = new JLabel("", JLabel.CENTER);
            viewButton[i] = new JButton("Details");
            contentPanel.add(result[i]);
            contentPanel.add(viewButton[i]);
        }

        JPanel controlPanel = new JPanel(new GridLayout(3, 2));
        controlPanel.setBorder(BorderFactory.createEmptyBorder(5,25,5,25));
        backButton = new JButton("Back");
        controlPanel.add(backButton);
        controlPanel.setBackground(Color.WHITE);

        this.add(contentPanel);
        this.add(controlPanel);
        this.setBackground(Color.WHITE);
    }

    /**
     * Method untuk menampilkan hasil pencarian.
     * @param res list user hasil pencarian.
     */
    public void setResult(User[] res) {
        for(int i = 0; i < res.length && i < 5; i++){
            result[i].setText(res[i].getName());
            result[i].setVisible(true);
            viewButton[i].setVisible(true);
        }
        if (res.length < 5) {
            for (int i = res.length; i < 5; i++) {
                result[i].setVisible(false);
                viewButton[i].setVisible(false);
            }
        }
    }

    public String getUserName(int index) {
        return result[index].getText();
    }

    public JButton getDetailButton(int index) {
        return viewButton[index];
    }

    public JButton getBackButton(){
        return backButton;
    }
}
