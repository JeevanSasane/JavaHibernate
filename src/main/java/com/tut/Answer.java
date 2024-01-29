package com.tut;

import javax.persistence.*;

@Entity
public class Answer {

    @Id
    @Column(name = "answer_id")
    private Long answerId;

    private String answer;

    public Answer(Long answerId, String answer) {
        this.answerId = answerId;
        this.answer = answer;
    }

    public Answer() {
        super();
    }

    public Long getAnswerId() {
        return answerId;
    }

    public void setAnswerId(Long answerId) {
        this.answerId = answerId;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
