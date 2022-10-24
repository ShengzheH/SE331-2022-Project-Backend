package se331.rest.service;

import se331.rest.entity.Comment;

public interface CommentService {
    Integer getCommentSize();
    Comment getComment(Long id);
    Comment save(Comment comment);
}
