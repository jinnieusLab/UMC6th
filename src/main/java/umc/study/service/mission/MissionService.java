package umc.study.service.mission;

import umc.study.domain.Mission;
import umc.study.web.dto.request.MissionRequestDTO;

public interface MissionService {
    Mission createMission(Long storeId, MissionRequestDTO.CreateMissionDTO createMissionDTO);
}
