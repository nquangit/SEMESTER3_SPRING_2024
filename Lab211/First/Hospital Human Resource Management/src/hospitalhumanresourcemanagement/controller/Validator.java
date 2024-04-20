/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalhumanresourcemanagement.controller;

/**
 *
 * @author ASUS
 */
public class Validator {

    // Phone number must be 
    // Start with 0
    // 9-11 in length
    public static final String VALID_PHONE_NUMBER_REGEX = "^0\\d{8,10}$";
    public static final String MATCH_ALL_EXCEPT_SPACE = ".*";

    // ID must be start with EM
    // and END with 4 digits
    public static final String VALID_ID_REGEX = "^(?i)(em)\\d{4}$";
    // Date format
    // Seperated by - or /
    public static final String VALID_DATE_REGEX = "^\\d{2}/\\d{2}/\\d{4}$";
}
