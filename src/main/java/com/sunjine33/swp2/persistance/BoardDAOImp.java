package com.sunjine33.swp2.persistance;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.sunjine33.swp2.domain.Board;

@Repository
public class BoardDAOImp implements BoardDAO{
	
	@Inject
	private SqlSession session;
	
	private static final String NS = "com.sunjine33.swp2.persistence.BoardMapper";
	private static final String CREATE = NS + ".create";
	private static final String READ = NS + ".read";
	private static final String UPDATE = NS + ".update";
	private static final String DELETE = NS + ".delete";
	private static final String SELECT_All = NS + ".listAll";
	

	@Override
	public void create(Board board) throws Exception {
		session.insert(CREATE, board);
	}

	@Override
	public Board read(Integer bno) throws Exception {
		return session.selectOne(READ, bno);
	}

	@Override
	public void update(Board board) throws Exception {
		session.update(UPDATE, board);
	}

	@Override
	public void delete(Integer bno) throws Exception {
		session.delete(DELETE, bno);
	}

	@Override
	public List<Board> listAll() throws Exception {
		return session.selectList(SELECT_All);
	}
	
	
}
