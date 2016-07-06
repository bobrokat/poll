package com.fujitsu.fs.javalab.poll.webapp.model;

/**
 * Created by Ekaterina on 02.05.2016.
 */
public class PollChoice {
    private Long id;
    private String choice_text;
    private int votes;
    private  Long poll_id;

    public String getChoice_text() {
        return choice_text;
    }

    public void setChoice_text(String choice_text) {
        this.choice_text = choice_text;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPoll_id() {
        return poll_id;
    }

    public void setPoll_id(Long poll_id) {
        this.poll_id = poll_id;
    }

    public int getVotes() {
        return votes;
    }

    public void setVotes(int votes) {
        this.votes = votes;
    }
}
