//
//
// package util;
//import java.io.BufferedWriter;
///**
// * @author Pedro
// *
// */
// import java.io.File;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.OutputStreamWriter;
//import java.io.Writer;
//import java.nio.charset.StandardCharsets;
//
//import register.RentRegister;
//
//
// public class FileWriter{
//	 RentRegister r=new RentRegister();
//
//	 public void writing() {
//		 File local = new File(System.getProperty("user.home"));
//		 try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(local +"Rent.txt"), StandardCharsets.UTF_8))) {
////			    writer.write(r.getDataForPrint());
//			} catch (IOException ex) {
//				System.err.println("Problem writing to the file statsTest.txt");
//			} 
//		 
//		 
//		 
//		 
//	        try {
//	            //Whatever the file path is.
//	            File statText = new File(System.getProperty("user.home"));
//	            FileOutputStream is = new FileOutputStream(statText);
//	            OutputStreamWriter osw = new OutputStreamWriter(is);    
//	            Writer w = new BufferedWriter(osw);
//	            w.write(r.getDataForPrint());
//	            w.close();
//	        } catch (IOException e) {
//	            System.err.println("Problem writing to the file statsTest.txt");
//	        }
//    }
// }
