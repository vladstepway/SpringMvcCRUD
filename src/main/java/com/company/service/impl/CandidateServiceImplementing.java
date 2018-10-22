package com.company.service.impl;

import com.company.dao.CandidateDao;
import com.company.model.Candidate;
import com.company.service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CandidateServiceImplementing implements CandidateService {

    @Autowired
    private CandidateDao candidateDao;

    public Candidate getCandidate(int id) {
        return candidateDao.getCandidate(id);
    }

    public List<Candidate> getAllCandidates() {
        return candidateDao.getAllCandidates();
    }

    @Override
    public int addCandidate(Candidate candidate) {
        return candidateDao.addCandidate(candidate);
    }

    @Override
    public int updateCandidate(Candidate candidate) {
        return candidateDao.updateCandidate(candidate);
    }

    @Override
    public int deleteCandidate(int id) {
        return candidateDao.deleteCandidate(id);
    }

    public CandidateDao getCandidateDao() {
        return candidateDao;
    }

}
