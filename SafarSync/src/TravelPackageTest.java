import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class TravelPackageTest {

    @Test
    public void testEnrollPassenger() {
        // Create destinations and activities
        Destination mountainRetreat = new Destination("Mountain Retreat", 
                new Activity("Hiking", "Explore the mountains", 50.0, 10),
                new Activity("Skiing", "Enjoy skiing on snowy slopes", 100.0, 5)
        );

        Destination riverAdventure = new Destination("River Adventure", 
                new Activity("Rafting", "Navigate through river rapids", 80.0, 15),
                new Activity("Fishing", "Catch fish in the river", 30.0, 8)
        );

        // Create a travel package
        TravelPackage travelPackage1 = new TravelPackage("Adventure Escape", 20, Arrays.asList(mountainRetreat, riverAdventure));

        // Create passengers
        Passenger standardPassenger = new Passenger("Utpal", 1, 100.0, PassengerType.STANDARD);
        Passenger goldPassenger = new Passenger("Diwakar", 2, 1000.0, PassengerType.GOLD);
        Passenger premiumPassenger = new Passenger("John", 3, 0.0, PassengerType.PREMIUM);

      //Successful enrollment test Case
        
	        // Test case: Enroll standard passenger for Hiking
	        travelPackage1.enrollPassenger(standardPassenger,mountainRetreat,mountainRetreat.getActivities().get(0));
	
	        // Assertions for standard passenger
	        assertEquals(1, travelPackage1.getPassengerEnrolledList().size());
	        assertEquals(50.0, standardPassenger.getBalance(), 0.01);
	
	
	        // Test case: Enroll gold passenger for Rafting
	        travelPackage1.enrollPassenger(goldPassenger,riverAdventure,riverAdventure.getActivities().get(0));
	
	        // Assertions for gold passenger
	        assertEquals(2, travelPackage1.getPassengerEnrolledList().size());
	        assertEquals(928.0, goldPassenger.getBalance(), 0.01);
	
	
	        // Test case: Enroll premium passenger for Skiing
	        travelPackage1.enrollPassenger(premiumPassenger,mountainRetreat,mountainRetreat.getActivities().get(1));
	
	        // Assertions for premium passenger
	        assertEquals(3, travelPackage1.getPassengerEnrolledList().size());
	        assertEquals(0.0, premiumPassenger.getBalance(), 0.01);
	

	//Unsuccessful enrollment test Case
	        
	     // Test case: Enroll standard passenger for Hiking
	        travelPackage1.enrollPassenger(standardPassenger,mountainRetreat,mountainRetreat.getActivities().get(1));
	        
	        // Assertions for standard passenger
	        assertEquals(3, travelPackage1.getPassengerEnrolledList().size());
	        assertEquals(50.0, standardPassenger.getBalance(), 0.01);
    }
    
    
    @Test
    public void testSignUpForActivitySuccessSTANDARD() {
        Activity hiking = new Activity("Hiking", "Explore the scenic trails", 1000, 10);
        Destination mountainRetreat = new Destination("Mountain Retreat", hiking);

        TravelPackage travelPackage = new TravelPackage("Adventure Escape", 20, new ArrayList<>(Arrays.asList(mountainRetreat)));

        Passenger passenger = new Passenger("Peter Parker", 2, 3000, PassengerType.STANDARD);

        assertTrue(passenger.signUpForActivity(hiking));
        assertTrue(passenger.getActivitiesEnrolledList().contains(hiking));
    }

    @Test
    public void testSignUpForActivitySuccessGold() {
        Activity hiking = new Activity("Hiking", "Explore the scenic trails", 1000, 10);
        Destination mountainRetreat = new Destination("Mountain Retreat", hiking);

        TravelPackage travelPackage = new TravelPackage("Adventure Escape", 20, new ArrayList<>(Arrays.asList(mountainRetreat)));

        Passenger passenger = new Passenger("John Doe", 1, 5000, PassengerType.GOLD);

        assertTrue(passenger.signUpForActivity(hiking));
        assertTrue(passenger.getActivitiesEnrolledList().contains(hiking));
    }

    @Test
    public void testSignUpForActivitySuccessPremium() {
        Activity hiking = new Activity("Hiking", "Explore the scenic trails", 1000, 10);
        Destination mountainRetreat = new Destination("Mountain Retreat", hiking);

        TravelPackage travelPackage = new TravelPackage("Adventure Escape", 20, new ArrayList<>(Arrays.asList(mountainRetreat)));

        Passenger passenger = new Passenger("Jane Smith", 2, 3000, PassengerType.PREMIUM);

        assertTrue(passenger.signUpForActivity(hiking));
        assertTrue(passenger.getActivitiesEnrolledList().contains(hiking));
    }

    @Test
    public void testSignUpForActivityInsufficientBalance() {
        Activity hiking = new Activity("Hiking", "Explore the scenic trails", 1000, 10);
        Destination mountainRetreat = new Destination("Mountain Retreat", hiking);

        TravelPackage travelPackage = new TravelPackage("Adventure Escape", 20, new ArrayList<>(Arrays.asList(mountainRetreat)));

        Passenger passenger = new Passenger("John Doe", 1, 500, PassengerType.STANDARD);

        assertFalse(passenger.signUpForActivity(hiking));
        assertFalse(passenger.getActivitiesEnrolledList().contains(hiking));
    }

    @Test
    public void testSignUpForActivityNoCapacity() {
        Activity hiking = new Activity("Hiking", "Explore the scenic trails", 1000, 0);
        Destination mountainRetreat = new Destination("Mountain Retreat", hiking);

        TravelPackage travelPackage = new TravelPackage("Adventure Escape", 20, new ArrayList<>(Arrays.asList(mountainRetreat)));

        Passenger passenger = new Passenger("Jane Smith", 2, 3000, PassengerType.STANDARD);

        assertFalse(passenger.signUpForActivity(hiking));
        assertFalse(passenger.getActivitiesEnrolledList().contains(hiking));
    }

}
