package com.example.board;

import com.example.board.board.controller.BoardController;
import com.example.board.board.dto.BoardDto;
import com.example.board.board.service.BoardServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class BoardApplicationTests {

	@Autowired
	private SqlSessionTemplate sqlSession;
	@Autowired
	private BoardController boardController;

	@Test
	public void contextLoads() {
	}

	@Test
	public void sqlSessionTest() throws Exception{
		System.out.println(sqlSession.toString());
	}
	@Test
	public void getBoardList() throws Exception{
		System.out.println(boardController.openBoardList());
	}
}
