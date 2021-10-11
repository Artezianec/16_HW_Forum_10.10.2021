package telran.forum.model;

import java.time.LocalDateTime;
import java.util.Objects;

public class Post implements Comparable<Post> {
    private String author;
    private int postid;
    private String title;
    private String content;
    private LocalDateTime date;
    private int likes;

    public Post(String author, int postid, String title, String content, LocalDateTime date, int likes) {
        this.author = author;
        this.postid = postid;
        this.title = title;
        this.content = content;
        this.date = date;
        this.likes = likes;
    }

    public String getAuthor() {
        return author;
    }

    public int getPostid() {
        return postid;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public int getLikes() {
        return likes;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Post{" +
                "author='" + author + '\'' +
                ", postid=" + postid +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", date=" + date +
                ", likes=" + likes +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return postid == post.postid;
    }

    @Override
    public int hashCode() {
        return Objects.hash(postid);
    }

    public int addLike;

    @Override
    public int compareTo(Post o) {
        int res = date.compareTo(o.date);
        {
            if (res != 0) {
                return res;
            }
        }
        return Integer.compare(postid, o.postid);
    }
}
