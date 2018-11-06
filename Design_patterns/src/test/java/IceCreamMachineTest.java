import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IceCreamMachineTest {
    @Test
    void makeIceCream() {
        //Initialize needed variables for test (Arrange)
        String IceCreamString = "1";
        String ExpectedIceCream = "Regular soft ice, disco dip";

        //Which function is the test going to use? (Act)
        IceCream IceCream1 = IceCreamMachine.makeIceCream(IceCreamString);

        //Check results, do they match the given expected results? (Assert)
        Assertions.assertNotNull(IceCream1);
        Assertions.assertEquals(ExpectedIceCream, IceCream1.getDescription());
    }

    @Test
    void makeIceCreamWrongInputNumber() {
        String IceCreamString = "99999";
        String ExpectedString = "Sorry, this command is not recognized";

        IceCream IceCream1 = IceCreamMachine.makeIceCream(IceCreamString);

        Assertions.assertNull(IceCream1);
    }

    @Test
    void makeIceCreamLiteralString() {
        String IceCreamString = "Oops a string";
        String ExpectedString = "Sorry, this command is not recognized";

        IceCream IceCream1 = IceCreamMachine.makeIceCream(IceCreamString);

        Assertions.assertNull(IceCream1);
    }

}