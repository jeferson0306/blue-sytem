package com.sistemablue.sistemablue.service;

import com.sistemablue.sistemablue.repository.ExameLaboratorialRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ExameService {

    private final ExameLaboratorialRepository exameLaboratorialRepository;


}
