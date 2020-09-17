package supermarket__billing.service;

import java.util.Iterator;
import java.util.List;

import supermarket__billing.model.CartItem;
import supermarket__billing.model.Invoice;

public class InvoicePrint {
	
public void printBills(Invoice invoice) {
			System.out.println("Customer:  "+invoice.getCustomerName());
			System.out.print("\n");
			
			List<CartItem> citems = invoice.getCartItems();
			List<Double> amounts = invoice.getItemsDiscount();
			Iterator<Double> itr = amounts.iterator();
			for(CartItem citem : citems) {
				double temp = citem.getUnitPrice()*citem.getQuantity();
				double temp2 = itr.next();
				System.out.printf("%s\t\t\t%d%s\t%.2f\n",citem.getName().trim(),citem.getQuantity(),citem.getUnit(),(temp-temp2));
				
			}
			System.out.println("---------------------------------------");
			
			System.out.printf("Total Amount \t\t\t%.2f\n",invoice.getTotalDiscountedPrice());
			System.out.printf("You Saved \t%.2f %s %.2f %s %.2f %s \n",invoice.getTotalPrice(),"-",invoice.getTotalDiscountedPrice(),"=",invoice.getTotalDiscount()," Rs");
	}

}
