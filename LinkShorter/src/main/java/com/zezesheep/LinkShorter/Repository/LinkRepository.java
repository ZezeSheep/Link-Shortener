package com.zezesheep.LinkShorter.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zezesheep.LinkShorter.Entity.Link;

@Repository
public interface LinkRepository extends JpaRepository<Link, Long> {

    Link findByIndexBase62(String indexBase62);   
    
}
