package com.hackerrank.whc.controller;

import com.hackerrank.whc.repository.CoachRepository;

public class CoachController {

    final CoachRepository coachRepository;

    public CoachController(CoachRepository coachRepository) {
        this.coachRepository = coachRepository;
    }
}
