package org.example.quorareactiveapp.models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Document(collection = "tag")
public class Tag extends BaseModel {
    @NotBlank(message= "Tag Name cannot be empty")
    @Size(min = 2,max = 100, message = "Tag Name can be of 2 to 100 characters")
    @Indexed(unique = true)
    private String tagName;
}
