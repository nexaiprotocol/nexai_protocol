package com.nexaiprotocol.world.storage.persistence;


import com.nexaiprotocol.world.entity.ChatRecord;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Chat data persistent interface of the data store
 *
 * @since 1.0
 */

@Repository
public interface ChatRecordRepository extends MongoRepository<ChatRecord, String> {

}
