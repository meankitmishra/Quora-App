package org.example.quorareactiveapp.services;

import org.example.quorareactiveapp.models.Tag;
import reactor.core.publisher.Mono;

import java.util.List;

public interface ITagService {

    public Mono<List<Tag>> findOrCreateTags(List<String> tagNames);

}
