import java.util.ArrayList;
import java.util.Scanner;

public class Prompt {
    int StageNum = 2;

    void runPrompt() {
        if (StageNum == 1) {
            Map_Stage1 stage1 = new Map_Stage1();
            stage1.runStage1();
        } else if (StageNum == 2) {
            Map_Stage2 stage2 = new Map_Stage2();
            stage2.runStage2();
        }
    }

    ArrayList<String> convertCmdLine(String cmdLine) {
        ArrayList<String> cmds = new ArrayList<>();
        for (int i = 0; i < cmdLine.length(); i++) {
            String CharInStr = Character.toString(cmdLine.charAt(i));
            cmds.add(CharInStr);
        }

        return cmds;
    }

    void runCmds(ArrayList<String> cmds, ArrayList<String[]> MapData) {
        PlayerMovement movement = new PlayerMovement();
        int turnCount = 0;
        for (String cmd : cmds) {
            if (cmd.equals("W")) {
                movement.goUp(MapData);
            } else if (cmd.equals("A")) {
                movement.goLeft(MapData);
            } else if (cmd.equals("S")) {
                movement.goDown(MapData);
            } else if (cmd.equals("D")) {
                movement.goRight(MapData);
            } else if (cmd.equals("R")) {
                runPrompt();
            } else if (cmd.equals("Q")) {
                System.out.println("Bye~");
                System.exit(0);
            } else if (!cmd.equals("W") || cmd.equals("A") || cmd.equals("S") || cmd.equals("D") || cmd.equals("Q")) {
                System.out.printf("%s: (경고!) 해당 명령을 수행할 수 없습니다! \n", cmd);
            }
            System.out.println();
            printMap(MapData);
            System.out.println();

        }

        IsStageClear(MapData, turnCount);
//        continuePrompt(MapData);
    }

    void printMap(ArrayList<String[]> MapData) {
        for (String[] arr : MapData) {
            for (String e : arr) {
                System.out.print(e);
            }
            System.out.println();
        }
    }

    void continuePrompt(ArrayList<String[]> MapData) {
        System.out.println();
        System.out.print("SOKOBAN> ");
        Scanner sc = new Scanner(System.in);
        String cmdLine = sc.nextLine();
        cmdLine = cmdLine.toUpperCase();

        runCmds(convertCmdLine(cmdLine), MapData);
    }

    void IsStageClear(ArrayList<String[]> MapData, int turnCount) {
        int O_Count = 0;
        for (String[] arr : MapData) {
            for (String e : arr) {
                if (e.equals("O")) {O_Count += 1;}
            }
        }

        if (O_Count == 0) {
            System.out.println("빠밤! Stage 클리어!");
            System.out.printf("턴수: %d\n", turnCount);
            StageNum += 1;
            runPrompt();
        } else if (O_Count != 0) {
            continuePrompt(MapData);
        }
    }





}

