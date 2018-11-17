package practice;

public class OverloadExample 
{
    public void disp()
    {
        System.out.println("Non static disp() method called");
    }
    
    public static void disp(Integer... i)
    {
    	System.out.print(i[1]);
        System.out.println("static disp() method called121");
    }
    
    public static void main(String args[])
    {
        //Calling the disp() method
        OverloadExample.disp(10,12,13);
        
    }
}
