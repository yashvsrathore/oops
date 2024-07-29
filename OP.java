import java.util.*;
import java.lang.*;

interface utility{
    public void get_details();
    public void set_details();
}
class Showroom implements utility{
    String Sname;
    String city;
    int totEmp;
    int totCars = 0;
    String SManager;

    @Override
    public void get_details() {
        System.out.println("*Showroom Name is: "+Sname);
        System.out.println("*Showroom Address is: "+city);
        System.out.println("*Manager Name is: "+SManager);
        System.out.println("*Total Employees is: "+totEmp);
        System.out.println("*Total Cars In Stock is: "+totCars);
    }
    @Override
    public void set_details(){
        Scanner o = new Scanner(System.in);
        System.out.println("**Please type");
        System.out.println();
        System.out.print("*The Showroom Name: ");
        Sname = o.nextLine();
        System.out.print(("*The Showroom Address: "));
        city = o.nextLine();
        System.out.print("*The Manager Name: ");
        SManager = o.nextLine();
        System.out.print("*The total no. of employees: ");
        totEmp = o.nextInt();
        System.out.print("*The total no. of cars present in stock: ");
        totCars = o.nextInt();
    }
}

class Cars extends Showroom {
    String CModel;
    String CColor;
    String CFuelType;
    int CPrice;
    String CType;
    String CTransmission;

    @Override
    public void get_details(){
        System.out.println("*Model Name: "+CModel);
        System.out.println("*Color of car: "+CColor);
        System.out.println("*Fuel type of car: "+CFuelType);
        System.out.println("*Price of car: "+CPrice);
        System.out.println("*Type of Car: "+CType);
        System.out.println("*Transmission: "+CTransmission);
    }

    @Override
    public void set_details(){
        Scanner o= new Scanner(System.in);
        System.out.println("**Please Enter the following details");
        System.out.println();
        System.out.print("*Car Model (Name): ");
        CModel = o.nextLine();
        System.out.print(("*Car Color: "));
        CColor= o.nextLine();
        System.out.print("*Fuel type of car: ");
        CFuelType = o.nextLine();
        System.out.print("*Price of car: ");
        CPrice = o.nextInt();
        o.nextLine();  //going to next line
        System.out.print("*Type of Car: ");
        CType = o.nextLine();
        System.out.print("*Transmission: ");
        CTransmission = o.nextLine();
        totCars++;
    }
}
class Employees extends Showroom{
    String Eid;
    String Ename;
    int Eage;
    String Edepart;


    @Override
    public void get_details() {
        System.out.println("*Employee id: "+Eid);
        System.out.println("*Name: "+Ename);
        System.out.println("*Age: "+Eage);
        System.out.println("*Department: "+Edepart);
        System.out.println("*Showroom Name: "+Sname);

    }
    @Override
    public void set_details(){
        Scanner o = new Scanner(System.in);
        UUID uuid = UUID.randomUUID();
        Eid = String.valueOf(uuid);
        System.out.println("**Please Enter employee details");
        System.out.println();
        System.out.print("*Name of Employee: ");
        Ename = o.nextLine();
        System.out.print(("*Age: "));
        Eage= o.nextInt();
        o.nextLine();
        System.out.print("*Department: ");
        Edepart =o.nextLine();
        System.out.print("*Name of Showroom");
        Sname =o.nextLine();


    }
}

class op{

    static void display(){
        System.out.println();
        System.out.println(" Hi there! What Would like to do? ");
        System.out.println("***\n");
        System.out.println();
        System.out.println("**Press 1. to add more Showrooms \n");
        System.out.println("**Press 2. to add more Employees \n");
        System.out.println("**Press 3. to add more Cars \n");
        System.out.println("**Press 4. to display all the Showrooms \n  ");
        System.out.println("**Press 6. to dosplay all the Cars\n");
        System.out.println("**Press 5. to display all the Employees \n");
        System.out.println("**Press 0. to quit \n");

    }

    public static void main(String[] args) {
        Scanner o = new Scanner(System.in);
        Showroom s[] = new Showroom[10];
        Employees e[] = new Employees[10];
        Cars c[] = new Cars[10];
        int carCounter = 0;
        int showroomCounter = 0;
        int employeesCounter = 0;
        int choice = 100;
        while(choice!=0){

            display();//Called to display menu
            choice = o.nextInt();
            while(choice!=9 && choice!=0){
                switch (choice) {
                    case 1:
                        s[showroomCounter] = new Showroom();
                        s[showroomCounter].set_details();
                        showroomCounter++;
                        System.out.println();
                        System.out.println("*Press 1 to Add another showroom");
                        System.out.println("*Press 9 to go back to display menu");
                        choice = o.nextInt();
                        break;
                    case 2:
                        e[employeesCounter] = new Employees();
                        e[employeesCounter].set_details();
                        employeesCounter++;
                        System.out.println();
                        System.out.println("*Press 2 to add another employee");
                        System.out.println("*Press 9 to go back to display menu");
                        choice =o.nextInt();
                        break;
                    case 3:
                        c[carCounter] = new Cars();
                        c[carCounter].set_details();
                        carCounter++;
                        System.out.println();
                        System.out.println("* Press 3 to add new car");
                        System.out.println("*Press 9 to go back to main menu");
                        choice = o.nextInt();
                        break;
                    case 4:
                        for (int i = 0; i < showroomCounter; i++) {
                            s[i].get_details();
                            System.out.println();
                            System.out.println("-------------------");
                        }
                        System.out.println();
                        System.out.println("*press 9 to go back to display menu");
                        System.out.println("*Press 0 to exit");
                        choice = o.nextInt();
                        break;
                    case 5:
                        for (int i = 0; i < employeesCounter; i++) {
                            e[i].get_details();
                            System.out.println();
                            System.out.println();
                        }
                        System.out.println();
                        System.out.println("*Press 9 to go back to display menu");
                        System.out.println("*Press 0 to exit");
                        choice = o.nextInt();
                        break;
                    case 6:
                        for (int i = 0; i < carCounter; i++) {
                            c[i].get_details();
                            System.out.println();
                            System.out.println();
                        }
                        System.out.println();
                        System.out.println("*Press 9 for display menu");
                        System.out.println("*Press 0 to exit");
                        choice = o.nextInt();
                        break;
                    default:
                        System.out.println("*Please enter valid choice: ");
                        break;
                }
            }
        }
    }
}