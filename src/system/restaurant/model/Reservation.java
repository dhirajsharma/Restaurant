package system.restaurant.model;

import java.sql.Time;
import java.sql.Date;

public class Reservation {
	private int reservation_id;
	private int customer_id;
	private int reservation_party_size;
	private String reservation_occasion;
	private Date reservation_start_date;
	private Date reservation_end_date;
	private Time reservation_start_time;
	private Time reservation_end_time;
	private String reservation_additional_details;
	private String reservation_bookedBy;
	private String customer_firstname;
	private String customer_lastname;
	private long customer_phone;
	private String customer_email;
	private String customer_streetAddress;
	private String customer_suiteAddress;
	private String customer_city;
	private String customer_state;
	private int customer_zip; 
	private String confirmation_code;
	private String reservation_status;
	private int table_number;
	
	/**
	 * @return the reservation_id
	 */
	public int getReservation_id() {
		return reservation_id;
	}
	/**
	 * @param reservation_id the reservation_id to set
	 */
	public void setReservation_id(int reservation_id) {
		this.reservation_id = reservation_id;
	}
	/**
	 * @return the customer_id
	 */
	public int getCustomer_id() {
		return customer_id;
	}
	/**
	 * @param customer_id the customer_id to set
	 */
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	/**
	 * @return the reservation_party_size
	 */
	public int getReservation_party_size() {
		return reservation_party_size;
	}
	/**
	 * @param reservation_party_size the reservation_party_size to set
	 */
	public void setReservation_party_size(int reservation_party_size) {
		this.reservation_party_size = reservation_party_size;
	}
	/**
	 * @return the reservation_occasion
	 */
	public String getReservation_occasion() {
		return reservation_occasion;
	}
	/**
	 * @param reservation_occasion the reservation_occasion to set
	 */
	public void setReservation_occasion(String reservation_occasion) {
		this.reservation_occasion = reservation_occasion;
	}
	/**
	 * @return the reservation_start_date
	 */
	public Date getReservation_start_date() {
		return reservation_start_date;
	}
	/**
	 * @param reservation_start_date the reservation_start_date to set
	 */
	public void setReservation_start_date(Date reservation_start_date) {
		this.reservation_start_date = reservation_start_date;
	}
	/**
	 * @return the reservation_end_date
	 */
	public Date getReservation_end_date() {
		return reservation_end_date;
	}
	/**
	 * @param reservation_end_date the reservation_end_date to set
	 */
	public void setReservation_end_date(Date reservation_end_date) {
		this.reservation_end_date = reservation_end_date;
	}
	/**
	 * @return the reservation_start_time
	 */
	public Time getReservation_start_time() {
		return reservation_start_time;
	}
	/**
	 * @param reservation_start_time the reservation_start_time to set
	 */
	public void setReservation_start_time(Time reservation_start_time) {
		this.reservation_start_time = reservation_start_time;
	}
	/**
	 * @return the reservation_end_time
	 */
	public Time getReservation_end_time() {
		return reservation_end_time;
	}
	/**
	 * @param reservation_end_time the reservation_end_time to set
	 */
	public void setReservation_end_time(Time reservation_end_time) {
		this.reservation_end_time = reservation_end_time;
	}
	/**
	 * @return the reservation_additional_details
	 */
	public String getReservation_additional_details() {
		return reservation_additional_details;
	}
	/**
	 * @param reservation_additional_details the reservation_additional_details to set
	 */
	public void setReservation_additional_details(String reservation_additional_details) {
		this.reservation_additional_details = reservation_additional_details;
	}
	/**
	 * @return the reservation_bookedBy
	 */
	public String getReservation_bookedBy() {
		return reservation_bookedBy;
	}
	/**
	 * @param reservation_bookedBy the reservation_bookedBy to set
	 */
	public void setReservation_bookedBy(String reservation_bookedBy) {
		this.reservation_bookedBy = reservation_bookedBy;
	}
	/**
	 * @return the customer_firstname
	 */
	public String getCustomer_firstname() {
		return customer_firstname;
	}
	/**
	 * @param customer_firstname the customer_firstname to set
	 */
	public void setCustomer_firstname(String customer_firstname) {
		this.customer_firstname = customer_firstname;
	}
	/**
	 * @return the customer_lastname
	 */
	public String getCustomer_lastname() {
		return customer_lastname;
	}
	/**
	 * @param customer_lastname the customer_lastname to set
	 */
	public void setCustomer_lastname(String customer_lastname) {
		this.customer_lastname = customer_lastname;
	}
	/**
	 * @return the customer_phone
	 */
	public long getCustomer_phone() {
		return customer_phone;
	}
	/**
	 * @param customer_phone the customer_phone to set
	 */
	public void setCustomer_phone(long customer_phone) {
		this.customer_phone = customer_phone;
	}
	/**
	 * @return the customer_email
	 */
	public String getCustomer_email() {
		return customer_email;
	}
	/**
	 * @param customer_email the customer_email to set
	 */
	public void setCustomer_email(String customer_email) {
		this.customer_email = customer_email;
	}
	/**
	 * @return the customer_streetAddress
	 */
	public String getCustomer_streetAddress() {
		return customer_streetAddress;
	}
	/**
	 * @param customer_streetAddress the customer_streetAddress to set
	 */
	public void setCustomer_streetAddress(String customer_streetAddress) {
		this.customer_streetAddress = customer_streetAddress;
	}
	/**
	 * @return the customer_suiteAddress
	 */
	public String getCustomer_suiteAddress() {
		return customer_suiteAddress;
	}
	/**
	 * @param customer_suiteAddress the customer_suiteAddress to set
	 */
	public void setCustomer_suiteAddress(String customer_suiteAddress) {
		this.customer_suiteAddress = customer_suiteAddress;
	}
	/**
	 * @return the customer_city
	 */
	public String getCustomer_city() {
		return customer_city;
	}
	/**
	 * @param customer_city the customer_city to set
	 */
	public void setCustomer_city(String customer_city) {
		this.customer_city = customer_city;
	}
	/**
	 * @return the customer_state
	 */
	public String getCustomer_state() {
		return customer_state;
	}
	/**
	 * @param customer_state the customer_state to set
	 */
	public void setCustomer_state(String customer_state) {
		this.customer_state = customer_state;
	}
	/**
	 * @return the customer_zip
	 */
	public int getCustomer_zip() {
		return customer_zip;
	}
	/**
	 * @param customer_zip the customer_zip to set
	 */
	public void setCustomer_zip(int customer_zip) {
		this.customer_zip = customer_zip;
	}
	/**
	 * @return the confirmation_code
	 */
	public String getConfirmation_code() {
		return confirmation_code;
	}
	/**
	 * @param confirmation_code the confirmation_code to set
	 */
	public void setConfirmation_code(String confirmation_code) {
		this.confirmation_code = confirmation_code;
	}
	/**
	 * @return the reservation_status
	 */
	public String getReservation_status() {
		return reservation_status;
	}
	/**
	 * @param reservation_status the reservation_status to set
	 */
	public void setReservation_status(String reservation_status) {
		this.reservation_status = reservation_status;
	}
	/**
	 * @return the table_number
	 */
	public int getTable_number() {
		return table_number;
	}
	/**
	 * @param table_number the table_number to set
	 */
	public void setTable_number(int table_number) {
		this.table_number = table_number;
	}	
}
