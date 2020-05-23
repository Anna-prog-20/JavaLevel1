public class Main {

    public static void main(String[] args) {
        Cat cat=new Cat("Персик","рыжий",5);
        performActions(cat);
        Dog dog=new Dog("Бобик","белый",3);
        performActions(dog);
    }

    public static void performActions(Cat cat){
        cat.run(200);
        cat.jump(5);
        cat.swim(5);
        System.out.println("*******");
        cat.run5(200,500);
        cat.jump5(5,30);
        cat.swim5(5,0);
    }
    public static void performActions(Dog dog){
        dog.run(200);
        dog.jump(5);
        dog.swim(5);
        System.out.println("*******");
        dog.run5(200,100);
        dog.jump5(5,3);
        dog.swim5(5,6);
    }
}
