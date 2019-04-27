package com.example.board.board.controller;

import com.example.board.board.dto.BoardDto;
import com.example.board.board.service.BoardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BoardController {

    // 로거 생성
    private Logger log = LoggerFactory.getLogger("board");

    // 서비스 빈(boardService) 연결
    @Autowired
    private BoardService boardService;

    @RequestMapping(value = "/board", method = RequestMethod.GET)
    public ModelAndView openBoardList() throws Exception{
        log.debug("게시물 목록 요청");
        ModelAndView mv = new ModelAndView("/board/boardList");
        List<BoardDto> list = boardService.selectBoardList();
        mv.addObject("list", list);
        return  mv;
    }

    @RequestMapping(value = "/board/write", method = RequestMethod.GET)
    public String openBoardWrite() throws Exception{
        log.debug("게시물 작성 화면 요청");
        return "/board/boardWrite";
    }

    @RequestMapping(value = "/board/write", method = RequestMethod.POST)
    public String insertBoard(BoardDto board) throws Exception{
        log.debug("게시물 작성 요청");
        boardService.insertBoard(board);
        return "redirect:/board";
    }

    @RequestMapping(value = "/board/{boardIdx}", method = RequestMethod.GET)
    public ModelAndView openBoardDetail(@PathVariable("boardIdx") int boardIdx) throws Exception{
        log.debug("게시물 상세 화면 요청");
        ModelAndView mv = new ModelAndView("/board/boardDetail");
        BoardDto board = boardService.selectBoardDetail(boardIdx);
        mv.addObject("board",board);
        return mv;
    }

    @RequestMapping(value = "/board/{boardIdx}", method = RequestMethod.PUT)
    public String updateBoard(BoardDto board) throws Exception{
        log.debug("게시물 수정 요청");
        boardService.updateBoard(board);
        return "redirect:/board";
    }

    @RequestMapping(value = "/board/{boardIdx}", method = RequestMethod.DELETE)
    public String deleteBoard(@PathVariable("boardIdx") int boardIdx) throws Exception{
        log.debug("게시물 삭제 요청");
        boardService.deleteBoard(boardIdx);
        return "redirect:/board";
    }

}
