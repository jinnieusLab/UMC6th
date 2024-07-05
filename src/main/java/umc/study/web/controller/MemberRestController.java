package umc.study.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.study.apiPayload.ApiResponse;
import umc.study.converter.MemberConverter;
import umc.study.converter.MemberMissionConverter;
import umc.study.domain.Member;
import umc.study.domain.mapping.MemberMission;
import umc.study.service.impl.member.MemberCommandService;
import umc.study.validation.annotation.ChallengeMission;
import umc.study.web.dto.request.MemberRequestDTO;
import umc.study.web.dto.response.MemberMissionResponseDTO;
import umc.study.web.dto.response.MemberResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberRestController {

    private final MemberCommandService memberCommandService;

    @PostMapping("/")
    public ApiResponse<MemberResponseDTO.JoinResultDTO> join(@RequestBody @Valid MemberRequestDTO.JoinDto request) {
        Member member = memberCommandService.joinMember(request);
        return ApiResponse.onSuccess(MemberConverter.toJoinResultDTO(member));
    }

    @Operation(summary = "멤버 미션 도전 API",description = "멤버가 미션에 도전하는 API입니다.")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 미션 도전 중으로 설정 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "MEMBER_MISSION403", description = "이미 도전 중인 미션입니다.",content = @Content(schema = @Schema(implementation = ApiResponse.class)))
    })
    @Parameters({
            @Parameter(name = "missionId", description = "미션의 id가 path variable입니다."),
    })
    @PostMapping("/missions/{missionId}")
    public ApiResponse<MemberMissionResponseDTO.AddMemberMissionResultDTO> addMemberMission(@ChallengeMission @PathVariable(name = "missionId") Long missionId) {
        System.out.println("Received request for missionId: " + missionId); // 디버깅 라인 추가
        MemberMission memberMission = memberCommandService.addMemberMission(missionId);
        return ApiResponse.onSuccess(MemberMissionConverter.toAddMemberMissionDTO(memberMission));
    }
}
