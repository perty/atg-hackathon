package se.atg.hackathon.fixtures.canary;


@SuppressWarnings({"unused", "WeakerAccess"})
public class Greeting {
    private Integer id;
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}