import org.junit.Test;

import junit.framework.TestCase;
import profile.Book;

/**
 * 
 */

/**
 * @author Pedro
 *
 */
public class test extends TestCase{
	Book book;
	@Test
	public void testRentRegister() {
		Book b=new Book(1221, "Jo�o", "ddd", "", 878877);
		 assertEquals("Jo�o", b.getBookName());
		
	}

}
