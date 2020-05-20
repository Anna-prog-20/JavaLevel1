//Создать класс "Сотрудник" с полями: ФИО, должность, email, телефон, зарплата, возраст

public class Employee{
    private String fullName;
    private String position;
    private String email;
    private String phon;
    private double salary;
    private int yearsOld;
    //Конструктор класса должен заполнять эти поля при создании объекта
    public Employee(String fullName,String position,String email,String phon, double salary,int yearsOld){
        this.fullName=fullName;
        this.position=position;
        this.email=email;
        this.phon=phon;
        this.salary=salary;
        this.yearsOld=yearsOld;
    }
    //Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль
    public void displaysInformation(){
        System.out.println(fullName +", "+position+", "+email+", "+phon+", "+salary+", "+yearsOld);
    }

    public int getYearsOld() {
        return yearsOld;
    }
}
