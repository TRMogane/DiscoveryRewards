package za.ac.nwu.ac.logic.impl;

import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.MemberDto;
import za.ac.nwu.ac.logic.FetchMemberFlow;
import za.ac.nwu.ac.translator.MemberTranslator;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Component
public class FetchMemberFlowImpl implements FetchMemberFlow {

    private final MemberTranslator memberTranslator;

    public FetchMemberFlowImpl(MemberTranslator memberTranslator) {
        this.memberTranslator = memberTranslator;
    }

    @Override
    public List<MemberDto> getAllMembers() {
        return memberTranslator.getAllMembers();
    }

    @Override
    public MemberDto getMemberByEmail(String email) {
        return memberTranslator.getMemberByEmail(email);
    }
}
