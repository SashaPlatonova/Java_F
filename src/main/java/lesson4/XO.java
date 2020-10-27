package lesson4;
import java.util.Scanner;

public class XO {

    public static char[][] MAP;
    private static boolean isInGame;
    private static int SIZE;
    private static final char USER = 'X';
    private static final char PC = 'O';
    private static final char DEFAULT = '_';

    static void fillMap(int size) {
        isInGame = true;
        MAP = new char[size][size];
        SIZE = size;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                MAP[i][j] = DEFAULT;
            }
        }
    }

    static void printMap() {
        System.out.print("  ");
        for (int i = 0; i < SIZE; i++) {
            System.out.print(i + 1 + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print(i + 1 + "|");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(MAP[i][j] + "|");
            }
            System.out.println();
        }
    }

    static boolean move(int x, int y, char player) {
        try {
            if (MAP[x][y] == DEFAULT) {
                MAP[x][y] = player;
                return true;
            } else {
                return false;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
    }

    private static void moveAI() {
        boolean isWinMove;

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (MAP[i][j]==DEFAULT){
                    MAP[i][j]=USER;
                    isWinMove=isVictory(USER);
                    if (isWinMove){
                        MAP[i][j]=PC;
                        return;
                    }
                    MAP[i][j]=DEFAULT;
                }
            }
        }
        while (true){
            int x = (int) (Math.random()*(SIZE-1));
            int y = (int) (Math.random()*(SIZE-1));
            if (MAP[x][y]==DEFAULT){
                MAP[x][y]=PC;
                return;
            }
            throw new IllegalArgumentException();
        }
    }

    static boolean isVictory(char player) {
        int checkRow=0, checkCol=0, checkDiag1=0, checkDiag2=0;
        for (int i = 0; i<SIZE; i++){
            for (int j = 0; j<SIZE; j++){
                if (MAP[i][j]==player){
                    checkRow++;
                    if (i==j){
                        checkDiag1++;

                    }
                    if (i+j==SIZE-1)
                        checkDiag2++;
                }

                if (MAP[j][i]==player){
                    checkCol++;
                }

                if (checkRow==SIZE||checkCol==SIZE||checkDiag1==SIZE||checkDiag2==SIZE)
                    return true;
            }
            checkRow=0;
            checkCol=0;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        fillMap(3);
        printMap();
        System.out.println("""
                Игра крестики-нолики!
                Вы играете за Х
                Для того, чтобы совершить ход: введите номер строки и номер столбца
                """);
        while (isInGame) {
            System.out.println("Ваш ход:");
            int x, y;
            try {
                x = in.nextInt();
                y = in.nextInt();
            } catch (Exception e) {
                System.out.println("Введите корректные данные");
                in.nextLine();
                continue;
            }
            x--;
            y--;
            if (move(x, y, USER)) {
                printMap();
                if (isVictory(USER)) {
                    System.out.println("Вы победили!");
                    break;
                }
                try {
                    System.out.println("Ходит компьютер");
                    moveAI();
                    printMap();
                } catch (Exception e) {
                    System.out.println("Ничья");
                    break;
                }
                if (isVictory(PC)) {
                    System.out.println("Вы проиграли!");
                    break;
                }
            } else {
                System.out.println("Введите корректные данные");
            }
        }

    }
}
