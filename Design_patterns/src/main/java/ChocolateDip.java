public class ChocolateDip extends ToppingsDecorator {

    public ChocolateDip(IceCream newIceCream){

        super(newIceCream);

    }

    public String getDescription(){

        return tempIceCream.getDescription() + ", chocolate dip";

    }

    public double getCost(){

        return tempIceCream.getCost() + 0.30;
    }

}
