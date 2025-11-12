package org.example.quorareactiveapp.services;

import org.example.quorareactiveapp.Adapter.QuestionAdapter;
import org.example.quorareactiveapp.DTO.QuestionRequestDTO;
import org.example.quorareactiveapp.DTO.QuestionResponseDTO;
import org.example.quorareactiveapp.models.Question;
import org.example.quorareactiveapp.models.Tag;
import org.example.quorareactiveapp.repositories.QuestionRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class QuestionService implements IQuestionService{

    private QuestionRepository questionRepository;

    private TagService tagService;

    public QuestionService(QuestionRepository _questionRepository , TagService _tagService) {
        this.questionRepository = _questionRepository;
        this.tagService = _tagService;
    }

    @Override
    public Mono<QuestionResponseDTO> createQuestion(QuestionRequestDTO questionRequestDTO){
        List<String> tagsToBeAdded = questionRequestDTO.getTags();
        Mono<List<Tag>> Tags = tagService.findOrCreateTags(tagsToBeAdded);

        return Tags.flatMap(tagList -> {
            Question newQuestion = QuestionAdapter.QuestionFromRequestDTO(questionRequestDTO, tagList);

            return questionRepository.save(newQuestion)
                    .map(savedQuestion -> QuestionAdapter.responseFromQuestion(savedQuestion, tagList))
                    .doOnSuccess(response -> System.out.println("Question created successfully " + response))
                    .doOnError(error -> System.out.println("Error creating question " + error));
        });
    }
}
