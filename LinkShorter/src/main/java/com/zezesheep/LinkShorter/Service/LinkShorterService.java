package com.zezesheep.LinkShorter.Service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.zezesheep.LinkShorter.DTO.LinkDTO;
import com.zezesheep.LinkShorter.DTO.RequestDTO;
import com.zezesheep.LinkShorter.Domain.Base62Converter;
import com.zezesheep.LinkShorter.Entity.Link;
import com.zezesheep.LinkShorter.Repository.LinkRepository;

@Service
public class LinkShorterService {

    private LinkRepository linkRepository;

    private ModelMapper modelMapper;

    public LinkShorterService(LinkRepository linkRepository, ModelMapper modelMapper){
        this.linkRepository = linkRepository;
        this.modelMapper = modelMapper;
    }

    public Optional<LinkDTO> getLinkByIdBase62(String idBase62) {
        Link link = linkRepository.findByIndexBase62(idBase62);
        if(link != null){
            LinkDTO linkDTO = modelMapper.map(link, LinkDTO.class);
            return Optional.of(linkDTO);
        }
        else{
            return Optional.empty();
        }
    }

    public LinkDTO generateShorterLink(RequestDTO newLongUrl) {
        Link newLink = modelMapper.map(newLongUrl, Link.class);
        
        newLink = linkRepository.save(newLink);

        Base62Converter base62Converter = Base62Converter.getInstance();

        String indexBase62OfItemCreated = base62Converter.toBase62(newLink.getId());

        newLink.setIndexBase62(indexBase62OfItemCreated);
        newLink = linkRepository.save(newLink);
        return modelMapper.map(newLink, LinkDTO.class);
    }
    
}
