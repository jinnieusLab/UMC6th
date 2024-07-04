package umc.study.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import umc.study.apiPayload.ApiResponse;
import umc.study.converter.MissionConverter;
import umc.study.domain.Mission;
import umc.study.service.impl.mission.MissionQueryService;
import umc.study.service.impl.mission.MissionService;
import umc.study.validation.annotation.CheckPage;
import umc.study.validation.annotation.ExistsStore;
import umc.study.web.dto.request.MissionRequestDTO;
import umc.study.web.dto.response.MissionResponseDTO;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/")
public class MissionRestController {
    private final MissionService missionService;
    private final MissionQueryService missionQueryService;

    @Operation(summary = "특정 가게 미션 등록 API",description = "특정 가게에 미션을 등록하는 API입니다.")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 가게 미션 등록 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "STORE4001", description = "가게를 찾을 수 없습니다.",content = @Content(schema = @Schema(implementation = ApiResponse.class)))
    })
    @Parameters({
            @Parameter(name = "storeId", description = "가게의 아이디, path variable 입니다."),
    })
    @PostMapping("stores/{storeId}/missions")
    public ApiResponse<MissionResponseDTO.CreateMissionResultDTO> createMission(@PathVariable Long storeId, @RequestBody @Valid MissionRequestDTO.CreateMissionDTO createMissionDTO) {
        Mission mission = missionService.createMission(storeId, createMissionDTO);
        return ApiResponse.onSuccess(MissionConverter.toCreateMissionResultDTO(mission));
    }

    @Operation(summary = "특정 가게의 미션 목록 조회 API",description = "특정 가게의 미션들의 목록을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요.")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 가게 미션 조회 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "STORE4001", description = "가게를 찾을 수 없습니다.",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "MISSION4001", description = "미션을 찾을 수 없습니다.",content = @Content(schema = @Schema(implementation = ApiResponse.class)))
    })
    @Parameters({
            @Parameter(name = "storeId", description = "가게의 아이디, path variable 입니다."),
            @Parameter(name = "page", description = "페이지 번호, 0번이 1 페이지 입니다."),
    })
    @GetMapping("stores/{storeId}/missions")
    public ApiResponse<MissionResponseDTO.MissionPreviewListDTO> readMissionsByStore(@ExistsStore @PathVariable(name = "storeId") Long storeId, @CheckPage @RequestParam(name = "page") Integer page) {
//        List<Mission> missionList = missionService.readMissionsByStore(storeId);
        System.out.println("Received request for storeId: " + storeId + ", page: " + page); // 디버깅 라인 추가
        Page<Mission> missionPage = missionQueryService.getMissionList(storeId, page);
        return ApiResponse.onSuccess(MissionConverter.toMissionPreviewListDTO(missionPage));
    }
}
