package za.ac.nwu.ac.web.sb.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.nwu.ac.domain.dto.MemberDto;
import za.ac.nwu.ac.domain.dto.TransactionDto;
import za.ac.nwu.ac.domain.service.GeneralResponse;
import za.ac.nwu.ac.logic.*;

import java.util.List;

@RestController
@RequestMapping("members")
public class TransactionController {

    private final FetchTransactionsFlow fetchTransactionsFlow;

    public TransactionController(FetchTransactionsFlow fetchTransactionsFlow) {
        this.fetchTransactionsFlow = fetchTransactionsFlow;
    }

//    @GetMapping("/all")
//    @ApiOperation(value = "Gets all transactions", notes = "Return all transactions")
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "The Ping was received and echoed", response = GeneralResponse.class),
//            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
//            @ApiResponse(code = 404, message = "Not found", response = GeneralResponse.class),
//            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})
//
//    public ResponseEntity<GeneralResponse<List<TransactionDto>>> getAll() {
//        List<TransactionDto> transactionDto = fetchTransactionsFlow.getAllTransactions();
//        GeneralResponse<List<TransactionDto>> response = new GeneralResponse<>(true, transactionDto);
//        return new ResponseEntity<>(response, HttpStatus.OK);
//    }

    @GetMapping("/memberTransactions/{email}")
    @ApiOperation(value = "Fetch transactions by Member email", notes = "Fetch transactions by email")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "No transactions for member", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})
    public ResponseEntity<GeneralResponse<List<TransactionDto>>> getByEmail(
            @ApiParam(value = "Get transactions by member email",
                    example = "",
                    name = "email",
                    required = true)
            @PathVariable("email") final String email){

        List<TransactionDto> transactionDto = fetchTransactionsFlow.getMemberTransactions(email);
        GeneralResponse<List<TransactionDto>> response = new GeneralResponse<>(true, transactionDto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}