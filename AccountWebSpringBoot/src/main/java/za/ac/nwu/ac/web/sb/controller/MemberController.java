package za.ac.nwu.ac.web.sb.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import za.ac.nwu.ac.domain.dto.MemberDto;
import za.ac.nwu.ac.domain.service.GeneralResponse;
import za.ac.nwu.ac.logic.FetchMemberFlow;

import java.util.List;

@RestController
@RequestMapping("members")
public class MemberController {

    private final FetchMemberFlow fetchMemberFlow;

    public MemberController(FetchMemberFlow fetchMemberFlow) {
        this.fetchMemberFlow = fetchMemberFlow;
    }

    @GetMapping("/all")
    @ApiOperation(value = "Gets all Member Accounts", notes = "Return all Members")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The Ping was received and echoed", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})

    public ResponseEntity<GeneralResponse<List<MemberDto>>> getAll(){
        List<MemberDto> memberDto = fetchMemberFlow.getAllMembers();
        GeneralResponse<List<MemberDto>> response = new GeneralResponse<>(true, memberDto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
