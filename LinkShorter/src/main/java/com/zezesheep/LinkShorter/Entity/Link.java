package com.zezesheep.LinkShorter.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Data
@Entity
@Table(name = "Link")
public class Link {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private Long id;

    @Column(name = "ORIGINAL_URL", length = 300)
    private String originalUrl;

    @Column(name = "INDEX_LINK_BASE_62", length = 100)
    private String indexBase62;
    
}
