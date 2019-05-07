package com.jineric.cassandranestedobj.repository;

import com.jineric.cassandranestedobj.model.Hero;
import org.springframework.data.repository.CrudRepository;

public interface HeroRepository extends CrudRepository<Hero, String> {
}
