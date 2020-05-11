import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        //1 задание: Задать целочисленный массив, состоящий из элементов 0 и 1.
        // Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
        // С помощью цикла и условия заменить 0 на 1, 1 на 0
        System.out.println("1 задание:");
        replacement();
        //2 задание: Задать пустой целочисленный массив размером 8.
        // С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21
        System.out.println("2 задание:");
        fillin();
        //3 задание: Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ]
        // пройти по нему циклом, и числа меньшие 6 умножить на 2
        System.out.println("3 задание:");
        comparison();
        //4 задание: Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
        // и с помощью цикла(-ов) заполнить его диагональные элементы единицами
        System.out.println("4 задание:");
        System.out.println("Введите размер массива:");
        int n=sc.nextInt();
        squaremas(n);
        //5 задание: ** Задать одномерный массив и найти в нем минимальный и максимальный элементы
        System.out.println("5 задание:");
        minmax();
        //6 задание:  ** Написать метод, в который передается не пустой одномерный целочисленный массив,
        // метод должен вернуть true, если в массиве есть место, в котором сумма левой и правой части массива равны.
        // Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true, checkBalance([1, 1, 1, || 2, 1]) → true,
        // граница показана символами ||, эти символы в массив не входят
        System.out.println("6 задание:");
        int [] mas={2,2,2,2,2,10};
        if (checkBalance(mas))
            System.out.println("Сумма левой и правой части массива равны");
        else System.out.println("В массиве нет равных частей");

    }
    public static void replacement(){
        int [] mas={1,0,0,1,0,1,1,1,0,0,1};
        displaymas("Исходный массив:",mas);
        for(int i=0;i<mas.length;i++){
            if (mas[i]==1) mas[i]=0;
                else mas[i]=1;
        }
        displaymas("Массив после замены 0 на 1, 1 на 0:",mas);
    }
    public static void fillin(){
        int []mas = new int[8];
        for (int i=0;i<mas.length;i++){
            mas[i]=i*3;
        }
        displaymas("Заполненный массив:",mas);
    }
    public static void comparison(){
       int []mas = {1,5,3,2,11,4,5,2,4,8,9,1};
       displaymas("Исходный массив:",mas);
       for (int i=0;i<mas.length;i++){
           if (mas[i]<6)
               mas[i]=mas[i]*2;
       }
       displaymas("Массив после замены чисел:",mas);
    }
    public static void squaremas(int n){
        int [][] mas=new int [n][n];
        for (int i=0; i<mas.length;i++)
            for(int j=i;j<i+1;j++)
                mas[i][j]=1;
         displaymas2("Двумерный массив ",mas);
    }
    public static void minmax(){
        int [] mas={1,5,8,9,0,20,16};
        int min=mas[0];
        int max=mas[0];
        for (int i=1; i<mas.length;i++){
            if (mas[i]<min) min=mas[i];
            if (mas[i]>max) max=mas[i];
        }
        displaymas("Массив:",mas);
        System.out.println("Минимальное значение массива: "+min);
        System.out.println("Минимальное значение массива: "+max);
    }
    public static boolean checkBalance(int mas[]){
        int s=0; //общая сумма
        int s1=0; //сумма слева
        int s2=0; //сумма справа
        for (int i=0;i<mas.length;i++)
            s=s+mas[i];
        s2=s;
        for (int i=0;i<mas.length;i++){
            s1=s1+mas[i];
            s2=s2-mas[i];
            if (s2==s1)
                return true;
        }
        return false;
    }

    public static void displaymas(String s, int mas[]){
        System.out.println(s);
        for(int i=0;i<mas.length;i++){
            System.out.print(mas[i]+" ");
        }
        System.out.println();
    }
    public static void displaymas2(String s, int mas[][]){
        System.out.println(s);
        for(int i=0;i<mas.length;i++){
            for (int j=0;j<mas.length;j++){
                System.out.print(mas[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
}

