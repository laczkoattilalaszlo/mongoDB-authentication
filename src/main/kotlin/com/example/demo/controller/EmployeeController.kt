package com.example.demo.controller

import com.example.demo.request.EmployeeRequest
import com.example.demo.response.EmployeeResponse
import com.example.demo.service.EmployeeService
import org.bson.types.ObjectId
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/employee")
class EmployeeController(
    private val employeeService: EmployeeService
) {

    @PostMapping
    fun createEmployee(@RequestBody request: EmployeeRequest): ResponseEntity<EmployeeResponse> {
        val createdEmployee = employeeService.createEmployee(request)

        return ResponseEntity
            .ok(
                EmployeeResponse.fromEntity(createdEmployee)
            )
    }

    @GetMapping
    fun findAllEmployees(): ResponseEntity<List<EmployeeResponse>> {
        val employees = employeeService.findAll()

        return ResponseEntity
            .ok(
                employees.map { EmployeeResponse.fromEntity(it) }
            )
    }

    @GetMapping("/{id}")
    fun findEmployeeById(@PathVariable id: ObjectId): ResponseEntity<EmployeeResponse> {
        val employee = employeeService.findById(id)

        return ResponseEntity
            .ok(
                EmployeeResponse.fromEntity(employee)
            )
    }

    @PutMapping("/{id}")
    fun updateUpdateEmployee(
        @PathVariable id: ObjectId,
        @RequestBody request: EmployeeRequest
    ): ResponseEntity<EmployeeResponse> {
        val updatedEmployee = employeeService.updateEmployee(id, request)

        return ResponseEntity
            .ok(
                EmployeeResponse.fromEntity(updatedEmployee)
            )
    }

    @DeleteMapping("/{id}")
    fun deleteEmployee(@PathVariable id: ObjectId): ResponseEntity<Void> {
        employeeService.deleteById(id)

        return ResponseEntity.noContent().build()
    }

}