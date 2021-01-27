package com.kruehl;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		//Deklaration
		float avg;
		int grade;
		int gradeAmount = 0;
		int[] gradeArray;
		
		System.out.println("Fuer welche Schulform wollen Sie den Schnitt berechnen?");
		System.out.println("Gymnasiale Oberstufe [G], Teilzeitberufsschule [T], Berufsfachschule[B]");

		Scanner scanner = new Scanner(System.in);
		String form = scanner.nextLine();
		
		System.out.println("Geben Sie die Anzahl der Noten an: ");
		
		try{
			gradeAmount = scanner.nextInt();
			if(gradeAmount < 1) {
				System.err.println("Die Anzahl der Noten muss mindestesens 1 sein");
				
				System.exit(-1);
			}
		} catch(IllegalArgumentException iae)
		{
			System.out.println("Die Anzahl der der Noten muss als ganze Zahl angegeben werden!");
			iae.printStackTrace();
		}
		gradeArray = new int[gradeAmount];	
			
		switch (form) {
		
            case "G": 
            case "g": 
            //Gymnasiale Oberstufe
            
            	for(int i=0;i<gradeAmount;i++)
            	{
            		System.out.println("Geben Sie Zahl " + i+1 + " ein: ");
            		grade = scanner.nextInt();
            		inputCheck(""+grade, 0, 15);
            		gradeArray[i] = grade;
            	}

                break;
                
            case "T": 
            case "t": 
            //Teilzeitberufsschule           	
            	for(int i=0;i<gradeAmount;i++)
            	{
            		System.out.println("Geben Sie Zahl " + i+1 + " ein: ");
            		grade = scanner.nextInt();
            		inputCheck(""+grade, 0, 6);
            		gradeArray[i] = grade;
            	}            	
				
                break;
                
            case "B": 
            case "b": 
            //Berufsfachschule           	
            	for(int i=0;i<gradeAmount;i++)
            	{
            		System.out.println("Geben Sie Zahl " + i+1 + " ein: ");
            		grade = scanner.nextInt();
            		inputCheck(""+grade, 0, 6);
            		gradeArray[i] = grade;
            	}
            	
                break;
                
            default: //error handling
                System.out.println(form + " Schulform falsch eingegeben!");
				System.exit(1);
        }
		avg = calculateAvgAndRound(gradeArray, gradeAmount);
		System.out.println("Der Durchschnitt ist: " + avg);
	}

	private static void inputCheck(String input, int min, int max) {
		
		try{
            int intInput = Integer.parseInt( input );
    		if (intInput < min || intInput > max) {
    			System.out.println("Falsche Eingabe!!");
    			System.out.println("Note muss zwischen " + min + " und " + max
    					+ " liegen.");
    			System.exit(1);
    		}
		}
		catch ( NumberFormatException e ) {
            System.err.println( "Das war keine Zahl!" );
            
            System.exit(-1);
		}
	}

	private static float calculateAvgAndRound(int[] gradeArray, int gradeAmount) {
		float sum = 0;
		for(int i=0;i<gradeAmount;i++)
		{
			sum += gradeArray[i];
		}
		float avg = (sum) / (float) gradeAmount;
		float rounded = roundToOneFract(avg);
		return rounded;
	}

	private static float roundToOneFract(float average) {
		return (float) (Math.floor(average * 10) / 10);
	}
}
