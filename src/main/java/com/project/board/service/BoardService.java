package com.project.board.service;

import com.project.board.entity.Board;
import com.project.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    //글 작성
    public void write(Board board){
        boardRepository.save(board);
    }

    //게시글 리스트 반환
    public List<Board> boardList(){
        return boardRepository.findAll();
    }

    //게시글 상세 반환
    public Board boardView(Long id){
        return boardRepository.findById(id).get();
    }

}
