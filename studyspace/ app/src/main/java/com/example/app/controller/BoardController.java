package com.example.app.controller;

import com.example.app.dto.BoardDto;
import com.example.app.dto.FileDto;
import com.example.app.service.BoardService;
import com.example.app.service.FileService;
import com.example.app.vo.BoardVo;
import com.example.app.vo.Criteria;
import com.example.app.vo.PageVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import static com.example.app.vo.Url.*;

@Controller
@RequestMapping(BOARD_URL)
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;
    private final FileService fileService;
    @GetMapping("/list")
    public String showBoardList(Model model,Criteria criteria){
        List<BoardVo> boardList=boardService.findAll(criteria);
        model.addAttribute("boardList", boardList);
        model.addAttribute("pageInfo",new PageVo(criteria,boardService.getTotal()));
        return "board/board";
    }

    @GetMapping("/write")
    public String boardWrite(){
        return "board/boardWrite";
    }

    @PostMapping("/write")
    public RedirectView boardWrite(BoardDto boardDto, HttpServletRequest req, RedirectAttributes redirectAttributes,
                                   @RequestParam("boardFile")List<FileDto> files){
        Long userNumber = (Long)req.getSession().getAttribute("userNumber");
        boardDto.setUserNumber(userNumber);
        boardService.register(boardDto);

        redirectAttributes.addFlashAttribute("boardNumber",boardDto.getBoardNumber());

        if(files!=null){
//            fileService.

        }




        return new RedirectView("/board/list");
    }

    @GetMapping("/view")
    public String boardView(Long boardNumber, Model model){
        model.addAttribute("board", boardService.findBoard(boardNumber));
        return "board/boardView";
    }

    @GetMapping("/modify")
    public String boardModify(Long boardNumber, Model model){
        model.addAttribute("board", boardService.findBoard(boardNumber));
        return "board/boardModify";
    }
    @PostMapping("/modify")
    public RedirectView boardModify(BoardDto boardDto,RedirectAttributes redirectAttributes){
        boardService.modify(boardDto);
        redirectAttributes.addAttribute("boardNumber",boardDto.getBoardNumber());
        return new RedirectView("/board/view");
    }

    @GetMapping("/remove")
    public RedirectView boardRemove(Long boardNumber){
        boardService.remove(boardNumber);
        return new RedirectView("/board/list");
    }
}
