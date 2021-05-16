package com.bhandari.sevendaypsychology.counsellor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CounsellorRepository extends JpaRepository<Counsellor, Long> {

    // It translates as
    //SELECT * FROM COUNSELLOR WHERE EMAIL=?
    @Query("SELECT c FROM Counsellor c WHERE c.email=?1 ")
    Optional<Counsellor> findCounsellorByEmail(String email);

}
