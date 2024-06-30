package umc.study.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.converter.MissionConverter;
import umc.study.domain.Mission;
import umc.study.repository.MissionRepository;
import umc.study.service.MissionService;
import umc.study.web.dto.request.MissionRequestDTO;

@Service
@RequiredArgsConstructor
@Transactional
public class MissionServiceImpl implements MissionService {
    private final MissionRepository missionRepository;

    @Override
    public Mission createMission(Long storeId, MissionRequestDTO.CreateMissionDTO createMissionDTO) {
        Mission mission = MissionConverter.toMission(createMissionDTO);
        return missionRepository.save(mission);
    }
}
