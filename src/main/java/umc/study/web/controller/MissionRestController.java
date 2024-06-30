package umc.study.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.study.apiPayload.ApiResponse;
import umc.study.converter.MissionConverter;
import umc.study.domain.Mission;
import umc.study.service.MissionService;
import umc.study.web.dto.request.MissionRequestDTO;
import umc.study.web.dto.response.MissionResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/")
public class MissionRestController {
    private final MissionService missionService;

    @PostMapping("stores/{storeId}/missions")
    public ApiResponse<MissionResponseDTO.CreateMissionResultDTO> createMission(@PathVariable Long storeId, @RequestBody @Valid MissionRequestDTO.CreateMissionDTO createMissionDTO) {
        Mission mission = missionService.createMission(storeId, createMissionDTO);
        return ApiResponse.onSuccess(MissionConverter.toCreateMissionResultDTO(mission));
    }
}
