package org.votusoperandi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.votusoperandi.domain.Vote;

import java.util.*;

public class ElectionResult {
    @JsonProperty
    private Map<Long, ElectionResultItem> items = new HashMap<>();
    @JsonProperty
    private Set<String> users = new HashSet<>();

    private void addItem(Vote vote){
        users.add(vote.getUserName());
        Long propositionId = vote.getSelectedProposition().getId();
        ElectionResultItem result = items.getOrDefault(propositionId, new ElectionResultItem());
        result.majorityVoteResult += vote.getMajorityVote()?1:0;
        result.scoringVoteResult += vote.getScoreVote();
        items.put(propositionId, result);
    }

    public static ElectionResult getResultForVotes(List<Vote> votes) {
        ElectionResult result = new ElectionResult();
        votes.stream().forEach(v -> result.addItem(v));
        return result;
    }
}

class ElectionResultItem {
    @JsonProperty
    int majorityVoteResult;
    @JsonProperty
    int scoringVoteResult;
}
