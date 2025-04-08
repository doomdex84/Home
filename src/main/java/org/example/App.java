package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    public Scanner sc;

    public App(Scanner sc) {
        this.sc = sc;
    }

    public void run() {

        System.out.println("moti 실행");

        int lastId = 0;

       List<Motivation> motivations = new ArrayList<Motivation>();

        while (true) {
            System.out.print("명령어) ");
            String cmd = sc.nextLine().trim();

            if (cmd.equals("exit")) {
                System.out.println("moti 종료");
                break;
            }else if (cmd.length() == 0) {
                System.out.println("명령어가 입력되지 않음");
                continue;
            }
            if (cmd.equals("add")) {
                int id = lastId +1;
                System.out.print("body : ");
                String body = sc.nextLine();
                System.out.print("source : ");
                String source = sc.nextLine();

                Motivation motivation = new Motivation(id, body, source); //조립
                motivations.add(motivation);


                System.out.println(id + "번 moti 저장");
                lastId++;



            }else if (cmd.equals("list")) {
                if (motivations.size() == 0) {
                    System.out.println("등록된 moti 없음");
                }

                System.out.println("=".repeat(40));
                System.out.printf("   제목   /  body   /   source   \n");

                for (int i = motivations.size() - 1; i >= 0; i--) {
                    Motivation motivation = motivations.get(i);
                    System.out.printf("   %d   /  %s   /   %s   \n", motivation.getId(), motivation.getBody(), motivation.getSource());
                }
                System.out.println("=".repeat(40));

            }else if(cmd.startsWith("delete")) {
                String[] cmdBits = cmd.split((" "));
                int id = Integer.parseInt(cmd.split(" ")[1]);

                Motivation foundmotivation = null;

                for (Motivation motivation : motivations) {
                    if (motivation.getId() == id) {
                        motivations.remove(motivation);
                        break;
                    }

                   if (foundmotivation == null) {
                       System.out.println("해당 moti는 없는데?");
                       return;
                   }

                   motivations.remove(id-1);
                    System.out.println(id+"해당 moti 삭제됨");

                }
                }

            else{
                System.out.println("사용할 수 없는 명령어");
            }
            }

            }
        }

class Motivation {
    public int id;
    public String body;
    public String source;

    public Motivation(int id, String body, String source) {
        this.id = id;
        this.body = body;
        this.source = source;
    }

    @Override
    public String toString() {
        return "Motivation{" +
                "id=" + id +
                ", body='" + body + '\'' +
                ", source='" + source + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}