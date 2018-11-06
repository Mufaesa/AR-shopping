public class DiscoDip extends ToppingsDecorator {

    public DiscoDip(IceCream newIceCream){

        super(newIceCream);

    }

    public String getDescription(){

        return tempIceCream.getDescription() + ", disco dip";

    }

    public double getCost(){

        return tempIceCream.getCost() + 0.25;
    }

}
