/**
 * @author Hong Huynh
 * CIS175 - Fall 2023
 * Sep 6, 2023
 */


package controller;

import java.util.Scanner;

import model.Plane;


public class PersistHelper {
	PlaneHelper helper = new PlaneHelper();

	public static void main(String[] args) {
		PersistHelper run = new PersistHelper();
		run.go();
	}

	private void go() {
		int userIn = 0;
		Scanner in = new Scanner(System.in);
		
		while (userIn != 5) {
			printMenu();
			userIn = in.nextInt();
			if (userIn == 1) {
				Plane t = new Plane();
				System.out.println("Enter name of Plane:");
				t.setName(in.next());
				System.out.println("Enter Plane length:");
				t.setLength(in.nextInt());
				helper.persist(t);
			} 
			else if (userIn == 2) {
				showAll();
			} 
			else if (userIn == 3) {
				Plane t = new Plane();
				System.out.println("Enter RowID of Plane to delete:");
				t.setRowId(in.nextInt());
				helper.delete(t);
			} 
			else if (userIn == 4) {
				Plane t = new Plane();
				showAll();
				System.out.println("Enter RowID of Plane to Update:");
				t.setRowId(in.nextInt());
				System.out.println("Enter new name of Plane:");
				t.setName(in.next());
				System.out.println("Enter new Plane length:");
				t.setLength(in.nextInt());
				helper.update(t);
			}
		}
		System.out.println("Done!");

	}

	/**
	 * @param helper
	 */
	private void showAll() {
		for (Plane t : helper.showAllPlane()) {
			//t.toString();
			System.out.println(t.toString());
		}
	}

	private void printMenu() {
		System.out.println("1.Create Plane");
		System.out.println("2.Show Plane");
		System.out.println("3.Delete Plane");
		System.out.println("4.Update Plane");
		System.out.println("5.Quit");
		System.out.println("**************");
	}

}

