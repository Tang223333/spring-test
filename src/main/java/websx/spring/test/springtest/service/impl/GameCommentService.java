package websx.spring.test.springtest.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import websx.spring.test.springtest.entity.GameComment;
import websx.spring.test.springtest.entity.GameMutual;
import websx.spring.test.springtest.mapper.IGameCommentMapper;
import websx.spring.test.springtest.service.IGameCommentService;
import websx.spring.test.springtest.service.IGameMutualService;

import java.util.List;

@Service
public class GameCommentService implements IGameCommentService {

    @Autowired
    private IGameCommentMapper iGameCommentMapper;

    @Override
    public List<GameComment> findAllGameComment() {
        return iGameCommentMapper.findAllGameComment();
    }
}
