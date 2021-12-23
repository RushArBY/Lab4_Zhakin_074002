package labarotorische4;

import java.io.*;

public class Employee {
    String surname;
    int salary;
    boolean isHaveKids;
    Employee() throws IOException{
        String b;
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in,"Cp1251"));
        System.out.println("\nEnter surname:");
        this.surname=input.readLine();
        System.out.println("\nEnter salary:");
        this.salary= Integer.parseInt(input.readLine());
        while(true){
            System.out.print("\nHaving kids (Yes/No):");
            b=input.readLine();
            if("Yes".equals(b)){
                this.isHaveKids=true;
                break;}
            if ("No".equals(b)){
                this.isHaveKids=false;
                break;
            }
            System.out.print("\nError!Repeat input.");
        }
    }
    public void InputFile() throws IOException {
        File file = new File("document.doc");
        file.deleteOnExit();
        FileWriter writer = new FileWriter(file, true);
        writer.append("\nThe surname of employee:").append(this.surname).append("; salary:").append(String.valueOf(this.salary)).append(";");
        if (this.isHaveKids)
            writer.append("The employee has deti.\n");
        else writer.append("There employee has no detey.\n");
        writer.flush();
        writer.close();
    }
    public static void OutputOfFile() throws IOException {
        File file = new File("document.doc");
        FileReader reader;
        char buffer[];
        int num;
        buffer = new char[1];
        reader = new FileReader(file);
        do {
            num = reader.read(buffer);
            System.out.print(buffer[0]);

        } while (num == 1);
        reader.close();
    }
    public static void main (String[] args) throws IOException{
        Employee[] employees;
        employees = new Employee[3];
        for (int i=0;i<3;i++)
            employees[i]=new Employee();
        for (int i=0;i<3;i++)
            employees[i].InputFile();
        OutputOfFile();


    }
}