package supermarket__billing;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import supermarket__billing.model.Cart;
import supermarket__billing.model.CartItem;
import supermarket__billing.model.Item;

public class TestInvoice {
	
	@Rule
    public final ExpectedException exception = ExpectedException.none();
	
	
	
	@Test
    public void shouldThrowErrorWhenPriceIsLessThan0() throws IOException {
		System.out.println(file_readmethod());
//        exception.expect(InvalidArticleConfigurationException.class);
//        exception.expectMessage("Price should be grater than 0");
//        new Article("Art0001", "Pencil", new BigDecimal(-1), ZERO, ZERO);
    }
	
	

	
	
	public BufferedReader file_readmethod() throws IOException {
		String line = "";
		String customerName;
		String custName;
		String customer_name;
		String itlist;

		Cart cart;
		BufferedReader br;
		
				ClassLoader classloader = Thread.currentThread().getContextClassLoader();
				InputStream is = classloader.getResourceAsStream("input.txt");
				InputStreamReader streamReader = new InputStreamReader(is, StandardCharsets.UTF_8);
				br = new BufferedReader(streamReader);
				System.out.println("nkiadjakshd"+br.readLine());
				return br;
				
	}
	
//			String cust_string=br.readLine();
//			String cust_cart=br.readLine();
//			
//			String[] s=cust_string;
//			return cust
//			System.out.println("dd"+cust_string);
//			System.out.println("rrd"+cust_cart);
//				String cstr[]=cust_string.split(" ");
//				String customer_firstname=cstr[1].trim();
//				String customer_lastname=cstr[2].trim();
//				customer_name=customer_firstname+" "+customer_lastname;
//
//				cart = new Cart(customer_name);
//			
//				System.out.println("jaiii"+Data.getItems());
//				String[] istr = cust_cart.split(", ");
//				for (int i = 0; i < istr.length; i++) {
//					String[] itstr = istr[i].split(" ");
//					System.out.println("gfucehvbuvjh"+itstr.length);
//					String itname="";
//					for(int j=0; j<itstr.length-1; j++)
//					{
//						itname+=" "+itstr[j];
//					}
////					itname = itstr[0];
//					System.out.println("oooooooooo"+itname);
//					String unit=itstr[itstr.length-1];
//					System.out.println("ankit"+unit);
////					String iiiiiiiii=itstr[1];
//					int qty=Integer.parseInt(unit.substring(0, unit.length()-2));
////					int qty = Integer.parseInt(itstr[1]);
//					if(qty==0)
//					{
//
//						throw new Exception("There exists an item with quantity zero, Please enter correct value.");
//					}
//					String itemid = Data.getItemIdentifier().get(itname.toLowerCase().trim());
//
//					List<Item> l=Data.getItems();
//					CartItem cartItem;
//					for(int j=0; j<l.size(); j++)
//					{
//						if(l.get(j).getName().equals(itemid))
//						{
//							cartItem = new CartItem(qty, l.get(j));
//							cart.addItem(cartItem);
//						}
//					}
//
//				}
//
//		
//	}
	
//    @Test
//    public void customerNameExistence() {
//    	BufferedReader br=file_readmethod();
//    	String cust_string=br.readLine();
//		String cust_cart=br.readLine();
//    	
////        Article article = getPencilWithId("Art0001");
//
////        assertEquals("Pencil", article.getName());
////        assertEquals(3.50, article.getUnitPrice().doubleValue(), 0);
//    }
//
//    @Test
//    public void shouldThrowErrorWhenPriceIsLessThan0() {
//        exception.expect(InvalidArticleConfigurationException.class);
//        exception.expectMessage("Price should be grater than 0");
//        new Article("Art0001", "Pencil", new BigDecimal(-1), ZERO, ZERO);
//    }
//
//    @Test
//    public void shouldReturnTrueWhenComparingTwoSameArticles() {
//        Article pencil1 = getPencilWithId("Art0001");
//        Article pencil2 = getPencilWithId("Art0001");
//
//        assertEquals(pencil1, pencil2);
//    }
//
//    @Test
//    public void shouldReturnFalseWhenComparingTwoDifferentArticles() {
//        Article pencil1 = getPencilWithId("Art0001");
//        Article pencil2 = getPencilWithId("Art0002");
//
//        assertNotEquals(pencil1, pencil2);
//    }
//
//    @Test
//    public void shouldComputeTaxWhenComputingPrice() {
//        Article pen = getPenWithTax(1.0, 2.55);
//
//        assertEquals(10.35, pen.getUnitPrice().doubleValue(), 0);
//    }
//
//    @Test
//    public void shouldThrowErrorWhenCGSTIsLessThan0() {
//        exception.expect(InvalidArticleConfigurationException.class);
//        exception.expectMessage("TAX should be between 0 and 100");
//        getPenWithTax(-1.0, 2.0);
//    }
//
//    @Test
//    public void shouldThrowErrorWhenSGSTIsLessThan0() {
//        exception.expect(InvalidArticleConfigurationException.class);
//        exception.expectMessage("TAX should be between 0 and 100");
//        getPenWithTax(1.0, -2.0);
//    }
//
//    @Test
//    public void shouldThrowErrorWhenCGSTIsGreaterThan100() {
//        exception.expect(InvalidArticleConfigurationException.class);
//        exception.expectMessage("TAX should be between 0 and 100");
//        getPenWithTax(101.0, 2.0);
//    }
//
//    @Test
//    public void shouldThrowErrorWhenSGSTIsGreaterThan100() {
//        exception.expect(InvalidArticleConfigurationException.class);
//        exception.expectMessage("TAX should be between 0 and 100");
//        getPenWithTax(1.0, 200.0);
//    }
//
//    private Article getPenWithTax(double cgst, double sgst) {
//        return new Article("Art001", "Pen", new BigDecimal(10), new BigDecimal(cgst), new BigDecimal(sgst));
//    }
//
//    private Article getPencilWithId(String id) {
//        return new Article(id, "Pencil", new BigDecimal(3.5), ZERO, ZERO);
//    }

}
