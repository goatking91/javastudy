package com.eomcs.lms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import com.eomcs.lms.domain.Board;
import com.eomcs.lms.domain.Lesson;
import com.eomcs.lms.domain.Member;
import com.eomcs.lms.handler.BoardAddCommand;
import com.eomcs.lms.handler.BoardDeleteCommand;
import com.eomcs.lms.handler.BoardDetailCommand;
import com.eomcs.lms.handler.BoardListCommand;
import com.eomcs.lms.handler.BoardUpdateCommand;
import com.eomcs.lms.handler.Command;
import com.eomcs.lms.handler.LessonAddCommand;
import com.eomcs.lms.handler.LessonDeleteCommand;
import com.eomcs.lms.handler.LessonDetailCommand;
import com.eomcs.lms.handler.LessonListCommand;
import com.eomcs.lms.handler.LessonUpdateCommand;
import com.eomcs.lms.handler.MemberAddCommand;
import com.eomcs.lms.handler.MemberDeleteCommand;
import com.eomcs.lms.handler.MemberDetailCommand;
import com.eomcs.lms.handler.MemberListCommand;
import com.eomcs.lms.handler.MemberUpdateCommand;

public class App {

  static Scanner keyboard = new Scanner(System.in);
  static Stack<String> commandHistory = new Stack<>();
  static Queue<String> commandHistory2 = new LinkedList<>();
  
  public static void main(String[] args) {
    
    List<Lesson> lessons = new ArrayList<>();
    List<Member> members = new LinkedList<>();
    List<Board> boards = new ArrayList<>();
    
    HashMap<String, Command> commandMap = new HashMap<>();
    commandMap.put("/lesson/add", 
        new LessonAddCommand(keyboard, lessons));
    commandMap.put("/lesson/list", 
        new LessonListCommand(keyboard, lessons));
    commandMap.put("/lesson/detail", 
        new LessonDetailCommand(keyboard, lessons));
    commandMap.put("/lesson/update", 
        new LessonUpdateCommand(keyboard, lessons));
    commandMap.put("/lesson/delete", 
        new LessonDeleteCommand(keyboard, lessons));
    
    commandMap.put("/member/add", 
        new MemberAddCommand(keyboard, members));
    commandMap.put("/member/list", 
        new MemberListCommand(keyboard, members));
    commandMap.put("/member/detail", 
        new MemberDetailCommand(keyboard, members));
    commandMap.put("/member/update", 
        new MemberUpdateCommand(keyboard, members));
    commandMap.put("/member/delete", 
        new MemberDeleteCommand(keyboard, members));
    
    commandMap.put("/board/add", 
        new BoardAddCommand(keyboard, boards));
    commandMap.put("/board/list", 
        new BoardListCommand(keyboard, boards));
    commandMap.put("/board/detail", 
        new BoardDetailCommand(keyboard, boards));
    commandMap.put("/board/update", 
        new BoardUpdateCommand(keyboard, boards));
    commandMap.put("/board/delete", 
        new BoardDeleteCommand(keyboard, boards));
    
    while (true) {
      String command = prompt();

      // 사용자가 입력한 명령을 스택에 보관한다.
      commandHistory.push(command);
      
      // 사용자가 입력한 명령을 큐에 보관한다.
      commandHistory2.offer(command);
      
      Command commandHandler = commandMap.get(command);
      
      if (commandHandler != null) {
        commandHandler.excute();
        
      } else if (command.equals("quit")) {
        System.out.println("안녕!");
        break;
        
      } else if (command.equals("history")) {
        printCommandHistory();
        
      } else if (command.equals("history2")) {
        printCommandHistory2();
        
      } else {
        System.out.println("실행할 수 없는 명령입니다.");
      }
      
      System.out.println(); 
    }

    keyboard.close();
  }

  @SuppressWarnings("unchecked")
  private static void printCommandHistory() {
    Stack<String> temp = (Stack<String>) commandHistory.clone();
    
    while (temp.size() > 0) {
      System.out.println(temp.pop());
    }
  }
  
  @SuppressWarnings("unchecked")
  private static void printCommandHistory2() {
    Queue<String> temp = (Queue<String>) ((LinkedList<String>) commandHistory2).clone();
    
    while (temp.size() > 0) {
      System.out.println(temp.poll());
    }
  }

  private static String prompt() {
    System.out.print("명령> ");
    return keyboard.nextLine().toLowerCase();
  }
}
