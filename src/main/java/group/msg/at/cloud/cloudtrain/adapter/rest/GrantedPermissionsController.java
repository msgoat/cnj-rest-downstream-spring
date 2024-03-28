package group.msg.at.cloud.cloudtrain.adapter.rest;

import group.msg.at.cloud.cloudtrain.core.boundary.GrantedPermissionManager;
import group.msg.at.cloud.cloudtrain.core.entity.GrantedPermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/grantedPermissions")
@CrossOrigin
public class GrantedPermissionsController {

    @Autowired
    GrantedPermissionManager boundary;

    @GetMapping
    public ResponseEntity<List<GrantedPermission>> getPermissionsByCurrentUser() {
        return ResponseEntity.ok(this.boundary.getGrantedPermissionsByCurrentUser());
    }
}
