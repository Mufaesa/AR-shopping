abstract class ToppingsDecorator implements IceCream{

    protected IceCream tempIceCream;

    public ToppingsDecorator(IceCream newIceCream){

        tempIceCream = newIceCream;

    }

    public String getDescription(){

        return tempIceCream.getDescription();

    }

    public double getCost() {

        return tempIceCream.getCost();

    }

}
