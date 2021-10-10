package telran.forum.model;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.function.Predicate;

public class Forum implements IForum {
    private Post[] posts;
    private int size = 0;

    @Override
    public boolean addPost(Post post) {
        if (post == null || getPostbyId(post.getPostid()) != null) {
            return false;
        }
        posts[size++] = post;
        return true;
    }

    @Override
    public boolean removePost(int postid) {
        int index = searchIndex(postid);
        if (index < 0) {
            return false;
        }
        System.arraycopy(posts, index + 1, posts, index, size - index - 1);
        size--;
        return true;
    }

    private int searchIndex(int postid) {
        for (int i = 0; i < size; i++) {
            if (posts[i].getPostid() == postid) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean updatePost(int postid, String newContent) {
        int index = searchIndex(postid);
        if (index == postid) {
            posts[index].setContent(newContent);
        }
        return false;
    }

    @Override
    public Post getPostbyId(int postid) {
        for (int i = 0; i < size; i++) {
            if (posts[i].getPostid() == postid) {
                return posts[i];
            }
        }
        return null;
    }

    @Override
    public Post[] getPostByAuthor(String author) {
        return getPostByPredicate(post -> post.getAuthor() == author);
    }

    @Override
    public Post[] getPostByAuthor(String author, LocalDate dateFrom, LocalDate dateTo) {
        return getPostByPredicate(post -> post.getAuthor() == author && post.getDate().isBefore(dateTo.atStartOfDay()) && post.getDate().isAfter(dateFrom.atStartOfDay()));
    }

    public Forum() {

    }

    private Post[] getPostByPredicate(Predicate<Post> predicate) {
        int count = 0;
        Post[] res = new Post[size];
        for (int i = 0; i < size; i++) {
            if (predicate.test(posts[i])) {
                res[count++] = posts[i];
            }
        }
        return Arrays.copyOf(res, count);
    }
}
