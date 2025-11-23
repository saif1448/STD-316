package lab6;

import java.util.Date;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

/**
 * Hotel Reservation System - Complete Implementation
 * Contains all exception classes and both Room and Booking classes.
 * 
 * @author Dr. Sukhwant Sagar
 * @version 1.0
 */

// ==================== EXCEPTION CLASSES ====================

/**
 * Custom exception thrown when invalid room properties are provided.
 */
class InvalidRoomException extends Exception {

	private static final long serialVersionUID = 1L;

	public InvalidRoomException() {
		super();
	}

	public InvalidRoomException(String message) {
		super(message);
	}
}

/**
 * Custom exception thrown when invalid booking details are provided.
 */
class InvalidBookingException extends Exception {

	private static final long serialVersionUID = 1L;

	public InvalidBookingException() {
		super();
	}

	public InvalidBookingException(String message) {
		super(message);
	}

}

/**
 * Custom exception thrown when the number of guests exceeds room capacity.
 */
class RoomCapacityExceededException extends Exception {

	private static final long serialVersionUID = 1L;

	public RoomCapacityExceededException() {
		super();
	}

	public RoomCapacityExceededException(String message) {
		super(message);
	}

}
// ==================== ROOM CLASS ====================

/**
 * Represents a hotel room with properties and behaviors for managing room
 * information and calculating costs. This class includes validation for all
 * room properties and throws appropriate exceptions when invalid data is
 * provided.
 */
class Room {

	// Instance variables
	private int roomNumber;
	private String roomType;
	private int capacity;
	private double pricePerNight;

	/**
	 * Default constructor that creates a room with default values. Default room:
	 * Room 101, Single type, capacity of 1, price of $100.0 per night.
	 */

	public Room() {
		this.roomNumber = 101;
		this.roomType = "Single";
		this.capacity = 1;
		this.pricePerNight = 100.0;
	}

	/**
	 * Parameterized constructor that creates a room with specified values.
	 * Validates all input parameters and throws exceptions for invalid data.
	 * 
	 * @param roomNumber    the room number (must be positive)
	 * @param roomType      the type of room (must not be null or empty)
	 * @param capacity      the maximum number of guests (must be positive)
	 * @param pricePerNight the price per night (must be non-negative)
	 * @throws InvalidRoomException if any parameter is invalid
	 */
	public Room(int roomNumber, String roomType, int capacity, double pricePerNight) throws InvalidRoomException {
		setRoomNumber(roomNumber);
		setRoomType(roomType);
		setCapacity(capacity);
		setPricePerNight(pricePerNight);
	}

	/**
	 * Gets the room number.
	 * 
	 * @return the room number
	 */
	public int getRoomNumber() {
		return roomNumber;
	}

	/**
	 * Sets the room number with validation.
	 * 
	 * @param roomNumber the room number to set (must be positive)
	 * @throws InvalidRoomException if roomNumber is less than or equal to 0
	 */
	public void setRoomNumber(int roomNumber) throws InvalidRoomException {
		if (roomNumber <= 0) {
			throw new InvalidRoomException("Room number must be positive.");
		}
		this.roomNumber = roomNumber;
	}

	/**
	 * Gets the room type.
	 * 
	 * @return the room type
	 */
	public String getRoomType() {
		return roomType;
	}

	/**
	 * Sets the room type with validation.
	 * 
	 * @param roomType the room type to set (must not be null or empty)
	 * @throws InvalidRoomException if roomType is null or empty
	 */
	public void setRoomType(String roomType) throws InvalidRoomException {
		if (roomType == null || roomType.trim().isEmpty()) {
			throw new InvalidRoomException("Room type cannot be null or empty.");
		}
		this.roomType = roomType.trim();
	}

	/**
	 * Gets the room capacity.
	 * 
	 * @return the maximum number of guests the room can accommodate
	 */
	public int getCapacity() {
		return capacity;
	}

	/**
	 * Sets the room capacity with validation.
	 * 
	 * @param capacity the capacity to set (must be positive)
	 * @throws InvalidRoomException if capacity is less than or equal to 0
	 */
	public void setCapacity(int capacity) throws InvalidRoomException {
		if (capacity <= 0) {
			throw new InvalidRoomException("Capacity must be positive.");
		}
		this.capacity = capacity;
	}

	/**
	 * Gets the price per night.
	 * 
	 * @return the price per night
	 */
	public double getPricePerNight() {
		return pricePerNight;
	}

	/**
	 * Sets the price per night with validation.
	 * 
	 * @param pricePerNight the price per night to set (must be non-negative)
	 * @throws InvalidRoomException if pricePerNight is negative
	 */

	public void setPricePerNight(double pricePerNight) throws InvalidRoomException {
		if (pricePerNight < 0) {
			throw new InvalidRoomException("Price per night cannot be negative.");
		}
		this.pricePerNight = round2(pricePerNight);
	}

	/**
	 * Calculates the total cost for a given number of nights.
	 * 
	 * @param numberOfNights the number of nights to stay
	 * @return the total cost rounded to 2 decimal places
	 */
	public double calculateCost(int numberOfNights) {
		if (numberOfNights < 0) {
			throw new IllegalArgumentException("Number of nights cannot be negative.");
		}
		return round2(pricePerNight * numberOfNights);
	}

	/**
	 * Calculates the total cost including tax for a given number of nights.
	 * 
	 * @param numberOfNights the number of nights to stay
	 * @param taxRate        the tax rate as a percentage (e.g., 13.0 for 13%)
	 * @return the total cost including tax, rounded to 2 decimal places
	 */

	public double calculateCostWithTax(int numberOfNights, double taxRate) {
		double base = calculateCost(numberOfNights);
		double total = base * (1 + taxRate / 100.0);
		return round2(total);
	}

	/**
	 * Applies a discount to a given cost.
	 * 
	 * @param cost            the original cost
	 * @param discountPercent the discount percentage (e.g., 10.0 for 10% off)
	 * @return the discounted cost rounded to 2 decimal places
	 */

	public double applyDiscount(double cost, double discountPercent) {
		if (cost < 0) {
			throw new IllegalArgumentException("Cost cannot be negative.");
		}
		if (discountPercent < 0) {
			throw new IllegalArgumentException("Discount percent cannot be negative.");
		}
		double discounted = cost * (1 - discountPercent / 100.0);
		return round2(discounted);
	}

	/**
	 * Checks if the room can accommodate the specified number of guests.
	 * 
	 * @param numberOfGuests the number of guests
	 * @return true if the room can accommodate the guests, false otherwise
	 */

	public boolean isAvailableForGuests(int numberOfGuests) {
		return numberOfGuests > 0 && numberOfGuests <= capacity;
	}

	/**
	 * Returns a string representation of the room.
	 * 
	 * @return a formatted string containing room details
	 */
	@Override
	public String toString() {
		return String.format("Room %d [%s] - Capacity: %d guests, $%.2f per night", roomNumber, roomType, capacity,
				pricePerNight);
	}

	private double round2(double value) {
		return Math.round(value * 100.0) / 100.0;
	}
}

// ==================== BOOKING CLASS ====================

/**
 * Represents a hotel room booking with guest information, dates, and associated
 * room. This class demonstrates association (has-a relationship) with the Room
 * class and includes comprehensive validation with exception handling.
 */
public class HotelReservationSystem {

	// Instance variables
	private String bookingID;
	private String guestName;
	private Date checkInDate;
	private Date checkOutDate;
	private int numberOfGuests;
	private Room room; // Association: Booking has-a Room

	/**
	 * Parameterized constructor that creates a booking with specified values.
	 * Validates all input parameters and throws appropriate exceptions for invalid
	 * data.
	 * 
	 * @param bookingID      the unique booking identifier (must not be null or
	 *                       empty)
	 * @param guestName      the name of the guest (must not be null or empty)
	 * @param checkInDate    the check-in date (must not be null)
	 * @param checkOutDate   the check-out date (must be after check-in date)
	 * @param numberOfGuests the number of guests (must be positive and within room
	 *                       capacity)
	 * @param room           the associated room (must not be null)
	 * @throws InvalidBookingException       if any parameter is invalid
	 * @throws RoomCapacityExceededException if numberOfGuests exceeds room capacity
	 */
	public HotelReservationSystem(String bookingID, String guestName, Date checkInDate, Date checkOutDate,
			int numberOfGuests, Room room) throws InvalidBookingException, RoomCapacityExceededException {
		setRoom(room); // validate room not null first (room needed for capacity check)
		setBookingID(bookingID);
		setGuestName(guestName);
		if (checkInDate == null) {
			throw new InvalidBookingException("Check-in date cannot be null.");
		}
		if (checkOutDate == null) {
			throw new InvalidBookingException("Check-out date cannot be null.");
		}
		if (!checkOutDate.after(checkInDate)) {
			throw new InvalidBookingException("Check-out must be after check-in.");
		}
		this.checkInDate = checkInDate;
		this.checkOutDate = checkOutDate;
		setNumberOfGuests(numberOfGuests); // capacity check inside
	}

	/**
	 * Gets the booking ID.
	 * 
	 * @return the booking ID
	 */
	public String getBookingID() {
		return bookingID;
	}

	/**
	 * Sets the booking ID with validation.
	 * 
	 * @param bookingID the booking ID to set (must not be null or empty)
	 * @throws InvalidBookingException if bookingID is null or empty
	 */

	public void setBookingID(String bookingID) throws InvalidBookingException {
		if (bookingID == null || bookingID.trim().isEmpty()) {
			throw new InvalidBookingException("Booking ID cannot be null or empty.");
		}
		this.bookingID = bookingID.trim();
	}

	/**
	 * Gets the guest name.
	 * 
	 * @return the guest name
	 */
	public String getGuestName() {
		return guestName;
	}

	/**
	 * Sets the guest name with validation.
	 * 
	 * @param guestName the guest name to set (must not be null or empty)
	 * @throws InvalidBookingException if guestName is null or empty
	 */

	public void setGuestName(String guestName) throws InvalidBookingException {
		if (guestName == null || guestName.trim().isEmpty()) {
			throw new InvalidBookingException("Guest name cannot be null or empty.");
		}
		this.guestName = guestName.trim();
	}

	/**
	 * Gets the check-in date.
	 * 
	 * @return the check-in date
	 */
	public Date getCheckInDate() {
		return checkInDate;
	}

	/**
	 * Sets the check-in date with validation.
	 * 
	 * @param checkInDate the check-in date to set (must not be null)
	 * @throws InvalidBookingException if checkInDate is null or after checkOutDate
	 */

	public void setCheckInDate(Date checkInDate) throws InvalidBookingException {
		if (checkInDate == null) {
			throw new InvalidBookingException("Check-in date cannot be null.");
		}
		if (this.checkOutDate != null && !checkInDate.before(this.checkOutDate)) {
			throw new InvalidBookingException("Check-in must be before current check-out date.");
		}
		this.checkInDate = checkInDate;
	}

	/**
	 * Gets the check-out date.
	 * 
	 * @return the check-out date
	 */
	public Date getCheckOutDate() {
		return checkOutDate;
	}

	/**
	 * Sets the check-out date with validation.
	 * 
	 * @param checkOutDate the check-out date to set (must not be null and must be
	 *                     after check-in)
	 * @throws InvalidBookingException if checkOutDate is null or before/equal to
	 *                                 checkInDate
	 */

	public void setCheckOutDate(Date checkOutDate) throws InvalidBookingException {
		if (checkOutDate == null) {
			throw new InvalidBookingException("Check-out date cannot be null.");
		}
		if (this.checkInDate != null && !checkOutDate.after(this.checkInDate)) {
			throw new InvalidBookingException("Check-out must be after check-in date.");
		}
		this.checkOutDate = checkOutDate;
	}

	/**
	 * Gets the number of guests.
	 * 
	 * @return the number of guests
	 */
	public int getNumberOfGuests() {
		return numberOfGuests;
	}

	/**
	 * Sets the number of guests with validation.
	 * 
	 * @param numberOfGuests the number of guests (must be positive and within room
	 *                       capacity)
	 * @throws InvalidBookingException       if numberOfGuests is less than or equal
	 *                                       to 0
	 * @throws RoomCapacityExceededException if numberOfGuests exceeds room capacity
	 */
	public void setNumberOfGuests(int numberOfGuests) throws InvalidBookingException, RoomCapacityExceededException {
		if (numberOfGuests <= 0) {
			throw new InvalidBookingException("Number of guests must be positive.");
		}
		if (room != null && !room.isAvailableForGuests(numberOfGuests)) {
			throw new RoomCapacityExceededException("Number of guests exceeds room capacity.");
		}
		this.numberOfGuests = numberOfGuests;
	}

	/**
	 * Gets the associated room.
	 * 
	 * @return the room object
	 */

	public Room getRoom() {
		return room;
	}

	/**
	 * Sets the associated room with validation.
	 * 
	 * @param room the room to set (must not be null)
	 * @throws InvalidBookingException if room is null
	 */

	public void setRoom(Room room) throws InvalidBookingException {
		if (room == null) {
			throw new InvalidBookingException("Room cannot be null.");
		}
		this.room = room;
	}

	/**
	 * Calculates the number of nights between check-in and check-out dates.
	 * 
	 * @return the number of nights
	 */
	public int getNumberOfNights() {
		long diffMillis = checkOutDate.getTime() - checkInDate.getTime();
		long days = java.util.concurrent.TimeUnit.MILLISECONDS.toDays(diffMillis);
		return (int) days;
	}

	/**
	 * Calculates the total cost of the booking. Uses the associated room's
	 * calculateCost method.
	 * 
	 * @return the total cost rounded to 2 decimal places
	 */
	public double getTotalCost() {
		return round2(room.calculateCost(getNumberOfNights()));
	}

	/**
	 * Calculates the total cost of the booking including tax.
	 * 
	 * @param taxRate the tax rate as a percentage (e.g., 13.0 for 13%)
	 * @return the total cost including tax, rounded to 2 decimal places
	 */
	public double getTotalCostWithTax(double taxRate) {
		return round2(room.calculateCostWithTax(getNumberOfNights(), taxRate));
	}

	/**
	 * Calculates the cost per guest for the booking.
	 * 
	 * @return the cost per guest rounded to 2 decimal places
	 */
	public double getCostPerGuest() {
		return round2(getTotalCost() / numberOfGuests);
	}

	/**
	 * Calculates the discounted total cost. Uses the associated room's
	 * applyDiscount method.
	 * 
	 * @param discountPercent the discount percentage (e.g., 10.0 for 10% off)
	 * @return the discounted total cost rounded to 2 decimal places
	 */
	public double getDiscountedTotal(double discountPercent) {
		return round2(room.applyDiscount(getTotalCost(), discountPercent));
	}

	/**
	 * Checks if the check-in date falls on a weekend (Friday or Saturday).
	 * 
	 * @return true if check-in is on Friday or Saturday, false otherwise
	 */
	public boolean isWeekendCheckIn() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(checkInDate);
		int day = cal.get(Calendar.DAY_OF_WEEK);
		return day == Calendar.FRIDAY || day == Calendar.SATURDAY;
	}

	/**
	 * Returns a string representation of the booking.
	 * 
	 * @return a formatted string containing booking details
	 */
	@Override
	public String toString() {
		return String.format("Booking %s - Guest: %s, %d guest(s), %d night(s), Total: $%.2f\n%s", bookingID, guestName,
				numberOfGuests, getNumberOfNights(), getTotalCost(), room.toString());
	}
	
	private double round2(double value) {
        return Math.round(value * 100.0) / 100.0;
    }
}