package program;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.excetion.DomainException;

public class Application {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy"); 
		
		try {
			System.out.print("Room number: ");
			Integer roomNumber = input.nextInt();
			
			System.out.print("Check-in date (dd/MM/yyyy): ");
			Date checkIn = sdf.parse(input.next());
			
			System.out.print("Check-out date (dd/MM/yyyy): ");
			Date checkOut = sdf.parse(input.next());
	
			Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);	
			System.out.println("Reservation:" + reservation.toString());
			
			System.out.println("\nEnter data to update the reservation: ");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			checkIn = sdf.parse(input.next());
			
			System.out.print("Check-out date (dd/MM/yyyy): ");
			checkOut = sdf.parse(input.next());
			
			reservation.updateDates(checkIn, checkOut);
			System.out.println("Reservation:" + reservation.toString());		
		}
		catch (ParseException e) {
			System.out.println("Invalid date format");
		}
		catch (DomainException e) {
			System.out.println("Error in reservation: " + e.getMessage());
		}
		catch (RuntimeException e) {
			System.out.println("Unexpected error");
		}
				
		input.close();
	}
}


