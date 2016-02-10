package system.restaurant.model;

import java.sql.Date;
import java.sql.Time;

public class RestaurantTiming {
	private Date restaurant_workingDate;
	private Time restaurant_openingTime;
	private Time restaurant_closingTime;
	/**
	 * @return the restaurant_workingDate
	 */
	public Date getRestaurant_workingDate() {
		return restaurant_workingDate;
	}
	/**
	 * @param restaurant_workingDate the restaurant_workingDate to set
	 */
	public void setRestaurant_workingDate(Date restaurant_workingDate) {
		this.restaurant_workingDate = restaurant_workingDate;
	}
	/**
	 * @return the restaurant_openingTime
	 */
	public Time getRestaurant_openingTime() {
		return restaurant_openingTime;
	}
	/**
	 * @param restaurant_openingTime the restaurant_openingTime to set
	 */
	public void setRestaurant_openingTime(Time restaurant_openingTime) {
		this.restaurant_openingTime = restaurant_openingTime;
	}
	/**
	 * @return the restaurant_closingTime
	 */
	public Time getRestaurant_closingTime() {
		return restaurant_closingTime;
	}
	/**
	 * @param restaurant_closingTime the restaurant_closingTime to set
	 */
	public void setRestaurant_closingTime(Time restaurant_closingTime) {
		this.restaurant_closingTime = restaurant_closingTime;
	}

}
