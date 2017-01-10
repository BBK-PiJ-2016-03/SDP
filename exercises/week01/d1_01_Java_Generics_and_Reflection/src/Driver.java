/**
 * Created by Alexander Worton on 10/01/2017.
 */
public class Driver {
    public static void main(String[] args) {
        // YOUR CODE GOES HERE
        Storage<BankAccount> aStorage = new Storage<>();
        Storage<String> sStorage = new Storage<>();

        /*
        1. What are the reasons for using generics here?
            To allow the Storage class to hold values of any type
        2. What are the benefits?
            Not having to create a separate Storage class for each type you wish to hold
            Not having to use Object type and losing access to methods for the stored type
                Not having to use reflection to access available methods or make a check against the type of object held
        */

        Class<BankAccount> baCls = BankAccount.class;
        try {
            BankAccount myAccount = baCls.newInstance();
            aStorage.setValue(myAccount);
            // Deposit
            myAccount.deposit(15);
        }
        catch ( InstantiationException e ) {
            // ...
        }
        catch ( IllegalAccessException e ) {
            // ...
        }

        //problem is that myAccount needs to be cast to BankAccount
        //Simply changing the type of the object to BankAccount isn't enough as an explicit cast is required
        //explicit cast is not safe, as not guaranteed that the object is of that type.
        //changing the Class to the generic Class<BankAccount> removes the need for the explicit cast.

        System.out.println( aStorage.getValue().showBalance() );
        if( aStorage.getClass() == sStorage.getClass() ) {
            System.out.println( "EQUAL" );
        } else {
            System.out.println( "NOT EQUAL" );
        }

        /*
        runtime output is 115.0 EQUAL
        115.0 is returned because the getValue returns the contained class which is a BankAccount
        and the showBalance is called to show the constructor value 100 plus the deposited amount of 15
        The classes are equal because it compares the Storage classes wrapping the BankAccount and String.
         */
    }
}

