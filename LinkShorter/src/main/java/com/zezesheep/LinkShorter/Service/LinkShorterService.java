package com.zezesheep.LinkShorter.Service;

import org.springframework.stereotype.Service;

import com.zezesheep.LinkShorter.DTO.LinkDTO;
import com.zezesheep.LinkShorter.DTO.RequestDTO;
import com.zezesheep.LinkShorter.Repository.LinkRepository;

@Service
public class LinkShorterService {

    private LinkRepository linkRepository;

    public LinkShorterService(LinkRepository linkRepository){
        this.linkRepository = linkRepository;
    }

    public LinkDTO getLinkByIdBase62(String hash) {
        return null;
    }

    public LinkDTO generateShorterLink(RequestDTO newLongUrl) {
        return null;
    }
    
}
