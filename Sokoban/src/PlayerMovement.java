
import java.util.ArrayList;

public class PlayerMovement {
    int[] findPlayer(ArrayList<String[]> MapData) {
        int V_Index = 0;
        for (String[] arr : MapData) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i].equals("P")) {
                    V_Index += MapData.indexOf(arr);
                }
            }
        }

        int H_Index = 0;
        for (String[] arr : MapData) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i].equals("P")) {
                    H_Index += i;
                }
            }
        }

        int[] index = new int[]{V_Index, H_Index};

        return index;
    }


    void goUp(ArrayList<String[]> MapData) {
        BallMovement b = new BallMovement();
        int[] index = findPlayer(MapData);
        int V_Index = index[0];
        int H_Index = index[1];
        String UpElement = MapData.get(V_Index - 1)[H_Index];
        if (UpElement.equals(" ")) {
            MapData.get(V_Index - 1)[H_Index] = "P";
            getBack_O_ByStageNum(MapData, V_Index, H_Index);
            System.out.println("W: 위로 이동합니다.");
        } else if (!(UpElement.equals(" ") || UpElement.equals("o"))) {
            System.out.printf("%c: (경고!) 해당 명령을 수행할 수 없습니다!", 'W');
        } else if (UpElement.equals("o")) {
            b.ballMoveUp(MapData);
            MapData.get(V_Index - 1)[H_Index] = "P";
            MapData.get(V_Index)[H_Index] = " ";
            System.out.println("W: 위로 이동합니다.");
        }
    }

    void goRight(ArrayList<String[]> MapData) {
        int[] index = findPlayer(MapData);
        int V_Index = index[0];
        int H_Index = index[1];
        String RightElement = MapData.get(V_Index)[H_Index + 1];
        if (RightElement.equals(" ")) {
            MapData.get(V_Index)[H_Index + 1] = "P";
            //O에 있다가 나올 떄만 O 추가해주는 작업.
            getBack_O_ByStageNum(MapData, V_Index, H_Index);
            //이까지
            System.out.println("D: 오른쪽으로 이동합니다.");
        } else if (!(RightElement.equals(" ") || RightElement.equals("o"))) {
            System.out.printf("%c: (경고!) 해당 명령을 수행할 수 없습니다!", 'D');
        } else if (RightElement.equals("o")) {
            BallMovement b = new BallMovement();
            b.ballMoveRight(MapData);
            MapData.get(V_Index)[H_Index + 1] = "P";
            MapData.get(V_Index)[H_Index] = " ";
            System.out.println("A: 오른쪽으로 이동합니다.");
        }
    }

    void goDown(ArrayList<String[]> MapData) {
        BallMovement b = new BallMovement();
        int[] index = findPlayer(MapData);
        int V_Index = index[0];
        int H_Index = index[1];
        String DownElement = MapData.get(V_Index + 1)[H_Index];
        if (DownElement.equals(" ")) {
            MapData.get(V_Index + 1)[H_Index] = "P";
            getBack_O_ByStageNum(MapData, V_Index, H_Index);
            System.out.println("S: 아래로 이동합니다.");
        } else if (!(DownElement.equals(" ") || DownElement.equals("o"))) {
            System.out.printf("%c: (경고!) 해당 명령을 수행할 수 없습니다!", 'S');
        } else if (DownElement.equals("o")) {
            b.ballMoveDown(MapData);
            MapData.get(V_Index + 1)[H_Index] = "P";
            MapData.get(V_Index)[H_Index] = " ";
            System.out.println("A: 왼쪽으로 이동합니다.");
        }
    }

    void goLeft(ArrayList<String[]> MapData) {
        BallMovement b = new BallMovement();
        int[] index = findPlayer(MapData);
        int V_Index = index[0];
        int H_Index = index[1];
        String LeftElement = MapData.get(V_Index)[H_Index - 1];
        if (LeftElement.equals(" ") || LeftElement.equals("O")) {
            MapData.get(V_Index)[H_Index - 1] = "P";
            getBack_O_ByStageNum(MapData, V_Index, H_Index);
            System.out.println("A: 왼쪽으로 이동합니다.");
        } else if (!(LeftElement.equals(" ") || LeftElement.equals("o") || LeftElement.equals("O"))) {
            System.out.printf("%c: (경고!) 해당 명령을 수행할 수 없습니다!", 'A');
        } else if (LeftElement.equals("o")) {
            b.ballMoveLeft(MapData);
            MapData.get(V_Index)[H_Index - 1] = "P";
            MapData.get(V_Index)[H_Index] = " ";
            System.out.println("A: 왼쪽으로 이동합니다.");
        }
    }

    void getBack_O(ArrayList<String[]> MapData, int V_Index, int H_Index, ArrayList<String[]> original) {
        String initialElement = original.get(V_Index)[H_Index];  //지도 초기값에서 P가 서있는 위치의 값이 initialElement
        if (initialElement.equals("O")) {
            MapData.get(V_Index)[H_Index] = "O";
        } else if (!initialElement.equals("O")) {
            MapData.get(V_Index)[H_Index] = " ";
        }
    }

    void getBack_O_ByStageNum(ArrayList<String[]> MapData, int V_Index, int H_Index) {
        Prompt p = new Prompt();
        if (p.StageNum == 1) {
            Map_Stage1 s1 = new Map_Stage1();
            ArrayList<String[]> original = s1.convertMapData();
            getBack_O(MapData, V_Index, H_Index, original);
        }
        if (p.StageNum == 2) {
            Map_Stage2 s2 = new Map_Stage2();
            ArrayList<String[]> original = s2.convertMapData();
            getBack_O(MapData, V_Index, H_Index, original);
        }
    }


}
