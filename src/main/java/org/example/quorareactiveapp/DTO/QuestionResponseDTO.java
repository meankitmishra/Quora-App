package org.example.quorareactiveapp.DTO;

import lombok.*;
import org.example.quorareactiveapp.models.Tag;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QuestionResponseDTO {

    private String title;


    private String content;

    private List<String> tags;

    private Instant createdAt;

    private Instant updatedAt;
}
