import java.util.Scanner;

public class Main {

    public static final int SIZE = 4;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[][] map = new String[SIZE][SIZE];
        String[] steps = new String[]{"x","o"};
        String choice;
        int x, y, step = 1;
        boolean isContinueGame = true;

        loadMap(map);
        do{
            do {
                System.out.printf("Enter your choice \n");
                System.out.printf("x: ");
                x = scanner.nextInt();
                System.out.printf("y: ");
                y = scanner.nextInt();
                if(!isValidLocation(x,y)){
                    System.out.printf("This location is not valid (from 0 -> 3)");
                }
            }while (!isValidLocation(x,y));

            if(step%2==0){
                upgradeMap(map,steps[0],x,y);
                step-=1;
            }else if(step%2==1){
                upgradeMap(map,steps[1],x,y);
                step+=1;
            }
            displayMap(map);
            System.out.printf("Want exit? (y/n): ");
            choice = scanner.next();
            if(choice.toLowerCase().equals("y")){
                isContinueGame = false;
            }
        }while(isContinueGame);


    }

    public static void upgradeMap(String[][] map, String step, int x, int y){
        for(int i = 0; i < map.length; i++){
            for(int j = 0; j < map[i].length; j++){
                if(x==j&&y==i){
                    map[x][y] = "|" + step.toUpperCase() +  "|";
                }
            }
        }
    }

    public static void loadMap(String[][] map){
        for(int i = 0; i < map.length; i++){
            for(int j = 0; j < map[i].length; j++){
                map[i][j] = "| |";
            }
        }
    }

    public static void displayMap(String[][] map){
        for(int i = 0; i < map.length; i++){
            for(int j = 0; j < map[i].length; j++){
                System.out.printf(map[i][j]);
            }
            System.out.println("");
        }
    }

    public static boolean isValidLocation(int x, int y){
        return x>=0&&x<SIZE&&y>=0&&y<SIZE?true:false;
    }
}
