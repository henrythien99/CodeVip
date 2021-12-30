package dapp.services;

import java.util.InputMismatchException;
import java.util.Scanner;

import dapp.App;
import dapp.models.Product;

public class ProductService {
	private String date;

	public void insert() {
		try (Scanner inputs = new Scanner(System.in)) {
			System.out.println("Enter product info:");
			inputs.nextLine();
			try {
				System.out.println("Product Type: ");
				int type  = inputs.nextInt();

				inputs.nextLine();

				System.out.print("Code: ");
				int id = inputs.nextInt();

				inputs.nextLine();

				System.out.println("Name: ");
				String name = inputs.nextLine();

				inputs.nextLine();

				System.out.println("Quantum: ");
				int quantity = inputs.nextInt();

				inputs.nextLine();

				System.out.println("Note:");
				inputs.nextLine();

				System.out.println("Rate:");
				Float price = inputs.nextFloat();

				
				Product p = new Product(type, id, name, quantity, date, price);
				App.PRODUCTS.add(p);

			} catch (InputMismatchException ei) {
				System.out.println("You have entered the wrong value, please re-enter it!");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

	}

	public void show() {
		System.out.println("List products");
		String header = String.format("%s%15s%30s%15s%15s", "Product Type", "Code", "Name", "Quantum", "Rate", "Note");
		System.out.println(header);
		for (Product p : App.PRODUCTS) {
			String row = String.format("%d%15s%30d%15f%15s", p.getType(), p.getId(), p.getName(), p.getQuantity(), p.getPrice(),
					p.getDate());
			System.out.println(row);
		}

	}

	public void update() {
		try (Scanner inputs = new Scanner(System.in)) {
			try {
				System.out.println("Enter Code: ");
				Integer id = inputs.nextInt();
				Product product = null;

				for (Product p : App.PRODUCTS) {
					if (p.getId().equals(id)) {
						product = p;
						break;
					}
				}

				if (product == null) {
					System.out.println("Mã sản phẩm không tồn tại. Xin vui long nhập lại!");
				}

				System.out.println("info product");
				String row = String.format("%d%15s%30d%15f%15s", product.getId(), product.getName(), product.getQuantity(),
						product.getPrice(), product.getDate());
				System.out.println(row);

				for (int i = 0; i < App.PRODUCTS.size(); i++) {
					if (id.equals(App.PRODUCTS.get(i).getId())) {

						inputs.nextLine();

						System.out.println("Name: ");
						String name = inputs.nextLine();

						System.out.println("Quantum: ");
						int quantity = inputs.nextInt();

						inputs.nextLine();

						System.out.println("Datee:");
						Integer date = inputs.nextInt();

						System.out.println("Rate:");
						Float price = inputs.nextFloat();

						App.PRODUCTS.get(i).setName(name);
						App.PRODUCTS.get(i).setQuantity(quantity);
						App.PRODUCTS.get(i).setDate(date);
						App.PRODUCTS.get(i).setPrice(price);

					}
				}

			} catch (InputMismatchException ei) {
				System.out.println("You have entered the wrong value, please re-enter it!");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	public Product getById(int id) {
		Product product = new Product();
		
		for (Product p : App.PRODUCTS) {
			if (p.getId().equals(id)) {
				product = p;
				break;
			}
		}
		return product;
	}
}