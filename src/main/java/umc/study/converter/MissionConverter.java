package umc.study.converter;

import umc.study.domain.Mission;
import umc.study.domain.Store;
import umc.study.web.dto.request.MissionRequestDTO;
import umc.study.web.dto.response.MissionResponseDTO;

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
                .reward(mission.getReward())
                .deadline(mission.getDeadline())
                .missionSpec(mission.getMissionSpec())
                .build();
    }
}
