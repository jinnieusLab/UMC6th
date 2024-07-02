package umc.study.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.study.apiPayload.ApiResponse;
import umc.study.converter.MemberConverter;
import umc.study.converter.MemberMissionConverter;
import umc.study.domain.Member;
import umc.study.domain.mapping.MemberMission;
import umc.study.service.impl.member.MemberCommandService;
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

    @PostMapping("/missions/{missionId}")
    public ApiResponse<MemberMissionResponseDTO.AddMemberMissionResultDTO> addMemberMission(@PathVariable Long missionId) {
        MemberMission memberMission = memberCommandService.addMemberMission(missionId);
        return ApiResponse.onSuccess(MemberMissionConverter.toAddMemberMissionDTO(memberMission));
    }
}
