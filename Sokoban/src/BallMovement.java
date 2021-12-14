import java.util.ArrayList;

public class BallMovement {
    void ballMoveUp(ArrayList<String[]> MapData) {
        PlayerMovement p = new PlayerMovement();
        int[] playerIndex = p.findPlayer(MapData);

        int V_Index = playerIndex[0] - 1;
        int H_Index = playerIndex[1];

        String UpElement = MapData.get(V_Index - 1)[H_Index];
        if (UpElement.equals(" ")) {
            MapData.get(V_Index - 1)[H_Index] = "o";
            MapData.get(V_Index)[H_Index] = " ";
        } else if (UpElement.equals("O")) {
            MapData.get(V_Index - 1)[H_Index] = "0";
            MapData.get(V_Index)[H_Index] = " ";
        } else if (!(UpElement.equals(" ") || UpElement.equals("O"))) {
            System.out.printf("%c: (경고!) 해당 명령을 수행할 수 없습니다!", 'W');
        }
    }

    void ballMoveRight(ArrayList<String[]> MapData) {
        PlayerMovement p = new PlayerMovement();
        int[] playerIndex = p.findPlayer(MapData);

        int V_Index = playerIndex[0];
        int H_Index = playerIndex[1] + 1;

        String RightElement = MapData.get(V_Index)[H_Index + 1];
        if (RightElement.equals(" ")) {
            MapData.get(V_Index)[H_Index + 1] = "o";
            MapData.get(V_Index)[H_Index] = " ";
        } else if (RightElement.equals("O")) {
            MapData.get(V_Index)[H_Index + 1] = "0";
            MapData.get(V_Index)[H_Index] = " ";
        } else if (!(RightElement.equals(" ") || RightElement.equals("O"))) {
            System.out.printf("%c: (경고!) 해당 명령을 수행할 수 없습니다!", 'D');
        }
    }

    void ballMoveDown(ArrayList<String[]> MapData) {
        PlayerMovement p = new PlayerMovement();
        int[] playerIndex = p.findPlayer(MapData);

        int V_Index = playerIndex[0] + 1;
        int H_Index = playerIndex[1];

        String DownElement = MapData.get(V_Index + 1)[H_Index];
        if (DownElement.equals(" ")) {
            MapData.get(V_Index + 1)[H_Index] = "o";
            MapData.get(V_Index)[H_Index] = " ";
        } else if (DownElement.equals("O")) {
            MapData.get(V_Index + 1)[H_Index] = "0";
            MapData.get(V_Index)[H_Index] = " ";
        } else if (!(DownElement.equals(" ") || DownElement.equals("O"))) {
            System.out.printf("%c: (경고!) 해당 명령을 수행할 수 없습니다!", 'S');
        }
    }

    void ballMoveLeft(ArrayList<String[]> MapData) {
        PlayerMovement p = new PlayerMovement();
        int[] playerIndex = p.findPlayer(MapData);

        int V_Index = playerIndex[0];
        int H_Index = playerIndex[1] - 1;

        String LeftElement = MapData.get(V_Index)[H_Index - 1];
        if (LeftElement.equals(" ")) {
            MapData.get(V_Index)[H_Index - 1] = "o";
            MapData.get(V_Index)[H_Index] = " ";
        } else if (LeftElement.equals("O")) {
            MapData.get(V_Index)[H_Index - 1] = "0";
            MapData.get(V_Index)[H_Index] = " ";
        } else if (!(LeftElement.equals(" ") || LeftElement.equals("O"))) {
            System.out.printf("%c: (경고!) 해당 명령을 수행할 수 없습니다!", 'A');
        }
    }

}
