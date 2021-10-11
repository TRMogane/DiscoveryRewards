package za.ac.nwu.ac.logic.impl;

import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.MemberDto;
import za.ac.nwu.ac.logic.SubtractMilesFlow;
import za.ac.nwu.ac.translator.MemberTranslator;

import javax.transaction.Transactional;

@Transactional
@Component("subtractMilesFlowName")
public class SubtractMilesFlowImpl implements SubtractMilesFlow {
    private final MemberTranslator memberTranslator;

    public SubtractMilesFlowImpl(MemberTranslator memberTranslator) {
        this.memberTranslator = memberTranslator;
    }

    @Override
    public MemberDto subtractMiles(String email, Integer amount) {
        MemberDto memberDto = memberTranslator.getMemberByEmail(email);
        Integer currentBalance = memberDto.getBalance();
        currentBalance -= amount;
        memberDto.setBalance(currentBalance);
        return memberTranslator.update(memberDto);
    }
}
