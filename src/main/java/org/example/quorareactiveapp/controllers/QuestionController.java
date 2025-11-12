package org.example.quorareactiveapp.controllers;

import org.example.quorareactiveapp.DTO.QuestionRequestDTO;
import org.example.quorareactiveapp.DTO.QuestionResponseDTO;
import org.example.quorareactiveapp.services.IQuestionService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/questions")
public class QuestionController {

    private IQuestionService questionService;
    public QuestionController(IQuestionService _questionService) {
        this.questionService = _questionService;
    }

    @PostMapping
    public Mono<QuestionResponseDTO> createQuestion(@RequestBody QuestionRequestDTO questionRequestDTO) {
        return questionService.createQuestion(questionRequestDTO)
                .doOnSuccess(response -> System.out.println("Question created successfully: " + response))
                .doOnError(throwable -> System.out.println("Error creating question: " + throwable));
    }

}
