package umc.study.service.mission;

import org.springframework.data.domain.Page;
import umc.study.domain.Mission;
import umc.study.domain.Store;

import java.util.Optional;

public interface MissionQueryService {
    Optional<Store> findStore(Long id);

    Page<Mission> getMissionList(Long StoreId, Integer page);
}
