
public class Activity {

 
	public String activityName;
	
	public String description;
	
	public double cost;
	
	public int capacity;
	
	public Destination destination;
	
	 public Activity(String activityName, String description, double cost, int capacity) {
			super();
			this.activityName = activityName;
			this.description = description;
			this.cost = cost;
			this.capacity = capacity;
		}


	public String getActivityName() {
		return activityName;
	}

	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}


	public void printActivityDetails() {
		System.out.println("    Activity Name- "+getActivityName()+" Activity Cost-"+getCost()+" Activity Capacity-"+getCapacity()+
				" Activity Description-"+getDescription());
		
	}


	public Destination getDestination() {
		return destination;
	}


	public void setDestination(Destination destination) {
		this.destination = destination;
	}


	public void reduceCapactiy() {
		this.capacity -= 1;
		
	}
	
	
}
