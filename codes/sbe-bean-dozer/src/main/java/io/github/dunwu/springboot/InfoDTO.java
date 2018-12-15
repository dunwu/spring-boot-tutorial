package io.github.dunwu.springboot;

public class InfoDTO {
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "InfoDTO{" + "content='" + content + '\'' + '}';
    }
}
