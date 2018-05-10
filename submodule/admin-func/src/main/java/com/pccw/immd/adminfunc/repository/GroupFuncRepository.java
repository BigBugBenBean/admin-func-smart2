package com.pccw.immd.adminfunc.repository;

import com.pccw.immd.adminfunc.domain.GroupFunc;
import com.pccw.immd.adminfunc.domain.id.GroupFuncId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository("groupFuncRepository")
public interface GroupFuncRepository extends JpaRepository<GroupFunc, GroupFuncId> {

    List<GroupFunc> findAll();

    List<GroupFunc> findByIdGrpId(String groupId);
}
