import java.util.ArrayList;
import java.util.Scanner;

public class Maps {
    ArrayList<String> inputLines() {
        ArrayList<String> lines = new ArrayList<>();

        String input = "Stage 1\n" +
                "#####\n" +
                "#OoP#\n" +
                "#####\n" +
                "=====\n" +
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

    //입력값에서 지도데이터만 추출
    ArrayList<String>[] getMapData(ArrayList<String> lines) {
        ArrayList<String> stage1 = new ArrayList<>();
        ArrayList<String> stage2 = new ArrayList<>();

        for (int i = 1; i < 4; i++) {
            stage1.add(lines.get(i));
        }

        for (int i = 6; i < 13; i++) {
            stage2.add(lines.get(i));
        }

        ArrayList<String>[] stages = new ArrayList[2];
        stages[0] = stage1;
        stages[1] = stage2;

//        System.out.println(Arrays.toString(stages));

        return stages;
    }

    //값 치환
    void ConvertAndPrintMapData() {
        ArrayList<String>[] stages = getMapData(inputLines());
        ArrayList<String> stage1 = stages[0];
        ArrayList<String> stage2 = stages[1];

        ArrayList<String[]> cvtdStg1 = new ArrayList<>();
        ArrayList<String[]> cvtdStg2 = new ArrayList<>();

        // ArrayList<String[]>에 요소 저장.
        for (String e : stage1) {
            String[] arr = e.split("");
            cvtdStg1.add(arr);
        }

        for (String e : stage2) {
            String[] arr = e.split("");
            cvtdStg2.add(arr);
        }

        printMaps(cvtdStg1, cvtdStg2);


    }

    void printMaps(ArrayList<String[]> cvtdStg1, ArrayList<String[]> cvtdStg2) {
        System.out.println("Stage 1");
        System.out.println();
        for (String[] arr : cvtdStg1) {
            for (String e : arr) {
                System.out.print(e);
            }
            System.out.println();
        }
        System.out.println();

        printMapData(cvtdStg1);

        System.out.println();
        System.out.println();

        System.out.println("Stage 2");
        System.out.println();
        for (String[] arr : cvtdStg2) {
            for (String e : arr) {
                System.out.print(e);
            }
            System.out.println();
        }
        System.out.println();

        printMapData(cvtdStg2);

    }

    void printMapData(ArrayList<String[]> cvtdStg) {
        int H;
        String[] temp = cvtdStg.get(0);
        for (int i = 0; i < cvtdStg.size(); i++) {
            if (cvtdStg.get(i).length > temp.length) {
                temp = cvtdStg.get(i);
            }
        }
        H = temp.length;


        int V;
        V = cvtdStg.size();

        int holeCount = 0;
        for (String[] arr : cvtdStg) {
            for (String e : arr) {
                if (e.equals("O")) { holeCount += 1; }
            }
        }

        int ballCount = 0;
        for (String[] arr : cvtdStg) {
            for (String e : arr) {
                if (e.equals("o")) { ballCount += 1; }
            }
        }


        int V_Position = 1;
        for (String[] arr : cvtdStg) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i].equals("P")) {V_Position += cvtdStg.indexOf(arr);}
            }
        }

        int H_Position = 1;
        for (String[] arr : cvtdStg) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i].equals("P")) {H_Position += i;}
            }
        }



        System.out.printf("가로크기: %d \n",H);
        System.out.printf("세로크기: %d \n", V);
        System.out.printf("구멍의 수: %d \n", holeCount);
        System.out.printf("공의 수: %d \n ", ballCount);
        System.out.printf("플레이어 위치: (%d,%d)",V_Position, H_Position);
    }
}


