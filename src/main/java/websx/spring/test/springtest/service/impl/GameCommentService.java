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

    @Override
    public GameComment findByIdGameComment(Long id) {
        return iGameCommentMapper.findByIdGameComment(id);
    }

    @Override
    public List<GameComment> findByGidGameComment(Long gid) {
        return iGameCommentMapper.findByGidGameComment(gid);
    }

    @Override
    public List<GameComment> findByAidGameComment(Long aid) {
        return iGameCommentMapper.findByAidGameComment(aid);
    }

    @Override
    public GameComment findByAidGidGameComment(Long aid, Long gid) {
        return iGameCommentMapper.findByAidGidGameComment(aid,gid);
    }

    @Override
    public GameComment saveGameComment(GameComment gameComment) {
        iGameCommentMapper.saveGameComment(gameComment);
        gameComment=iGameCommentMapper.findAllGameComment().get(iGameCommentMapper.findAllGameComment().size()-1);
        return gameComment;
    }

    @Override
    public GameComment updateGameComment(GameComment gameComment) {
        iGameCommentMapper.updateGameComment(gameComment);
        gameComment=iGameCommentMapper.findByIdGameComment(gameComment.getId());
        return gameComment;
    }

    @Override
    public GameComment deleteGameComment(Long id) {
        GameComment gameComment=iGameCommentMapper.findByIdGameComment(id);
        iGameCommentMapper.deleteGameComment(id);
        return gameComment;
    }
}
