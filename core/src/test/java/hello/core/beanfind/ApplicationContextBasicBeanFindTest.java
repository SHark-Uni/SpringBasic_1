package hello.core.beanfind;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceimpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class ApplicationContextBasicBeanFindTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    //유연성이 떨어짐. 성능이 떨어짐.
    @Test
    @DisplayName("구체적 타입으로만 조회")
    void findBeanByDetailType(){
        MemberService memberService = ac.getBean("memberService", MemberServiceimpl.class);

        assertThat(memberService).isInstanceOf(MemberServiceimpl.class);
    }

    @Test
    @DisplayName("빈 이름으로 조회하기")
    void findBeanByName(){
        MemberService memberService = ac.getBean("memberService", MemberService.class);

        assertThat(memberService).isInstanceOf(MemberServiceimpl.class);
    }

    //같은 타입이 여러개라면?!
    @Test
    @DisplayName("이름 없이 타입으로만 조회")
    void findBeanByType(){
        MemberService memberService = ac.getBean(MemberService.class);

        assertThat(memberService).isInstanceOf(MemberServiceimpl.class);
    }

    //같은 타입이 여러개라면?!
    @Test
    @DisplayName("없는 이름 조회")
    void findBeanByNameX(){
        assertThrows(
                NoSuchBeanDefinitionException.class,
                ()->ac.getBean("xxxxx", MemberService.class));
    }

}
