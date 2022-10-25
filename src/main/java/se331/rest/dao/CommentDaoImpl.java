package se331.rest.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import se331.rest.entity.Comment;
import se331.rest.repository.CommentRepository;

@Repository
public class CommentDaoImpl implements CommentDao{
    @Autowired
    CommentRepository commentRepository;
    @Override
    public Integer getCommentSize() {
        return Math.toIntExact(commentRepository.count());
    }

    @Override
    public Comment getComment(Long id) {
        return commentRepository.findById(id).orElse(null);
    }

    @Override
    public Comment save(Comment comment) {
        return commentRepository.save(comment);
    }
}
