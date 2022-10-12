package com.wahyu.perwira.learnrestapiv1.service;

import com.wahyu.perwira.learnrestapiv1.entity.Member;
import com.wahyu.perwira.learnrestapiv1.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    public List<Member> getMember() {
        return memberRepository.findAll();
    }

    public Optional<Member> findId(int id) {
        return memberRepository.findById(id);
    }

    public Member getMemberId(int id) {
        return memberRepository.findById(id).get();
    }

    public Member create(Member member) {
        return memberRepository.save(member);
    }

    public Member update(Member member, int id) {
        Member members = memberRepository.findById(id).get();
        members.setFullname(member.getFullname());
        members.setStageName(member.getStageName());
        members.setBirthday(member.getBirthday());
        members.setGroupsId(member.getGroupsId());
        return memberRepository.save(members);
    }

    public void deleteById(int id) {
        memberRepository.deleteById(id);
    }
}