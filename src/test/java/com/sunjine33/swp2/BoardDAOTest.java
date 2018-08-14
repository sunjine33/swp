package com.sunjine33.swp2;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sunjine33.swp2.domain.Board;
import com.sunjine33.swp2.persistance.BoardDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class BoardDAOTest {

	@Inject
	private static BoardDAO dao;
	
	private static Logger logger = LoggerFactory.getLogger(BoardDAOTest.class);
	
	@Test
	public void testCreate() throws Exception {
		Board board = DummyBoard("새글 제목","새글 내용");
		dao.create(board);
	}

	@Test
	public void testRead() throws Exception {
		Board first = dao.read(1);
		logger.info(first != null ? first.toString() : "Board is empty.");
	}

	@Test
	public void testUpdate() throws Exception {
		Board board = DummyBoard("수정 제목","수정 내용");
		dao.update(board);
	}

	@Test
	public void testDelete() throws Exception {
		dao.delete(1);
	}

	@Test
	public void testListAll() throws Exception {
		dao.listAll();
	}
	
	private Board DummyBoard(String title, String content) {
		Board board = new Board();
		board.setTitle(title);
		board.setContent(content);
		return board;
	}
}
