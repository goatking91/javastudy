package com.eomcs.lms;
import java.util.Scanner;
import com.eomcs.lms.handler.BoardHandler;
import com.eomcs.lms.handler.LessonHandler;
import com.eomcs.lms.handler.MemberHandler;

public class App {

  static Scanner keyboard = new Scanner(System.in);

  public static void main(String[] args) {
    
    LessonHandler lesson = new LessonHandler();
    lesson.keyboard = keyboard;
    
    MemberHandler member = new MemberHandler();
    member.keyboard = keyboard;
    
    BoardHandler board = new BoardHandler();
    board.keyboard = keyboard;
    
    BoardHandler board2 = new BoardHandler();
    board2.keyboard = keyboard;
    
    while (true) {
      String command = prompt();

      if (command.equals("/lesson/add")) {
        lesson.addLesson();
        
      } else if (command.equals("/lesson/list")) {
        lesson.listLesson();
      
      } else if (command.equals("/member/add")) {
        member.addMember();
        
      } else if (command.equals("/member/list")) {
        member.listMember();
        
      } else if (command.equals("/board/add")) {
        board.addBoard();
        
      } else if (command.equals("/board/list")) {
        board.listBoard();
        
      } else if (command.equals("/board2/add")) {
        board2.addBoard();
        
      } else if (command.equals("/board2/list")) {
        board2.listBoard();
        
      } else if (command.equals("quit")) {
        System.out.println("안녕!");
        break;
        
      } else {
        System.out.println("실행할 수 없는 명령입니다.");
      }
      
      System.out.println(); 
    }

    keyboard.close();
  }

  private static String prompt() {
    System.out.print("명령> ");
    return keyboard.nextLine().toLowerCase();
  }
}
