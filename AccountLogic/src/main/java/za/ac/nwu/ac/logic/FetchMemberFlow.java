package za.ac.nwu.ac.logic;

import za.ac.nwu.ac.domain.dto.MemberDto;

import java.util.List;

public interface FetchMemberFlow {
    List<MemberDto> getAllMembers();
    MemberDto getMemberByEmail(String email);
}
