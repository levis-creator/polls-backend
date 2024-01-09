package com.micosoft.pollsbackend.poll;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="poll")
public class Poll {
    @Id
    private String id;
    private String question;
    private String answerA;
    private String answerB;
    private int voteA=0;
    private int voteB=0;

    public Poll() {
    }

    public Poll(String id, String question, String answerA, String answerB, int voteA, int voteB) {
        this.id = id;
        this.question = question;
        this.answerA = answerA;
        this.answerB = answerB;
        this.voteA = voteA;
        this.voteB = voteB;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswerA() {
        return answerA;
    }

    public void setAnswerA(String answerA) {
        this.answerA = answerA;
    }

    public String getAnswerB() {
        return answerB;
    }

    public void setAnswerB(String answerB) {
        this.answerB = answerB;
    }

    public int getVoteA() {
        return voteA;
    }

    public void setVoteA(int voteA) {
        this.voteA = voteA;
    }

    public int getVoteB() {
        return voteB;
    }

    public void setVoteB(int voteB) {
        this.voteB = voteB;
    }
}
