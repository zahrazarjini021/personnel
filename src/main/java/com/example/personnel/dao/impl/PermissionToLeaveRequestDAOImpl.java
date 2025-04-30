package com.example.personnel.dao.impl;

import com.example.personnel.dao.PermissionToLeaveRequestDAO;
import com.example.personnel.entity.PermissionToLeaveRequest;

import java.util.ArrayList;
import java.util.List;

public class PermissionToLeaveRequestDAOImpl implements PermissionToLeaveRequestDAO {

    private final List<PermissionToLeaveRequest> permissionToLeaveRequests = new ArrayList<>();


    public void save(PermissionToLeaveRequest request) {
        permissionToLeaveRequests.add(request);
    }

    public List<PermissionToLeaveRequest> findAll() {
        return new ArrayList<>(permissionToLeaveRequests);
    }

    public void clear() {
        permissionToLeaveRequests.clear();
    }
}
