import java.util.ArrayList;
import java.util.Scanner;

public class Prompt {
    void runPrompt() {
        System.out.println("Stage 2");
        System.out.println();

        Maps m = new Maps();
        ArrayList<String[]> MapData = m.convertMapData();
        printMap(MapData);

        System.out.println();
        System.out.print("SOKOBAN> ");
        Scanner sc = new Scanner(System.in);
        String cmdLine = sc.nextLine();
        cmdLine = cmdLine.toUpperCase();

        runCmds(convertCmdLine(cmdLine), MapData);

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
        Movement movement = new Movement();
        for (String cmd : cmds) {
            if (cmd.equals("W")) {
                movement.goUp(MapData);
            } else if (cmd.equals("A")) {
                movement.goLeft(MapData);
            } else if (cmd.equals("S")) {
                movement.goDown(MapData);
            } else if (cmd.equals("D")) {
                movement.goRight(MapData);
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
            continuePrompt(MapData);

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





    }

