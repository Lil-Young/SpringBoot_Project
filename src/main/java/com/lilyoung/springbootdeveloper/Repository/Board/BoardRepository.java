package com.lilyoung.springbootdeveloper.Repository.Board;

import com.lilyoung.springbootdeveloper.Entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {

}
