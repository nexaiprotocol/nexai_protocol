package com.nexaiprotocol.common.util;

import java.util.regex.Pattern;

/**
 * Utility class for validating common formats such as email and phone numbers.
 *
 * @since 1.0
 */
public class ValidationUtils {

    // Regular expression for validating email addresses
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");

    // Regular expression for validating phone numbers in E.164 format
    private static final Pattern PHONE_PATTERN = Pattern.compile("^\\+[1-9]\\d{1,14}$");

    /**
     * Validates the format of an email address.
     *
     * @param email The email address to validate
     * @return Returns true if the email format is valid, otherwise returns false
     */
    public static boolean isValidEmail(String email) {
        return email != null && EMAIL_PATTERN.matcher(email).matches();
    }

    /**
     * Validates the format of a phone number.
     *
     * @param phone The phone number to validate
     * @return Returns true if the phone number format is valid, otherwise returns false
     */
    public static boolean isValidPhone(String phone) {
        return phone != null && PHONE_PATTERN.matcher(phone).matches();
    }
}
