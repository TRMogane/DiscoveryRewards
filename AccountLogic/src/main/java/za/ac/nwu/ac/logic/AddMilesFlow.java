package za.ac.nwu.ac.logic;

import za.ac.nwu.ac.domain.dto.MemberDto;

public interface AddMilesFlow {
    MemberDto addMiles(String email, Integer amount);
}
