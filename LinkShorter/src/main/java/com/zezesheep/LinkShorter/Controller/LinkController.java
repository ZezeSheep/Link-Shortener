package com.zezesheep.LinkShorter.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zezesheep.LinkShorter.DTO.LinkDTO;
import com.zezesheep.LinkShorter.DTO.RequestDTO;
import com.zezesheep.LinkShorter.Service.LinkShorterService;

@RestController
@RequestMapping("/link")
public class LinkController {

    private LinkShorterService linkShorter;

    @Autowired
    public LinkController(LinkShorterService linkShorter){

    }

    @GetMapping("/{hash}")
	public LinkDTO getMovieById(@PathVariable(value="hash") String hash) throws Exception{
		return linkShorter.getLinkByIdBase62(hash);
	}
	
	@PostMapping("")
	public LinkDTO getShorterLink(@RequestBody RequestDTO newLongUrl) {
		return linkShorter.generateShorterLink(newLongUrl);
	}
    
}
