/**
 * TicketMachine models a ticket machine that issues
 * flat-fare tickets.
 * The price of a ticket is specified via the constructor.
 * Instances will check to ensure that a user only enters
 * sensible amounts of money, and will only print a ticket
 * if enough money has been input.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2011.07.31
 */
public class TicketMachine
{
    // The price of a ticket from this machine.
    private int price;
    // The amount of money entered by a customer so far.
    private int balance;
    // The total amount of money collected by this machine.
    private int total;
    

    /**
     * Create a machine that issues tickets of the given price.
     */
    public TicketMachine(int cost)
    {
        price = cost;
        balance = 0;
        total = 0;
    }

    /**
     * @Return The price of a ticket.
     */
    public int getPrice()
    {
        return price;
    }

    /**
     * Return The amount of money already inserted for the
     * next ticket.
     */
    public int getBalance()
    {
        return balance;
    }

    /**
     * Receive an amount of money from a customer.
     * Check that the amount is sensible.
     */
    public void insertMoney(int amount)
    {
        if(amount > 0) {
            balance = balance + amount;
        }
        else {
            System.out.println("Use a positive amount rather than: " +
                               amount);
        }
    }
    
     public void printTicket()
    {
        int descuento = 10;
        if (balance >= price) {
            // Simulate the printing of a ticket.
            System.out.println("##################");
            System.out.println("# The BlueJ Line");
            System.out.println("# Ticket");
            System.out.println("# " + price + " cents.");
            System.out.println("##################");
            System.out.println();

            // Update the total collected with the price.
            total = total + price;
            // Reduce the balance by the prince.
            balance = balance - price;
        }
        else {
            int amountLeftToPay = price - balance;
            System.out.println("You must insert at least: " +
                               amountLeftToPay + " more cents.");
                    
        }
    }
    
    /**
     * Imprimir billetes con el 10% de descuento
     */
    public void printTicketWithDiscount()
    {
        int discountPrice;
        discountPrice = (price * 90) / 100;
        if (balance >= discountPrice) {
            // Simulate the printing of a ticket.
            System.out.println("##################");
            System.out.println("# The BlueJ Line");
            System.out.println("# Ticket");
            System.out.println("# " + discountPrice + " cents.");
            System.out.println("##################");
            System.out.println();

            // Update the total collected with the price.
            total = total + discountPrice;
            // Reduce the balance by the prince.
            balance = balance - discountPrice;
        }
        else {
            int amountLeftToPay = discountPrice - balance;
            System.out.println("You must insert at least: " +
                               amountLeftToPay + " more cents.");
    }
}

    /**
     * Return the money in the balance.
     * The balance is cleared.
     */
    public int refundBalance()
    {
        int amountToRefund;
        amountToRefund = balance;
        balance = 0;
        return amountToRefund;
    }
    
    /**
     * Return the money that you must insert
     * to be able to print a ticket.
     */
    public int getAmountLeftToPay()
    {
        int amountLeftToPay;
        amountLeftToPay = price-balance;
        return amountLeftToPay;
    }
    /**
     * Return all the money
     */
    public int emptyMachine()
    {
        int totalMoney;
        totalMoney = balance+total;
        balance = 0;
        total = 0;
        return totalMoney;
    }
}
