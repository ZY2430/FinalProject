package wuzi;

import javax.swing.*; 
  
import java.awt.event.*; 
import java.awt.*; 
/* 
 * 五子棋的主框架，程序启动类 
 */
public class StartChessJFrame extends JFrame { 
 private ChessBoard chessBoard;//对战面板 
 private Panel toolbar;//工具条面板 
 private Button startButton;//设置开始按钮 
 private Button backButton;//设置悔棋按钮 
 private Button exitButton;//设置退出按钮 
  
   
 public StartChessJFrame() { 
  setTitle("单机版五子棋");//设置标题 
  chessBoard=new ChessBoard();//初始化面板对象，创建和添加菜单 
  MyItemListener lis=new MyItemListener();//初始化按钮事件监听器内部类 
  toolbar=new Panel();//工具面板栏实例化 
  startButton=new Button("重新开始"); 
  backButton=new Button("悔棋"); 
  exitButton=new Button("退出");//三个按钮初始化 
  toolbar.setLayout(new FlowLayout(FlowLayout.LEFT));//将工具面板按钮用FlowLayout布局 
  toolbar.add(backButton); 
  toolbar.add(startButton); 
  toolbar.add(exitButton);//将三个按钮添加到工具面板上 
  startButton.addActionListener(lis); 
  backButton.addActionListener(lis); 
  exitButton.addActionListener(lis);//将三个按钮事件注册监听事件 
  add(toolbar,BorderLayout.SOUTH);//将工具面板布局到界面南方也就是下面 
  add(chessBoard);//将面板对象添加到窗体上 
  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//设置界面关闭事件 
  pack();//自适应大小 
 } 
 private class MyItemListener implements ActionListener{ 
  public void actionPerformed(ActionEvent e) { 
   Object obj=e.getSource();//获取事件源 
   if(obj==startButton){ 
    System.out.println("重新开始...");//重新开始 
    //JFiveFrame.this内部类引用外部类 
    chessBoard.restartGame(); 
   }else if(obj==exitButton){ 
    System.exit(0);//结束应用程序 
   }else if(obj==backButton){ 
    System.out.println("悔棋...");//悔棋 
    chessBoard.goback(); 
   }    
  }   
 } 
 
} 

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
        chessBoard = new ChessBoard();//intialize the chess board初始化面板对象，创建和添加菜单
        MyItemListener lis = new MyItemListener();//construct and initialize the inner action listener class初始化按钮事件监听器内部类
        toolbar = new Panel();//the instantiation of the tool bar工具面板栏实例化
        startButton = new Button("Restart");
        backButton = new Button("undo");
        exitButton = new Button("undo");//initialize the three buttons
        toolbar.setLayout(new FlowLayout(FlowLayout.LEFT));//将工具面板按钮用FlowLayout布局
        toolbar.add(backButton);
        toolbar.add(startButton);
        toolbar.add(exitButton);//add three buttons into the toolbar将三个按钮添加到工具面板上
        startButton.addActionListener(lis);
        backButton.addActionListener(lis);
        exitButton.addActionListener(lis);//add each button an ActionListener将三个按钮事件注册监听事件
        add(toolbar, BorderLayout.SOUTH);//use the Border lay out and add the toolbar将工具面板布局到界面南方也就是下面
        add(chessBoard);//add the main chess board to the frame将面板对象添加到窗体上
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//set the close operation 设置界面关闭事件
        pack();//self-adapted the size of frame自适应大小
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
                //JFiveFrame.this内部类引用外部类
                chessBoard.restartGame();
                //Restart the whole game
            } else if (obj == exitButton) {
                // the exit button was clicked
                System.exit(0);// exit the program
            } else if (obj == backButton) {
                //the back button was clicked
                System.out.println("Undo...");//undo the last step悔棋
                chessBoard.goback();
                //now it's back to the last step
            }
        }
    }

}
