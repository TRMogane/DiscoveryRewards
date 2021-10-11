package za.ac.nwu.ac.logic.impl;

import za.ac.nwu.ac.domain.dto.MemberDto;
import za.ac.nwu.ac.logic.AddMilesFlow;
import za.ac.nwu.ac.translator.MemberTranslator;

public class AddMilesFlowImpl implements AddMilesFlow {

    private final MemberTranslator memberTranslator;

    public AddMilesFlowImpl(MemberTranslator memberTranslator) {
        this.memberTranslator = memberTranslator;
    }

    @Override
    public MemberDto addMiles(Integer miles) {
        return memberTranslator.update(miles);
    }
}
