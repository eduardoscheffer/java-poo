package enumsComposicoes.exercicioPost.entities;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Post {
    private final static DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    private LocalDateTime moment;
    private String title;
    private String content;
    private Integer likes;

    List<Comment> comments = new ArrayList<>();

    public Post() {
    }

    public Post(LocalDateTime moment, String title, String content, Integer likes) {
        this.moment = moment;
        this.title = title;
        this.content = content;
        this.likes = likes;
    }

    public void addComment(Comment comment) {
        comments.add(comment);
    }

    public void removeComment(Comment comment) {
        comments.remove(comment);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(title).append("\n");
        sb.append(likes).append(" Likes - ").append(fmt.format(moment)).append("\n");
        sb.append(content).append("\n");
        sb.append("Comments: " + "\n");
        for (Comment c : comments) {
            sb.append(c.getText() + "\n");
        }
        //sb.append("\n");
        return sb.toString();
    }
}
