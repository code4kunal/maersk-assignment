package com.maersk.assignement.persistence.dao;

import com.maersk.assignement.constant.MovieRating;
import com.maersk.assignement.persistence.entity.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieDAO extends JpaRepository<MovieEntity, Integer> {

}
