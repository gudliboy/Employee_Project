package com.example.testApp.Services;

import com.example.testApp.Entity.Test;
import com.example.testApp.Respository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TestService {

//    @Autowired
    private final TestRepository testRepository;

    public TestService(TestRepository testRepository){
        this.testRepository = testRepository;
    }

    public Test saveTest(Test test){
        return testRepository.save(test);
    }

    public List<Test> getAllTests(){
        return testRepository.findAll();
    }

    public Test updateTest(Long testId, Test updateTest){
        return testRepository.findByTestId(testId).map(test -> {
            test.setName(updateTest.getName());
            test.setEmail(updateTest.getEmail());
            return testRepository.save(test);
        }).orElseThrow(()->new RuntimeException("test case is not present of TestId "+testId));
    }
}
