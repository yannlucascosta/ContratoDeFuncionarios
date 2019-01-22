package teste;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Departament;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

public class Start {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		SimpleDateFormat b = new SimpleDateFormat("dd/MM/yyyy");
		
		
		Scanner in = new Scanner(System.in);
		System.out.print("Enter department's name: ");
		String departament = in.nextLine();
		System.out.print("Enter worker data: ");
		System.out.println();
		System.out.print("Name: ");
		String name = in.nextLine();
		System.out.print("Level: ");
		String level = in.nextLine();
		System.out.print("Base Salary: ");
		double salary = in.nextDouble();
		
		Worker a = new Worker(new Departament(departament) , name , WorkerLevel.valueOf(level) ,salary );
		System.out.println();
		System.out.print("How many contracts to this worker?");
		int n = in.nextInt();
		
		
		
		for(int i = 0;i<n;i++) {
			System.out.println("Enter contract #"+(i+1)+" data:");
			System.out.print("Date (DD/MM/YYYY):");
			Date data = b.parse(in.next());
			System.out.print("Value per hour: ");
			double valor = in.nextDouble();
			System.out.print("Duration (hours): ");
			int duration = in.nextInt();
			HourContract c = new HourContract(data ,valor , duration );
			a.addContract(c);
			
			
		}
		
		System.out.println();
		System.out.print("Enter month and year to calculate income (MM/yyyy): ");
		String mesAno = in.next();
		int month = Integer.parseInt(mesAno.substring(0 , 2));
		int year = Integer.parseInt(mesAno.substring(3));
		System.out.println("Name: "+a.getName());
		System.out.println("Departament: "+a.getDepartament().getName());
		System.out.println("Income for: "+mesAno +": "+String.format("%.2f",a.income(year , month)));
		
		
		
		
		
	}

}
