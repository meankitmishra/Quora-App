package org.example.quorareactiveapp.services;

import org.example.quorareactiveapp.DTO.QuestionRequestDTO;
import org.example.quorareactiveapp.DTO.QuestionResponseDTO;
import org.example.quorareactiveapp.models.Question;
import reactor.core.publisher.Mono;

public interface IQuestionService {

    public Mono<QuestionResponseDTO> createQuestion(QuestionRequestDTO questionRequestDTO);
}
