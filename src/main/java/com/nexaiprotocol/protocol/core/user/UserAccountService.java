package com.nexaiprotocol.protocol.core.user;


import com.nexaiprotocol.common.exception.AuthenticationException;
import com.nexaiprotocol.common.exception.DataAccessException;
import com.nexaiprotocol.model.entity.UserInfoEntity;
import com.nexaiprotocol.model.vo.LoginVo;
import com.nexaiprotocol.model.vo.SignupVo;
import com.nexaiprotocol.model.vo.UserInfoVo;
import org.springframework.data.domain.Page;

import java.util.Optional;

/**
 * Service interface for managing user-related operations such as login, signup, and user retrieval.
 * This interface defines methods for interacting with user data in both Web2 and Web3 contexts.
 *
 * @since 1.0
 */
public interface UserAccountService {

    /**
     * Authenticates a user based on the provided login credentials.
     *
     * @param loginVo The login credentials containing information such as username/email and password.
     * @return The authenticated user's information as a {@link UserInfoEntity} object.
     */
    UserInfoEntity login(LoginVo loginVo) throws AuthenticationException;

    /**
     * Registers a new user with the provided signup information.
     *
     * @param signupVo The signup information containing details such as username, email, password, and wallet address.
     * @return The newly created user's information as a {@link UserInfoEntity} object.
     */
    UserInfoEntity signup(SignupVo signupVo) throws DataAccessException;

    /**
     * Retrieves a user's information by their unique user ID.
     *
     * @param userId The unique identifier of the user.
     * @return The user's information as a {@link UserInfoEntity} object, or null if no user is found.
     */
    Optional<UserInfoEntity> findById(String userId);


    /**
     * Retrieves a user's information by their email address.
     *
     * @param email The email address of the user.
     * @return An {@link Optional} containing the user's information as a {@link UserInfoEntity} object
     * if found, or an empty {@link Optional} if no user is found.
     */
    UserInfoEntity findByEmail(String email);

    /**
     * Retrieves a user's information by their blockchain wallet address.
     *
     * @param address The blockchain wallet address associated with the user.
     * @return The user's information as a {@link UserInfoEntity} object, or null if no user is found.
     */
    UserInfoEntity findByAddress(String address);

    /**
     * Retrieves a list of all users in the system.
     *
     * @return A list of {@link UserInfoEntity} objects representing all users.
     */
    Page<UserInfoEntity> findAll(int page, int size);

    /**
     * Updates a user's information by their ID.
     *
     * @param userInfo The updated user information.
     * @return The updated {@link UserInfoVo} object.
     */
    UserInfoEntity updateUserInfo(UserInfoVo userInfo);
}
