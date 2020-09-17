package supermarket__billing.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import supermarket__billing.Data;
import supermarket__billing.Discount_FactoryMethod;

public class Invoice extends Cart{
	
		Discount_FactoryMethod d;

		double totalPrice;
		double totalDiscountedPrice;
		double totalDiscount;
		List<Double> itemsDiscount;

		public double getTotalPrice() {
			return totalPrice;
		}

		public void setTotalPrice(double totalPrice) {
			this.totalPrice = totalPrice;
		}

		public double getTotalDiscountedPrice() {
			return totalDiscountedPrice;
		}

		public void setTotalDiscountedPrice(double totalDiscountedPrice) {
			this.totalDiscountedPrice = totalDiscountedPrice;
		}

		public void setTotalDiscount(double totalDiscount) {
			this.totalDiscount = totalDiscount;
		}

		public void setItemsDiscount(List<Double> itemsDiscount) {
			this.itemsDiscount = itemsDiscount;
		}
		
		public double getTotalDiscount() {
			return totalDiscount;
		}

		public List<Double> getItemsDiscount() {
			return itemsDiscount;
		}

		
		
		
		public void billCartItemsAfterDiscounts() {

			itemsDiscount = new ArrayList<>();
//			System.out.println("jjjjjjjjjjjjjjjjjjjjjjjjjjjjj");
			
			
			cartItems.forEach(item -> {

//				System.out.println("ankitaaassssssssssssssssssssssssss"+item);
//				Category category = Data.getCategories().get(item.getCategoryname());
//				System.out.println("lllllllllllll"+item.getCategoryname());
				Category cat=null;
				for(int i=0; i<Data.getCategories().size(); i++)
				{
					Category x=Data.getCategories().get(i);
//					System.out.println("kkkkkk"+x.getName());
					if(x.getName().equals(item.getCategoryname()))
					{
//						System.out.println("hello");
						cat=x;
//						System.out.println("hhhhhhh"+c);
						break;
					}
				}
//				System.out.println("ooooooo"+cat);
				SubCategory sub=null;
//				System.out.println("dnmsj"+item.getSubcategoryname());
				for(int j=0; j<Data.getSubcategories().size(); j++)
				{
					SubCategory x=Data.getSubcategories().get(j);
//					System.out.println("kkkkkk"+x.getName());
					if(x.getName().equals(item.getSubcategoryname()))
					{
//						System.out.println("hello");
						sub=x;
//						System.out.println("hhhhhhh"+c);
						break;
					}
				}
//				System.out.println("vvvvvvv"+sub);
				
			
				
				
//				System.out.println("fdgsjfhdsjf"+Data.getCategories().get(item.getCategoryname()));
//				SubCategory sub = Data.getSubcategories().get(item.getSubcategoryId() - 1);
				String dtype=item.getDiscountType();
				System.out.println("101"+dtype);
				int q = item.getQuantity();
				double catDisc = cat.discount.getDiscountAmount(item.getUnitPrice()) * q;
				double subDisc = sub.discount.getDiscountAmount(item.getUnitPrice()) * q;;
				
				double itemDisc=0;
				if(dtype.equals("percentage_off"))
				{
	
//				catDisc = cat.discount.getDiscountAmount(item.getUnitPrice()) * q;
//				subDisc = sub.discount.getDiscountAmount(item.getUnitPrice()) * q;
				itemDisc= item.discount.getDiscountAmount(item.getUnitPrice()) * q;
				//= item.discount.getDiscountAmount(item.getUnitPrice()) * q;
			//	System.out.println("socsis"+itemDisc);
//				System.out.println("gggggggg"+item);
//				System.out.println("hghghghgh"+itemDisc);
				double arr[] = { catDisc, subDisc, itemDisc };
				Arrays.sort(arr);
//				System.out.println(arr[0]+" "+arr[1]+" "+arr[2]);
				itemsDiscount.add(arr[2]);
				totalDiscount += arr[2];
				
				}
				else {
					int buy_units=item.discount.getBuyUnits();
					System.out.println("jaideep"+buy_units);
					int min = item.discount.getMinPurchaseQty();
				System.out.println("gggg"+item.discount.getMinPurchaseQty());
				
//				if(q>min && min!=0)
//				{
					int free=q%item.discount.getMinPurchaseQty();
					int get_items=(q-free)%buy_units;
					System.out.println("get_items"+item.getUnitPrice());
					itemDisc=get_items*item.getUnitPrice();
					
//					int bogo_applied_items=q-free-
//					itemDisc=get_items*item.discount.getDiscountAmount(item.getUnitPrice());
					System.out.println("sanju"+itemDisc);
					itemsDiscount.add(itemDisc);
					totalDiscount += itemDisc;
//				}
//				else {
//					itemDisc = 0;
//				}
//
//				if (min > 0) {
//					catDisc = 0;
//					subDisc = 0;
//
//				}
			//	System.out.println("min:" + min + " q:" + q);
				// calculation for bogo discount
//				if (min > q) {
//					itemDisc = 0;
//				} else {
//					if (min != 0) {
//						System.out.println("annnnnnnnnnn"+min);
//						int free = q / min;
//						System.out.print("free" + free);
//						itemDisc = free * item.discount.getDiscountAmount(item.getUnitPrice());
//					}
//
//				}
//				System.out.println(catDisc);
//				System.out.println(subDisc);
//				System.out.println(itemDisc);
				}
//				double arr[] = { catDisc, subDisc, itemDisc };
//				Arrays.sort(arr);
//				System.out.println(arr[0]+" "+arr[1]+" "+arr[2]);
//				itemsDiscount.add(arr[2]);
//				System.out.println("kkkkkkkkkkk"+itemsDiscount);
//				totalDiscount += arr[2];
//				System.out.println("llllllll"+totalDiscount);
//				System.out.println("oooooooooooooooooooo"+item.getDiscount());
				totalPrice+=item.getUnitPrice()*q;
//				totalPrice=item.getDiscount().getDiscountAmount();
//				totalPrice += item.getDiscount();
//
			});
//
			totalDiscountedPrice = totalPrice - totalDiscount;
//			System.out.println("a"+totalPrice+" "  +totalDiscount);
//			System.out.println(totalDiscount);
//			System.out.println(totalPrice);

		}

		
		public Invoice(Cart cart) {
			super(cart.getCustomerName());
			this.cartItems = cart.getCartItems();
//			System.out.println("cart items"+this.cartItems);

		}

		@Override
		public String toString() {
			return "Invoice [totalAmount=" + totalPrice + ", totalDiscountedAmount=" + totalDiscountedPrice
					+ ", totalDiscount=" + totalDiscount + ", itemsDiscount=" + itemsDiscount + "]";
		}

}
