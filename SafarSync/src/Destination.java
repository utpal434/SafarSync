import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Destination {

	public String destinationName;
		
	public List<Activity> activities;

	
	public Destination(String destinationName, Activity... activities) {
		super();
		this.destinationName = destinationName;
		this.activities = new ArrayList<>(Arrays.asList(activities));
	}
	
	public String getDestinationName() {
		return destinationName;
	}

	public void setDestinationName(String destinationName) {
		this.destinationName = destinationName;
	}

	public List<Activity> getActivities() {
		return activities;
	}

	public void setActivities(List<Activity> activities) {
		this.activities = activities;
	}

	public void printDestinationDetails() {

		
		String destinationName = getDestinationName();
		System.out.println("Destiantion Name-> "+destinationName );
		
		List<Activity> activitiesAtDestination = getActivities();
		
		System.out.println("  Activities At "+destinationName);
		
		int activityCount=1;
		
		for(Activity activity:getActivities()) {
			System.out.println("    Activity "+activityCount++);
			
			activity.printActivityDetails();
		}
		
	}

	@Override
	public String toString() {
		return "Destination [destinationName=" + destinationName + ", activities=" + activities + "]";
	}
	
	
}
