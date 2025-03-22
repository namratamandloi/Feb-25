class Box
{
	double height;
	double width;
	double breadth;
	
	public Box(double height, double width, double breadth){
		this.height = height;
		this.width = width;
		this.breadth = breadth;
	}
	
	double getVolume(){
			double volume = height*width*breadth;
			return volume;
		}
		
	double getArea(){
			double area = 2*(width * height + height * breadth + breadth * width);
			return area;
		}
	
	void display()
	{
		System.out.println("Volume: " + getVolume());
		System.out.println("area: " + getArea());
	}
}
	class BoxDemo
	{	
		public static void main(String args[])
		{
			Box b = new Box(5, 4, 6);
			Box b1 = new Box(3, 5, 7);
			
			b.getVolume();
			b.getArea();
			b.display();
			
			b1.getVolume();
			b1.getArea();
			b1.display();
		}
	}