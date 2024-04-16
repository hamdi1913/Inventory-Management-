package inventorymanagementsystem;
/**
 * @author Hamdi
 */
class Item {
    private String name;
    private String department;
    private int id;
    private int quantity;

    public Item(String name, String department, int id, int quantity) {
        this.name = name;
        this.department = department;
        this.id = id;
        this.quantity = quantity;
    }

    public String getName(){
        return name;
    }
    public String getDepartment() {
        return department;
    }
     public int getID() {
        return id;
    }
    public int getQuantity() {
        return quantity;
    }

    //set methods
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setID(int id) {
        this.id = id;
    }
    
    public void setName(String name){
        this.name = name;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

   
}
