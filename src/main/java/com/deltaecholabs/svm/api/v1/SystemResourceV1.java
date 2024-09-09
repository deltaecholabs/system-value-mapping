package com.deltaecholabs.svm.api.v1;

import com.deltaecholabs.svm.api.Role;
import com.deltaecholabs.svm.system.SystemMapper;
import com.deltaecholabs.svm.system.SystemService;
import jakarta.annotation.security.RolesAllowed;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

@Path("/api/v1/systems")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Tag(name = "system", description = "System Operations")
public class SystemResourceV1 {

    private final SystemService systemService;
    private final SystemMapper systemMapper;

    public SystemResourceV1(SystemService systemService, SystemMapper systemMapper) {
        this.systemService = systemService;
        this.systemMapper = systemMapper;
    }

    @GET
    @APIResponse(responseCode = "200", description = "Get All Systems",
            content = @Content(schema = @Schema(type = SchemaType.ARRAY, implementation = SystemV1.class))
    )
    @RolesAllowed(Role.SVM_SYSTEM_READ)
    public Response get() {
        return Response.ok(systemService.findAll().stream().map(systemMapper::toApi)).build();
    }

}
