package com.nexaiprotocol.api.v1.web;


import com.nexaiprotocol.common.exception.AuthenticationException;
import com.nexaiprotocol.common.result.ResultCode;
import com.nexaiprotocol.common.result.ResponseResult;
import com.nexaiprotocol.model.entity.UserInfoEntity;
import com.nexaiprotocol.model.vo.*;
import com.nexaiprotocol.protocol.core.user.UserAccountService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Controller for handling account-related operations such as user signup and login.
 *
 * @since 1.0
 */

@Log4j2
@Tag(name = "UserInfo Controller")
@RestController
@RequestMapping("/api/v1/ai/user")
public class UserInfoController {

    private final UserAccountService userAccountService;
    private final Validator validator;

    public UserInfoController(UserAccountService userAccountService) {
        this.userAccountService = userAccountService;
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        this.validator = factory.getValidator();
    }

    /**
     * Handles user signup requests.
     * This method processes the user's signup information, creates a new user account,
     * and returns the result of the operation.
     *
     * @param signupVo The account information provided by the user for signup.
     * @return A {@link ResponseResult} object indicating the success of the operation.
     * If successful, the response contains the newly created user's information.
     * If failed, the response contains an error message.
     */
    @Operation(summary = "Signup", description = "Register a new user account.")
    @PostMapping("/signup")
    public ResponseResult signup(@Valid @RequestBody SignupVo signupVo) {

        // Custom validation method to validate both email and phone number formats.
        if (!signupVo.isValid()) {
            return ResponseResult.error()
                    .code(ResultCode.VALIDATION_ERROR)
                    .msg("Invalid email or phone number format.");
        }

        try {
            // Attempt to create a new user account
            UserInfoEntity userInfoEntity = this.userAccountService.signup(signupVo);

            // If user creation is successful, map the result to a response object
            if (Objects.nonNull(userInfoEntity)) {
                UserInfoVo userInfoVo = new UserInfoVo();
                BeanUtils.copyProperties(userInfoEntity, userInfoVo);
                return ResponseResult.success().data("result", userInfoVo);
            } else {
                // If user creation fails, return an error response
                return ResponseResult.error().msg("Signup failed: Unable to create user account.");
            }
        } catch (Exception e) {
            // Handle unexpected errors and return an appropriate error response
            return ResponseResult.error().msg("Signup failed: " + e.getMessage());
        }
    }

    /**
     * Handles user login requests.
     * This method authenticates the user based on the provided login credentials
     * and returns the result of the operation.
     *
     * @param loginVo The login credentials provided by the user.
     * @return A {@link ResponseResult} object indicating the success of the operation.
     * If successful, the response contains the authenticated user's information.
     * If failed, the response contains an error message.
     */
    @Operation(summary = "Login", description = "Authenticate a user with their login credentials.")
    @PostMapping("/login")
    public ResponseResult login(@RequestBody LoginVo loginVo) {
        try {
            // Authenticate the user based on the provided credentials
            UserInfoEntity userInfoEntity = this.userAccountService.login(loginVo);

            // If authentication is successful, map the result to a response object
            if (Objects.nonNull(userInfoEntity)) {
                UserInfoVo userInfoVo = new UserInfoVo();
                BeanUtils.copyProperties(userInfoEntity, userInfoVo);
                return ResponseResult.success().data("result", userInfoVo);
            } else {
                // If authentication fails, return an error response
                return ResponseResult.error().msg("Login failed: Invalid credentials.");
            }
        } catch (AuthenticationException e) {
            // Handle authentication-specific errors
            return ResponseResult.error().msg("Login failed: " + e.getMessage());
        } catch (Exception e) {
            // Handle unexpected errors and return an appropriate error response
            return ResponseResult.error().msg("Login failed: An unexpected error occurred.");
        }
    }


    @Operation(summary = "Get User Info", description = "Retrieve a user's information by their email address.")
    @PostMapping("/info/{email}")
    public ResponseResult getUserInfo(@PathVariable String email) {
        try {
            UserInfoEntity userInfoEntity = this.userAccountService.findByEmail(email);
            if (Objects.nonNull(userInfoEntity)) {
                //  UserInfoVo userInfoVo = new UserInfoVo();
                // BeanUtils.copyProperties(userInfoEntity, userInfoVo);
                return ResponseResult.success().data("result", userInfoEntity);
            } else {
                return ResponseResult.error().msg("User not found: No user associated with the provided email.");
            }
        } catch (Exception e) {
            return ResponseResult.error().msg("Failed to retrieve user information: An unexpected error occurred.");
        }
    }


    /**
     * Updates a user's information based on the provided data.
     *
     * @param userInfoVo The user information to update.
     * @return A {@link ResponseResult} object containing the updated user information.
     * @throws IllegalArgumentException If the user information is invalid or the user does not exist.
     */
    @Operation(summary = "Update User Info", description = "Update a user's information with the provided data.")
    @PostMapping("/update")
    public ResponseResult updateUserInfo(@RequestBody UserInfoVo userInfoVo) {
        try {
            if (userInfoVo == null || userInfoVo.getEmail() == null || userInfoVo.getWalletAddress() == null) {
                throw new IllegalArgumentException("User email or wallet address cannot be null.");
            }
            UserInfoEntity updatedUserInfoEntity = this.userAccountService.updateUserInfo(userInfoVo);
            // Map the updated user information to a response object
            UserInfoVo responseVo = new UserInfoVo();
            BeanUtils.copyProperties(updatedUserInfoEntity, responseVo);
            return ResponseResult.success().data("result", responseVo);
        } catch (IllegalArgumentException e) {
            return ResponseResult.error().msg(e.getMessage());
        } catch (Exception e) {
            return ResponseResult.error().msg("Failed to update user information: " + e.getMessage());
        }
    }
}
