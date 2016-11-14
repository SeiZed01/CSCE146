
public class Fruit implements Comparable {

	private String name;
	private double weight;
	
	public Fruit(String aName, double weight){
		setName(aName);
		setWeight(weight);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double price) {
		if(price >= 0.0)
			this.weight = price;
	}
	public String toString(){
		return this.name + " " + this.weight;
	}
	public int compareTo(Object obj) {
		Fruit aFruit = (Fruit)obj;
		if(this.weight < aFruit.getWeight())
			return -1;
		else if(this.weight > aFruit.getWeight())
			return 1;
		else
			return 0;
	}
}
