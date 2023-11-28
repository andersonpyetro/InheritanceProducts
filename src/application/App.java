package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class App {
	
	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Product> list = new ArrayList<>();
		
		System.out.println("Enter the number of products: ");
		int n = sc.nextInt();
		
		for (int i = 1; i<n; i++) {
			System.out.print("Product #" + i + " data");
			System.out.print("Comom, used or imported: ");
			char type = sc.next().charAt(0);
			System.out.print("name: ");
			String name = sc.nextLine();
			System.out.print("Price: ");
			Double price = sc.nextDouble();
			
			if (type == 'c') {
				list.add(new Product(name, price));
			}
			
			if (type == 'i') {
				System.out.print("Customs fee: ");
				Double customsFee = sc.nextDouble();
				list.add(new ImportedProduct(name,price, customsFee));
			
			} 
			else if (type == 'u') {
				System.out.print("Manufacture date (DD/MM/YYYY): ");
				LocalDate date = LocalDate.parse(sc.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
				list.add(new UsedProduct(name, price, date));
			}
			
		}
		
		System.out.println();
		System.out.print("PRICE TAGS: ");
		
		for (Product prod : list) {
			System.out.println(prod.priceTag());
		}
		
		
		
		
		
		
		
		
		
		
		
		
		sc.close();		
	}

}
