//1. Создать классы Собака и Кот с наследованием от класса Животное
public class Cat extends Animal{
    public Cat(String name,String color,int age){
        super(name,color,age);
    }
    //3. У каждого животного есть ограничения на действия
    // (бег: кот 200 м., собака 500 м.; прыжок: кот 2 м., собака 0.5 м.;
    // плавание: кот не умеет плавать, собака 10 м.).
    //4. При попытке животного выполнить одно из этих действий,
    // оно должно сообщить результат в консоль.
    // (Например, dog1.run(150); -> результат: run: true)
    @Override
    public void run(int length) {
        if (length<=200)
            System.out.println(String.format("%s пробежал %d м",getName(),length));
        else
            System.out.println(String.format("%s не может пробежать %d м",getName(),length));
    }

    @Override
    public void swim(int length) {
        System.out.println(String.format("%s не умеет плавать",getName()));
    }

    @Override
    public void jump(int height) {
        if (height<=2)
            System.out.println(String.format("%s прыгнул %d м",getName(),height));
        else
            System.out.println(String.format("%s не может прыгнуть %d м",getName(),height));
    }
}
