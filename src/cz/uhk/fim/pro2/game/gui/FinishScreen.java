package cz.uhk.fim.pro2.game.gui;

import cz.uhk.fim.pro2.game.ScoreManager;
import cz.uhk.fim.pro2.game.model.World;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class FinishScreen extends Screen {

            JLabel jLabelScore;
            JButton jButtonHome;
            JButton jButtonRetry;

            public FinishScreen(MainFrame mainFrame, World world) {
                super(mainFrame);

                int score = world.getBird().getScore();

                jLabelScore = new JLabel(score + "");
                jButtonHome = new JButton("Home");
                jButtonRetry = new JButton("Retry");
                ScoreManager.putScore(score);

                jLabelScore.setFont(new Font("Arial", Font.BOLD, 40));
                jLabelScore.setForeground(Color.black);
                jLabelScore.setBounds(230, 200, 100, 50);
                jButtonHome.setBounds(100, 400, 280, 50);
                jButtonRetry.setBounds(100, 460, 280, 50);


                add(jButtonRetry);
                add(jButtonHome);
                add(jLabelScore);

                jButtonRetry.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            mainFrame.setScreen(new GameScreen(mainFrame));
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }

                    }
                });

                jButtonHome.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        mainFrame.setScreen(new HomeScreen(mainFrame));
                    }
                });

            }

        }