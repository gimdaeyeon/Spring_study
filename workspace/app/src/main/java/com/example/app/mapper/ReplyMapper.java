package com.example.app.mapper;

import com.example.app.dto.ReplyDto;
import com.example.app.vo.Criteria;
import com.example.app.vo.ReplyVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ReplyMapper {
//    댓글 등록
    public void insert(ReplyDto replyDto);
    public List<ReplyVo> selectList(Long boardNumber);
    public ReplyVo select(Long replyNumber);
    public void update(ReplyDto replyDto);
    public void delete(Long replyNumber);
    public List<ReplyVo> selectListPage(@Param("criteria") Criteria criteria,@Param("boardNumber") Long boardNumber);
    public int selectTotal(Long boardNumber);
}
