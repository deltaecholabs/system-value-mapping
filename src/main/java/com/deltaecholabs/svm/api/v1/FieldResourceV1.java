package com.deltaecholabs.svm.api.v1;

import com.deltaecholabs.svm.api.Role;
import com.deltaecholabs.svm.field.FieldMapper;
import com.deltaecholabs.svm.field.FieldService;
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

@Path("/api/v1/fields")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Tag(name = "field", description = "Field Operations")
public class FieldResourceV1 {

    private final FieldService fieldService;
    private final FieldMapper fieldMapper;

    public FieldResourceV1(FieldService fieldService, FieldMapper fieldMapper) {
        this.fieldService = fieldService;
        this.fieldMapper = fieldMapper;
    }

    @GET
    @APIResponse(responseCode = "200", description = "Get All Fields",
            content = @Content(schema = @Schema(type = SchemaType.ARRAY, implementation = FieldV1.class))
    )
    @RolesAllowed(Role.SVM_FIELD_READ)
    public Response get() {
        return Response.ok(fieldService.findAll().stream().map(fieldMapper::toApi)).build();
    }

}
