package Pack;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentManager {
    public static void main(String[] args) {
        ArrayList<Student> array = new ArrayList<>();
        while (true) {
            //主界面
            System.out.println("-------Welcome to the school student manager-------");
            System.out.println("1 input student information");
            System.out.println("2 fix student information");
            System.out.println("3 delete student information");
            System.out.println("4 look forward to all student information");
            System.out.println("5 exit");
            System.out.println("input your choice:");

            Scanner sc = new Scanner(System.in);
            String line = sc.nextLine();


            switch (line) {
                case "1":
                    //input student information
                    addStudent(array);
                    break;
                case "2":
                    // fix student information
                    updateStudent(array);
                    break;
                case "3":
                    //delete student information
                    deleteStudent(array);
                    break;
                case "4":
                    // look forward to all student information
                    findStudent(array);
                    break;
                case "5":
                    System.out.println("Thanks for your using");
                    System.exit(0);

            }


        }
    }


    public static void addStudent(ArrayList<Student> array) {
        Scanner sc = new Scanner(System.in);
        String sid;
        while (true) {
            System.out.println("input sid:");
             sid = sc.nextLine();

            boolean flag = used(array, sid);
            if (flag) {
                System.out.println("the number has used");
            } else {
                break;
            }
        }

        System.out.println("input name:");
        String name = sc.nextLine();

        System.out.println("input age:");
        String age = sc.nextLine();

        System.out.println("input address:");
        String address = sc.nextLine();


        Student s = new Student();
        s.setSid(sid);
        s.setName(name);
        s.setAge(age);
        s.setAdress(address);


        array.add(s);


    }

    public static boolean used(ArrayList<Student> array, String sid) {
        boolean flag = false;
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < array.size(); i++) {
            Student s = array.get(i);
            if (s.getSid().equals(sid)) {
                flag = true;
                break;
            }
        }


        return flag;
    }


    public static void updateStudent(ArrayList<Student> array) {
        int index = -1;
        Scanner sc = new Scanner(System.in);
        Student s = new Student();

        System.out.println("Enter the student number of the student to be modified：");
        String sid = sc.nextLine();

        System.out.println("input new name");
        String name = sc.nextLine();
        System.out.println("input new age");
        String age = sc.nextLine();
        System.out.println("input new address");
        String address = sc.nextLine();


        s.setSid(sid);
        s.setName(name);
        s.setAge(age);
        s.setAdress(address);

        for (int i = 0; i < array.size(); i++) {
            Student student = array.get(i);
            if (student.getSid().equals(sid)) {
                index = i;
            }
        }
        if (index == -1) {
            System.out.println("you have worry input");
        } else {
            array.set(index, s);
            System.out.println("update success");
        }

    }


    public static void deleteStudent(ArrayList<Student> array) {
        int index = -1;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the student number of the student to delete");
        String sid = sc.nextLine();

        for (int i = 0; i < array.size(); i++) {
            Student s = array.get(i);
            if (s.getSid().equals(sid)) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            System.out.println("you have worry input");
        } else {
            array.remove(index);
            System.out.println("delete success");
        }
    }


    public static void findStudent(ArrayList<Student> array) {
        if (array.size() == 0) {
            System.out.println("Please input information before querying");
            return;
        }
        System.out.println("sid  name  age  address");
        for (int i = 0; i < array.size(); i++) {
            Student s = array.get(i);
            System.out.println(s.getSid() + "  " + s.getName() + "  " + s.getAge() + "  " + s.getAdress());
        }
    }


}
