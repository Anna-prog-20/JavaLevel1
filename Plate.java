import java.util.Scanner;

public class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
    }
    public boolean decreaseFood(int n) {
        if (food-n<0) {
            System.out.println("В тарелке нет столько еды!");
            do{
                infoAddFood();
                if (food-n>=0){
                    food-=n;
                    return true;
                }
            } while (food-n<0);
            return false;
        }
        else{
            food -= n;
        }
        return true;
    }
    public void info() {
        System.out.println("В тарелке: " + food+" ед. еды.");
    }

    public int addFood(int n){
        food+=n;
        return food;
    }

    public void infoAddFood(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Добавьте еду в тарелку!");
        int n = sc.nextInt();
        addFood(n);
    }

    public void setFood(int food) {

        this.food = food;
    }

    public int getFood() {

        return food;
    }
}
