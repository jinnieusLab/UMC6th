package umc.study.service.impl.mission;

import umc.study.domain.Mission;
import umc.study.web.dto.request.MissionRequestDTO;

import java.util.List;

public interface MissionService {
    Mission createMission(Long storeId, MissionRequestDTO.CreateMissionDTO createMissionDTO);

    List<Mission> readMissionsByStore(Long storeId);
}
