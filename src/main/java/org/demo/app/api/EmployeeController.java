package org.demo.app.api;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.RequiredArgsConstructor;
import org.demo.app.model.EmployeeDAO;
import org.demo.app.service.EmployeeService;
import org.demo.app.util.EmployeeUtil;

import java.util.List;

@Path("/api/v1/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findEmployeeById(@PathParam("id") Long id) {
        return Response.ok(employeeService.findEmployeeById(id)).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response findEmployeeByEmail(@QueryParam("email") String email) {
        return Response.ok(EmployeeUtil.createRandomEmployee()).status(Response.Status.OK).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(EmployeeDAO employee) {
        return Response.ok(employeeService.createEmployee(employee)).status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("id") Long id, EmployeeDAO employee) {
        return Response.ok(employeeService.updateEmployee(id, employee)).status(Response.Status.OK).build();
    }

    @POST
    @Path("/{size}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response createDummy(@PathParam("size") Long size) {
        List<EmployeeDAO> employeeList = EmployeeUtil.getEmployeeList(size.intValue());
        return Response.ok(employeeService.createEmployee(employeeList)).status(Response.Status.CREATED).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAllEmployees() {
        return Response.ok(employeeService.findEmployees()).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        return Response.ok(employeeService.deleteEmployee(id)).build();
    }

}
