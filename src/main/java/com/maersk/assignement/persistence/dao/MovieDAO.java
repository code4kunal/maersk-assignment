package com.maersk.assignement.persistence.dao;

import com.maersk.assignement.persistence.entity.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieDAO extends JpaRepository<MovieEntity, Integer> {

}
