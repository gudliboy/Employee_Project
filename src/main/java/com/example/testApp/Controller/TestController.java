package com.example.testApp.Controller;

import com.example.testApp.Entity.Test;
import com.example.testApp.Services.TestService;
import com.example.testApp.dto.request.TestRequestDto;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class TestController {
    private TestService testService;

    public TestController(TestService testService){
        this.testService=testService;
    }

    @PostMapping("/create")
    public ResponseEntity<Test> createTest(@Valid @RequestBody TestRequestDto testRequestDto){
        try{
            Test test=new Test();
            test.setTestId(testRequestDto.getTestId());
            test.setName(testRequestDto.getName());
            test.setEmail(testRequestDto.getEmail());

            Test savedTest=testService.saveTest(test);
            return new ResponseEntity<>(savedTest,HttpStatus.OK);
        }
        catch (RuntimeException e){
            Map<String,String> error=new HashMap<>();
            error.put("error","User creation failed");
            error.put("message",e.getMessage());
            throw new RuntimeException("The testId you are trying to add is already present",e);
        }

    }

    @GetMapping("/print")
    public ResponseEntity<List<Test>> getTest(){
        return ResponseEntity.ok(testService.getAllTests());
    }

    @PutMapping("/update/{testId}")
    public ResponseEntity<Test> updateTest(@PathVariable Long testId, @RequestBody Test test) throws Exception {
//        return ResponseEntity.ok(testService.updateTest(testId,test));
        try{
            Test updateTest=testService.updateTest(testId,test);
            return new ResponseEntity<>(updateTest, HttpStatus.OK);
        }
        catch (RuntimeException e){
            Map<String,String> error=new HashMap<>();
            error.put("error","update failed");
            error.put("message",e.getMessage());
            throw new RuntimeException("id not found",e);
        }
    }
}
