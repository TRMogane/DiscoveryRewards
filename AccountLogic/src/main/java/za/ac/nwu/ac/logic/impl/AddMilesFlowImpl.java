package za.ac.nwu.ac.logic.impl;

import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.MemberDto;
import za.ac.nwu.ac.logic.AddMilesFlow;
import za.ac.nwu.ac.translator.MemberTranslator;

import javax.transaction.Transactional;

@Transactional
@Component("addMilesFlowName")
public class AddMilesFlowImpl implements AddMilesFlow {

    private final MemberTranslator memberTranslator;

    public AddMilesFlowImpl(MemberTranslator memberTranslator) {
        this.memberTranslator = memberTranslator;
    }

    @Override
    public MemberDto addMiles(String email, Integer amount) {
        MemberDto memberDto = memberTranslator.getMemberByEmail(email);
        Integer currentBalance = memberDto.getBalance();
        currentBalance += amount;
        memberDto.setBalance(currentBalance);
        return memberTranslator.update(memberDto);
    }
}
