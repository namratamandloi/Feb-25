 class ComplexNumber {
    double real;
    double img;

    
    public ComplexNumber() {
        this.real = 0;
        this.img = 0;
    }

    public ComplexNumber(double real) {
        this.real = real;
        this.img = 0;
    }

    public ComplexNumber(double real, double img) {
        this.real = real;
        this.img = img;
    }

    public ComplexNumber addNumber(ComplexNumber other) 
	{
        double realSum = this.real + other.real;
        double imgSum = this.img + other.img;
        return new ComplexNumber(realSum, imgSum);
    }

    public ComplexNumber multiplyNumber(ComplexNumber other)
	{
        double realProduct = (this.real * other.real) - (this.img * other.img);
        double imgProduct = (this.real * other.img) + (this.img * other.real);
        return new ComplexNumber(realProduct, imgProduct);
    }

    public void display() 
	{
        if (this.img >= 0)
			{
            System.out.println(this.real + " + " + this.img + "i");
        } 
		else {
            System.out.println(this.real + " - " + (-this.img) + "i");
		}
	}
}

  class ComplexNumberDemo
  {
    public static void main(String[] args) {
     
        ComplexNumber c1 = new ComplexNumber(3, 2);  
        ComplexNumber c2 = new ComplexNumber(4, -2); 

        
        ComplexNumber sum = c1.addNumber(c2);
        System.out.print("Sum: ");
        sum.display();

       
        ComplexNumber product = c1.multiplyNumber(c2);
        System.out.print("Product: ");
        product.display();
    }
}
