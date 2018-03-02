import static org.junit.Assert.assertEquals;

import java.lang.reflect.Field;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Lab1Tests {

	private Field month;
	private Field day;
	private Field year;
	
	@BeforeEach
	public void setUp() throws Exception {
		month = CalendarDate.class.getDeclaredField("month");
		month.setAccessible(true);
		day = CalendarDate.class.getDeclaredField("day");
		day.setAccessible(true);
		year = CalendarDate.class.getDeclaredField("year");
		year.setAccessible(true);
	}
	
	@Test
	public void testFields() {
		assertEquals("CalendarDate should only have \"month\" and \"date\" and \"year\" fields", CalendarDate.class.getDeclaredFields().length, 3);
	}
	
	@Test
	public void testConstructor() {
		CalendarDate cd = new CalendarDate(12,25,2017);
		try {
			assertEquals("CalendarDate constructor not working correctly", month.get(cd), 12);
			assertEquals("CalendarDate constructor not working correctly", day.get(cd), 25);
			assertEquals("CalendarDate constructor not working correctly", year.get(cd), 2017);
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testToString() {
		//double digit month and day
		CalendarDate cd = new CalendarDate(12,25,2017);
		assertEquals("toString not working correctly", cd.toString(), "12/25/2017");
		
		//single digit month and day
		cd = new CalendarDate(1,1,2018);
		assertEquals("toString not working correctly", cd.toString(), "1/1/2018");
	}
	
	@Test
	public void testCompareTo() {
		//different years
		CalendarDate cd = new CalendarDate(12,25,2017);
		CalendarDate cd2 = new CalendarDate(12,25,2018);
		assertEquals("compareTo not working correctly", cd.compareTo(cd2), -1);
		
		//different months
		cd = new CalendarDate(12,25,2018);
		cd2 = new CalendarDate(11,25,2018);
		assertEquals("compareTo not working correctly", cd.compareTo(cd2), 1);
		
		//different days
		cd = new CalendarDate(12,24,2018);
		cd2 = new CalendarDate(12,25,2018);
		assertEquals("compareTo not working correctly", cd.compareTo(cd2), -1);
		
		//same date
		cd = new CalendarDate(12,25,2018);
		cd2 = new CalendarDate(12,25,2018);
		assertEquals("compareTo not working correctly", cd.compareTo(cd2), 0);
	}
	
	@Test
	public void testIsLeapYear() {
		//not divisible by 4
		CalendarDate cd = new CalendarDate(12,25,2017);
		assertEquals("isLeapYear not working correctly", cd.isLeapYear(), false);
		
		//divisible by 4 but not 100
		cd = new CalendarDate(12,25,2016);
		assertEquals("isLeapYear not working correctly", cd.isLeapYear(), true);
		
		//divisible by 4 and 100 but not 400
		cd = new CalendarDate(12,25,1900);
		assertEquals("isLeapYear not working correctly", cd.isLeapYear(), false);
		
		//divisible by 4 and 400
		cd = new CalendarDate(12,25,2000);
		assertEquals("isLeapYear not working correctly", cd.isLeapYear(), true);
	}
	
	@Test
	public void testIsValidDate() {
		//invalid year
		CalendarDate cd = new CalendarDate(12,25,-1);
		assertEquals("isValidDate not working correctly", cd.isValidDate(), false);
		
		//invalid months
		cd = new CalendarDate(0,25,0);
		assertEquals("isValidDate not working correctly", cd.isValidDate(), false);
		cd = new CalendarDate(13,25,0);
		assertEquals("isValidDate not working correctly", cd.isValidDate(), false);
		
		//test days
		for(int i=1; i<=12; ++i) {
			//test invalid day
			cd = new CalendarDate(i,0,2018);
			assertEquals("isValidDate not working correctly", cd.isValidDate(), false);
			if(i == 4 || i == 6 || i == 9 || i == 11) {
				//test invalid day based on month
				cd = new CalendarDate(i,31,2018);
				assertEquals("isValidDate not working correctly", cd.isValidDate(), false);
				//test valid day based on month
				cd = new CalendarDate(i,30,2018);
				assertEquals("isValidDate not working correctly", cd.isValidDate(), true);
			} else if(i != 2) {
				//test invalid day based on month
				cd = new CalendarDate(i,32,2018);
				assertEquals("isValidDate not working correctly", cd.isValidDate(), false);
				//test valid day based on month
				cd = new CalendarDate(i,31,2018);
				assertEquals("isValidDate not working correctly", cd.isValidDate(), true);
			} else {
				//test invalid days based on leap year
				cd = new CalendarDate(i,30,2016);
				assertEquals("isValidDate not working correctly", cd.isValidDate(), false);
				cd = new CalendarDate(i,29,2018);
				assertEquals("isValidDate not working correctly", cd.isValidDate(), false);
				//test valid days based on leap year
				cd = new CalendarDate(i,29,2016);
				assertEquals("isValidDate not working correctly", cd.isValidDate(), true);
				cd = new CalendarDate(i,28,2018);
				assertEquals("isValidDate not working correctly", cd.isValidDate(), true);
			}
		}
	
	}
}
