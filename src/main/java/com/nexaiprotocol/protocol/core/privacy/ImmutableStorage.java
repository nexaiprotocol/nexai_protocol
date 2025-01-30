package com.nexaiprotocol.protocol.core.privacy;


import com.nexaiprotocol.protocol.core.privacy.exception.StorageReadException;
import com.nexaiprotocol.protocol.core.privacy.exception.StorageWriteException;
import com.nexaiprotocol.protocol.core.privacy.impl.AuditTrail;

/**
 * <h2>Note: Development version, still incomplete.</h2>
 * Guarantees write-once-read-many (WORM) semantics for critical audit records.
 * Ensures stored data cannot be modified or deleted after commitment.
 *
 * @see AuditTrail
 * @since 1.0
 */
public interface ImmutableStorage {

    /**
     * Persists data with immutability guarantees
     *
     * @param entry Serialized audit record
     * @return Unique content-addressable identifier (e.g., CID, hash)
     * @throws StorageWriteException If write operation violates immutability
     */
    String store(byte[] entry) throws StorageWriteException;

    /**
     * Retrieves stored data by identifier
     *
     * @param id Content identifier from store operation
     * @return Original stored bytes
     * @throws StorageReadException If data cannot be retrieved or verification fails
     */
    byte[] retrieve(String id) throws StorageReadException;
}