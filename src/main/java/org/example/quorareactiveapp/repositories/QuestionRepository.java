package org.example.quorareactiveapp.repositories;

import org.example.quorareactiveapp.models.Question;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends ReactiveMongoRepository<Question, String> {

}
