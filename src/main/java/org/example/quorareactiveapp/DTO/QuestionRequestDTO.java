package org.example.quorareactiveapp.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QuestionRequestDTO {
    @NotBlank(message = "The title can not be empty")
    @Size(min = 3, max = 100 , message = "The title should be of range 3 to 100 characters")
    private String title;

    @NotBlank(message="The content can not be empty")
    @Size(min = 10,max = 1000, message = "The Question content should be of range 10 to 1000 characters")
    private String content;

    private List<String> tags;

}
