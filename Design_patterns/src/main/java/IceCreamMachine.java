public class IceCreamMachine {

    public static IceCream makeIceCream(String sentIceCream){
        try{
            //Get parameter string, convert to int for switch case
            int iceCreamNumber = Integer.parseInt(sentIceCream);

            switch(iceCreamNumber) {
                case 0:
                    return new ChocolateDip(new SoftIce());
                case 1:
                    return new DiscoDip(new SoftIce());
                default:
                    System.out.println("Sorry, this command is not recognized");
                    return null;
            }
        } catch (NumberFormatException e){
            System.out.println("Input requirement: a number");
            return null;
        }
    }
}
