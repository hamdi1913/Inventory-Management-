package inventorymanagementsystem;
/**
 * @author Hamdi
 */
import java.util.ArrayList;
import java.util.Scanner;
import static java.lang.System.exit;

public class UniversityInventory {
     static UniversityInventory inventory = new UniversityInventory();
     static ArrayList<Item> items;
     static ArrayList<User> users;
     //static String name,dept;
     //static int id,quantity
     static Scanner input2=new Scanner(System.in);
     
    public UniversityInventory() {
        items = new ArrayList<Item>();
        users = new ArrayList<User>();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void updateItem(Item item,String newName, String newdepartment,int newID, int newQuantity) {
        Item currentItem = searchItem(item.getID());
        if (currentItem != null) {
            currentItem.setQuantity(newQuantity);
            currentItem.setID(newID);
            currentItem.setDepartment(newdepartment);
            currentItem.setName(newName);
        } else {
            System.out.println("Item not found.");
        }
    }

    public void removeItem(int itemId) {
        Item item = searchItem(itemId);
        if (item != null) {
            items.remove(item);
        } else {
            System.out.println("Item not found.");
        }

    }

    public Item searchItem(int itemid) {
        
        for (Item item : items) {
            if (item.getID()==itemid){
                //founditem=item;
                return item;
            }
            
        }
       return null;
    }

   /* public void displayInventory() {
        System.out.println("Inventory:");
        for (Item item : items) {
            System.out.println(item.getName() + " | Quantity: " + item.getQuantity());
        }
    }*/
    ///methods for user
    public void addUser(User user) {
        users.add(user);
    }

    /*public void updateUser(User user, int newQuantity) {
        User currentUser = searchUser(user.getUsername());
        if (currentUser != null) {
            currentUser.setQuantity(newQuantity);
        } else {
            System.out.println("Item not found.");
        }
    }*/

    public void removeUser(String Username) {
        User user = searchUser(Username);
        if (user != null) {
            items.remove(user);
        } else {
            System.out.println("User not found.");
        }

    }

    public User searchUser(String userName) {
        for (User user : users) {
            if (user.getUsername().equalsIgnoreCase(userName)) {
                return user;
            }
        }
        return null;
    }

   /* public void displayUser() {
        System.out.println("Users:");
        for (User user : users) {
            System.out.println(user.getUsername() + " | Quantity: " +item.getQuantity());
        }
    }*/

    public static void main(String[] args) {
       // UniversityInventory inventory = new UniversityInventory();
        
            view(); 
    }
    public static void view(){
        //UniversityInventory inventory = new UniversityInventory();
          int c,b=1;
         
        do
        {
           c=Login_menu();
           switch(c)
          {
               case 1://login
                   if(users.isEmpty()==false){
                       Login();
                   }
                   else{
                      System.out.println("There Is No Created User yet please Sign in Or Contact Your Admin");
                      view();
                   }
                   break;
               case 2://signin//
                   if(users.isEmpty()==true){
                            Signin();
                   }
                   else if(users.isEmpty()==false){
                       LoginAdmin();
                   }
                   else{
                           System.out.println("error!!!!!!!!"); 
                           view();
                           }
                   break;    
               case 3:
                   exit(0);
               default:
                   System.out.println("Wrong input");             
           }
        }while(b==1);
        
    }
    
        public static void Inventory(){
            
            int size,i,c=1,b=1;  
        do
        {
           int ch=Inventory_menu();
           switch(ch)
          {
               case 1: //to add items
                    System.out.print("Enter the number of Items to Add: ");
                    size=input2.nextInt();
                    input2.nextLine();
                   for(i=0;i<size;i++){
                           System.out.print("Enter Item's "+c+" Name: ");
                           String name=input2.nextLine();
                           //input2.nextLine();
                           
                           System.out.print("Enter Item's "+c+" Department: ");
                           String dept =input2.nextLine();
                           //input2.nextLine();
                           
                           System.out.print("Enter Item's "+c+" ID: ");
                           int id =input2.nextInt();
                           input2.nextLine();
                           
                           System.out.print("Enter Item's "+c+" Quantity: ");
                           int quantity=input2.nextInt();
                           input2.nextLine();
                           
                           Item itemi = new Item(name, dept, id, quantity);
                           inventory.addItem(itemi);
                           c++;
                           }
                   break;
                   
               case 2://to search
                    System.out.print("Enter item ID to search: ");
                    int isId=input2.nextInt();
                    input2.nextLine();
                    
                    Item searchResult = inventory.searchItem(isId);
                    if (searchResult != null) {
                        System.out.println("\t\t\t\t\t........ITEMS.........");
                        System.out.println("\t\tItem's ID\t\tItem's Name\t\tItem's Department \tItem's Quantity");
                           System.out.println("\t\t"+searchResult.getID()+"\t\t\t"+searchResult.getName()+"\t\t\t"+searchResult.getDepartment()+"\t\t\t"+searchResult.getQuantity());

                    } 
                    else {
                        System.out.println("Item not found.");
                    }
                   break;
                   
               case 3://to update
                   System.out.print("Enter item's Id to update: ");
                   int iuId=input2.nextInt();
                   input2.nextLine();
                   
                   searchResult = inventory.searchItem(iuId);
                   if (searchResult != null) {
                        System.out.println("\t\t\t\t\t........ITEMS BEFORE UPDATE.........");
                        System.out.println("\t\tItem's ID\t\tItem's Name\t\tItem's Department \tItem's Quantity");
                        items.forEach(item -> {
                            System.out.println("\t\t"+item.getID()+"\t\t\t"+item.getName()+"\t\t\t"+item.getDepartment()+"\t\t\t"+item.getQuantity());
               }); 
                          System.out.print("Enter updated Item's Name: ");
                           String uname=input2.nextLine();
                           //input2.nextLine();
                           
                           System.out.print("Enter updated Item's Department: ");
                           String udept =input2.nextLine();
                           //input2.nextLine();
                           
                           System.out.print("Enter updated Item's ID: ");
                           int uid =input2.nextInt();
                           input2.nextLine();
                           
                           System.out.print("Enter updated Item's Quantity: ");
                           int uquantity=input2.nextInt();
                           input2.nextLine();
                        
                        inventory.updateItem(searchResult,uname, udept,uid,uquantity);
                        //after update
                       System.out.println("\t\t\t\t\t........ITEMS AFTER UPDATED.........");
                        System.out.println("\t\tItem's ID\t\tItem's Name\t\tItem's Department \tItem's Quantity");
                        for (Item item : items) {
                           System.out.println("\t\t"+item.getID()+"\t\t\t"+item.getName()+"\t\t\t"+item.getDepartment()+"\t\t\t"+item.getQuantity());

                        } 
                   } 
                    else {
                        System.out.println("Item you want to update is not found.");
                    }
                   
                   break;
               case 4://to delete
                   System.out.print("Enter item's ID to delete: ");
                   int idId=input2.nextInt();
                   input2.nextLine();                   
                   
                   //
                   System.out.println("\t\t\t\t\t........ITEMS BEFORE DELETED.........");
                   System.out.println("\t\tItem's ID\t\tItem's Name\t\tItem's Department \tItem's Quantity");
                        for (Item item : items) {
                           System.out.println("\t\t"+item.getID()+"\t\t\t"+item.getName()+"\t\t\t"+item.getDepartment()+"\t\t\t"+item.getQuantity());
                        } //
                        
                        inventory.removeItem(idId);
                        
                    System.out.println("\t\t\t\t\t........ITEMS AFTER ONE ITEM DELETED.........");
                        System.out.println("\t\tItem's ID\t\tItem's Name\t\tItem's Department \tItem's Quantity");
                        for (Item item : items) {
                           System.out.println("\t\t"+item.getID()+"\t\t\t"+item.getName()+"\t\t\t"+item.getDepartment()+"\t\t\t"+item.getQuantity());

                        } 
                   break;
                     
               case 5://to display
                   System.out.println("\t\t\t\t\t........ITEMS.........");
                        System.out.println("\t\tItem's ID\t\tItem's Name\t\tItem's Department \tItem's Quantity");
                        for (Item item : items) {
                           System.out.println("\t\t"+item.getID()+"\t\t\t"+item.getName()+"\t\t\t"+item.getDepartment()+"\t\t\t"+item.getQuantity());

                        } 
                   break;
                      
               case 6://main menu
                   //Login_menu();
                   view();
                  
                   
               case 7://to exit
                      exit(0);
               default:
                   System.out.println("Wrong input");             
           }
        }while(b==1);
    }
        public static void Login(){
                   System.out.print("Enter your username: ");
                   String username=input2.nextLine();
                   input2.nextLine();
                   
                   System.out.print("Enter your Password your password should be only numbers: ");
                   int pass =input2.nextInt();
                   input2.nextLine();
             
                   users.forEach(user -> {//iteration way
                       if (user.getPassword()==pass){
                           
                           Inventory();
                       }
                       else{
                           System.out.println("Wrong Username or Password please Contact your Admin!...");
                       }
         });
        }
        public static void LoginAdmin(){
                   System.out.print("Enter  username: ");
                   String username=input2.nextLine();
                   input2.nextLine();
                   
                   System.out.print("Enter  Password: ");
                   int pass =input2.nextInt();
                   input2.nextLine();
             
                   for (User user : users) {
                    if (user.getPassword()==pass && user.isAdmin==true){
                        Signin();
                    }
                    else{
                        System.out.println("This Accont Is Not Admin Account Please Contact Your Admin...");           
                    }
                   }
        }
        public static void Signin(){
                       // UniversityInventory inventory = new UniversityInventory();
                        int size,i,c=1;  
                       System.out.print("Enter the number of User to register: ");
                       size=input2.nextInt();
                       input2.nextLine();
                       
                       for(i=0;i<size;i++){
                           System.out.print("Enter User "+c+" username: ");
                           String username2=input2.nextLine();
                   
                           System.out.print("Enter user "+c+" Password: ");
                           int pass2 =input2.nextInt();
                           input2.nextLine();
                           
                           System.out.print("Enter user "+c+" devision: ");
                           String dev=input2.nextLine();
                           //input2.nextLine();
                           
                           System.out.print("IS THE USER "+c+" ADMINISTRACTER| yes or no: ");
                           String prevAdmin =input2.nextLine();
                       
                                if("yes".equals(prevAdmin)||"YES".equals(prevAdmin)){
                                    User useri = new User(username2, pass2, dev, true);
                                    inventory.addUser(useri);
                                }
                                else if("no".equals(prevAdmin)||"NO".equals(prevAdmin)){
                                    User useri = new User(username2, pass2, dev, false);
                                    inventory.addUser(useri);
                                }else{
                                    System.out.print("Wrong input! ");
                                }c++;
                           }
                       /*
                     
                       */
        }

    public static int Login_menu(){
        int c;
        System.out.println("*******************************************************************************");
        System.out.println("\t\t\t\tAMU INVENTORY MANAGEMENT SYSTEM\n");
        System.out.println("\t\t\tPress 1: TO LOGIN...\n");
        System.out.println("\t\t\tPress 2: To Sign in...\n");
        System.out.println("\t\t\tPress 3: To exit...\n");
        System.out.println("*******************************************************************************");
        System.out.print("\t\t\t\n Enter your choice: ");
        c=input2.nextInt();
        return c;
    }
    //
    public static int Inventory_menu(){
        int c;
        System.out.println("*******************************************************************************");
        System.out.println("\t\t\t\tINVENTORY MANAGEMENT\n");
        System.out.println("\t\t\tPress 1: TO Add Items...\n");
        System.out.println("\t\t\tPress 2: To Search Item...\n");
        System.out.println("\t\t\tPress 3: To Update Item...\n");
        System.out.println("\t\t\tPress 4: To Delete Item...\n");
        System.out.println("\t\t\tPress 5: To Display Items...\n");
        System.out.println("\t\t\tPress 6: To go back to main menu...\n");
        System.out.println("\t\t\tPress 7: To Exit...\n");
        System.out.println("*******************************************************************************");
        System.out.print("\t\t\t\n Enter your choice: ");
        c=input2.nextInt();
        return c;
    }
}