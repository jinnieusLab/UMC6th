package umc.study.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.study.apiPayload.ApiResponse;
import umc.study.converter.StoreConverter;
import umc.study.domain.Store;
import umc.study.service.impl.store.StoreService;
import umc.study.web.dto.request.StoreRequestDTO;
import umc.study.web.dto.response.StoreResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stores")
public class StoreRestController {
    private final StoreService storeService;

    @Operation(summary = "가게 등록 API",description = "가게를 등록하는 API입니다.")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200", description = "OK, 가게 등록 성공"),
    })
    @PostMapping("/")
    public ApiResponse<StoreResponseDTO.CreateStoreResultDTO> createStore(@RequestBody @Valid StoreRequestDTO.CreateStoreDTO createStoreDTO) {
        Store store = storeService.createStore(createStoreDTO);
        return ApiResponse.onSuccess(StoreConverter.toCreateStoreResultDTO(store));
    }
}
