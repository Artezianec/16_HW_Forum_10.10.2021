package telran.forum.model;

import java.time.LocalDate;

public interface IForum {
    boolean addPost(Post post);

    boolean removePost(int postid);

    boolean updatePost(int postid, String newContent);

    Post getPostbyId(int postid);

    Post[] getPostByAuthor(String author);

    Post[] getPostByAuthor(String author, LocalDate dateForm, LocalDate dateTo);

    int size = 0;
}
