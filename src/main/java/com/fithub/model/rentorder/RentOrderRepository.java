package com.fithub.model.rentorder;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.transaction.Transactional;

public interface RentOrderRepository extends JpaRepository<RentOrder, Integer> {
	 
    // william ，返回指定教室的全部 rentdate renttime rentstatus
    @Query("SELECT r.rentdate, r.renttime ,r.rentstatus FROM RentOrder r WHERE r.classroomid = :classroomid")
    List<Object[]> findAllrentDateAndrentTimeAndrentStatusByClassroomId(@Param("classroomid") Integer classroomId);

    // william 查詢場地是否被預訂
    @Query("SELECT r FROM RentOrder r WHERE r.classroomid = :classroomid AND r.rentdate = :rentdate AND r.renttime = :renttime")
    RentOrder checkClassroomAvailability(
        @Param("classroomid") Integer classroomId,
        @Param("rentdate") String rentdate,
        @Param("renttime") String renttime
    );

    // william 更新訂單已付款
    @Modifying
    @Transactional
    @Query("UPDATE RentOrder r SET  r.rentstatus = :rentstatus WHERE r.rentorderid = :rentorderid")
    void updateRentstatusById(@Param("rentorderid") Integer rentorderid,@Param("rentstatus") String rentstatus);
}
