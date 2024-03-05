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
    public Response create(EmployeeDAO employee) {
        return Response.ok(employeeService.createEmployee(employee)).status(201).build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, EmployeeDAO employee) {
        return Response.ok(employeeService.updateEmployee(id, employee)).status(200).build();
    }

    @POST
    @Path("/{size}")
    public Response createDummy(@PathParam("size") Long size) {
        List<EmployeeDAO> employeeList = EmployeeUtil.getEmployeeList(size.intValue());
        return Response.ok(employeeService.createEmployee(employeeList)).status(201).build();
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
