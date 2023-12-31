import java.util.ArrayList;
import java.util.List;

public class TravelPackage {

	private String packageName;
    private long passengerCapacity;
    private List<Destination> destinations;
    private List<Passenger> passengerEnrolledList;

    public TravelPackage(String packageName, long passengerCapacity, List<Destination> destinations) {
        this.packageName = packageName;
        this.passengerCapacity = passengerCapacity;
        this.destinations = destinations;
        
        this.passengerEnrolledList = new ArrayList<>();

    }

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public long getPassengerCapacity() {
		return passengerCapacity;
	}

	public void setPassengerCapacity(long passengerCapacity) {
		this.passengerCapacity = passengerCapacity;
	}

	public List<Destination> getDestinations() {
		return destinations;
	}

	public void setDestinations(List<Destination> destinations) {
		this.destinations = destinations;
	}

	public List<Passenger> getPassengerEnrolledList() {
		return passengerEnrolledList;
	}

	public void setPassengerEnrolledList(List<Passenger> passengerEnrolledList) {
		this.passengerEnrolledList = passengerEnrolledList;
	}
	
	public void printTravelPackageItenary() {
		System.out.println("Package Name-> "+ getPackageName());
		
		List<Destination> destinationList = getDestinations();
		
		int destinationCount = 1;
		for(Destination destination:destinationList) {
			System.out.println("Destiantion "+destinationCount++);
			destination.printDestinationDetails();
		}
	}
	
	
	public void printEnrolledPassengerList() {
		
            System.out.println("Package Name-> "+ getPackageName());
				
			System.out.println("Passenger Capacity- "+getPassengerCapacity());
			
			System.out.println("Currently Enrolled Passenger- "+getPassengerEnrolledList().size());
			
			List<Passenger> passengerList = getPassengerEnrolledList();
			
			int passengerCount=1;
			
			for(Passenger passenger:passengerList) {  
				System.out.println("Passenger "+passengerCount++);
				
				System.out.println(" Passenger Name- "+passenger.getName());
				System.out.println(" Passenger Number- "+passenger.getPassengerNumber());

			}
			
		}

	public void enrollPassenger(Passenger passenger, Destination destination, Activity activity) {
		
		boolean isEligibleForSignUp = passenger.signUpForActivity(activity);
		if(isEligibleForSignUp) {
			this.passengerEnrolledList.add(passenger);
		}
	
		
	}

	public void printActivitiesWithSpace() {
		
		List<Destination> destinationList = getDestinations();
		
		for(Destination destination:destinationList) {
			List<Activity> activities = destination.getActivities();
			
			for(Activity activity:activities) {
				if(activity.getCapacity()>0) {
					activity.printActivityDetails();
				}
			}
		}
		
	}
	
	
}
