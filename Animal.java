public abstract class Animal {
    private String name;
    private String color;
    private int age;

    public Animal(String name, String color, int age){
        this.name=name;
        this.color=color;
        this.age=age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public int getAge() {
        return age;
    }
    //2. Животные могут выполнять действия: бежать, плыть, перепрыгивать препятствие.
    // В качестве параметра каждому методу передается величина,
    // означающая или длину препятствия (для бега и плавания),
    // или высоту (для прыжков)
    public abstract void run(int length);
    public abstract void swim(int length);
    public abstract void jump(int height);
    //5. * Добавить животным разброс в ограничениях.
    // То есть у одной собаки ограничение на бег может быть 400 м., у другой 600 м
    public void run5(int length,int confinesLength){
        if (length<=confinesLength)
            System.out.println(String.format("%s пробежал %d м",getName(),length));
        else
            System.out.println(String.format("%s не может пробежать %d м",getName(),length));
    };
    public void swim5(int length,int confinesLength){
        if (length<=confinesLength)
            System.out.println(String.format("%s проплыл %d м",getName(),length));
        else if (confinesLength==0)
            System.out.println(String.format("%s не может плавать",getName()));
        else
            System.out.println(String.format("%s не может проплыть %d м",getName(),length));
    };
    public void jump5(int height,int confinesHeight){
        if (height<=confinesHeight)
            System.out.println(String.format("%s прыгнул %d м",getName(),height));
        else
            System.out.println(String.format("%s не может прыгнуть %d м",getName(),height));
    };
}
