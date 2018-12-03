package com.eomcs.lms.proxy;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import com.eomcs.lms.domain.Lesson;

public class LessonDaoProxy {

  ObjectInputStream in;
  ObjectOutputStream out;

  public LessonDaoProxy(ObjectInputStream in, ObjectOutputStream out) {
    this.in = in;
    this.out = out;
  }

  public int delete(int no) throws Exception {
    out.writeUTF("/lesson/delete");
    out.writeInt(no);
    out.flush();

    if (in.readUTF().equals("ok")) {
      return 1;
    } else {
      return 0;
    }

  }

  public int update(Lesson lesson) throws Exception {
    out.writeUTF("/lesson/update");
    out.writeObject(lesson);
    out.flush();

    if (in.readUTF().equals("ok")) {
      return 1;
    } else {
      return 0;
    }

  }

  public int add(Lesson lesson) throws Exception {
    out.writeUTF("/lesson/add");
    out.writeObject(lesson);
    out.flush();

    if (in.readUTF().equals("ok")) {
      return 1;
    } else {
      return 0;
    }
  }

  public Lesson[] list() throws Exception {
    out.writeUTF("/lesson/list");
    out.flush();

    if (in.readUTF().equals("ok")) {
      return (Lesson[]) in.readObject();
    } else {
      return null;
    }
  }

  public Lesson detail(int no) throws Exception {
    out.writeUTF("/lesson/detail");
    out.writeInt(no);
    out.flush();

    if (in.readUTF().equals("ok")) {
      return (Lesson) in.readObject();
    } else {
      return null;
    }
  }

  public static void main(String[] args) throws Exception {
    try (Socket socket = new Socket("localhost", 8888);
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());) {

      LessonDaoProxy lessonDao = new LessonDaoProxy(in, out);

      Lesson[] lessons = lessonDao.list();

      for (Lesson lesson : lessons) {
        System.out.println(lesson);
      }
    }

  }

}
