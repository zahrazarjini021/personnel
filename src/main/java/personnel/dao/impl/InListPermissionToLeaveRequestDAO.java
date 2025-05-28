package personnel.dao.impl;

import personnel.dao.PermissionToLeaveRequestDAO;
import personnel.entity.PermissionToLeaveRequest;

import java.util.ArrayList;
import java.util.List;

public class InListPermissionToLeaveRequestDAO implements PermissionToLeaveRequestDAO {


    private final List<PermissionToLeaveRequest> localList = new ArrayList<>();

    @Override
    public void save(PermissionToLeaveRequest request) {
        localList.add(request);
    }

    @Override
    public List<PermissionToLeaveRequest> findAll() {
        return new ArrayList<>(localList);
    }

}
