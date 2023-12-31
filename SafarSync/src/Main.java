import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		//creating test activities
		Activity hiking = new Activity("Hiking", "Explore the scenic trails", 1000, 10);
		
		Activity riverRafting = new Activity("River Rafting", "Experience River Rafting", 3000, 6);
		
		Activity Camping = new Activity("Camping", "Night Camping", 500, 20);
		
		Activity  Safari = new Activity("Safari Tour", "Jungle Safari Adventure", 5000, 4);
		
		Activity rockClimbing = new Activity("Rock Climbing", "Conquer vertical cliffs", 1500, 8);

		Activity kayaking = new Activity("Kayaking", "Navigate through scenic waters", 2000, 12);

		Activity stargazing = new Activity("Stargazing", "Night Sky Observation", 800, 15);

		Activity hotAirBalloon = new Activity("Hot Air Balloon Ride", "Float above breathtaking landscapes", 3500, 6);
		
		// Destinations and Activities Assignment
		// Destination 1
		Destination mountainRetreat = new Destination("Mountain Retreat", hiking, rockClimbing);

		// Destination 2
		Destination riverAdventure = new Destination("River Adventure", riverRafting, kayaking);

		// Destination 3
		Destination campingSite = new Destination("Camping Site", Camping, stargazing);

		// Destination 4
		Destination safariPark = new Destination("Safari Adventure", Safari, hotAirBalloon);
		
		hiking.setDestination(mountainRetreat);
		rockClimbing.setDestination(mountainRetreat);
		
		riverRafting.setDestination(riverAdventure);
		kayaking.setDestination(riverAdventure);
		
		Camping.setDestination(campingSite);
		stargazing.setDestination(campingSite);
		
		Safari.setDestination(safariPark);
		hotAirBalloon.setDestination(safariPark);
		
		
		// Destination assignment in travel packages
		
		//Travel Package 1
		TravelPackage travelPackage1 = new TravelPackage("Adventure Escape", 20, new ArrayList<>(Arrays.asList(mountainRetreat, riverAdventure)));
		
		//Passenger 1
		Passenger passenger1 = new Passenger("Utpal", 1, 10000);
		
		
		//GOLD Passenger
		passenger1.setType(PassengerType.GOLD);
		
		//enrolling for Adventure Escape
		
		
		System.out.println("---------------Sign Up For Activity-------------");
		List<Destination> destinations = travelPackage1.getDestinations();
		 Scanner scanner = new Scanner(System.in);

		// Select Destination
	     System.out.println("Enter Destination: ");
         for(Destination dest:destinations) {
        	 System.out.println("."+dest.getDestinationName()+" ");
         }
	        
	     String destinationName = scanner.nextLine().trim();
	        
		 System.out.println("Selected Destination- "+destinationName);
		 
		 Destination selectedDestination = destinations.stream()
			        .filter(destination -> destination.getDestinationName().equalsIgnoreCase(destinationName))
			        .findFirst()
			        .orElse(null);
		 
		 if(selectedDestination!=null) {
			 System.out.println(selectedDestination.toString());
			 
			 
			 List<Activity> activitiesAtDestination = selectedDestination.getActivities();
			 
			 
			 System.out.println("Select Activity('exit' to stop): ");
			 System.out.println("Activity  "+"Price");
	         for(Activity activity:activitiesAtDestination) {
	        	 System.out.println(activity.getActivityName()+"  "+activity.getCost());
	         }
	         while (true) {
	             String activityName = scanner.nextLine().trim();

	             // Check if the user wants to stop
	             if (activityName.equals("exit")) {
	                 System.out.println("Stopping input.");
	                 break; // Exit the loop
	             }
	             
	             System.out.println("Selected Activity- "+activityName);
	             
	    		 Activity selectedActivity = activitiesAtDestination.stream()
	    			        .filter(activity -> activity.getActivityName().equalsIgnoreCase(activityName))
	    			        .findFirst()
	    			        .orElse(null);
	    		 
	    		 if(selectedActivity!=null) {
	    			 travelPackage1.enrollPassenger(passenger1, selectedDestination, selectedActivity);
	    		 }
	    		 
	    		 else {
	    			 System.out.println("Enter Correct Activity");
	    		 }
	             
	            
	         }

		 		 }
		 
		 else {
			 System.out.println("Enter Correct Destination");
		 }
	        

		 System.out.println("---------------Printing Travel Package Itenary-------------");
		 
		travelPackage1.printTravelPackageItenary();
		
		System.out.println("---------------Printing Enrolled Passenger Details-------------");
		travelPackage1.printEnrolledPassengerList();;
		
		System.out.println("---------------Printing Individual Passenger Details and Enrolled Activities-------------");
		passenger1.printPassengerDetials();
		
		
		System.out.println("---------------Printing Activities With Spaces Left-------------");
		travelPackage1.printActivitiesWithSpace();
		
	}
	
	
}
