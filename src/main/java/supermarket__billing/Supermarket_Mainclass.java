package supermarket__billing;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import supermarket__billing.model.Invoice;
import supermarket__billing.service.FileCartService;
import supermarket__billing.service.FileReaderService;
import supermarket__billing.service.InvoicePrint;

public class Supermarket_Mainclass {
	
	
	public static void main(String[] args) {
		
//		String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
//		String appConfigPath = rootPath + "configuration.properties";
//		Properties appProps = new Properties();
		try {
//			appProps.load(new FileInputStream(appConfigPath));
			init();
			String filename = null;
			if (0 < args.length) {
				filename = args[0];
			}
			readCustomerCarts(filename); 
			generateInvoices();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
//			System.out.println("vbf"+e);
			System.out.println(e.getMessage());
//			System.out.println("hello"+e.toString());
		//	appProps.getProperty(e.getMessage());
//			e.printStackTrace();
		}
	}

	
	
	
	private static void generateInvoices() {
	
//		Invoice invoices = new Invoice(cart);
//		Invoice invoice=new Invoice();
//		Invoice i=new In
		Data.getCarts().forEach(cart -> {
			Invoice invoice = new Invoice(cart);
//			System.out.println("ankasjka"+invoice);
			invoice.billCartItemsAfterDiscounts();
			Data.setInvoices(invoice);
			InvoicePrint bps = new InvoicePrint();
//			System.out.println("baby"+Data.getInvoices());
			bps.printBills(Data.getInvoices());
			
//			invoices.add(invoice);
		});
		
//		Data.setInvoices(invoice);
		
//		Data.setInvoices(invoices);

	}

//	private static void printInvoices() {
//		InvoicePrint bps = new InvoicePrint();
////		System.out.println("baby"+Data.getInvoices());
////		bps.printBills(Data.getInvoices());
//	}

	private static void readCustomerCarts(String inputfile) throws Exception {
		FileCartService file_cart = new FileCartService();
		Data.setCarts(file_cart.readBillFromInput(inputfile));

	}

	private static void init() {
		FileReaderService rs = new FileReaderService();
		Data.init(rs);

	}


}
