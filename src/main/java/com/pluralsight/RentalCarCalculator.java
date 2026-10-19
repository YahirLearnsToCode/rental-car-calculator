package com.pluralsight;

import java.util.Scanner;

public class RentalCarCalculator {

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);

        // Prompting user for data
        System.out.print("When would you like to pick up the car? ");
        String pickUpDate = myScanner.nextLine();

        System.out.print("How many days would you like to rent the car? ");
        int rentalDays = Integer.parseInt(myScanner.nextLine());

        System.out.print("Do you want an electric toll tag at $3.95/day? y/n ");
        boolean hasTollTag = checkTollTag(myScanner.nextLine());

        System.out.print("Do you want an GPS at $2.95/day? y/n ");
        boolean hasGPS = checkGPS(myScanner.nextLine());

        System.out.print("Do you want roadside assistance at $3.95/day? y/n ");
        boolean hasRoadsideAssistance = checkRoadsideAssistance(myScanner.nextLine());

        System.out.print("What is your age? ");
        int age = Integer.parseInt(myScanner.nextLine());

        // variable to retrieve basic car rental price
        double basicCarRentalPrice = basicCarRental(rentalDays);
        double totalOptionsPrice = optionsCost(hasTollTag, hasGPS, hasRoadsideAssistance);
        double underAgeDriverSurcharge = 0;

        // Displaying all
        System.out.println("\nPick up date: " + pickUpDate);

        System.out.printf("Basic car rental Price : $%.2f\n",basicCarRentalPrice);

        System.out.printf("Total cost with addons: $%.2f\n", totalOptionsPrice);

        // checking to see if underage surcharge is applied
        if (age < 25) {
            underAgeDriverSurcharge = underageDriverSurcharge(basicCarRentalPrice);
            System.out.printf("Underage driver surcharge: $%.2f\n", underAgeDriverSurcharge);
        } else {
            System.out.println("Underage driver surcharge: $" + underAgeDriverSurcharge);
        }

        // Printing total
        System.out.printf("Your total car rental price is: $%.2f", (basicCarRentalPrice + totalOptionsPrice + underAgeDriverSurcharge));
    }

    // Method takes in hasTollTag answer y/n and returns true or false
    public static boolean checkTollTag(String hasTollTag) {
        return (hasTollTag.charAt(0) == ('y'));
    }

    // Method takes in hasGPS answer y/n and returns true or false
    public static boolean checkGPS(String hasGPS) {
        return (hasGPS.charAt(0) == ('y'));
    }

    // Method takes in hasRoadsideAssistance answer y/n and returns true or false
    public static boolean checkRoadsideAssistance(String hasRoadsideAssistance) {
        return (hasRoadsideAssistance.charAt(0) == ('y'));
    }

    // Calculating basic car rental
    public static double basicCarRental(int rentalDays) {
        return rentalDays * 29.99;
    }

    //Calculate fees from options
    public static double optionsCost(boolean hasTollTag, boolean hasGPS, boolean hasRoadsideAssistance) {
        double totalOptionsCost = 0;

        if (hasTollTag)
            totalOptionsCost += 3.95;

        if (hasGPS)
            totalOptionsCost += 2.95;

        if (hasRoadsideAssistance)
            totalOptionsCost += 3.95;

        return totalOptionsCost;
    }

    public static double underageDriverSurcharge(double basicCarRental) {
        // Instructions say to only print out how much the 30% fee but not totaled with price
        return (basicCarRental * .30);
    }
}
