package za.ac.nwu.ac.logic.impl;

import za.ac.nwu.ac.domain.dto.MemberDto;
import za.ac.nwu.ac.logic.SubtractMilesFlow;
import za.ac.nwu.ac.translator.MemberTranslator;

public class SubtractMilesFlowImpl implements SubtractMilesFlow {
    private final MemberTranslator memberTranslator;

    public SubtractMilesFlowImpl(MemberTranslator memberTranslator) {
        this.memberTranslator = memberTranslator;
    }

    @Override
    public MemberDto subtractMiles(Integer miles) {
        return memberTranslator.update(-miles);
    }
}
