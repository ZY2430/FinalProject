
package wuzi;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * 五子棋的主框架，程序启动类
 * This class is main frame of connect 6 game
 *It's main functions is to initialize the game
 *CS 151 final project
 * Author: group5
 */

public class StartChessJFrame extends JFrame {

    /**
     * instance variables
     */
    private ChessBoard chessBoard;//the main chess board
    private Panel toolbar;//the tool bar
    private Button startButton;//the start button
    private Button backButton;//set the undo button
    private Button exitButton;//set the exit button

    /**
     * This is the constructor
     */
    public StartChessJFrame() {
        setTitle("The stand-alone version Connect 6");// set the title of this game
        chessBoard = new ChessBoard();//intialize the chess board
        MyItemListener lis = new MyItemListener();//construct and initialize the inner action listener class
        toolbar = new Panel();//the instantiation of the tool bar
        startButton = new Button("Restart");
        backButton = new Button("undo");
        exitButton = new Button("Exit");//initialize the three buttons
        toolbar.setLayout(new FlowLayout(FlowLayout.LEFT));
        toolbar.add(backButton);
        toolbar.add(startButton);
        toolbar.add(exitButton);//add three buttons into the toolbar
        startButton.addActionListener(lis);
        backButton.addActionListener(lis);
        exitButton.addActionListener(lis);//add each button an ActionListener
        add(toolbar, BorderLayout.SOUTH);//use the Border lay out and add the toolbar
        add(chessBoard);//add the main chess board to the frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//set the close operation 
        pack();//self-adapted the size of frame
    }

    /**
     * this inner class is to specifying the actionListener
     */
    private class MyItemListener implements ActionListener {

        /**
         * handle the actionEvent
         *
         * @param e the ActionEvent after clicked certain button
         */
        public void actionPerformed(ActionEvent e) {
            Object obj = e.getSource();//get the source of the actionEvent
            if (obj == startButton) {
                // if the restartButton was clicked
                System.out.println("Restarting...");
                //JFiveFrame.this
                chessBoard.restartGame();
                //Restart the whole game
            } else if (obj == exitButton) {
                // the exit button was clicked
                System.exit(0);// exit the program
            } else if (obj == backButton) {
                //the back button was clicked
                System.out.println("Undo...");//undo the last step
                chessBoard.goback();
                //now it's back to the last step
            }
        }
    }

}
