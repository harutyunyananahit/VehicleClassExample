public class Test
{
	public static void main(String[] args) {
	    Trailor trail = new Trailor(4.5);
      Truck tr = new Truck(2017, "mercedes", 4.5, 5.6);
      Vehicle v = new Boat();
      System.out.println(v.move());
	    tr.AttachTrailor(trail);
      tr.DeattachTrailor(trail);
      tr.DeattachTrailor(trail);
			System.out.println(tr.getFullLength());
	}
}

abstract class Vehicle
{
    private int yearModel;
    private String make;
    private double length;
    private double weight;

    //default Constructor
    public Vehicle() {}

    //my Constructor
    public Vehicle(int yearModel, String make, double length, double weight)
    {
        this.yearModel = yearModel;
        this.make = make;
        this.length = length;
        this.weight = weight;
    }

    public void setYearModel(int y)
    {
        yearModel = y;
    }
    public void setMake(String m)
    {
        make = m;
    }
    public void setLength(double l)
    {
        length = l;
    }

    public void setWeight(double w)
    {
        weight = w;
    }
    public int getYear()
    {
        return this.yearModel;
    }
    public String getMake()
    {
        return this.make;
    }
    public double getLength()
    {
        return this.length;
    }
    public double getWeight()
    {
        return this.weight;
    }
    public abstract String move();

}

class Car extends Vehicle
{
    public String move()
    {
        return "A car rolls down the road.";
    }
}

class Boat extends Vehicle
{
    public String move()
    {
        return "A boat sails across the water.";
    }
}

class Plane extends Vehicle
{
    public String move()
    {
        return "A plane flies through the air.";
    }
}

class Truck extends Vehicle
{
		private double fullLength = this.getLength();
    //default Constructor
    public Truck()
    {
        super();
    }

    //my Constructor
    public Truck(int yearModel, String make, double length, double weight)
    {
        super(yearModel, make, length, weight);
    }
		public double getFullLength()
		{
			return this.fullLength;
		}
    public void AttachTrailor(Trailor myTrailor)
    {
      if(myTrailor != null)
      {
        fullLength += myTrailor.getLength();
      }
    }
    public void DeattachTrailor(Trailor myTrailor)
    {
      if(this.getFullLength() > this.getLength() && myTrailor != null)
      {
        fullLength -= myTrailor.getLength();
      }
      else
        throw new ArithmeticException("No trailer found");
    }
    public String move()
    {
        return "A track rolls down the road.";
    }
}

class Trailor
{
    private double length;

    //default Constructor
    public Trailor() {
      this.length = 0;
    }

    //my Constructor
    public Trailor(double length)
    {
        this.length = length;
    }

    public void setLength(double l)
    {
        length = l;
    }

    public double getLength()
    {
        return length;
    }
}
