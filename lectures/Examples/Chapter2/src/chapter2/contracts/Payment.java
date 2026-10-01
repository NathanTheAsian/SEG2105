package chapter2.contracts;

// FULL CONTRACT
// JAVA 8?
public interface Payment
{
    abstract void makePayment();//by default it is a abstract method
    boolean validatesPayment();
    
    default void defaultMethod(String inputString){
        System.out.println("Inside SomeInterfaceTwo defaultMethod::"+inputString);
    }
    
}
