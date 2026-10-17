import java.util.HashMap;


/**
 * Class for a Vending Machine.  Contains a hashtable mapping item names to item data, as
 * well as the current balance of money that has been deposited into the machine.
 */
class Vendor {
    private HashMap<String, Item> Stock = new HashMap<String,Item>();
    private double balance;

    Vendor(int numCandy, int numGum) {
        Stock.put("Candy", new Item(1.25, numCandy));
        Stock.put("Gum", new Item(.5, numGum));
        this.balance = 0;
    }

    /** resets the Balance to 0 */
    void resetBalance () {
        this.balance = 0;
    }

    /** returns the current balance */
    double getBalance () {
        return this.balance;
    }

    /** adds money to the machine's balance
     * @param amt how much money to add
     * */
    void addMoney (double amt) {
        this.balance = this.balance + amt;
    }

    /** attempt to purchase named item.  Message returned if
     * the balance isn't sufficient to cover the item cost.
     *
     * @param name The name of the item to purchase ("Candy" or "Gum")
     */
    void select (String name) {
        if (Stock.containsKey(name)) {
            Item item = Stock.get(name);
            if (balance >= item.price) {
                item.purchase(1);
                this.balance = this.balance - item.price;
            }
            else
                System.out.println("Gimme more money");
        }
        else System.out.println("Sorry, don't know that item");
    }
    /**
     *Empties the vendor's Inventory. Does not keep item names.
     **/
    void emptyInventory(){
        Stock.clear();
    }
    /**
     *Checks the vendor's Inventory to see if item exists
     * @param name The name of the item to check ("Candy" or "Gum")
     **/
    boolean hasItem(String name){
        return Stock.containsKey(name);
    }
    /**
     *Restocks items by checking to see if item exists, if it does, it increases amount, if not,
     * it returns error message
     **/
    void restockExistingVendorItem(String name, int amount){
        if(hasItem(name)) {
          Stock.get(name).restock(amount);
        }else {
            System.out.println("Error: Items does not exist");
        }
    }
    /**
     *Restocks items by checking to see if item exists, if it does, it increases amount, if not,
     * adds it to stock
     **/
    void restockExistingVendorItemAndNewItems(String name,double price, int amount){
        if(hasItem(name)) {
            Stock.get(name).restock(amount);
        }else {
            Stock.put(name, new Item(price,amount));
        }
    }
    /**
     *Checks current stock for a certain item
     **/
    int getItemStock(String name){
        if(hasItem(name)){
            return Stock.get(name).stock;
        }else{
            return 0;
        }
    }
    /**
     * Checks to see if new name is taken already,if not, changes the name of
     * an existing item to that new name
     **/
    void changeExistingNameOfItem(String currentName, String newName){
        if(hasItem(currentName)) {
            if(!hasItem(newName)) {
              Item item = Stock.remove(currentName);
              Stock.put(newName,item);
            }
        }
    }
    /**
     * Prints the inventory of Vendor using a loop to go through each item in the HashMap;
     **/
    void printInventory(){
        System.out.println("Vendor Inventory:");
        for(String name : Stock.keySet()){
            Item item = Stock.get(name);
            System.out.println(name + ": Price: $" + item.price + ", Amount: " + item.stock);
        }
    }

}

class Examples {
}

