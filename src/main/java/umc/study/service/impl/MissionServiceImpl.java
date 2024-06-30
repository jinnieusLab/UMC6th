package umc.study.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.apiPayload.exception.handler.MissionHandler;
import umc.study.converter.MissionConverter;
import umc.study.domain.Mission;
import umc.study.domain.Store;
import umc.study.repository.MissionRepository;
import umc.study.repository.StoreRepository;
import umc.study.service.MissionService;
import umc.study.web.dto.request.MissionRequestDTO;

@Service
@RequiredArgsConstructor
@Transactional
public class MissionServiceImpl implements MissionService {
    private final MissionRepository missionRepository;
    private final StoreRepository storeRepository;

    @Override
    public Mission createMission(Long storeId, MissionRequestDTO.CreateMissionDTO createMissionDTO) {

        // Mission의 Store 연관 관계
        Store store = storeRepository.findById(storeId).orElseThrow(() -> {
            throw new MissionHandler(ErrorStatus.MISSION_NOT_FOUND);});
        Mission mission = MissionConverter.toMission(createMissionDTO, store);
        mission.setStore(store);

        return missionRepository.save(mission);
    }
}
