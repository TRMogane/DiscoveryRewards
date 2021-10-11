package za.ac.nwu.ac.translator.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.MemberDto;
import za.ac.nwu.ac.domain.persistence.Member;
import za.ac.nwu.ac.repo.persistence.MemberRepository;
import za.ac.nwu.ac.translator.MemberTranslator;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Component
public class MemberTranslatorImpl implements MemberTranslator {

    private final MemberRepository memberRepository;

    @Autowired
    public MemberTranslatorImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public List<MemberDto> getAllMembers() {
        try{
            List<MemberDto> memberDto = new ArrayList<>();
            for(Member member : memberRepository.findAll()){
                memberDto.add(new MemberDto(member));
            }
            return memberDto;
        }catch (Exception e){
            throw new RuntimeException("No Members found", e);
        }
    }

    @Override
    public MemberDto getMemberByEmail(String email) {
        try{
           Member member = memberRepository.getMemberByEmail(email);
            return new MemberDto(member);
        }catch (Exception e){
            throw new RuntimeException("Unable to get Member");
        }
    }

    @Override
    public MemberDto create(MemberDto memberDto) {
         try{
            Member member = memberRepository.save(memberDto.getMember());
            return new MemberDto(member);
        }catch (Exception e){
            throw new RuntimeException("Unable to create a Member", e);
        }
    }

    @Override
    public MemberDto update(MemberDto memberDto) {
        try{
            Member member = memberRepository.save(memberDto.getMember());
            return new MemberDto(member);
        }catch (Exception e){
            throw new RuntimeException("Unable to create a Member", e);
        }
    }
}
