package dapp;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import dapp.models.Order;
import dapp.models.Product;
import dapp.services.OrderService;
import dapp.services.ProductService;


/**
 * Hello world!
 *
 */

public class App {
	
	public static List<Product> PRODUCTS = new ArrayList<Product>();
	public static List<Order> ORDERS = new ArrayList<Order>();

	public static void menu() {
		System.out.println("------------------List Option------------------");
		System.out.println("1. Add new products");
		System.out.println("2. Show products");
		System.out.println("3. Edit product");
		System.out.println("4. Delete product");
		System.out.println("5. Purchase");
		System.out.println("6. Show order list");
		System.out.println("7. Exit.");
		System.out.println("------------Edit by Vo Dang Hong Thien------------");
	}

	public static void main(String[] args) {
		
		for (int i = 0; i < 4; i++) {
			Float price = (float) (i + 4);
			Product p = new Product(i + 1, i, "SP " + (i + 1), 1,
					"Date"  + (i + 1), price);
			
			App.PRODUCTS.add(p);
		}
		
		int function = 0;
		
		do {
			menu();
			try (Scanner inputs = new Scanner(System.in)) {
				try {
					System.out.print("Select Number Menu: ");
					function = inputs.nextInt();
					ProductService productService = new ProductService();
					OrderService orderService = new OrderService();
					
					switch (function) {
					case 1:
						productService.insert();
						break;
					case 2:
						productService.show();
						break;
					case 3:
						productService.update();
						break;
					case 4:
						
						break;
					case 5:
						orderService.order();
						break;
					case 6:
						orderService.show();
						break;

					default:
						break;
					}
				} catch (InputMismatchException ei) {
					System.out.println("You have entered the wrong value, please re-enter it!");
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}

		} while (function != 7);

		System.out.println("Thank you for using App Super Market");

	}
}
