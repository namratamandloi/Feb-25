class Room
{
 double height;
 double width;
 double breadth;
 
 public Room(double height, double width, double breadth){
	this.height = height;
	this.width = width;
	this.breadth = breadth;
}

public double volume(){
	return height * width * breadth;
}
}

class RoomDemo{
	
	public static void main(String args[])
		{
		 Room r1 = new Room(5, 10, 20);
		 Room r2 = new Room(4, 3, 5);
		 System.out.println("Volume of room: " +r2.volume());
		 System.out.println("Volume of room: " +r1.volume());
		 }
}
	