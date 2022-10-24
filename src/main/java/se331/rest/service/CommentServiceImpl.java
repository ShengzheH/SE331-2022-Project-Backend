package se331.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se331.rest.dao.CommentDao;
import se331.rest.entity.Comment;
@Service
public class CommentServiceImpl implements CommentService{
    @Autowired
    CommentDao commentDao;
    @Override
    public Integer getCommentSize() {
        return commentDao.getCommentSize();
    }

    @Override
    public Comment getComment(Long id) {
        return commentDao.getComment(id);
    }

    @Override
    public Comment save(Comment comment) {
        return commentDao.save(comment);
    }
}
