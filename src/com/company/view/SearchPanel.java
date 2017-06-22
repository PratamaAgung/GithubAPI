package com.company.view;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

/**
 * Created by Pratama Agung on 6/16/2017,
 * berfungsi menampilkan view pada saat memasukkan input search.
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
    private JLabel statusPanel;

    /**
     * Constructor untuk kelas SearchPanel.
     */
    public SearchPanel(){
        this.setLayout(new GridLayout(3,1));
        prepareGUI();
        setTitleLabel();
        setUserField();
        setFilterField();
    }

    /**
     * Method untuk menambahkan komponen dasar GUI pada kelas ini.
     */
    private void prepareGUI(){
        headerLabel = new JLabel("", JLabel.CENTER);

        controlPanel = new JPanel();
        controlPanel.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();

        statusPanel = new JLabel("", JLabel.CENTER);

        this.add(headerLabel);
        this.add(controlPanel);
        this.add(statusPanel);
        this.setBackground(Color.WHITE);
    }

    /**
     * Method untuk mengatur title label.
     */
    private void setTitleLabel(){
        headerLabel.setText("GitHUB Search");
        headerLabel.setFont(new Font(headerLabel.getFont().getName(), Font.PLAIN, 20));
        ImageIcon icon = new ImageIcon("src/img/github.png");
        headerLabel.setIcon(icon);
    }

    /**
     * Method untuk mengatur field pencarian user.
     */
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

    /**
     * Methos untuk mengatur tampilan filter.
     */
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

        followMin.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                statusPanel.setText("Set minimum follower to " + followMin.getValue());
            }
        });

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

        repoMin.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                statusPanel.setText("Set minimum repository to " + repoMin.getValue());
            }
        });
        searchButton = new JButton("Search");
        gbc.gridy = 4;
        gbc.gridx = 0;
        gbc.gridwidth = 10;
        controlPanel.add(searchButton, gbc);
    }

    /**
     * Method untuk mendapatkan button yang digunkaan untuk memulai searching.
     * @return searchButton.
     */
    public JButton getSearchButton(){
        return searchButton;
    }

    /**
     * Method untuk mendapatkan nama user yang akan dicari.
     * @return string nama user.
     */
    public String getUser(){
        return userSearch.getText();
    }

    /**
     * Method untuk mendapatkan type pencarian user yang dikehendaki.
     * @return 0 : username, 1 : email, 2 : fullname.
     */
    public int getSearchIn(){
        return searchIn.getSelectedIndex();
    }

    /**
     * Method untuk mendapatkan apakah filter follower diaktifkan.
     * @return boolean apakah filter follower diaktifkan.
     */
    public boolean isFilterFollower(){
        return follower.isSelected();
    }

    /**
     * Method untuk mendapatkan jumlah minimum follower yang dikehendaki.
     * @return minimum follower.
     */
    public int getMinFollower(){
        return followMin.getValue();
    }

    /**
     * Method untuk mendapatkan apakah filter repository diaktifkan.
     * @return boolean apakah filter repository aktif.
     */
    public boolean isFilterRepo(){
        return repository.isSelected();
    }

    /**
     * Methos untuk mendapatkan jumlah minimum repository yang dikehendaki
     * @return jumlah minimum repository yang dikehendaki.
     */
    public int getMinRepo(){
        return repoMin.getValue();
    }
}
