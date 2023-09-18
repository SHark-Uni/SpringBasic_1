package hello.core.beanfind;

import hello.core.AppConfig;
import hello.core.discount.DiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class ApplicationContextSameBeanFind {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SameBeanConfig.class);

    //NoUniqueBeanDefinition
    @Test
    @DisplayName("같은 타입이 둘 이상 있는 경우, 중복오류가 발생한다.")
    void findBeanByTypeDuplicate(){
        Assertions.assertThrows(NoUniqueBeanDefinitionException.class,()->ac.getBean(MemberRepository.class));
    }

    @Test
    @DisplayName("같은 타입이 둘 이상 있는 경우, 빈 이름을 지정하면 됩니다.")
    void findDuplicateBean_ByName(){
        MemberRepository bean = ac.getBean("memberRepository1", MemberRepository.class);

        assertThat(bean).isInstanceOf(MemberRepository.class);
    }

    @Test
    @DisplayName("특정 타입을 모두 조회하고 싶어.")
    void findAllBeansByType(){
        Map<String, MemberRepository> beansOfType = ac.getBeansOfType(MemberRepository.class);

        for (String key : beansOfType.keySet()) {
            assertThat(beansOfType.get(key)).isInstanceOf(MemberRepository.class);
        }
    }

    @Configuration
    static class SameBeanConfig{
        @Bean
        public MemberRepository memberRepository1(){
            return new MemoryMemberRepository();
        }
        @Bean
        public MemberRepository memberRepository2(){
            return new MemoryMemberRepository();
        }
    }
}
