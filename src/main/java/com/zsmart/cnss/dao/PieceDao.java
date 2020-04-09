package com.zsmart.cnss.dao;

import com.zsmart.cnss.bean.Piece;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PieceDao extends JpaRepository<Piece, Long> {

    public Piece findByReference(String reference);

    public int deleteByReference(String reference);

}
