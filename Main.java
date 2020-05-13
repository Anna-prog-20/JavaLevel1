import java.util.Random;
import java.util.Scanner;

public class Main {
    //Создать массив из слов String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
    //При запуске программы компьютер загадывает слово, запрашивает ответ у пользователя,
    //сравнивает его с загаданным словом и сообщает правильно ли ответил пользователь. Если слово не угадано, компьютер показывает буквы которые стоят на своих местах.
    //apple – загаданное
    //apricot - ответ игрока
    //ap############# (15 символов, чтобы пользователь не мог узнать длину слова)
    //Для сравнения двух слов посимвольно, можно пользоваться:
    //String str = "apple";
    //str.charAt(0); - метод, вернет char, который стоит в слове str на первой позиции
    //Играем до тех пор, пока игрок не отгадает слово
    //Используем только маленькие буквы
    public static void main(String[] args) {
        gameMakeup();

    }
    public static void gameMakeup(){
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli",
                "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom",
                "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        Scanner sc=new Scanner(System.in);
        String puzzle=makeup(words);
        boolean a;
        //System.out.println("Тсссс!!! Я загадал слово: "+puzzle);
        System.out.println("Угадай, какое из следующих слов я загадал:");
        display(words);
        do{
            String reply = sc.next();
            a=compare(puzzle, reply);
        }while (a==false);
        sc.close();
    }
    //загадываем слово
    static String makeup(String words[]){
        Random r=new Random();
        int i=r.nextInt(words.length);
        return words[i];
    }
    //Выводим массив слов
    static void display(String[] words){
        for (int i=0;i<words.length;i++){
            System.out.println(words[i]);
        }
    }
    //сравниваем слово загадку и ответ
    static boolean compare(String puzzle,String reply){
        int n=SearchMinSize(puzzle,reply);
        if (puzzle.equals(reply)){
            System.out.println("Поздравляю!!! Вы угадали!!!");
            return true;
        }else {
            String s=getString(puzzle,reply,n);
            int k=calculateQuantity(s);
            if (k!=s.length()-1){
                System.out.println("Вы не угадали, но есть совпадения букв "+s);
                System.out.println("Попробуйте ещё раз");}
                else {
                    System.out.println("Вы не угадали, и совпадений нет!");
                    System.out.println("Попробуйте ещё раз");
                }
            return false;
        }
    }
    //ищем минимальный размер слова
    static int SearchMinSize(String puzzle,String reply){
        if (puzzle.length()<=reply.length()){
            return puzzle.length();
        } else {
            return reply.length();
        }
    }
    //расчитываем количество # в строке s
    static int calculateQuantity(String s) {
        int k = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '#') {
                k++;
            }
        }
        return k;
    }
    //получаем строчку с совпадениями слова загадки и ответа для подсказки
    static String getString(String puzzle,String reply,int n){
        String s="";
        for (int i = 0; i < n; i++) {
            if (puzzle.charAt(i) == reply.charAt(i)) {
                s+=puzzle.charAt(i);
            }else{
                s+="#";
            }
        }
        if (n<15) {
            for (int i = 0; i < 15 - n - 1; i++) {
                s += "#";
            }
        }
        return s;
    }
}
