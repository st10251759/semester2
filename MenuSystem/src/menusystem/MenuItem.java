package menusystem;

//class for menu items
public class MenuItem {
  private String name;
    private boolean available;
    //constructor method with two parameters
    public MenuItem(String name, boolean available) {
        this.name = name;
        this.available = available;
    }
    //accessor method
    public String getName() {
        return name;
    }
    //boolean method
    public boolean isAvailable() {
        return available;
    }
    //toString method
    @Override
    public String toString() {
        return name + " (" + (available ? "Available" : "Not Available") + ")";
    }
} 
