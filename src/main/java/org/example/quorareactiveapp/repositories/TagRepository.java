package org.example.quorareactiveapp.repositories;

import org.example.quorareactiveapp.models.Tag;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface TagRepository extends ReactiveMongoRepository<Tag, String> {
    Mono<Tag> findFirstByTagName(String tagName);
}
