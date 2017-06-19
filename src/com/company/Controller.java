package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Controller {
    private JFrame mainView;
    private JPanel mainFrame;
    private Search searcher;

    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.mainView = new JFrame("GitHUB User Search");
        controller. mainView.setSize(700,700);
        controller.mainView.setLayout(new GridLayout(1,1));

        controller.mainView.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent){
                System.exit(0);
            }
        });

        controller.mainFrame = new JPanel(new CardLayout());
        SearchPanel searchPage = new SearchPanel();
        controller.mainFrame.add("searchPage", searchPage);

        ResultPanel result = new ResultPanel();
        controller.mainFrame.add("resultPage", result);

        controller.mainView.add(controller.mainFrame);
        controller.mainView.setVisible(true);

        searchPage.getSearchButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout layout = (CardLayout) controller.mainFrame.getLayout();
                layout.show(controller.mainFrame, "resultPage");
                User[] userList;
                userList = Search.Search("https://api.github.com/search/users?q=tom+repos:%3E42+followers:%3E1000");
                for (int i = 0; i < 5 && i < userList.length; i++){
                    result.setResultLabel(i, userList[i].getName());

                }
            }
        });
    }
}
