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
        List<Motivation> motivations = new ArrayList<>();

        while (true) {
            System.out.print("명령어) ");
            String cmd = sc.nextLine().trim();

            if (cmd.equals("exit")) {
                System.out.println("moti 종료");
                break;
            } else if (cmd.length() == 0) {
                System.out.println("명령어가 입력되지 않음");
                continue;
            }

            if (cmd.equals("add")) {
                int id = ++lastId;
                System.out.print("body : ");
                String body = sc.nextLine();
                System.out.print("source : ");
                String source = sc.nextLine();

                Motivation motivation = new Motivation(id, body, source);
                motivations.add(motivation);

                System.out.println(id + "번 moti 저장");

            } else if (cmd.equals("list")) {
                if (motivations.isEmpty()) {
                    System.out.println("등록된 moti 없음");
                } else {
                    System.out.println("=".repeat(40));
                    System.out.printf("   번호   /  body   /   source   \n");

                    for (int i = motivations.size() - 1; i >= 0; i--) {
                        Motivation motivation = motivations.get(i);
                        System.out.printf("   %d   /  %s   /   %s   \n", motivation.getId(), motivation.getBody(), motivation.getSource());
                    }

                    System.out.println("=".repeat(40));
                }

            } else if (cmd.startsWith("delete")) {
                String[] cmdBits = cmd.split(" ");
                if (cmdBits.length < 2) {
                    System.out.println("삭제할 moti 번호를 입력하세요.");
                    continue;
                }

                try {
                    int id = Integer.parseInt(cmdBits[1]);
                    Motivation foundMotivation = null;

                    for (Motivation motivation : motivations) {
                        if (motivation.getId() == id) {
                            foundMotivation = motivation;
                            break;
                        }
                    }

                    if (foundMotivation == null) {
                        System.out.println("해당 moti는 없는데?");
                    } else {
                        motivations.remove(foundMotivation);
                        System.out.println(id + "번 moti 삭제됨");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("숫자로 된 ID를 입력하세요.");
                }

            } else {
                System.out.println("사용할 수 없는 명령어");
            }
        }
    }
}

class Motivation {
    private int id;
    private String body;
    private String source;

    public Motivation(int id, String body, String source) {
        this.id = id;
        this.body = body;
        this.source = source;
    }

    public int getId() {
        return id;
    }

    public String getBody() {
        return body;
    }

    public String getSource() {
        return source;
    }
}
