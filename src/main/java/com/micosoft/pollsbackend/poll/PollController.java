package com.micosoft.pollsbackend.poll;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/polls")
@CrossOrigin


public class PollController {
    private final PollService pollService;

    @Autowired
    public PollController(PollService pollService) {
        this.pollService = pollService;
    }

    @GetMapping
    public List<Poll> getPolls() {
        return pollService.gettingPolls();
    }

    @GetMapping("{id}")
    public Optional<Poll> getPoll(@PathVariable("id") String id) {
        return pollService.getPoll(id);
    }

    @PostMapping
    public void postPolls(@RequestBody Poll poll) {
        pollService.createPoll(poll);
    }

    @PutMapping("{id}")
    public void updatePoll(@PathVariable("id") String id, @RequestParam(required = false) String question, @RequestParam(required = false) String answerA, @RequestParam(required = false) String answerB, @RequestParam(required = false) String voteA,@RequestParam(required = false) String voteB) {
        pollService.updatePoll(id,question,answerA,answerB,voteA,voteB);
    }

    @DeleteMapping("{id}")
    public void deletingPoll(@PathVariable("id")String id) {
        pollService.deletePoll(id);
    }
}
