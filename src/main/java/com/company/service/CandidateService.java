package com.company.service;

import com.company.model.Candidate;

import java.util.List;

public interface CandidateService {

    Candidate getCandidate(int id);

    List<Candidate> getAllCandidates();
    List<String> getAllCandidatesID();

     List<String> getListOfStates();

    int addCandidate(Candidate candidate);

    int updateCandidate(Candidate candidate);

    int deleteCandidate(int id);
}
