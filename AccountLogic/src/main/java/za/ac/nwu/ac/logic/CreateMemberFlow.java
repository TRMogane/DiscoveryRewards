package za.ac.nwu.ac.logic;

import za.ac.nwu.ac.domain.dto.MemberDto;

public interface CreateMemberFlow {
    MemberDto create(MemberDto memberDto);
}
