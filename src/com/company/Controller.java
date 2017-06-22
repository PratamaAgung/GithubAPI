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

    public Controller() {
        searcher = new Search();
    }

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

        DetailPanel detail = new DetailPanel();
        controller.mainFrame.add("detailPage", detail);

        controller.mainView.add(controller.mainFrame);
        controller.mainView.setVisible(true);

        searchPage.getSearchButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String user = searchPage.getUser();
                int searchIn = searchPage.getSearchIn();
                boolean isFollower = searchPage.isFilterFollower();
                int followMin = searchPage.getMinFollower();
                boolean isRepo = searchPage.isFilterRepo();
                int repoMin = searchPage.getMinRepo();
                String url = controller.searcher.urlUserBuilder(user, searchIn, isFollower, followMin, isRepo, repoMin);
                User[] userList;
                userList = controller.searcher.userSearch(url);
                result.setResult(userList);
                CardLayout layout = (CardLayout) controller.mainFrame.getLayout();
                layout.show(controller.mainFrame, "resultPage");
            }
        });

        for (int i = 0; i < 5; i++) {
            int finalI = i;
            result.getDetailButton(finalI).addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String username = result.getUserName(finalI);
                    String url = controller.searcher.urlRepoBuilder(username);
                    Repo [] repos;
                    repos = controller.searcher.searchUserRepo(url);
                    detail.setResult(username, repos);
                    CardLayout layout = (CardLayout) controller.mainFrame.getLayout();
                    layout.show(controller.mainFrame, "detailPage");
                }
            });
        }
    }
}
