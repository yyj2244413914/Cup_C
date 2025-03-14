/*TicTacToe 是一款经典的游戏，也被称为“三连棋”。该游戏非常简单，可以在纸上或者
计算机上进行。游戏的目标是在一个3x3的方格中先将自己的符号（通常是X或O）连成一条
线。这条线可以是水平、垂直或对角线。先连成一条线的玩家为赢家，当然也有可能是平局。
（判定平局的规则是3x3方格中的所有符号都已填满，但是没有出现同一符号的三连现象。） 
请编写一个程序 TicTacToe，通过键盘的输入方式实现参与该游戏的两个玩家的对决过程。
程序执行中提示两个玩家交替输入符号（X 或者 O）的位置。每当输入一个符号就要在屏幕上
显示棋盘目前的状态，并且判断当前的游戏的状态（赢或者平局） */
//导入java.util包以识别玩家每一次输入。
import java.util.Scanner;
public class TicTacToe {
    //定义棋盘，其中的空格表示该位置没有被占用，直线用以分块。
    static String[][] board = {
        {" ", "_", " ", "_", " ", "_"},
        {"|", " ", "|", " ", "|", " ", "|"},
        {" ", "_", " ", "_", " ", "_"},
        {"|", " ", "|", " ", "|", " ", "|"},
        {" ", "_", " ", "_", " ", "_"},
        {"|", " ", "|", " ", "|", " ", "|"},
        {" ", "_", " ", "_", " ", "_"}
    };
    //定义一个方法，用于在玩家落子后更新棋盘。
    public static void afterMove(String[][] board, int row, int col,int player) {
        if(player%2==1)
        {board[2*row-1][2*col-1] = "X";}
        else{board[2*row-1][2*col-1] = "O";}
    }
    //定义一个方法，用于判断当前游戏是否已经结束。
    public static boolean checkWin(String[][] board) {
        int i=0,j=0;
        for(i=1;i<4;i++){
           j=2*i-1;
           //横纵线判断
          if(board[1][j].equals(board[3][j])&&board[3][j].equals(board[5][j])&&!board[1][j].equals(" "))
          {return true;}
          if(board[j][1].equals(board[j][3])&&board[j][3].equals(board[j][5])&&!board[j][1].equals(" "))
          {return true;}
        }
        //对角线判断
        if(board[1][1].equals(board[3][3])&&board[3][3].equals(board[5][5])&&!board[1][1].equals(" "))
        {return true;}
        if(board[1][5].equals(board[3][3])&&board[3][3].equals(board[5][1])&&!board[1][5].equals(" "))
        {return true;}
        return false;
   }
    //定义主函数，用于实现游戏的流程。
    public static void main(String[] args) {
        System.out.print("欢迎来到井字棋游戏！\n");
    for (String[] row : board) {
        for (String s : row) {
            System.out.print(s);
        }
        System.out.println();
    }
    int player=1;
    int row=0,col=0;
    String[] playerrole={"甲","乙"};//定义玩家角色
    while((player<=9)&&(checkWin(board)==false)){
        System.out.print("请玩家"+playerrole[(player-1)%2]+"输入要落子的位置（行号和列号，以空格分隔）：");
        Scanner scanner = new Scanner(System.in);
        row = scanner.nextInt();
        col = scanner.nextInt();
        //判断输入是否合法
        while(!board[2*row-1][2*col-1].equals(" ")){
            System.out.print("该位置已被占用，请重新输入：");
            row = scanner.nextInt();
            col = scanner.nextInt();
        }
        afterMove(board, row, col, player);
        for (String[] row1 : board) {
            for (String s : row1) {
                System.out.print(s);
            }
            System.out.println();
        }
        player++;
    }
    if(checkWin(board)==true){
        System.out.print("恭喜玩家"+playerrole[player%2]+"获胜！");
    }
    if(player>9){
        System.out.print("游戏结束，平局！");
    }
}
}
