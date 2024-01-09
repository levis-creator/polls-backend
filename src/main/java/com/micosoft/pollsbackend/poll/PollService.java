package com.micosoft.pollsbackend.poll;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class PollService {
    private final PollRepository pollRepository;

    @Autowired
    public PollService(PollRepository pollRepository) {
        this.pollRepository = pollRepository;
    }

    public List<Poll> gettingPolls() {
        return pollRepository.findAll();
    }

    public Optional<Poll> getPoll(String id) {
        boolean exist = pollRepository.existsById(id);
        if (exist) {
            Optional<Poll> pollById;
            pollById = pollRepository.findById(id);
            return pollById;
        } else {
            throw new IllegalStateException("Item does not exist");
        }
    }

    public void createPoll(Poll poll) {
        boolean exists = pollRepository.existsById(poll.getId());
        if (poll.getId() == null || exists) {
            throw new IllegalStateException("Id Error");
        }
        pollRepository.save(poll);
    }

    public void deletePoll(String id) {
        boolean exist = pollRepository.existsById(id);
        if (exist) {
            pollRepository.deleteById(id);
        } else {
            throw new IllegalStateException("Item does not exist");
        }
    }

    @Transactional
    public void updatePoll(String id, String question, String answerA, String answerB, String voteA, String voteB) {
        Poll poll = pollRepository.findById(id).orElseThrow(() -> new IllegalStateException("Does not exist"));
        assert poll != null;
        if (question != null && !Objects.equals(poll.getQuestion(), question)) {
            poll.setQuestion(question);
        }
        if (answerA != null) {

            if (!Objects.equals(poll.getAnswerA(), answerA)) {
                poll.setAnswerA(answerA);
            }
        }
        if (answerB !=null) {
            if (!Objects.equals(poll.getAnswerB(), answerB)) {
                poll.setAnswerB(answerB);
            }
        }
        if (voteA != null) {
            int voteAint = Integer.parseInt(voteA);
            if (poll.getVoteA() != voteAint) {
                poll.setVoteA(voteAint);
            }

        }
        if (voteB != null) {
            int voteBint = Integer.parseInt(voteB);
            if (poll.getVoteB() != voteBint) {
                poll.setVoteB(voteBint);
            }
        }
        pollRepository.save(poll);
    }
}
