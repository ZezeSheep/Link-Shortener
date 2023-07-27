package com.zezesheep.LinkShorter.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
		this.linkShorter = linkShorter;
    }

    @GetMapping("/{indexBase62}")
	public ResponseEntity<LinkDTO> getMovieById(@PathVariable(value="indexBase62") String indexBase62) throws Exception{
		Optional<LinkDTO> otionalLink = linkShorter.getLinkByIdBase62(indexBase62);
		if(otionalLink.isPresent()){
			return new ResponseEntity<LinkDTO>(otionalLink.get(), HttpStatus.OK);
		}
		else{
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("")
	public ResponseEntity<LinkDTO> getShorterLink(@RequestBody RequestDTO newLongUrl) {
		LinkDTO linkDTO = linkShorter.generateShorterLink(newLongUrl);
		return new ResponseEntity<LinkDTO>(linkDTO, HttpStatus.CREATED);
	}
    
}
