package lab6;

import org.junit.jupiter.api.*;
import java.util.Date;
import java.util.Calendar;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Comprehensive JUnit 5 test class for Hotel Reservation System.
 * Tests are executed in lexicographical order by method name.
 * 
 * @author Dr. Sukhwant Sagar
 * @version 1.0
 */
@TestMethodOrder(MethodOrderer.MethodName.class)
public class HotelReservationSystemTest {
    
    private Room room1;
    private Room room2;
    private Date checkIn;
    private Date checkOut;
    
    @BeforeEach
    public void setUp() throws InvalidRoomException {
        // Setup common test data
        room1 = new Room(201, "Double", 2, 150.0);
        room2 = new Room(301, "Suite", 4, 300.0);
        
        Calendar cal = Calendar.getInstance();
        cal.set(2024, Calendar.NOVEMBER, 15, 0, 0, 0);
        cal.set(Calendar.MILLISECOND, 0);
        checkIn = cal.getTime();
        
        cal.set(2024, Calendar.NOVEMBER, 18, 0, 0, 0);
        checkOut = cal.getTime();
    }
    
    // ========== Room Constructor Tests ==========
    
    @Test
    public void test01_RoomDefaultConstructor() {
        Room room = new Room();
        assertEquals(101, room.getRoomNumber());
        assertEquals("Single", room.getRoomType());
        assertEquals(1, room.getCapacity());
        assertEquals(100.0, room.getPricePerNight(), 0.01);
    }
    
    @Test
    public void test02_RoomParameterizedConstructorValid() throws InvalidRoomException {
        Room room = new Room(202, "Double", 2, 175.50);
        assertEquals(202, room.getRoomNumber());
        assertEquals("Double", room.getRoomType());
        assertEquals(2, room.getCapacity());
        assertEquals(175.50, room.getPricePerNight(), 0.01);
    }
    
    @Test
    public void test03_RoomConstructorInvalidRoomNumber() {
        assertThrows(InvalidRoomException.class, () -> {
            new Room(0, "Single", 1, 100.0);
        });
    }
           
    @Test
    public void test10_RoomConstructorNegativePrice() {
        assertThrows(InvalidRoomException.class, () -> {
            new Room(101, "Single", 1, -50.0);
        });
    }
    
    // ========== Room Getter Tests ==========
           
    @Test
    public void test13_RoomGetCapacity() {
        assertEquals(2, room1.getCapacity());
    }
    
    @Test
    public void test14_RoomGetPricePerNight() {
        assertEquals(150.0, room1.getPricePerNight(), 0.01);
    }
    
    // ========== Room Setter Tests ==========
    
    @Test
    public void test15_RoomSetRoomNumberValid() throws InvalidRoomException {
        room1.setRoomNumber(999);
        assertEquals(999, room1.getRoomNumber());
    }
    
    @Test
    public void test16_RoomSetRoomNumberInvalid() {
        assertThrows(InvalidRoomException.class, () -> {
            room1.setRoomNumber(0);
        });
    }
      
    @Test
    public void test20_RoomSetCapacityInvalid() {
        assertThrows(InvalidRoomException.class, () -> {
            room1.setCapacity(-1);
        });
    }
    
    @Test
    public void test21_RoomSetPricePerNightValid() throws InvalidRoomException {
        room1.setPricePerNight(200.50);
        assertEquals(200.50, room1.getPricePerNight(), 0.01);
    }       
    
    // ========== Room Computational Methods Tests ==========
    
    @Test
    public void test24_RoomCalculateCost() {
        double cost = room1.calculateCost(3);
        assertEquals(450.0, cost, 0.01);
    }
            
    @Test
    public void test28_RoomCalculateCostWithTaxZeroRate() {
        double cost = room1.calculateCostWithTax(3, 0.0);
        assertEquals(450.0, cost, 0.01);
    }
    
    @Test
    public void test29_RoomCalculateCostWithTaxHighRate() {
        double cost = room2.calculateCostWithTax(2, 15.0);
        assertEquals(690.0, cost, 0.01);
    }
      
    
    @Test
    public void test32_RoomApplyDiscountFiftyPercent() {
        double discounted = room2.applyDiscount(600.0, 50.0);
        assertEquals(300.0, discounted, 0.01);
    }
    
    @Test
    public void test33_RoomIsAvailableForGuestsTrue() {
        assertTrue(room1.isAvailableForGuests(2));
    }
    
    @Test
    public void test36_RoomIsAvailableForGuestsOne() {
        assertTrue(room1.isAvailableForGuests(1));
    }
    
    @Test
    public void test37_RoomToString() {
        String str = room1.toString();
        assertTrue(str.contains("201"));
        assertTrue(str.contains("Double"));
        assertTrue(str.contains("2"));
        assertTrue(str.contains("150.00"));
    }
    
    // ========== Booking Constructor Tests ==========
    
    @Test
    public void test38_BookingConstructorValid() throws Exception {
        HotelReservationSystem booking = new HotelReservationSystem("B001", "John Doe", checkIn, checkOut, 2, room1);
        assertEquals("B001", booking.getBookingID());
        assertEquals("John Doe", booking.getGuestName());
        assertEquals(2, booking.getNumberOfGuests());
        assertNotNull(booking.getRoom());
    }
    
    @Test
    public void test39_BookingConstructorNullBookingID() {
        assertThrows(InvalidBookingException.class, () -> {
            new HotelReservationSystem(null, "John Doe", checkIn, checkOut, 2, room1);
        });
    }
        
    @Test
    public void test42_BookingConstructorEmptyGuestName() {
        assertThrows(InvalidBookingException.class, () -> {
            new HotelReservationSystem("B001", "", checkIn, checkOut, 2, room1);
        });
    }
        
    @Test
    public void test45_BookingConstructorCheckOutBeforeCheckIn() {
        assertThrows(InvalidBookingException.class, () -> {
            new HotelReservationSystem("B001", "John Doe", checkOut, checkIn, 2, room1);
        });
    }
      
    
    @Test
    public void test50_BookingConstructorNullRoom() {
        assertThrows(InvalidBookingException.class, () -> {
            new HotelReservationSystem("B001", "John Doe", checkIn, checkOut, 2, null);
        });
    }
    
    // ========== Booking Getter Tests ==========
    
    @Test
    public void test51_BookingGetBookingID() throws Exception {
        HotelReservationSystem booking = new HotelReservationSystem("B002", "Jane Smith", checkIn, checkOut, 1, room1);
        assertEquals("B002", booking.getBookingID());
    }
    
    @Test
    public void test52_BookingGetGuestName() throws Exception {
        HotelReservationSystem booking = new HotelReservationSystem("B003", "Bob Johnson", checkIn, checkOut, 2, room1);
        assertEquals("Bob Johnson", booking.getGuestName());
    }
     
    
    @Test
    public void test55_BookingGetNumberOfGuests() throws Exception {
        HotelReservationSystem booking = new HotelReservationSystem("B006", "David Wilson", checkIn, checkOut, 2, room1);
        assertEquals(2, booking.getNumberOfGuests());
    }
    
    @Test
    public void test56_BookingGetRoom() throws Exception {
        HotelReservationSystem booking = new HotelReservationSystem("B007", "Emma Martinez", checkIn, checkOut, 2, room1);
        assertEquals(room1, booking.getRoom());
    }
    
    // ========== Booking Setter Tests ==========
    
    @Test
    public void test57_BookingSetBookingIDValid() throws Exception {
        HotelReservationSystem booking = new HotelReservationSystem("B008", "Frank Taylor", checkIn, checkOut, 2, room1);
        booking.setBookingID("B999");
        assertEquals("B999", booking.getBookingID());
    }
       
    @Test
    public void test60_BookingSetGuestNameEmpty() throws Exception {
        HotelReservationSystem booking = new HotelReservationSystem("B011", "Ivy Jackson", checkIn, checkOut, 2, room1);
        assertThrows(InvalidBookingException.class, () -> {
            booking.setGuestName("");
        });
    }
    
    @Test
    public void test61_BookingSetCheckInDateValid() throws Exception {
        HotelReservationSystem booking = new HotelReservationSystem("B012", "Jack White", checkIn, checkOut, 2, room1);
        Calendar cal = Calendar.getInstance();
        cal.set(2024, Calendar.NOVEMBER, 14, 0, 0, 0);
        Date newCheckIn = cal.getTime();
        booking.setCheckInDate(newCheckIn);
        assertEquals(newCheckIn, booking.getCheckInDate());
    }
          
    @Test
    public void test63_BookingSetCheckOutDateValid() throws Exception {
        HotelReservationSystem booking = new HotelReservationSystem("B014", "Larry Martin", checkIn, checkOut, 2, room1);
        Calendar cal = Calendar.getInstance();
        cal.set(2024, Calendar.NOVEMBER, 20, 0, 0, 0);
        Date newCheckOut = cal.getTime();
        booking.setCheckOutDate(newCheckOut);
        assertEquals(newCheckOut, booking.getCheckOutDate());
    }
    
    @Test
    public void test64_BookingSetCheckOutDateBeforeCheckIn() throws Exception {
        HotelReservationSystem booking = new HotelReservationSystem("B015", "Monica Garcia", checkIn, checkOut, 2, room1);
        Calendar cal = Calendar.getInstance();
        cal.set(2024, Calendar.NOVEMBER, 14, 0, 0, 0);
        Date invalidCheckOut = cal.getTime();
        assertThrows(InvalidBookingException.class, () -> {
            booking.setCheckOutDate(invalidCheckOut);
        });
    }
         
    @Test
    public void test67_BookingSetRoomValid() throws Exception {
        HotelReservationSystem booking = new HotelReservationSystem("B018", "Paul Rodriguez", checkIn, checkOut, 2, room1);
        booking.setRoom(room2);
        assertEquals(room2, booking.getRoom());
    }
    
     // ========== Booking Computational Methods Tests ==========
    
    @Test
    public void test69_BookingGetNumberOfNights() throws Exception {
        HotelReservationSystem booking = new HotelReservationSystem("B020", "Rachel Lee", checkIn, checkOut, 2, room1);
        assertEquals(3, booking.getNumberOfNights());
    }
    
    @Test
    public void test70_BookingGetNumberOfNightsOneDayStay() throws Exception {
        Calendar cal = Calendar.getInstance();
        cal.set(2024, Calendar.DECEMBER, 1, 0, 0, 0);
        Date in = cal.getTime();
        cal.set(2024, Calendar.DECEMBER, 2, 0, 0, 0);
        Date out = cal.getTime();
        HotelReservationSystem booking = new HotelReservationSystem("B021", "Sam Walker", in, out, 1, room1);
        assertEquals(1, booking.getNumberOfNights());
    }
    
    @Test
    public void test71_BookingGetNumberOfNightsWeekStay() throws Exception {
        Calendar cal = Calendar.getInstance();
        cal.set(2024, Calendar.DECEMBER, 1, 0, 0, 0);
        Date in = cal.getTime();
        cal.set(2024, Calendar.DECEMBER, 8, 0, 0, 0);
        Date out = cal.getTime();
        HotelReservationSystem booking = new HotelReservationSystem("B022", "Tina Hall", in, out, 2, room1);
        assertEquals(7, booking.getNumberOfNights());
    }
    
       
    @Test
    public void test75_BookingGetTotalCostWithTaxZeroRate() throws Exception {
        HotelReservationSystem booking = new HotelReservationSystem("B026", "Xavier Wright", checkIn, checkOut, 2, room1);
        assertEquals(450.0, booking.getTotalCostWithTax(0.0), 0.01);
    }
    
    @Test
    public void test76_BookingGetCostPerGuest() throws Exception {
        HotelReservationSystem booking = new HotelReservationSystem("B027", "Yolanda Lopez", checkIn, checkOut, 2, room1);
        assertEquals(225.0, booking.getCostPerGuest(), 0.01);
    }
           
    @Test
    public void test79_BookingGetDiscountedTotal() throws Exception {
        HotelReservationSystem booking = new HotelReservationSystem("B030", "Brian Green", checkIn, checkOut, 2, room1);
        assertEquals(405.0, booking.getDiscountedTotal(10.0), 0.01);
    }
    
    @Test
    public void test80_BookingGetDiscountedTotalTwentyPercent() throws Exception {
        HotelReservationSystem booking = new HotelReservationSystem("B031", "Catherine Adams", checkIn, checkOut, 2, room1);
        assertEquals(360.0, booking.getDiscountedTotal(20.0), 0.01);
    }
    
       
    @Test
    public void test86_BookingToString() throws Exception {
        HotelReservationSystem booking = new HotelReservationSystem("B037", "Irene Roberts", checkIn, checkOut, 2, room1);
        String str = booking.toString();
        assertTrue(str.contains("B037"));
        assertTrue(str.contains("Irene Roberts"));
        assertTrue(str.contains("2"));
        assertTrue(str.contains("3"));
    }
    
        
    @Test
    public void test90_IntegrationMultipleDiscounts() throws Exception {
        HotelReservationSystem booking = new HotelReservationSystem("B103", "Discount Hunter", checkIn, checkOut, 2, room1);
        double originalCost = booking.getTotalCost();
        double firstDiscount = booking.getDiscountedTotal(10.0);
        double secondDiscount = room1.applyDiscount(firstDiscount, 5.0);
        
        assertEquals(450.0, originalCost, 0.01);
        assertEquals(405.0, firstDiscount, 0.01);
        assertEquals(384.75, secondDiscount, 0.01);
    }
}
