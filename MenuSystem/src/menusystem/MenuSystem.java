
package menusystem;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MenuSystem {

    public static void main(String[] args) {
        //Create an Array List to store menu items
         List<MenuItem> menuItems = new ArrayList<>();
         //Display a welcome message
        JOptionPane.showMessageDialog(null, "Welcome to the Restaurant Menu Management System!",
                "Welcome", JOptionPane.INFORMATION_MESSAGE);

        String itemName; //declare a variable to store itemName each time an item is captured
        
        //while loop to continue reprompting user to add new items until the user enters 'zzz'
        while (true) {
            itemName = JOptionPane.showInputDialog(null,
                    "Enter menu item name (Type 'zzz' to finish):", "Add Menu Item", JOptionPane.PLAIN_MESSAGE);
            //if user enters 'zzz' or 'ZZZ' exit the while loop
            if (itemName == null || itemName.equalsIgnoreCase("zzz")) {
                break;
            }
            //add to arrayList menuItems each item captured
            menuItems.add(new MenuItem(itemName, true));
            
            //Display a message to confrim with the user that the item is added
            JOptionPane.showMessageDialog(null, "Item added: " + itemName,
                    "Success", JOptionPane.INFORMATION_MESSAGE);
        }
        
        //utility class in Java that provides various methods for working with collections like lists or sets, used to sort in alphabetical order)
        //try Collections.sort(menuItems);
        Collections.sort(menuItems, (item1, item2) -> item1.getName().compareTo(item2.getName()));

        //Create a string builder to display the MenuItems
        StringBuilder menuDisplay = new StringBuilder("Today's Menu:\n");
        for (MenuItem item : menuItems) {//for each loop for working with the arrayList
            menuDisplay.append(item).append("\n");
        }
        //Display the items calling the stringbuilder to string method
        JOptionPane.showMessageDialog(null, menuDisplay.toString(),
                "Menu", JOptionPane.PLAIN_MESSAGE);
        //Prompt user to search for a specifc dish
        
        //can do a while loop to reprompt if dish is not found
        
        boolean checkAnotherDish = true;
        while (checkAnotherDish) {
            //prompt user to enter a dish to check availablity
            String dishName = JOptionPane.showInputDialog(null,"Enter a dish name to check availability:", "Check Availability", JOptionPane.PLAIN_MESSAGE);

            boolean dishFound = false;
            for (MenuItem item : menuItems) {//for each loop working with array list
                if (item.getName().equalsIgnoreCase(dishName)) {//if dish is found
                    dishFound = true;
                    JOptionPane.showMessageDialog(null, item.getName() + " is an excelllent choice!",
                            "Availability", JOptionPane.INFORMATION_MESSAGE);
                    break;
                }
            }

            if (!dishFound) {//if dish is not found
                JOptionPane.showMessageDialog(null, dishName + " is not available today.",
                        "Availability", JOptionPane.WARNING_MESSAGE);
            }
            //ask user whether they want to enter another dish to search
            int choice = JOptionPane.showConfirmDialog(null,
                    "Do you want to check another dish?", "Check Another Dish", JOptionPane.YES_NO_OPTION);
            checkAnotherDish = (choice == JOptionPane.YES_OPTION);
        }
        //display user friendly exit message
        JOptionPane.showMessageDialog(null, "Thank you for using the Restaurant Menu Management System!",
                "Goodbye", JOptionPane.INFORMATION_MESSAGE);
    }
}






