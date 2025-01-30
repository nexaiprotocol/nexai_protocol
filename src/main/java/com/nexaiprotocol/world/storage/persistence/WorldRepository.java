package com.nexaiprotocol.world.storage.persistence;


import com.nexaiprotocol.world.entity.WorldEnvironment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * World state persistent interface of the data store
 *
 * @since 1.0
 */

@Repository
public interface WorldRepository extends MongoRepository<WorldEnvironment, String> {

}
