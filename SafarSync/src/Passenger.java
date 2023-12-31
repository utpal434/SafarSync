import java.util.ArrayList;
import java.util.List;

public class Passenger {

	public String name;
	
	public long passengerNumber;
	
	public double balance;
	
	PassengerType type;
	
	private List<Activity> activitiesEnrolledList = new ArrayList<Activity>();

	
	public Passenger(String name, long passengerNumber, double balance) {
		super();
		this.name = name;
		this.passengerNumber = passengerNumber;
		this.balance = balance;
	}
	
	public Passenger(String name, long passengerNumber, double balance, PassengerType type) {
		super();
		this.name = name;
		this.passengerNumber = passengerNumber;
		this.balance = balance;
		this.type = type;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getPassengerNumber() {
		return passengerNumber;
	}

	public void setPassengerNumber(long passengerNumber) {
		this.passengerNumber = passengerNumber;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(long balance) {
		this.balance = balance;
	}
	
	public PassengerType getType() {
		return type;
	}

	public void setType(PassengerType type) {
		this.type = type;
	}

	public List<Activity> getActivitiesEnrolledList() {
		return activitiesEnrolledList;
	}

	public void setActivitiesEnrolledList(List<Activity> activitiesEnrolledList) {
		this.activitiesEnrolledList = activitiesEnrolledList;
	}

	@Override
	public String toString() {
		return "Passenger [name=" + name + ", passengerNumber=" + passengerNumber + ", balance=" + balance + "]";
	}

	public void printPassengerDetials() {
        System.out.println("Passenger: " + name);
        System.out.println("Number: " + passengerNumber);
        System.out.println("Balance: " + balance);
        
        System.out.println("Signed Up Activities:");
        for (Activity activity : activitiesEnrolledList) {
            System.out.println("Activity: " + activity.getActivityName() +
                    ", Destination: " + activity.getDestination().getDestinationName());

        }
		
	}

	public boolean signUpForActivity(Activity activity) {
		 
		if(activity.getCapacity()==0) {
			System.out.println("Activity doesn't has enough capactiy");
			return false;
		}
		
		else {
			if(this.type!=PassengerType.PREMIUM) {
			double activityCost = calculateActivityPrice(activity);
			
			if(this.balance<activityCost) {
				System.out.println("Insufficient Balance");
				return false;
			}
			
			else {
			 			    			    
			    this.balance -= activityCost;
              System.out.println("Balance after deduction for "+type+"Passenger"+balance);
			}
			}
			
			activity.reduceCapactiy();
		    
		    this.activitiesEnrolledList.add(activity);
		    
		    System.out.println(" Passenger enrolled for the "+activity.getActivityName()+" successfully");
		    
		    return true;
		}
	}

	private double calculateActivityPrice(Activity activity) {

       double price = activity.getCost();
		switch (type) {
		case GOLD:
			price = price*0.9;
			break;
		case PREMIUM:
			price = 0;	
			break;

		default:
			break;
		}
		
		System.out.println("Price for "+type+"Passenger"+price);
		return price;
	}


}
