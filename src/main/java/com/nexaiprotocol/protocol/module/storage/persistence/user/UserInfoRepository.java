package com.nexaiprotocol.protocol.module.storage.persistence.user;


import com.nexaiprotocol.model.entity.UserInfoEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Repository interface for managing {@link UserInfoEntity} entities in MongoDB.
 * This interface extends {@link MongoRepository} to provide CRUD operations
 * and custom query methods for user information.
 *
 * @since 1.0
 */
public interface UserInfoRepository extends MongoRepository<UserInfoEntity, String> {

    /**
     * Finds a user by their email address.
     * This method is useful for Web2 authentication scenarios.
     *
     * @param email The email address associated with the user.
     * @return The {@link UserInfoEntity} object matching the provided email, or null if no match is found.
     */
    UserInfoEntity findUserInfoByEmail(String email);

    /**
     * Finds a user by their wallet address.
     * This method is useful for Web3 authentication scenarios, where users are identified by their blockchain wallet address.
     *
     * @param address The wallet address associated with the user.
     * @return The {@link UserInfoEntity} object matching the provided wallet address, or null if no match is found.
     */
    UserInfoEntity findUserInfoByWalletAddress(String address);

    /**
     * Checks if a user with the given email already exists in the database.
     * This method is typically used during user registration to ensure email uniqueness.
     *
     * @param email The email address to check.
     * @return True if a user with the specified email exists, false otherwise.
     */
    boolean existsByEmail(String email);

    /**
     * Checks if a user with the given wallet address already exists in the database.
     * This method is typically used during user registration to ensure wallet address uniqueness.
     *
     * @param walletAddress The wallet address to check.
     * @return True if a user with the specified wallet address exists, false otherwise.
     */
    boolean existsByWalletAddress(String walletAddress);
}
