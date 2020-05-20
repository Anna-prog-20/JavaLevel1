public class Main {

    public static void main(String[] args) {
        //Создать массив из 5 сотрудников
        Employee[] employee=new Employee[5];
        employee=enterValuesInMass(employee);
        displaysInformationFilter(employee);
    }
    //Вносим значения полей
    public static Employee[] enterValuesInMass(Employee employee[]){
        employee[0]=new Employee("Петров Петр Петрович","директор",
                "dirPPP@mail.ru","89263552626",150000,40);
        employee[1]=new Employee("Сидоренко Карл Петрович","главный бухгалтер",
                "buhSKP@mail.ru","89263552000",120000,35);
        employee[2]=new Employee("Петушко Ольга Викторовна","зам. директора",
                "zamdirPOV@mail.ru","89263550000",130000,45);
        employee[3]=new Employee("Петренко Василий Виниаминович","менеджер",
                "menegerPVV@mail.ru","89263552666",50000,50);
        employee[4]=new Employee("Раздобреева Анна Николаевна","специалист",
                "specRAN@mail.ru","89263552555",45000,45);
        return employee;
    }
    //С помощью цикла вывести информацию только о сотрудниках старше 40 лет
    public static void displaysInformationFilter(Employee mas[]){
        System.out.println("Информация о сотрудниках старше 40 лет:");
        for (int i=0;i<mas.length-1;i++){
            if (mas[i].getYearsOld()>=40)
                mas[i].displaysInformation();
        }
    }


}
