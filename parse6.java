package import1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class parse6 {

	public static String COMMA_DELIMITER = ",";

	
	public static void main(String[] args) {

		int android = 0;   // deklarera android räknare

		List<List<String>> records = new ArrayList<>();
		try (Scanner scanner = new Scanner(new File("sample.csv"));) {
			while (scanner.hasNextLine()) {
				records.add(getRecordFromLine(scanner.nextLine()));
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		//  Skapar en lista för personer med "a" i namnet
				List<String> personA = new ArrayList<String>();
				
				System.out.println ("\n" + "::::::::::Personer med a i deras namn::::::::::"+"\n");

				// iterera genom records och fylla localValues
				for (int i = 1; i < records.size(); i++) {
				// loopa genom values inne i records
				List<String> localValues = records.get(i);

				// kolla om namnlista 1 har personer med "a"
				if (localValues.get(1).toLowerCase().contains("a")) {
				// lägg till personA
				personA.add(localValues.get(1));
				}
				
				// kolla om namnlista 2 har personer med "a"
				if (localValues.get(2).toLowerCase().contains("a")) {
				// lägg till personA
				personA.add(localValues.get(2));
					}

				}

				// iterera genom hela personA och printa ut values
				for (String personB : personA) {
					System.out.println ("\n" + personB );

				}
		
		
		
		
		
		
		
		// Skapa en lista för personer som ska använda android
		List<String> personUsingAndroid = new ArrayList<String>();

		// iterera genom records
		for (int i = 0; i < records.size(); i++) {
			// iterera genom values inne i records
			List<String> localValues = records.get(i);

			// Kolla om kolumn 6 innehöller "Android"
			if (localValues.get(6).contains("Android")) {
				// adda dem till personUsing Android
				personUsingAndroid.add(localValues.get(6));
				android++; // plusa på räknare

			}

		}
		// Skriva resultat
		System.out.println("\n" +"\n" +"::Antal Personer som ska använda Android::" + android);
		
		
		
		

		// Skapar tre olika listor för namn1 lista1 naman2 lista 2 och tidstämpel
		List<String> tidStamp = new ArrayList<String>();
		List<String> namesOne = new ArrayList<String>();
		List<String> namesTwo = new ArrayList<String>();

		System.out.println("\n" + "\n" + "::::::::::Personer med Samma tidstämpel::::::::::");
		
		// iterera genom records
		for (int i = 0; i < records.size(); i++) {
			// iterera genom values inne i records och tilldela values till listor
			List<String> localValues = records.get(i);
			tidStamp.add(localValues.get(0));
			namesOne.add(localValues.get(1));
			namesTwo.add(localValues.get(2));

		}
		// iterera genom alla tre Arraylistor så att index i är lika för alla tre
		for (int i = 1; i < tidStamp.size(); i++)

		{
			System.out.println("\n" + tidStamp.get(i));
			System.out.println(namesOne.get(i) + "  " + namesTwo.get(i));

		}

	}
		
	

	private static List<String> getRecordFromLine(String line) {
		List<String> values = new ArrayList<String>();
		try (Scanner rowScanner = new Scanner(line)) {
			rowScanner.useDelimiter(COMMA_DELIMITER);
			while (rowScanner.hasNext()) {
				values.add(rowScanner.next());
			}
			
		
		}

		return values;
	}

}
