package com.company;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Pratama Agung on 6/18/2017.
 */
public class ResultPanel extends JPanel {
    private JLabel [] result;
    private JButton [] viewButton;

    public ResultPanel(){
        this.setLayout(new GridLayout(3,1));
        JLabel title = new JLabel("Result", JLabel.CENTER);
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
        this.add(contentPanel);
        this.setBackground(Color.WHITE);
    }

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
}
