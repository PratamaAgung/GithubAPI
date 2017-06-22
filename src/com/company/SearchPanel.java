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
    private JTextField userSearch;
    private JComboBox searchIn;
    private JCheckBox follower;
    private JSlider followMin;
    private JCheckBox repository;
    private JSlider repoMin;

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

        userSearch = new JTextField();
        gbc.gridy = 1;
        gbc.gridwidth = 8;
        gbc.weightx = gbc.weighty = 0.0;
        controlPanel.add(userSearch, gbc);

        String [] option = {"Username", "Email", "Name"};
        searchIn= new JComboBox(option);
        gbc.gridx = 8;
        gbc.gridwidth = 3;
        controlPanel.add(searchIn, gbc);
    }
    private void setFilterField(){
        follower = new JCheckBox();
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

        followMin = new JSlider(0,100);
        followMin.setMinorTickSpacing(5);
        followMin.setMajorTickSpacing(20);
        followMin.setPaintTicks(true);
        followMin.setPaintLabels(true);
        gbc.gridy = 3;
        gbc.gridx = 1;
        gbc.gridwidth = 4;
        controlPanel.add(followMin, gbc);

        repository = new JCheckBox();
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

        repoMin = new JSlider(0,100);
        repoMin.setMinorTickSpacing(5);
        repoMin.setMajorTickSpacing(20);
        repoMin.setPaintTicks(true);
        repoMin.setPaintLabels(true);
        gbc.gridy = 3;
        gbc.gridx = 6;
        gbc.gridwidth = 4;
        controlPanel.add(repoMin, gbc);

        searchButton = new JButton("Search");
        gbc.gridy = 4;
        gbc.gridx = 0;
        gbc.gridwidth = 10;
        controlPanel.add(searchButton, gbc);
    }

    public JButton getSearchButton(){
        return searchButton;
    }

    public String getUser(){
        return userSearch.getText();
    }

    public int getSearchIn(){
        return searchIn.getSelectedIndex();
    }

    public boolean isFilterFollower(){
        return follower.isSelected();
    }

    public int getMinFollower(){
        return followMin.getValue();
    }

    public boolean isFilterRepo(){
        return repository.isSelected();
    }

    public int getMinRepo(){
        return repoMin.getValue();
    }
}
