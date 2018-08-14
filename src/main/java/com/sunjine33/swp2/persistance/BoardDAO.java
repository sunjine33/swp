package com.sunjine33.swp2.persistance;

import java.util.List;

import com.sunjine33.swp2.domain.Board;

public interface BoardDAO {

	public void create(Board board) throws Exception;

	public Board read(Integer bno) throws Exception;

	public void update(Board board) throws Exception;

	public void delete(Integer bno) throws Exception;

	public List<Board> listAll() throws Exception;
}
