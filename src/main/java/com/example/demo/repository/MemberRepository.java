package com.example.demo.repository;

import com.example.demo.entity.Member;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface MemberRepository extends PagingAndSortingRepository<Member, Long> {

}
