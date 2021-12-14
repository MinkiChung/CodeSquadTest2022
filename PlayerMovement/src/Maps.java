import java.util.ArrayList;
import java.util.Scanner;

public class Maps {
    ArrayList<String> inputLines() {
        ArrayList<String> lines = new ArrayList<>();

        String input =
                "Stage 2\n" +
                "  #######  \n" +
                "###  O  ###\n" +
                "#    o    #\n" +
                "# Oo P oO #\n" +
                "###  o  ###\n" +
                " #   O  #  \n" +
                " ########  \n";

        Scanner scanner = new Scanner(input);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            lines.add(line);
        }

        scanner.close();

        return lines;
    }

    ArrayList<String> getMapData(ArrayList<String> lines) {
        ArrayList<String> stage2 = new ArrayList<>();

        for (int i = 1; i < lines.size(); i++) {
            stage2.add(lines.get(i));
        }

        return stage2;
    }

    ArrayList<String[]> convertMapData() {
        ArrayList<String> stage2 = getMapData(inputLines());

        ArrayList<String[]> cvtdStg2 = new ArrayList<>();

        // ArrayList<String[]>에 요소 저장.

        for (String e : stage2) {
            String[] arr = e.split("");
            cvtdStg2.add(arr);
        }

        return cvtdStg2;

    }
}
