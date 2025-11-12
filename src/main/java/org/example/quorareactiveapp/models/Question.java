package org.example.quorareactiveapp.models;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "questions")
public class Question extends BaseModel{
    @NotBlank(message= "The Title can not be empty")
    @Size(min = 3, max = 100, message = "Title must be in between 3 to 100 character")
    private String title;

    @NotBlank(message = "the question content can not be empty")
    @Size(min = 10,max =1000,message = "Question must be in between 10 to 1000 character")
    private String content;

    @Indexed
    @Field("tag_name")
    List<String> tags = new ArrayList<>();
}
