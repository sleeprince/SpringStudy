package com.spring.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.dto.TempDTO;

@Repository
public class TempDao {

  @Autowired
  private SqlSession session;

  public List<TempDTO> findAll(TempDTO dto) {
    return session.selectList("sql.findAll", dto);
  }

  public TempDTO findOne(TempDTO dto) {
    return session.selectOne("sql.findOne", dto);
  }

  public TempDTO save(TempDTO dto) {
    //transaction(session.insert("sql.save", dto));
    session.insert("sql.save", dto); // autocommit 일경우는 바로 호출
    return dto;
  }

  public TempDTO edit(TempDTO dto) {
    //transaction(session.update("sql.edit", dto));
    session.update("sql.edit", dto); // autocommit 일경우는 바로 호출
    return dto;
  }

  public void accept(TempDTO dto) {
    //transaction(session.update("sql.accept", dto));
    session.update("sql.accept", dto); // autocommit 일경우는 바로 호출
  }

  // 데이터베이스와 트랜잭션 중 입력과 수정 시 커밋과 롤백 처리 할지 결정하는 메소드
  private void transaction(int status) {
    if(status == 1) {
      session.commit();
    } else {
      session.rollback();
    }
  }
}
