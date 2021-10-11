package telran.forum.tests;

import telran.forum.model.Forum;
import telran.forum.model.IForum;
import telran.forum.model.Post;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

class ForumTest {
    IForum forum;
    Post[] posts;
    LocalDateTime now = LocalDateTime.now();

    @BeforeEach
    void setUp() {
        forum = new Forum();
        posts = new Post[6];
        posts[0] = new Post("Author 1", 1, "Title 1", "Content 1",now,0);
        posts[1] = new Post("Author 2", 2, "Title 2", "Content 2",now,0);
        posts[2] = new Post("Author 3", 3, "Title 3", "Content 3",now,0);
        posts[3] = new Post("Author 4", 4, "Title 4", "Content 4",now,0);
        posts[4] = new Post("Author 5", 5, "Title 5", "Content 5",now,0);
        for (int i = 0; i < posts.length; i++) {
            forum.addPost(posts[i]);
        }
    }

    @Test
    void addPost() {
        assertFalse(forum.addPost(posts[5]));
        assertFalse(forum.addPost(posts[4]));
    }

    @Test
    void removePost() {
        assertTrue(forum.removePost(1));
        assertFalse(forum.removePost(6));
    }

    @Test
    void updatePost() {
        assertTrue(forum.updatePost(1,"New Content"));
    }

    @Test
    void getPostbyId() {
    }

    @Test
    void getPostByAuthor() {
    }

    @Test
    void testGetPostByAuthor() {
    }
}