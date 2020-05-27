public class Cat {
    private String name;
    private int appetite;
    private boolean satiety=false;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }

    public void eat(Plate p) {
        if (p.decreaseFood(appetite))
            satiety=true;
        infoSatiety(satiety);
    }

    public void infoSatiety(boolean satiety){
        if (satiety==false)
            System.out.println(String.format("Котик %s голодный!",name));
        else
            System.out.println(String.format("Котик %s сытый!",name));
    }
    public void setName(String name) {

        this.name = name;
    }

    public void setAppetite(int appetite) {

        this.appetite = appetite;
    }

    public void setSatiety(boolean satiety) {
        this.satiety = satiety;
    }

    public String getName() {

        return name;
    }

    public int getAppetite() {

        return appetite;
    }
    public boolean getSatiety(){
        return satiety;
    }
}
