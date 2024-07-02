package umc.study.service.impl.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.apiPayload.exception.handler.FoodCategoryHandler;
import umc.study.apiPayload.exception.handler.MemberHandler;
import umc.study.apiPayload.exception.handler.MissionHandler;
import umc.study.converter.MemberConverter;
import umc.study.converter.MemberMissionConverter;
import umc.study.converter.MemberPreferConverter;
import umc.study.domain.FoodCategory;
import umc.study.domain.Member;
import umc.study.domain.Mission;
import umc.study.domain.mapping.MemberMission;
import umc.study.domain.mapping.MemberPrefer;
import umc.study.repository.FoodCategoryRepository;
import umc.study.repository.MemberMissionRepository;
import umc.study.repository.MemberRepository;
import umc.study.repository.MissionRepository;
import umc.study.web.dto.request.MemberRequestDTO;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberCommandServiceImpl implements MemberCommandService {

    private final MemberRepository memberRepository;
    private final FoodCategoryRepository foodCategoryRepository;
    private final MissionRepository missionRepository;
    private final MemberMissionRepository memberMissionRepository;

    @Override
    @Transactional
    public Member joinMember(MemberRequestDTO.JoinDto request) {
        Member newMember = MemberConverter.toMember(request);
        List<FoodCategory> foodCategoryList = request.getPreferCategory().stream()
                .map(category -> foodCategoryRepository.findById(category)
                        .orElseThrow(() -> new FoodCategoryHandler(ErrorStatus.FOOD_CATEGORY_NOT_FOUND))).toList();

        List<MemberPrefer> memberPreferList = MemberPreferConverter.toMemberPreferList(foodCategoryList);
        for (MemberPrefer memberPrefer : memberPreferList) {
            memberPrefer.setMember(newMember);
        }
        return memberRepository.save(newMember);
    }

    @Override
    public MemberMission addMemberMission(Long missionId) {
        // MemberMission의 Member와 Mission 연관관계
        Mission mission = missionRepository.findById(missionId).orElseThrow(() -> {
            throw new MissionHandler(ErrorStatus.MISSION_NOT_FOUND);
        });
        // member는 하드코딩
        Member member = memberRepository.findById(1L).orElseThrow(() -> {
            throw new MemberHandler(ErrorStatus.MEMBER_NOT_FOUND);
        });

        MemberMission memberMission = MemberMissionConverter.toMemberMissionDTO(member, mission);
        return memberMissionRepository.save(memberMission);
    }
}
