package com.zezesheep.LinkShorter.DTO;

import lombok.Data;

@Data
public class LinkDTO {

    private Long id;

    private String originalUrl;

    private String hash;
    
}
