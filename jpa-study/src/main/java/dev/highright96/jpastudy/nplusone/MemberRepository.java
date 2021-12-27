package dev.highright96.jpastudy.nplusone;

import java.util.List;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MemberRepository extends JpaRepository<Member, Long> {

    @Query("select distinct m from Member m join fetch m.orders")
    List<Member> findAllJoinFetch();

    @EntityGraph(attributePaths = "orders")
    @Query("select distinct m from Member m")
    List<Member> findAllEntityGraph();
}
