package com.company;

import com.company.model.Repo;
import com.company.model.User;
import com.company.view.DetailPanel;
import com.company.view.ResultPanel;
import com.company.view.SearchPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by Pratama Agung on 6/16/2017,
 * berfungsi sebagai controller dalam aplikasi GitHUB API.
 */
public class Controller {
    private JFrame mainView;
    private JPanel mainFrame;
    private Search searcher;
    private SearchPanel searchPage;
    private DetailPanel detail;
    private ResultPanel result;

    /**
     * Constructor untuk kelas Controller.
     */
    public Controller() {
        searcher = new Search();
        mainView = new JFrame("GitHUB User Search");
        mainView.setSize(700,700);
        mainView.setLayout(new GridLayout(1,1));

        mainView.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent){
                System.exit(0);
            }
        });

        mainFrame = new JPanel(new CardLayout());
        searchPage = new SearchPanel();
        mainFrame.add("searchPage", searchPage);

        result = new ResultPanel();
        mainFrame.add("resultPage", result);
        result.getBackButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout layout = (CardLayout) mainFrame.getLayout();
                layout.show(mainFrame, "searchPage");
            }
        });

        detail = new DetailPanel();
        mainFrame.add("detailPage", detail);
        detail.getBackButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout layout = (CardLayout) mainFrame.getLayout();
                layout.show(mainFrame, "resultPage");
            }
        });

        mainView.add(mainFrame);
        mainView.setVisible(true);
    }

    /**
     * Methos main untuk menjalankan program.
     * @param args arguments.
     */
    public static void main(String[] args) {
        Controller controller = new Controller();

        controller.searchPage.getSearchButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String user = controller.searchPage.getUser();
                int searchIn = controller.searchPage.getSearchIn();
                boolean isFollower = controller.searchPage.isFilterFollower();
                int followMin = controller.searchPage.getMinFollower();
                boolean isRepo = controller.searchPage.isFilterRepo();
                int repoMin = controller.searchPage.getMinRepo();
                String url = controller.searcher.urlUserBuilder(user, searchIn, isFollower, followMin, isRepo, repoMin);
                User[] userList;
                userList = controller.searcher.userSearch(url);
                controller.result.setResult(userList);
                CardLayout layout = (CardLayout) controller.mainFrame.getLayout();
                layout.show(controller.mainFrame, "resultPage");
            }
        });

        for (int i = 0; i < 5; i++) {
            int finalI = i;
            controller.result.getDetailButton(finalI).addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String username = controller.result.getUserName(finalI);
                    String url = controller.searcher.urlRepoBuilder(username);

                    Repo[] repos;
                    repos = controller.searcher.searchUserRepo(url);
                    controller.detail.setResult(username, repos);
                    CardLayout layout = (CardLayout) controller.mainFrame.getLayout();
                    layout.show(controller.mainFrame, "detailPage");
                }
            });
        }
    }
}
