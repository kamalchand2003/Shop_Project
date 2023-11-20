package ProjectShopKeeper;

import java.util.*;

import java.util.Map.Entry;


/*
 * This is a project of online Ordering grocery
 * In this there are two users Customer (Buyer)  and Shopkeeper(Seller)
 * Buyer can view the products,order the Products ,set the quantity,
 * know the total price of product
 * 
 * Seller(Shop keeper) can add a product in shop,delete a product,update the price of product
 * view Product.
 */




public class Shop_keeping_App {
	
	
		
	
	 static Map<String, String> userDatabase = new HashMap<>();      //database for USER
	 static Map<String, String> CustomerDatabase=new HashMap<>();    //database for Customer
	
	 static Map<String, Double> Shop1 = new TreeMap<>();            //Storing the product in Shop1 using map and to display in ascending order using TreeMap
	 static Map<String, Double> cart = new HashMap<>();             //Storing the purchased products adding into cart
	
	 static boolean authenticateUser( String newUserName, String newPassword) {
                                                                    // Check if the entered username exists in the map and if the corresponding password matches
         return userDatabase.containsKey(newUserName) &&
                 userDatabase.get(newUserName).equals(newPassword);
     }
	 
	 static boolean authenticateCustomer( String newUserName, String newPassword) {
                                                                        // Check if the entered Customer name is same  or not
         return CustomerDatabase.containsKey(newUserName) &&
                 CustomerDatabase.get(newUserName).equals(newPassword);
     }
	 
	 static boolean authenticateNewUser( String newUserName) {            
                                                         // Check if the entered  new username exists in the map
         return userDatabase.containsKey(newUserName); 
     }
	 
	 static boolean authenticateNewCustomer( String newUserName) {
                                                                 // Check if the entered new Customer exists in the map 
         return CustomerDatabase.containsKey(newUserName); 
     }
	
	 public static void main(String[]ar){              //main Method
		
		 try{
		 
		 Scanner sc=new Scanner(System.in);
		
		                                                    //products  in the Shop
			Shop1.put("soda", 25.0);
		    Shop1.put("limesoda", 25.0);
		    Shop1.put("chips", 15.0);
	        Shop1.put("chocolate", 20.0);
	        Shop1.put("vegetable", 30.0);
	        Shop1.put("soap", 5.0);
	        Shop1.put("juice", 40.0);
	        Shop1.put("snacks", 18.0);
	        Shop1.put("fruits", 50.0);
	        Shop1.put("oil", 25.0);
	        Shop1.put("shampoo", 15.0);
	        Shop1.put("curd", 12.0);
	        Shop1.put("milk", 2.0);
	        Shop1.put("candy", 8.0);
	        
	        Shop1.put("pen", 5.0);
	        Shop1.put("pencil", 2.0);
	        Shop1.put("inkpen", 10.0);
	        Shop1.put("gelpen", 8.0);
	        Shop1.put("ballpointpen", 7.0);
	        Shop1.put("eraser", 1.0);
	        Shop1.put("scale", 3.0);
	        Shop1.put("gifts", 15.0);
	        Shop1.put("accessories", 12.0);
	        Shop1.put("shoe", 30.0);
	        Shop1.put("socks", 5.0);
	        Shop1.put("football", 20.0);
	        Shop1.put("carrom", 25.0);
	        Shop1.put("basketball", 18.0);
		

		 userDatabase.put("kamal", "kamal");                        //User name and password for user
	    
	     
	     CustomerDatabase.put("kamal", "k123");                      //Customer name and password for user
	    
		
		 System.out.println(" WELCOME TO SHOP APPLICATION    :)");         //start the process Of starting the application
		 System.out.println();
		 System.out.println("1. CUSTOMER     2.  SELLER     ");            //customer want to choose his option Customer / shop keeper
		 System.out.println("Click  1 or 2");
		int Customer_Choice=sc.nextInt();
		
		switch(Customer_Choice){                                           //according to his choice this application execute
	
		
		case 1:   //case 1.0 
			System.out.println("Already a user sign_in  ");
			System.out.println("1. Sign_in    2. Login");
			System.out.println("Click 1 or 2");
			int Customer_choice=sc.nextInt();
			
			switch(Customer_choice){
			
	        case 1:  //case 1.1
				
			 boolean checking=true;
			 while(checking){
				
				System.out.println("enter your Name :___________ ");
				String name=sc.next();                                                    //Customer wants to authenticate his id
				System.out.println("enter your Password :__________ ");
				String password=sc.next();
		      
		       
		       if (authenticateCustomer(name,password)) {
		            System.out.println("Welcome ="+name);
		            checking=false;
		            System.out.println("Displaying Products and its price ");         //if id and password is correct he can able to purchase
		            Order();
		            CustomerOption();
		       }
		            
    
		       	else{
		    	   
		    	   System.out.println("Username or password wrong .please try again");
		       		}
			 	}
			 
			 break;                              //case 1.1 break
			    
	        	case 2:                          //case 1.2
				boolean CustomerLogin=true;
				while(CustomerLogin){
				System.out.println("enter your name : ");
				String newUserName=sc.next();
				System.out.println("enter your password : ");
				String newPassword=sc.next();
				
				 if (authenticateNewCustomer(newUserName)) {
			            System.out.println("User already exists try new name");
			           
			         }
				 else{
					
					 CustomerDatabase.put(newUserName, newPassword);
					 System.out.println("Welcome new User :"+newUserName);
					 CustomerLogin=false;
					 Order();
					 CustomerOption();
				 }
				
				 
				
				}
				 break;                          //case 1.2 break
				default:
					System.out.println("invalid choice, select 1-to signin  select 2_to login");
					break;
			    }
				break;                              //case 1.0 break
			
			
		case 2:  
			System.out.println("Already a user sign_in  ");                    //SELLER
			System.out.println("1.Sign_in   2.Login");
			System.out.println("Click 1 or 2");
			int Seller_choice=sc.nextInt();
			
			switch(Seller_choice){
			
			 case 1:                   //case 2.1
				
			 boolean checking=true;
			 while(checking){
				
				System.out.println("enter your name : ");
				String name=sc.next();
				System.out.println("enter your password : ");
				String password=sc.next();
		      
		       
		       if (authenticateUser(name,password)) {
		            System.out.println("welcome =="+name);
		            checking=false;
		            SellerChoice(name);
		            

		          }
		     else{
		    	   
		    	   System.out.println("Username or password wrong .please try again");
		       }
			 }
		 break;                              //case 2.1 break
		 
		
			case 2:                          //case 2.2
				boolean userLogin=true;
				while(userLogin){
				System.out.println("enter your name : ");
				String newUserName=sc.next();
				System.out.println("enter your password : ");
				String newPassword=sc.next();
				
				 if (authenticateNewUser(newUserName)) {
			            System.out.println("User already exists try new name");
			           
			         }
				 else{
					 userLogin=false;
					 userDatabase.put(newUserName, newPassword);
					 System.out.println("Welcome new SHOPKEEPER User :"+newUserName);
					 SellerChoice(newUserName);
		
				 }
				
				 
				
				}
			 break;                              //case 2.2 break
			
			default:
					System.out.println("Invalid choice, select 1-to signin  select 2_to login");
					break;
			 
				
			}
			break;                             //case 2.0 break
		default:
			System.out.println("Invalid choice, select 1_for customer 2_ for seller ");
			break;
		}
		 }
		 catch(Exception e){
			 System.out.println("Something went wrong "+e);
		 }
	}
	static void Order(){                                               //display the n number of products
		int i=1;
	 for (Map.Entry<String, Double> productEntry : Shop1.entrySet()) {
         String productName = productEntry.getKey();
         double price = productEntry.getValue();
         if(i%5==0){
        	 System.out.println();
         }
      //   System.out.print(i+"  " + productName + ": $" + price+"  ");
         System.out.printf("%-10s $%.2f", productName, price);
         System.out.printf("       ");
         i++;
     }
	}
	
	static void search(String search){                          //search the product by its starting letter or by word

	for (Map.Entry<String, Double> productEntry : Shop1.entrySet()) {
        String productName = productEntry.getKey();
        double price = productEntry.getValue();
        if (productName.toLowerCase().startsWith(search.toLowerCase())) {
            System.out.println("  " + productName + ": $" + price);
        }
      }
	}
     
	


	 private static void addToCart(Map<String, Double> Shop1) {              //adding the product in the cart
	        Scanner scanner = new Scanner(System.in);
	      

	        while (true) {
	            System.out.print("\nEnter product name to add to cart (or 'done' to finish): ");
	            String productName = scanner.nextLine().trim();

	            if ("done".equalsIgnoreCase(productName)) {
	                break;
	            }

	            if (Shop1.containsKey(productName)) {
	                System.out.print("Enter quantity: ");
	                int quantity = scanner.nextInt();

	                // Update the quantity in the cart
	                cart.put(productName, cart.getOrDefault(productName, (double) 0) + quantity);
	                System.out.println("product added in cart");
	            } 
	            
	            else {
	                System.out.println("Product not found.");
	            }
	            scanner.nextLine();
	          }
	        }
                                                                                                //Calculating the total Price of Products Purchased
	    private static double calculateTotalPrice(Map<String, Double> cart2, Map<String, Double> Shop1) {  
	        double total = 0.0;
	        System.out.println();
	        System.out.println("Generating bill......");
	        for (Map.Entry<String, Double> entry : cart2.entrySet()) {
	        	
	            String productName = entry.getKey();
	            double quantity = entry.getValue();
	            double unitPrice = Shop1.get(productName);
	            System.out.println(productName+"  *  "+(int)quantity+" = $"+unitPrice*quantity);
	            
	            total += unitPrice * quantity;
	        }

	        return total;
	    }
	
   static void CustomerOption(){                       //if customer is authenticated allowed to purchase/search products;
	   Scanner sc=new Scanner(System.in);
	   boolean ProductChoice=true;
       while(ProductChoice){
       System.out.println();
       
       System.out.println("1.Search Product         2.Buy Product     3.Finish "    );
       System.out.println("Click 1 or 2 or 3");
       int customerChoice=sc.nextInt();
       if(customerChoice==3){
       	break;
       }
       
       else if(customerChoice==1){
       System.out.println("Search by the Product first letter or word  :");
       String search=sc.next();
       search(search);
       }
       
       else if(customerChoice==2){
       addToCart(Shop1);
       }
       
       }
       double totalPrice = calculateTotalPrice(cart, Shop1);
       System.out.println("\nTotal Price of Products in Cart: $" + totalPrice);
       System.out.println("thank you :) ");
     
  		}
static void SellerChoice(String name){
	Scanner sc=new Scanner(System.in);
    boolean UserChoice=true;
    while(UserChoice){
    	System.out.println();
    	System.out.println();
    System.out.println("1. View Product   2.Add new Product   3.Delete Product   4.Update Product Price   5.Exit" );
    int SellerChoice=sc.nextInt();
    if(SellerChoice==1){
    Order();
    }
    else if(SellerChoice==2){
    	System.out.println("enter the product name to add");
	   String newProduct=sc.next();
	   System.out.println("enter the price of "+newProduct+" = ");
	   double price=sc.nextDouble();
	   Shop1.put(newProduct, price);
	   System.out.println("Added item ");
    }
    else if(SellerChoice==3){
    	System.out.println("enter the product name to Delete");
    	 String newProduct=sc.next();
    	 if(Shop1.containsKey(newProduct)){
    	 Shop1.remove(newProduct);
    	 System.out.println("Removed Product "+newProduct);
    	 }else{
    		 System.out.println("No product is found in name "+newProduct);
    	 }
    }
    else if(SellerChoice==4){
    	System.out.println("enter the product name for UPDATE Price");
    	 String newProduct=sc.next();
    	 System.out.println("enter the price to update");
    	 double price=sc.nextDouble();
    	 if(Shop1.containsKey(newProduct)){
        	 Shop1.put(newProduct, price);
        	 System.out.println("updated Product "+newProduct);
        	 }else{
        		 System.out.println("No product is found in name "+newProduct+" for update");
        	 }
    	
    	
    }
    else if(SellerChoice==5){
    	System.out.println("THANK YOU :) "+name);
    	UserChoice=false;
    }
   
  
  
    }
}
  
}




	

