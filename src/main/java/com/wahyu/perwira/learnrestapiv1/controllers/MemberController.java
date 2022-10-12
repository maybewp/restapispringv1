package com.wahyu.perwira.learnrestapiv1.controllers;

import com.wahyu.perwira.learnrestapiv1.entity.Member;
import com.wahyu.perwira.learnrestapiv1.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class MemberController {

    @Autowired
    MemberService memberService;

    @GetMapping("/members/test")
    public String hello() {
        return "Hello World";
    }

    @GetMapping("/members")
    public ResponseEntity<Object> getMembers() {
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        List<Member> members = memberService.getMember();
        try {
            map.put("status", 1);
            map.put("message", "Data Found");
            map.put("data", members);
            return new ResponseEntity<>(map, HttpStatus.OK);
        } catch (Exception e) {
            map.put("status", 0);
            map.put("message", "Data Not Found");
            map.put("data", null);
            return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/members/{id}")
    public ResponseEntity<?> getMemberId(@PathVariable("id") int id) {
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        try {
            Member member = memberService.getMemberId(id);
            map.put("status", 1);
            map.put("message", "Data Found");
            map.put("data", member);
            return new ResponseEntity<>(map, HttpStatus.OK);
        } catch (Exception ex) {
            map.put("status", 0);
            map.put("message", ex.getMessage());
            map.put("data", null);
            return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/members")
    public ResponseEntity<?> addMember(@Valid @RequestBody Member member) {
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        try {
            memberService.create(member);
            map.put("status", 1);
            map.put("message", "Insert Successfully");
            map.put("data", null);
            return new ResponseEntity<>(map, HttpStatus.OK);
        } catch (Exception ex) {
            map.put("status", 0);
            map.put("message", ex.getMessage());
            map.put("data", null);
            return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/members/{id}")
    public ResponseEntity updateMember(@PathVariable("id") int id, @RequestBody Member member) {
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        try {
            memberService.update(member, id);
            map.put("status", 1);
            map.put("message", "Update Successfully");
            map.put("data", null);
            return new ResponseEntity<>(map, HttpStatus.OK);
        } catch (Exception ex) {
            map.put("status", 0);
            map.put("message", "Update Unsuccessfully");
            map.put("data", null);
            return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/members/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") int id) {
        Optional<Member> memberId = memberService.findId(id);
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        if (memberId.isPresent()) {
            try {
                memberService.deleteById(id);
                map.put("status", 1);
                map.put("message", "Delete Successfully");
                map.put("data", null);
                return new ResponseEntity<>(map, HttpStatus.OK);
            } catch (Exception ex) {
                map.put("status", 0);
                map.put("message", ex.getMessage());
                map.put("data", null);
                return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
            }
        } else {
            map.put("status", 0);
            map.put("message", "Delete Unsuccessfully");
            map.put("data", null);
            return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
        }
    }
}
