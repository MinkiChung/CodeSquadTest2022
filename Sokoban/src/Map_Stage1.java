import java.util.ArrayList;
import java.util.Scanner;

public class Map_Stage1 {
    ArrayList<String> inputLines() {
        ArrayList<String> lines = new ArrayList<>();

        String input = "Stage 1\n" +
                "#####\n" +
                "#OoP#\n" +
                "#####";


        Scanner scanner = new Scanner(input);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            lines.add(line);
        }

        scanner.close();

        return lines;
    }

    ArrayList<String> getMapData(ArrayList<String> lines) {
        ArrayList<String> stage1 = new ArrayList<>();

        for (int i = 1; i < lines.size(); i++) {
            stage1.add(lines.get(i));
        }

        return stage1;
    }

    ArrayList<String[]> convertMapData() {
        ArrayList<String> stage1 = getMapData(inputLines());

        ArrayList<String[]> cvtdStg1 = new ArrayList<>();

        // ArrayList<String[]>에 요소 저장.

        for (String e : stage1) {
            String[] arr = e.split("");
            cvtdStg1.add(arr);
        }

        return cvtdStg1;

    }

    void runStage1() {
        Prompt P_Stage1 = new Prompt();
        System.out.println("Stage 1");
        System.out.println();

        ArrayList<String[]> MapData = convertMapData();
        P_Stage1.printMap(MapData);

        System.out.println();
        System.out.print("SOKOBAN> ");
        Scanner sc = new Scanner(System.in);
        String cmdLine = sc.nextLine();
        cmdLine = cmdLine.toUpperCase();

        P_Stage1.runCmds(P_Stage1.convertCmdLine(cmdLine), MapData);
    }


}
