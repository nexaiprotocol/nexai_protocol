package com.nexaiprotocol.model.vo;


import com.nexaiprotocol.common.util.ValidationUtils;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * @since 1.0
 */


@Data
@Schema(description = "Signup information for a new user, including Web3 fields.")
public class SignupVo implements Serializable {

    @Schema(description = "Email address for the user", example = "example@example.com", required = true)

    private String email;

    @Schema(description = "Hashed password for security", example = "5f4dcc3b5aa765d61d8327deb882cf99", required = true)
    private String passwordHash;


    /**
     * Custom validation method to validate both email and phone number formats.
     *
     * @return Returns true if both the email and phone number formats are valid, otherwise returns false
     */
    public boolean isValid() {
        //&& ValidationUtils.isValidPhone(this.mobile)
        return ValidationUtils.isValidEmail(this.email);
    }
}
