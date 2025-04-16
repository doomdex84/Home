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
            System.out.print("명령어 : ");
            String cmd = sc.nextLine();

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
                System.out.println(id + "번이 저장됨");

                Motivation motivation = new Motivation(id, body, source);
                motivations.add(motivation);

            } else if (cmd.equals("list")) {
                if (motivations.isEmpty()) {
                    System.out.println("등록된 moti 없음");
                } else {
                    System.out.println("=".repeat(40));
                    System.out.printf("    번호    /    본문    /   출처    \n");
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
                    Motivation foundMotivation = findById(motivations, id);

                    if (foundMotivation == null) {
                        System.out.println("해당 moti는 없는데?");
                    } else {
                        motivations.remove(foundMotivation);
                        System.out.println(id + "번 moti 삭제됨");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("숫자로 된 ID를 입력하세요.");
                }

            } else if (cmd.startsWith("edit")) {
                String[] cmdBits = cmd.split(" ");
                if (cmdBits.length < 2) {
                    System.out.println("수정할 moti 번호를 입력하세요.");
                    continue;
                }

                int id;
                try {
                    id = Integer.parseInt(cmdBits[1]);
                } catch (NumberFormatException e) {
                    System.out.println("ID는 숫자로 입력해야 합니다.");
                    continue;
                }

                Motivation foundMotivation = findById(motivations, id);

                if (foundMotivation == null) {
                    System.out.println("해당 moti는 없던데????");
                    continue;
                }

                // 기존 내용 출력
                System.out.println("body(기존) : " + foundMotivation.getBody());
                System.out.println("source(기존) : " + foundMotivation.getSource());

                // 새 내용 입력
                String newBody;
                String newSource;

                while (true) {
                    System.out.print("new body : ");
                    newBody = sc.nextLine().trim();
                    if (!newBody.isEmpty()) break;
                    System.out.println("수정사항(body) 입력해");
                }

                while (true) {
                    System.out.print("new source : ");
                    newSource = sc.nextLine().trim();
                    if (!newSource.isEmpty()) break;
                    System.out.println("수정사항(source) 입력해");
                }

                // 내용 수정
                foundMotivation.setBody(newBody);
                foundMotivation.setSource(newSource);

                System.out.println(id + "번 moti 수정됨");

            } else {
                System.out.println("사용할 수 없는 명령어");
            }
        }
    }

    // ID로 motivation 찾기
    private Motivation findById(List<Motivation> motivations, int id) {
        for (Motivation motivation : motivations) {
            if (motivation.getId() == id) {
                return motivation;
            }
        }
        return null;
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
