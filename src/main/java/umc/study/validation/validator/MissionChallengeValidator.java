package umc.study.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.domain.enums.MissionStatus;
import umc.study.repository.MemberMissionRepository;
import umc.study.validation.annotation.ChallengeMission;

@Component
@RequiredArgsConstructor
public class MissionChallengeValidator implements ConstraintValidator<ChallengeMission, Long> {

    private final MemberMissionRepository membermissionRepository;

    @Override
    public void initialize(ChallengeMission constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long missionId, ConstraintValidatorContext context) {
        boolean isMissionChallenged = membermissionRepository.existsByMissionIdAndStatus(missionId, MissionStatus.CHALLENGING);
        System.out.println("mission id: " + missionId); // 디버깅 라인 추가
        System.out.println("isMissionChallenged " + isMissionChallenged); // 디버깅 라인 추가

        // 도전 중이 아니라면(false라면) 추가
        if(!isMissionChallenged){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.MEMBER_MISSION_CHALLENGE.getMessage()).addConstraintViolation();
        }

        return !isMissionChallenged;
    }
}
