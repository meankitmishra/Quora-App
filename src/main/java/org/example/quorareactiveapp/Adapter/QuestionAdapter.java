package org.example.quorareactiveapp.Adapter;

import org.example.quorareactiveapp.DTO.QuestionRequestDTO;
import org.example.quorareactiveapp.DTO.QuestionResponseDTO;
import org.example.quorareactiveapp.models.Question;
import org.example.quorareactiveapp.models.Tag;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class QuestionAdapter {
    public static Question QuestionFromRequestDTO(QuestionRequestDTO requestDTO, List<Tag> tagList) {

        List<String> tagIds = tagList.stream()
                .map(Tag::get_id)
                .collect(Collectors.toList());

        return Question.builder()
                .title(requestDTO.getTitle())
                .content(requestDTO.getContent())
                .tags(tagIds)
                .build();
    }

    public static QuestionResponseDTO responseFromQuestion(Question question,List<Tag> tagList) {

        List<String> tagNames = tagList.stream()
                .map(Tag::getTagName)
                .toList();

        return QuestionResponseDTO.builder()
                .title(question.getTitle())
                .content(question.getContent())
                .tags(tagNames)
                .createdAt(question.getCreatedAt())
                .updatedAt(question.getUpdatedAt())
                .build();
    }

}
