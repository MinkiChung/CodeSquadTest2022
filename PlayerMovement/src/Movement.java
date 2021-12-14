
import java.util.ArrayList;

public class Movement {
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

        int[] index = new int[] {V_Index, H_Index};

        return index;
    }


    void goUp(ArrayList<String[]> MapData){
        int[] index = findPlayer(MapData);
        int V_Index = index[0];
        int H_Index = index[1];
        String UpElement = MapData.get(V_Index - 1)[H_Index];
        if (UpElement.equals(" ") ) {
            MapData.get(V_Index - 1)[H_Index] = "P";
            MapData.get(V_Index)[H_Index] = " ";
            System.out.println("W: 위로 이동합니다.");
        } else if (!UpElement.equals(" ")) {
            System.out.printf("%c, (경고!) 해당 명령을 수행할 수 없습니다!", 'W');
        }
    }

    void goRight(ArrayList<String[]> MapData){
        int[] index = findPlayer(MapData);
        int V_Index = index[0];
        int H_Index = index[1];
        String RightElement = MapData.get(V_Index)[H_Index + 1];
        if (RightElement.equals(" ") ) {
            MapData.get(V_Index)[H_Index + 1] = "P";
            MapData.get(V_Index)[H_Index] = " ";
            System.out.println("D: 오른쪽으로 이동합니다.");
        } else if (!RightElement.equals(" ")) {
            System.out.printf("%c: (경고!) 해당 명령을 수행할 수 없습니다!", 'D');
        }
    }

    void goDown(ArrayList<String[]> MapData){
        int[] index = findPlayer(MapData);
        int V_Index = index[0];
        int H_Index = index[1];
        String DownElement = MapData.get(V_Index + 1)[H_Index];
        if (DownElement.equals(" ") ) {
            MapData.get(V_Index + 1)[H_Index] = "P";
            MapData.get(V_Index)[H_Index] = " ";
            System.out.println("S: 아래로 이동합니다.");
        } else if (!DownElement.equals(" ")) {
            System.out.printf("%c: (경고!) 해당 명령을 수행할 수 없습니다!", 'S');
        }
    }

    void goLeft(ArrayList<String[]> MapData){
        int[] index = findPlayer(MapData);
        int V_Index = index[0];
        int H_Index = index[1];
        String LeftElement = MapData.get(V_Index)[H_Index - 1];
        if (LeftElement.equals(" ") ) {
            MapData.get(V_Index)[H_Index - 1] = "P";
            MapData.get(V_Index)[H_Index] = " ";
            System.out.println("A: 왼쪽으로 이동합니다.");
        } else if (!LeftElement.equals(" ")) {
            System.out.printf("%c: (경고!) 해당 명령을 수행할 수 없습니다!", 'A');
        }
    }


}
