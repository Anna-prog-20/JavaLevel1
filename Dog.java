//1. Создать классы Собака и Кот с наследованием от класса Животное
public class Dog extends Animal{
    public Dog(String name,String color,int age){
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
        if (length<=500)
            System.out.println(String.format("%s пробежал %d м",getName(),length));
        else
            System.out.println(String.format("%s не может пробежать %d м",getName(),length));
    }

    @Override
    public void swim(int length) {
        if (length<=10)
            System.out.println(String.format("%s проплыл %d м",getName(),length));
        else
            System.out.println(String.format("%s не может проплыть %d м",getName(),length));
    }

    @Override
    public void jump(int height) {
        if (height<=0.5)
            System.out.println(String.format("%s прыгнул %d м",getName(),height));
        else
            System.out.println(String.format("%s не может прыгнуть %d м",getName(),height));
    }
}
