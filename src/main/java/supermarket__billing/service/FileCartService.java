package supermarket__billing.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import supermarket__billing.Data;
import supermarket__billing.exception.QuantityZeroException;
import supermarket__billing.model.Cart;
import supermarket__billing.model.CartItem;
import supermarket__billing.model.Item;

public class FileCartService {
	Properties appProps = new Properties();
	
	public List<Cart> readBillFromInput(String inputfile) throws Exception  {

		//read inputs from input.txt file

		List<Cart> all_cart_items = new ArrayList<>();
		
		String line = "";
		String customerName;
		String custName;
		String customer_name;
		String itlist;

		Cart cart;
		BufferedReader br;
		try {
			if (inputfile != null) {
				br = new BufferedReader(new FileReader(inputfile));
			} else {
				ClassLoader classloader = Thread.currentThread().getContextClassLoader();
				InputStream is = classloader.getResourceAsStream("input.txt");

				InputStreamReader streamReader = new InputStreamReader(is, StandardCharsets.UTF_8);

				br = new BufferedReader(streamReader);
			}
			
			String cust_string=br.readLine();
			String cust_cart=br.readLine();
			System.out.println("dd"+cust_string);
			System.out.println("rrd"+cust_cart);
//			if(cust_cart==null)
//			{
//				System.out.println(appProps.getProperty("Cart_DoesNotExist"));
//			}
				String cstr[]=cust_string.split(" ");
				String customer_firstname=cstr[1].trim();
				String customer_lastname=cstr[2].trim();
				customer_name=customer_firstname+" "+customer_lastname;
//				System.out.println("fir"+customer_name);
				//bills.add(customer_name);
				cart = new Cart(customer_name);
			
			
			
//			while ((cust_cart) != null) // returns a Boolean value
//			{

//				String[] cart_items  = cust_cart.split(","); // use comma as separator
//				
//				custName = cstr[1].trim();
//				System.out.println("ankita"+custName);
//				cart = new Cart(custName);
//				itlist = cstr[1];
				System.out.println("jaiii"+Data.getItems());
				String[] istr = cust_cart.split(", ");
				for (int i = 0; i < istr.length; i++) {
					String[] itstr = istr[i].split(" ");
					System.out.println("gfucehvbuvjh"+itstr.length);
					String itname="";
					for(int j=0; j<itstr.length-1; j++)
					{
						itname+=" "+itstr[j];
					}
//					itname = itstr[0];
					System.out.println("oooooooooo"+itname);
//					System.out.println("fgf"+dat);
					List<Item> lis=Data.getItems();
					//Item item = DataStore.getItems().get(itemid - 1);
					CartItem cartItem;
					List<String> item_names=new ArrayList<>();
					
					for(int j=0; j<lis.size(); j++)
					{
						item_names.add(lis.get(j).getName().trim());
//						System.out.println("kkkkk"+lis.get(j).getName());
//						if(lis.get(j).getName().equals(itname))
//						{
//							throw new Exception("Item "+itname+" not avaible in supermarket.");
//							cartItem = new CartItem(qty, l.get(j));
//							cart.addItem(cartItem);
//						}
						System.out.println(item_names.get(j).getClass());
//					System.out.println(item_names);
					}
					System.out.println("final_lsit"+item_names);
					itname=itname.trim();
					System.out.println("itemmm"+itname.getClass());
//					itname=itname.trim();
					
					if(!item_names.contains(itname))
					{
						throw new Exception("Item "+itname+" not avaible in supermarket.");
					}
					
					
//					if(Data.getItems().contains(itname))
//					{
//						throw new Exception("Item "+itname+" not avaible in supermarket.");
//					}
					String unit=itstr[itstr.length-1];
					//System.out.println("ankit"+unit);
//					String iiiiiiiii=itstr[1];
					int qty=Integer.parseInt(unit.substring(0, unit.length()-2));
//					int qty = Integer.parseInt(itstr[1]);
					if(qty==0)
					{
//						throw new Exception();
//						System.out.println("bjh"+appProps.getProperty("Cart.ZERO_QUANTITY"));
						throw new Exception("There exists an item with quantity zero, Please enter correct value.");
					}
					
//					if(qty==0)
//					{
//						System.out.println("vhgfh");
//						System.out.println(appProps.getProperty("Cart.ZERO_QUANTITY"));
//					}
//					if(qty==0) throw new appProps.getProperty("Cart.ZERO_QUANTITY");
//					System.out.println("sdsds"+Data.getItems());
					String itemid = Data.getItemIdentifier().get(itname.toLowerCase().trim());
//					System.out.println("dfjdskgjkl"+itemid);
					List<Item> l=Data.getItems();
					//Item item = DataStore.getItems().get(itemid - 1);
//					CartItem cartItem;
					for(int j=0; j<l.size(); j++)
					{
						if(l.get(j).getName().equals(itemid))
						{
							cartItem = new CartItem(qty, l.get(j));
							cart.addItem(cartItem);
						}
					}

				}

				all_cart_items.add(cart);

		} catch (IOException e) {
			
			e.printStackTrace();
		}

		return all_cart_items;
	}

}
