package umc.study.converter;

import umc.study.domain.Mission;
import umc.study.domain.Review;
import umc.study.domain.Store;
import umc.study.web.dto.request.MissionRequestDTO;
import umc.study.web.dto.response.MissionResponseDTO;

import java.util.List;

public class MissionConverter {
    public static Mission toMission(MissionRequestDTO.CreateMissionDTO createMissionDTO, Store store) {
        return Mission.builder()
                .reward(createMissionDTO.getReward())
                .deadline(createMissionDTO.getDeadline())
                .missionSpec(createMissionDTO.getMissionSpec())
                .store(store)
                .build();
    }

    public static MissionResponseDTO.CreateMissionResultDTO toCreateMissionResultDTO(Mission mission) {
        return MissionResponseDTO.CreateMissionResultDTO.builder()
                .missionId(mission.getId())
                .storeId(mission.getStore().getId())
                .build();
    }

    public static MissionResponseDTO.MissionPreviewDTO toMissionPreviewDTO(Mission mission) {
        return MissionResponseDTO.MissionPreviewDTO.builder()
                .missionId(mission.getId())
                .storeId(mission.getStore().getId())
                .reward(mission.getReward())
                .deadline(mission.getDeadline())
                .missionSpec(mission.getMissionSpec())
                .build();
    }

    public static MissionResponseDTO.MissionPreviewListDTO toMissionPreviewListDTO(List<Mission> missionList) {
        List<MissionResponseDTO.MissionPreviewDTO> missionPreviewDTOList = missionList.stream().map(MissionConverter::toMissionPreviewDTO).toList();

        return MissionResponseDTO.MissionPreviewListDTO.builder()
                .missionPreviewDTOList(missionPreviewDTOList)
                .build();
    }
}
