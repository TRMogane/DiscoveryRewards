package za.ac.nwu.ac.logic;

import za.ac.nwu.ac.domain.dto.MemberDto;

public interface SubtractMilesFlow {
    MemberDto subtractMiles(String email, Integer amount);
}
