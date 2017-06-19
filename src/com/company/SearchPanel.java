package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Pratama Agung on 6/16/2017.
 */
public class SearchPanel extends JPanel{
    private JLabel headerLabel;
    private JPanel controlPanel;
    private GridBagConstraints gbc;
    private JButton searchButton;

    public SearchPanel(){
        this.setLayout(new GridLayout(3,1));
        prepareGUI();
        setTitleLabel();
        setUserField();
        setFilterField();
    }

    private void prepareGUI(){
        headerLabel = new JLabel("", JLabel.CENTER);

        controlPanel = new JPanel();
        controlPanel.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();

        this.add(headerLabel);
        this.add(controlPanel);
        this.setBackground(Color.WHITE);
    }

    private void setTitleLabel(){
        headerLabel.setText("GitHUB Search");
        headerLabel.setFont(new Font(headerLabel.getFont().getName(), Font.PLAIN, 20));
        ImageIcon icon = new ImageIcon("src/img/github.png");
        headerLabel.setIcon(icon);
    }

    private void setUserField(){
        JLabel userLabel = new JLabel("Search:");
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 10;
        gbc.gridheight = 1;
        gbc.weightx = gbc.weighty = 0.0;
        gbc.insets = new Insets(5,5,5,5);
        controlPanel.add(userLabel, gbc);

        JTextField userSearch = new JTextField();
        gbc.gridy = 1;
        gbc.gridwidth = 8;
        gbc.weightx = gbc.weighty = 0.0;
        controlPanel.add(userSearch, gbc);

        String [] option = {"Username", "Email", "Name"};
        JComboBox mode = new JComboBox(option);
        gbc.gridx = 8;
        gbc.gridwidth = 3;
        controlPanel.add(mode, gbc);
    }
    private void setFilterField(){
        JCheckBox follower = new JCheckBox();
        gbc.gridy = 2;
        gbc.gridx = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 2;
        controlPanel.add(follower, gbc);

        JLabel followMinLabel = new JLabel("Minimum Follower");
        gbc.gridheight = 1;
        gbc.gridx = 1;
        gbc.gridwidth = 2;
        controlPanel.add(followMinLabel, gbc);

        JLabel followMaxLabel = new JLabel("Maximum Follower");
        gbc.gridx = 3;
        gbc.gridwidth = 2;
        controlPanel.add(followMaxLabel, gbc);

        JSlider followMin = new JSlider(0,100);
        followMin.setMinorTickSpacing(5);
        followMin.setMajorTickSpacing(20);
        followMin.setPaintTicks(true);
        followMin.setPaintLabels(true);
        gbc.gridy = 3;
        gbc.gridx = 1;
        gbc.gridwidth = 2;
        controlPanel.add(followMin, gbc);

        JSlider followMax = new JSlider(0,100);
        followMax.setMinorTickSpacing(5);
        followMax.setMajorTickSpacing(20);
        followMax.setPaintTicks(true);
        followMax.setPaintLabels(true);
        gbc.gridx = 3;
        controlPanel.add(followMax, gbc);

        JCheckBox repository = new JCheckBox();
        gbc.gridy = 2;
        gbc.gridx = 5;
        gbc.gridwidth = 1;
        gbc.gridheight = 2;
        controlPanel.add(repository, gbc);

        JLabel repoMinLabel = new JLabel("Minimum Repository");
        gbc.gridheight = 1;
        gbc.gridx = 6;
        gbc.gridwidth = 2;
        controlPanel.add(repoMinLabel, gbc);

        JLabel repoMaxLabel = new JLabel("Maximum Repository");
        gbc.gridx = 8;
        gbc.gridwidth = 2;
        controlPanel.add(repoMaxLabel, gbc);

        JSlider repoMin = new JSlider(0,100);
        repoMin.setMinorTickSpacing(5);
        repoMin.setMajorTickSpacing(20);
        repoMin.setPaintTicks(true);
        repoMin.setPaintLabels(true);
        gbc.gridy = 3;
        gbc.gridx = 6;
        gbc.gridwidth = 2;
        controlPanel.add(repoMin, gbc);

        JSlider repoMax = new JSlider(0,100);
        repoMax.setMinorTickSpacing(5);
        repoMax.setMajorTickSpacing(20);
        repoMax.setPaintTicks(true);
        repoMax.setPaintLabels(true);
        gbc.gridx = 8;
        controlPanel.add(repoMax, gbc);

        searchButton = new JButton("Search");
        gbc.gridy = 4;
        gbc.gridx = 0;
        gbc.gridwidth = 10;
        controlPanel.add(searchButton, gbc);
    }

    public JButton getSearchButton(){
        return searchButton;
    }
}
