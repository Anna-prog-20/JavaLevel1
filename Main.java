import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

    //  \u007C vertical line
    //  \u005F underscore character
    //  \u00AF macron character
    //  \u00A4 currency sign
    //  \u00D8 O Letter with stroke
    //  \u00B7 Middle dot
    public static final char verticalLine='\u007C';
    public static char dot='\u00B7';
    /**
     * 1. Initialize field 3x7
     * 2. Specify players' sign
     * 3. Keyboard handling (hometask achievement)
     * 4. Move handling (hometask achievement)
     * 5. Check win
     * 6. Move handling (coordinates)
     * 7. Put value on field
     */
    public static void main(String[] args) {
        init();
    }

    static void init() {
        //TODO Разбить данную функцию на более на несколько мелких
        char[] signs = rollPlayingSign();
        char humanSign = signs[0];
        char[][] fieldValues = getFieldValues();
        drawPlayingField(fieldValues);
        String currentPlayer = "Human";
        char currentPlayerSign = humanSign;
        boolean isWin;
        do {

            int[] coordinates=move(currentPlayer);
            coordinates=AddValueOnField(currentPlayer,currentPlayerSign,fieldValues,coordinates);

            clearField();
            drawPlayingField(fieldValues);

            isWin = checkWin(fieldValues);
            if (!isWin) {
                currentPlayer = switchPlayer(currentPlayer);
                currentPlayerSign = switchPlayerSign(currentPlayerSign);
            }
        } while (!isWin);

        if (isWin) {
            System.out.println(String.format("Congrats Mr. %s!!! You are winner", currentPlayer));
        }

    }
    //Добавляем значение хода в игровое поле
    static int[] AddValueOnField(String currentPlayer, char currentPlayerSign,char[][] fieldValues,int[] coordinates){
        boolean isPlotted;
        do {
            isPlotted = putValueOnField(fieldValues, coordinates, currentPlayerSign);
            if (!isPlotted) {
                coordinates = move(currentPlayer);
                isPlotted = putValueOnField(fieldValues, coordinates, currentPlayerSign);
            }
        } while (!isPlotted);
        return coordinates;
    }


    static String switchPlayer(String currentUser) {
        return currentUser.equals("Human") ? "Computer" : "Human";
    }

    static char switchPlayerSign(char currentPlayerSign) {

        return currentPlayerSign == 'X' ? 'O' : 'X';
    }

    static void clearField() {
        for (int i = 0; i < 50; i++) {
            System.out.println("\b");
        }
    }

    /**
     * @param fieldValues
     * @param coordinates
     * @param playerSign
     * @return if value added true otherwise false
     */
    static boolean putValueOnField(char[][] fieldValues, int[] coordinates, char playerSign) {
        if (fieldValues[coordinates[0]][coordinates[1]] == dot) {
            fieldValues[coordinates[0]][coordinates[1]] = playerSign;
            System.out.println(String.format("Value plotted on coordinates [x: %s, y: %s]", coordinates[0], coordinates[1]));
            return true;
        }
        System.out.println("Value already plotted. Please choose other coordinates");
        return false;
    }

    static int[] move(String currentPlayer) {
        if (currentPlayer.equals("Human")) {
            return movePlayer();
        }
        return moveComputer();
    }

    /**
     * @return array of coordinates where first item is X, secondary is Y
     */
    static int[] movePlayer() {
        //TODO Сделать проверку на ввод недопустимых координат по [X, Y], вывести ошибку и дать возможность выбрать еще раз
        int mas[]={0,1,2};
        int mas1[]={1,3,5};
        int x=0;
        int y=0;
        x=inputCoordinates('X',mas);
        y=inputCoordinates('Y',mas1);
        return new int[]{x, y};
    }
    //Проверка на правильность введенных координат
    static boolean checkCoordinates(int mas[],int k){
        for (int i=0;i<3;i++){
            if (k==mas[i]) {
                return true;
            }
        }
        return false;
    }
    //Ввод координат
    static int inputCoordinates(char C,int mas[]){
        int x=0;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Input "+C+" coordinate of "+ Arrays.toString(mas));
            x = scanner.nextInt();
            if (checkCoordinates(mas,x)) break;
            System.out.println("You made a mistake with the coordinates. Please choose other coordinates");
        }while(!checkCoordinates(mas,x));
        return x;
    }
    /**
     * @return array of coordinates where first item is X, secondary is Y
     */
    static int[] moveComputer() {
        int[] availableXCoordinates = {0, 1, 2};
        int[] availableYCoordinates = {1, 3, 5};

        Random random = new Random();
        int x = availableXCoordinates[random.nextInt(3)];
        System.out.println(x);
        int y = availableYCoordinates[random.nextInt(3)];
        System.out.println(y);

        return new int[]{x, y};
    }

    static boolean checkWin(char[][] fieldValues) {
            return checkWinHorizontal(fieldValues,dot)==checkWinVertical(fieldValues,dot)==checkWinDiaganal(fieldValues,dot);

    }
    //Проверка победы по горизонтали
    static boolean checkWinHorizontal(char[][] fieldValues,char symbol){
        for (int i=0;i<3;i++)
        if (fieldValues[i][1] != symbol && fieldValues[i][3] != symbol && fieldValues[i][5] != symbol) {
            if (fieldValues[i][1] == fieldValues[i][3] && fieldValues[i][3] == fieldValues[i][5]) {
                return true;
            }
        }
        return false;
    }
    //Проверка победы по вертикали
    static boolean checkWinVertical(char[][] fieldValues,char symbol){
        for (int i=1;i<6;i+=2)
            if (fieldValues[0][i] != symbol && fieldValues[1][i] != symbol && fieldValues[2][i] != symbol) {
                if (fieldValues[0][i] == fieldValues[1][i] && fieldValues[1][i] == fieldValues[2][i]) {
                    return true;
                }
            }
        return false;
    }
    //Проверка победы по диагонали
    static boolean checkWinDiaganal(char[][] fieldValues,char symbol){
        for (int i=0, j=0;i<2;i++,j+=4)
            if (fieldValues[0][1+j] != symbol && fieldValues[1][3] != symbol && fieldValues[2][5-j] != symbol) {
                if (fieldValues[0][1+j] == fieldValues[1][3] && fieldValues[1][3] == fieldValues[2][5-j]) {
                    return true;
                }
            }
        return false;
    }
    static char[][] getFieldValues() {

        return enterFieldValues(3,7);
        };

    //заносим изначальные значения игрового поля nxk
    static char[][]enterFieldValues(int n, int k){
        char [][] playingField=new char[n][k];
        for (int i=0;i<n;i++){
            for (int j=0;j<=k-1;j+=2) {
                if (j==k-1)
                    playingField[i][j] = verticalLine;
                else{
                    playingField[i][j] = verticalLine;
                    playingField[i][j+1]=dot;
                }
            }
        }
        return playingField;
        }


    static char[] rollPlayingSign() {
        char[] signs = new char[2];
        System.out.println("Choosing X or O ...");
        int i=new Random().nextInt(2);
        if (i==0){
            choosePlayingSign(signs,'O','X',"Your sign: O");
        } else if(i==1){
            choosePlayingSign(signs,'X','O',"Your sign: X");
        }else {
            System.out.println("Something went wrong. Unknown sign rather than [X, O]");
            System.exit(-1);
        }
        return signs;
    }
    //присваиваем O или X игроку и компьютеру
    static void choosePlayingSign(char[] signs,char a, char b, String s){
        signs[0] = a;//значение игрока
        signs[1] = b;//значение компьютера
        System.out.println(s);
    }

    static void drawPlayingField(char[][] fieldValues) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(fieldValues[i][j]);
            }
            System.out.println();
        }
    }

}