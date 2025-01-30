package com.nexaiprotocol.protocol.module.storage.persistence.agent;


import com.nexaiprotocol.model.entity.AgentEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Agent persistent interface of the data store
 *
 * @since 1.0
 */


public interface AgentRepository extends MongoRepository<AgentEntity, String> {

}
