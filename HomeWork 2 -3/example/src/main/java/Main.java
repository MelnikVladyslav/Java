import java.sql.*;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Connect to database
        String strCon="jdbc:mariadb://localhost:3306/java_vpd011";
        Scanner input = new Scanner(System.in);
        int oper = 0;

        System.out.println("Enter the number oper: ");
        oper = input.NextInt();

        if (oper == 1) {
            //Select
            try (Connection con = DriverManager.getConnection(strCon, "root", "")) {
                System.out.println("Connection is good");
                String query = "SELECT * FROM categories";
                PreparedStatement command = con.prepareStatement(query);
                ResultSet resultSet = command.executeQuery();
                while (resultSet.next()) {
                    System.out.println("Id: " + resultSet.getInt("id"));
                    System.out.println("Name: " + resultSet.getString("name"));
                }
            } catch (Exception ex) {
                System.out.println("Error connection " + ex.getMessage());
            }
        }

        //Insert
        if(oper == 2)
        {
            string name = "";
            try (Connection con = DriverManager.getConnection(strCon, "root", "")) {
                System.out.println("Connection is good");
                System.out.println("Enter the name: ");
                name = input.NextInt();
                String query = "INSERT INTO `categories`(`name`) VALUES ('[value-2]')";
                PreparedStatement command = con.prepareStatement(query);
            } catch (Exception ex) {
                System.out.println("Error connection " + ex.getMessage());
            }
        }
        //Update
        if (oper == 3)
        {
            string name = "";
            try (Connection con = DriverManager.getConnection(strCon, "root", "")) {
                System.out.println("Connection is good");
                System.out.println("Enter the name: ");
                name = input.NextInt();
                String query = "UPDATE `categories` SET `id`='[value-1]',`name`='[value-2]' WHERE 1";
                PreparedStatement command = con.prepareStatement(query);
            } catch (Exception ex) {
                System.out.println("Error connection " + ex.getMessage());
            }
        }
        //Delete
        if (oper == 4)
        {
            int id = 0;
            try (Connection con = DriverManager.getConnection(strCon, "root", "")) {
                System.out.println("Connection is good");
                System.out.println("Enter the id: ");
                id = input.NextInt();
                String query = "DELETE FROM `categories` WHERE 0";
                PreparedStatement command = con.prepareStatement(query);
            } catch (Exception ex) {
                System.out.println("Error connection " + ex.getMessage());
            }
        }
    }

    //Test array
    public static void testArray()
    {
        Scanner input = new Scanner(System.in);
        int n = 10;
        int[] mas = new int[n];
        for (int i = 0; i < n; i++)
            mas[i] = getRandomNumber(-10, 20);

        for (int item : mas)
            System.out.printf("%d\t", item);
        System.out.println();
        int count = 0;
        for (int item : mas) {
            if(item>=0)
                count++;
        }
        System.out.println("Кількість додатніх чисел "+ count);
    }

    //Sort array
    public static void SortArray()
    {
        Person[] list = {
                new Person("Іван", "Музичко"),
                new Person("Оксана", "Марко"),
                new Person("Василь", "Шлунок"),
                new Person("Вікторія", "Закуска"),
                new Person("Олег", "Закуска"),
                new Person("Артур", "Закуска")
        };

        for (Person p : list)
            System.out.println(p);

        Arrays.sort(list /*, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getLastName().compareTo(o2.getLastName());
            }
        }*/);

        System.out.println("------Сортований список-------");
        for (Person p : list)
            System.out.println(p);
    }
    public static int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
}
