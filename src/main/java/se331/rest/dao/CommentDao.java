package se331.rest.dao;

import se331.rest.entity.Comment;

public interface CommentDao {
    Integer getCommentSize();
    Comment getComment(Long id);
    Comment save(Comment comment);

}
