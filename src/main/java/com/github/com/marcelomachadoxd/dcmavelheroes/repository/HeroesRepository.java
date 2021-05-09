package com.github.com.marcelomachadoxd.dcmavelheroes.repository;

import com.github.com.marcelomachadoxd.dcmavelheroes.document.Heroes;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;


@EnableScan
public interface HeroesRepository extends CrudRepository<Heroes, String> {





}
