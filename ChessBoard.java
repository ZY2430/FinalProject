package wuzi;

import javax.swing.*; 
  
import java.awt.*; 
import java.awt.event.MouseListener; 
import java.awt.event.MouseMotionListener; 
import java.awt.event.MouseEvent; 
/*Connect Six*/ 
public class ChessBoard extends JPanel implements MouseListener{ 

 Point[] chessList=new Point[(Config.ROWS+1)*(Config.COLS+1)];//Initialize each array element to null
 boolean isBack=true;//Black piece first by default 
 boolean gameOver=false;//Whether the game is over 
 int chessCount;//Number of pieces on the current board 
 int xIndex,yIndex;//The index of the current piece
 public ChessBoard(){ 
  setBackground(Color.LIGHT_GRAY);//Set the background color to yellow 
  addMouseListener(this);//Add event listener
  addMouseMotionListener(new MouseMotionListener() {//Anonymous inner class
     
   @Override 
   public void mouseMoved(MouseEvent e) { 
    int x1=(e.getX()-Config.MARGIN+Config.GRID_SPAN/2)/Config.GRID_SPAN; 
    int y1=(e.getY()-Config.MARGIN+Config.GRID_SPAN/2)/Config.GRID_SPAN;//Convert mouse click coordinate position to grid index 
    if(x1<0||x1>Config.ROWS||y1<0||y1>Config.COLS||gameOver||findChess(x1,y1)){
     setCursor(new Cursor(Cursor.DEFAULT_CURSOR));//Set to default shape 
    }else{ 
     setCursor(new Cursor(Cursor.HAND_CURSOR));//
    } 
   } 
     
   @Override 
   public void mouseDragged(MouseEvent e) { 
   } 
  }); 
 } 
 /*draw*/ 
 public void paintComponent(Graphics g){ 
  super.paintComponent(g);//Draw chess board 
  for(int i=0;i<=Config.ROWS;i++){//Draw horizontal lines
   g.drawLine(Config.MARGIN, Config.MARGIN+i*Config.GRID_SPAN, Config.MARGIN+Config.COLS*Config.GRID_SPAN, Config.MARGIN+i*Config.GRID_SPAN); 
  } 
  for(int i=0;i<=Config.COLS;i++){//Draw a straight line
   g.drawLine(Config.MARGIN+i*Config.GRID_SPAN, Config.MARGIN, Config.MARGIN+i*Config.GRID_SPAN,Config.MARGIN+Config.ROWS*Config.GRID_SPAN); 
  } 
  /*Draw piece*/ 
  for(int i=0;i<chessCount;i++){ 
   int xPos=chessList[i].getX()*Config.GRID_SPAN+Config.MARGIN;//X-coordinates of the grid crossing 
   int yPos=chessList[i].getY()*Config.GRID_SPAN+Config.MARGIN;//Y coordinate of grid crossing 
   g.setColor(chessList[i].getColor());//Set color 
   g.fillOval(xPos-Point.DIAMETER/2, yPos-Point.DIAMETER/2, Point.DIAMETER, Point.DIAMETER); 
   if(i==chessCount-1){ 
    g.setColor(Color.red);//Mark the last pieces in red
    g.drawRect(xPos-Point.DIAMETER/2, yPos-Point.DIAMETER/2, Point.DIAMETER, Point.DIAMETER); 
   } 
  } 
 } 
   
  
  
 @Override 
 public void mousePressed(MouseEvent e) {//Invoked when the mouse button is pressed on a component 
  if(gameOver)//The game is over and cannot be played 
   return ; 
  String colorName=isBack ? "Black Piece" : "White Piece"; 
  xIndex=(e.getX()-Config.MARGIN+Config.GRID_SPAN/2)/Config.GRID_SPAN; 
  yIndex=(e.getY()-Config.MARGIN+Config.GRID_SPAN/2)/Config.GRID_SPAN;//Convert mouse click coordinate position to grid index 
  if(xIndex<0||xIndex>Config.ROWS||yIndex<0||yIndex>Config.COLS)//pieces fall outside the chessboard and cannot be played
   return ; 
  if(findChess(xIndex,yIndex))//There are already pieces in the x and y positions.
   return ; 
    
  Point ch=new Point(xIndex,yIndex,isBack ? Color.black : Color.white); 
  chessList[chessCount++]=ch; 
  repaint();//Notify the system to repaint 
  if(isWin()){ 
   String msg=String.format("Congratulations,%s ~ win the game", colorName); 
   JOptionPane.showMessageDialog(this, msg); 
   gameOver=true;   
  } 
  else if(chessCount==(Config.COLS+1)*(Config.ROWS+1)) 
  { 
   String msg=String.format("A Draw"); 
   JOptionPane.showMessageDialog(this,msg); 
   gameOver=true; 
  } 
  isBack=!isBack; 
 } 
   
 @Override 
 public void mouseClicked(MouseEvent e) {//Called when the mouse button is clicked (pressed and released) on a component 
 } 
  
 @Override 
 public void mouseReleased(MouseEvent e) {////Invoked when the mouse button is released on a component
 } 
  
 @Override 
 public void mouseEntered(MouseEvent e) {//Called when the mouse enters the component
 } 
  
 @Override 
 public void mouseExited(MouseEvent e){//Called when the mouse leaves the component  
 } 
   
 private boolean findChess(int x,int y){ 
  for(Point c:chessList){ 
   if(c!=null&&c.getX()==x&&c.getY()==y) 
    return true; 
  } 
  return false; 
 } 
   
 /*Judge which side wins the game*/ 
 private boolean isWin(){ 
  int continueCount=1;//Number of pieces 
  for(int x=xIndex-1;x>=0;x--){//Look left 
   Color c=isBack ? Color.black : Color.white; 
   if(getChess(x,yIndex,c)!=null){ 
    continueCount++; 
   }else 
    break; 
  } 
  for(int x=xIndex+1;x<=Config.ROWS;x++){//Look right
   Color c=isBack ? Color.black : Color.white; 
   if(getChess(x,yIndex,c)!=null){ 
    continueCount++; 
   }else 
    break; 
  } 
  if(continueCount>=6){//Judging that the number of records is greater than or equal to six, that means the party wins 
   return true; 
  }else 
   continueCount=1; 
  // 
  for(int y=yIndex-1;y>=0;y--){//look up 
   Color c=isBack ? Color.black : Color.white; 
   if(getChess(xIndex,y,c)!=null){ 
    continueCount++; 
   }else 
    break; 
  } 
  for(int y=yIndex+1;y<=Config.ROWS;y++){//look down 
   Color c=isBack ? Color.black : Color.white; 
   if(getChess(xIndex,y,c)!=null){ 
    continueCount++; 
   }else 
    break; 
  } 
  if(continueCount>=6){
   return true; 
  }else 
   continueCount=1; 
  // 
  for(int x=xIndex+1,y=yIndex-1;y>=0&&x<=Config.COLS;x++,y--){
   Color c=isBack ? Color.black : Color.white; 
   if(getChess(x,y,c)!=null){ 
    continueCount++; 
   }else 
    break; 
  } 
  for(int x=xIndex-1,y=yIndex+1;y<=Config.ROWS&&x>=0;x--,y++){ 
   Color c=isBack ? Color.black : Color.white; 
   if(getChess(x,y,c)!=null){ 
    continueCount++; 
   }else 
    break; 
  } 
  if(continueCount>=6){ 
   return true; 
  }else 
   continueCount=1; 
  // 
  for(int x=xIndex-1,y=yIndex-1;y>=0&&x>=0;x--,y--){
   Color c=isBack ? Color.black : Color.white; 
   if(getChess(x,y,c)!=null){ 
    continueCount++; 
   }else 
    break; 
  } 
  for(int x=xIndex+1,y=yIndex+1;y<=Config.ROWS&&x<=Config.COLS;x++,y++){ 
   Color c=isBack ? Color.black : Color.white; 
   if(getChess(x,y,c)!=null){ 
    continueCount++; 
   }else 
    break; 
  } 
  if(continueCount>=6){
   return true; 
  }else 
   continueCount=1; 
  return false;   
 } 
 private Point getChess(int xIndex,int yIndex,Color color){ 
  for(Point c:chessList){ 
   if(c!=null&&c.getX()==xIndex&&c.getY()==yIndex&&c.getColor()==color) 
    return c; 
  } 
  return null; 
 } 
 public void restartGame(){//Clear all the pieces in the board
  for(int i=0;i<chessList.length;i++) 
   chessList[i]=null; 
  /*Restore game-related variables*/
  isBack=true; 
  gameOver=false;//Whether the game is over 
  chessCount=0;//Number of pieces on the current board
  repaint();  
 } 
 public void goback(){ 
  if(chessCount==0) 
   return ; 
  chessList[chessCount-1]=null; 
  chessCount--; 
  if(chessCount>0){ 
   xIndex=chessList[chessCount-1].getX(); 
   yIndex=chessList[chessCount-1].getY(); 
  } 
  isBack=!isBack; 
  repaint(); 
 } 
 //Dimension:rectangle 
 public Dimension getPreferredSize(){ 
  return new Dimension((Config.MARGIN) *2+Config.GRID_SPAN*Config.COLS,Config.MARGIN*2+Config.GRID_SPAN*Config.ROWS); 
 } 
   
   
  
} 
