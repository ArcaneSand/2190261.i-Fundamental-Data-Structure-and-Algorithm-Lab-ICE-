package logic;

public class UnitCard {
	private String name;
	private int bloodCost;
	private int power;
	private int health;
	private String flavorText;

	public String toString() {
		return this.getName() + " (POW: " + this.getPower() + ", HP: " + this.getHealth() + ")";
	}
	
	public UnitCard(String name,int bloodCost,int power,int health,String flavorText) {
		
	}
	
	public void setName(String name) {
		if(name.isBlank())name = "Creature";
		this.name = name;
	}
	
	public void setBloodCost(int bloodCost) {
		if(bloodCost < 0) bloodCost = 0;
		this.bloodCost = bloodCost;
	}
	
	public void setPower(int power) {
		if(power < 0) power = 0;
		this.power = power;
	}
	
	public void setHealth(int health) {
		if(health < 1)health = 1;
	}
	
	public boolean equals(UnitCard other) {
		return this.name == other.getName();
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getBloodCost() {
		return this.bloodCost;
	}
	
	public int getPower() {
		return this.power;
	}
	
	public int getHealth() {
		return this.health;
	}
	
	public String flavorText() {
		return this.flavorText;
	}
}
