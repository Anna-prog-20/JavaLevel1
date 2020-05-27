public class Main {

    public static void main(String[] args) {
        Cat[] cat=new Cat[3];
        cat=enterValuesInMass(cat);
        Plate plate = new Plate(100);
        plate.info();
        feedCat(cat,plate);
    }

    //Вносим значения полей
    public static Cat[] enterValuesInMass(Cat cat[]){
        cat[0]=new Cat("Barsik",5);
        cat[1]=new Cat("Vaska",150);
        cat[2]=new Cat("Borya",5);
        return cat;
    }

    public static void feedCat(Cat cat[],Plate plate){
        for (int i=0;i<cat.length;i++) {
            cat[i].eat(plate);
            plate.info();
        }
    }
}
