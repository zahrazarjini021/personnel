package personnel.dao;

import personnel.dao.impl.InListPermissionToLeaveRequestDAO;
import personnel.dao.impl.PermissionToLeaveRequestDAOImpl;
import personnel.entity.PermissionToLeaveRequest;

import java.util.List;

public class PermissionToLeaveRequestProxy implements PermissionToLeaveRequestDAO{


    private final PermissionToLeaveRequestDAO dbDao = new PermissionToLeaveRequestDAOImpl();
    private final PermissionToLeaveRequestDAO fallbackDao = new InListPermissionToLeaveRequestDAO();
    private boolean dbAvailable = true;


    @Override
    public void save(PermissionToLeaveRequest request) {
        try {
            if (dbAvailable) {
                dbDao.save(request);
            } else {
                fallbackDao.save(request);
            }
        } catch (Exception e) {
            System.out.println("DB unavailable. Switching to memory.");
            dbAvailable = false;
            fallbackDao.save(request);
        }
    }

    @Override
    public List<PermissionToLeaveRequest> findAll() {
        if (dbAvailable) {
            try {
                return dbDao.findAll();
            } catch (Exception e) {
                System.out.println("DB unavailable. Reading from memory.");
                dbAvailable = false;
                return fallbackDao.findAll();
            }
        } else {
            return fallbackDao.findAll();
        }
    }


}
