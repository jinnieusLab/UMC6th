package umc.study.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.domain.mapping.MemberMission;

public interface MemberMissionRepository extends JpaRepository<MemberMission, Long> {
    boolean existsByMission_IdAndStatus(Long missionId, String status);
    MemberMission findMemberMissionByMission_Id(Long missionId);
}
