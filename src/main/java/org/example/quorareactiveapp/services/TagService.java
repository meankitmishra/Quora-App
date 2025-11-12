package org.example.quorareactiveapp.services;


import org.example.quorareactiveapp.models.Tag;
import org.example.quorareactiveapp.repositories.TagRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class TagService implements ITagService{

    private TagRepository tagRepository;

    public TagService(TagRepository _tagRepository){
        this.tagRepository = _tagRepository;
    }

    @Override
    public Mono<List<Tag>> findOrCreateTags(List<String> tagNames){
        if(tagNames == null || tagNames.isEmpty()){
            return Mono.just(List.of());
        }

        return Flux.fromIterable(tagNames)
                .flatMap(tagName -> tagRepository.findFirstByTagName(tagName)
                                .switchIfEmpty(tagRepository.save(Tag.builder().tagName(tagName).build()))
                        ).collectList();
    }

}
