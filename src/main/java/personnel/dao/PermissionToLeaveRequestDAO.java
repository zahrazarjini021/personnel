package personnel.dao;

import personnel.entity.PermissionToLeaveRequest;

import java.util.List;

public interface PermissionToLeaveRequestDAO {

    void save(PermissionToLeaveRequest request);

    List<PermissionToLeaveRequest> findAll();
}
