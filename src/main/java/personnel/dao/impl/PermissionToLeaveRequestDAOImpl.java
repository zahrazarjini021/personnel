package personnel.dao.impl;

import personnel.dao.PermissionToLeaveRequestDAO;
import personnel.entity.PermissionToLeaveRequest;
import personnel.entity.Person;
import personnel.utils.DBHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PermissionToLeaveRequestDAOImpl implements PermissionToLeaveRequestDAO {

    private final List<PermissionToLeaveRequest> permissionToLeaveRequests = new ArrayList<>();


    public void save(PermissionToLeaveRequest request) {
        String sql = "INSERT INTO permission_to_leave (person_id, fromDate, toDate, acceptedOrRejected) VALUES (?, ?, ?, ?)";

        try (Connection conn = DBHandler.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, request.getPerson().getPersonId());
            stmt.setDate(2, java.sql.Date.valueOf(request.getFromDate()));
            stmt.setDate(3, java.sql.Date.valueOf(request.getToDate()));

            if (request.getAcceptedOrRejected() != null) {
                stmt.setBoolean(4, request.getAcceptedOrRejected());
            } else {
                stmt.setNull(4, java.sql.Types.BOOLEAN);
            }

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public List<PermissionToLeaveRequest> findAll() {
        List<PermissionToLeaveRequest> requests = new ArrayList<>();
        String sql = "SELECT person_id, fromDate, toDate, acceptedOrRejected FROM permission_to_leave";

        try (Connection conn = DBHandler.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                PermissionToLeaveRequest request = new PermissionToLeaveRequest();

                Person person = new Person();
                person.setPersonId(rs.getInt("person_id"));
                request.setPerson(person);

                request.setFromDate(rs.getDate("fromDate").toLocalDate());
                request.setToDate(rs.getDate("toDate").toLocalDate());

                boolean accepted = rs.getBoolean("acceptedOrRejected");
                if (rs.wasNull()) {
                    request.setAcceptedOrRejected(null);
                } else {
                    request.setAcceptedOrRejected(accepted);
                }

                requests.add(request);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return requests;
    }



}
