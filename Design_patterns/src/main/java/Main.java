import java.util.Scanner;

public class Main {
    private IceCream[] IceCreams = new IceCream[2];

    Main(){
        welcome();
        createIceCreams();
        showMenu();
        whichIceCream();
    }

    public static void main(String[] args) {
        new Main();
    }

    private void welcome(){
        System.out.println("Welcome, which ice cream would you like to order?");
    }

    private void createIceCreams() {
        //Call factory pattern
        IceCream iceCream1 = IceCreamMachine.makeIceCream("0");
        IceCream iceCream2 = IceCreamMachine.makeIceCream("1");
        IceCreams[0] = iceCream1;
        IceCreams[1] = iceCream2;
    }

    private void showMenu(){
        IceCreamIterator iterator = new IceCreamIterator(IceCreams);
        int index = 0;

        while (iterator.hasNext()) {
            IceCream I = iterator.next();
            System.out.println(index + ") The " + I.getDescription() + " has a price of €" + I.getCost());
            index++;
        }
    }

    private void whichIceCream(){

        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        IceCream order =  IceCreamMachine.makeIceCream(input);

        if (order != null) {
            System.out.println("Your " + order.getDescription() + " is done, dig in!");
        } else {
            whichIceCream();
        }
    }

}
