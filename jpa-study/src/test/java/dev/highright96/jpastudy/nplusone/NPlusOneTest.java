package dev.highright96.jpastudy.nplusone;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
public class NPlusOneTest {

    @PersistenceContext
    EntityManager em;

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    OrderRepository orderRepository;

    @BeforeEach
    void setUp() {
        List<Member> members = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            Member member = Member.builder()
                .name("유저" + i)
                .build();
            List<Order> orders = new ArrayList<>();
            for (int j = 1; j <= 5; j++) {
                orders.add(Order.builder()
                    .name("주문" + j)
                    .build()
                );
            }
            member.addOrders(orders);
            members.add(member);
        }
        memberRepository.saveAll(members);
    }

    @Test
    void 즉시_로딩_N1_쿼리_테스트() {
        List<Member> members = memberRepository.findAll();
        assertThat(members.size()).isEqualTo(5);
    }

    @Test
    void 지연_로딩_N1_쿼리_테스트() {
        List<Member> members = memberRepository.findAll();
        assertThat(members.size()).isEqualTo(5);
    }

    @Test
    @Transactional
    void 지연_로딩_N1_쿼리_연관_엔티티_조회_테스트() {
        em.clear();

        List<Member> members = memberRepository.findAll();
        for (Member member : members) {
            System.out.println(member.getOrders().size());
        }
        assertThat(members.size()).isEqualTo(5);
    }

    @Test
    @Transactional
    void 지연_로딩_N1_쿼리_페치_조인_테스트() {
        em.clear();

        List<Member> members = memberRepository.findAllJoinFetch();
        for (Member member : members) {
            System.out.println(member.getOrders().size());
        }
        assertThat(members.size()).isEqualTo(5);
    }

    @Test
    @Transactional
    void 지연_로딩_N1_쿼리_엔티티_그래프_테스트() {
        em.clear();

        List<Member> members = memberRepository.findAllEntityGraph();
        for (Member member : members) {
            System.out.println(member.getOrders().size());
        }
        assertThat(members.size()).isEqualTo(5);
    }

    /*
    공통점
    카테시안 곱(Cartesian Product)이 발생하여 쿼리 결과는 member * orders 만큼 나옴
    해결방법으로는 distinct 또는 List 대신 Set 을 사용하면 된다.

    차이점
    페치 조인은 inner join
    엔티티 그래프는 outer join
    */
    @Test
    @Transactional
    void 지연_로딩_N1_쿼리_엔티티_그래프와_페치_조인_비교_테스트() {
        em.clear();
        memberRepository.findAllJoinFetch();
        memberRepository.findAllEntityGraph();

    }
}
