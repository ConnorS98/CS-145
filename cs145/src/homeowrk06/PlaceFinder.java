package homeowrk06;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class PlaceFinder {

	public static void main(String[] args) {
		//Query the user for a place:
		Scanner user = new Scanner(System.in);
		System.out.println("You asked me to search for a place: ");
		String place = user.next();
		System.out.println(place + " has zip codes: " + PUT THE RESULTS OF THE ARRAY HERE + "\n");
		System.out.println("Do you want to search again? ");
		String again = user.next();
		if (again.startsWith("y") || again.startsWith("Y")) {
			System.out.println("You asked me to search for a place: ");
			place = user.next();
			System.out.println(place + " has zip codes: " + PUT THE RESULTS OF THE ARRAY HERE + "\n");
			System.out.println("Do you want to search again? ");
		} else {
			System.out.println("Goodbye!");
		}
	}
	
	public static ArrayList<Place> findThePlace(String placeName) throws FileNotFoundException {
		ArrayList<Place> place = new ArrayList<Place>(); // the arraylist of all places
		Scanner in = new Scanner(new File("zipstest.txt"));
		String cityState = null;
		String zip = null;
		if (in.hasNextLine()) {
			String nextLine = in.nextLine();
			Scanner line = new Scanner(nextLine);
			zip = line.next();
			line.next(); // skip this x coor
			line.next(); // skip this y coor
			while (line.hasNext()) {
				cityState += line.next();
			}
		}
		
		boolean placeExists = false;
		int indexOfCityState = -1;
		for (int i = 0; i < place.size(); i++) {
			if (place.get(i).getCityState().equals(cityState) ) {
				placeExists = true;
				indexOfCityState = i;
			}
		}		
		if (!placeExists) {	// cityState not in ArrayList; create new place
			Place newPlace = new Place();
			newPlace.setCityState(cityState);
			ArrayList<String> zipList = new ArrayList<String>();
			zipList.add(zip);
			newPlace.setZip(zipList);
				
		} else { // cityState in ArrayList already; just add zipcode
			ArrayList<String> zipList = place.get(indexOfCityState).getZip();
			place.get(indexOfCityState).setZip(zipList);
		}
		return place;
	}
}
