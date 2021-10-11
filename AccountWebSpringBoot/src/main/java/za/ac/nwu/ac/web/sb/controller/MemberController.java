package za.ac.nwu.ac.web.sb.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.nwu.ac.domain.dto.MemberDto;
import za.ac.nwu.ac.domain.service.GeneralResponse;
import za.ac.nwu.ac.logic.AddMilesFlow;
import za.ac.nwu.ac.logic.CreateMemberFlow;
import za.ac.nwu.ac.logic.FetchMemberFlow;
import za.ac.nwu.ac.logic.SubtractMilesFlow;

import java.util.List;

@RestController
@RequestMapping("members")
public class MemberController {

    private final FetchMemberFlow fetchMemberFlow;
    private final CreateMemberFlow createMemberFlow;
    private final AddMilesFlow addMilesFlow;
    private final SubtractMilesFlow subtractMilesFlow;

    public MemberController(FetchMemberFlow fetchMemberFlow,
                            @Qualifier("createMemberFlowName") CreateMemberFlow createMemberFlow,
                            @Qualifier("addMilesFlowName") AddMilesFlow addMilesFlow,
                            @Qualifier("subtractMilesFlowName") SubtractMilesFlow subtractMilesFlow) {
        this.fetchMemberFlow = fetchMemberFlow;
        this.createMemberFlow = createMemberFlow;
        this.addMilesFlow = addMilesFlow;
        this.subtractMilesFlow = subtractMilesFlow;
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

    @PostMapping("")
    @ApiOperation(value = "Creates Member Accounts", notes = "Creates new Member in the DB")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Member created", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})
    public ResponseEntity<GeneralResponse<MemberDto>> create(
            @ApiParam(value = "Request body to create New Member Account",
                    required = true)
            @RequestBody MemberDto memberAccountsDto) {
        MemberDto memberAccountsResponse = createMemberFlow.create(memberAccountsDto);
        GeneralResponse<MemberDto> response = new GeneralResponse<>(true, memberAccountsResponse);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/{email}")
    @ApiOperation(value = "Fetch Member by email", notes = "Fetch by email")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Member Found", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})
    public ResponseEntity<GeneralResponse<MemberDto>> getByEmail(
            @ApiParam(value = "Get member by email",
                    example = "",
                    name = "email",
                    required = true)
            @PathVariable("email") final String email){

        MemberDto memberAccountsResponse = fetchMemberFlow.getMemberByEmail(email);

        GeneralResponse<MemberDto> response = new GeneralResponse<>(true, memberAccountsResponse);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    @RequestMapping(value = "/EarnMiles/{email}/{amount}", method = RequestMethod.PUT)
    @ApiOperation(value = "Fetch Member by email and Add Miles", notes = "Fetch and Add")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Member Updated", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})
    public ResponseEntity<GeneralResponse<MemberDto>> earnMiles(
            @ApiParam(value = "Get member by email",
                     example = "",
                     name = "email",
                    required = true)
            @PathVariable("email") final String email,
            @ApiParam(value = "Amount to add to Miles",
                    example = "",
                    name = "amount",
                    required = true)
            @PathVariable("amount") final Integer amount){

        MemberDto memberAccountsResponse = addMilesFlow.addMiles(email, amount);

        GeneralResponse<MemberDto> response = new GeneralResponse<>(true, memberAccountsResponse);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/SpendMiles/{emailAdd}/{amountBal}", method = RequestMethod.PUT)
    @ApiOperation(value = "Fetch Member by email and Subtract Miles", notes = "Fetch and Subtract")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Member Updated", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})
    public ResponseEntity<GeneralResponse<MemberDto>> spendMiles(
            @ApiParam(value = "Get member by email",
                    example = "",
                    name = "emailAdd",
                    required = true)
            @PathVariable("emailAdd") final String emailAdd,
            @ApiParam(value = "Amount to subtract from Miles",
                    example = "",
                    name = "amountBal",
                    required = true)
            @PathVariable("amountBal") final Integer amountBal){

        MemberDto memberAccountsResponse =  subtractMilesFlow.subtractMiles(emailAdd, amountBal);

        GeneralResponse<MemberDto> response = new GeneralResponse<>(true, memberAccountsResponse);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
