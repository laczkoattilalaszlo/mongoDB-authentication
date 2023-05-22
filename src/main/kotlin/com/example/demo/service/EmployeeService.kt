package com.example.demo.service

import com.example.demo.model.Employee
import com.example.demo.repository.EmployeeRepository
import com.example.demo.request.EmployeeRequest
import org.bson.types.ObjectId
import org.springframework.stereotype.Service

@Service
class EmployeeService(
    private val employeeRepository: EmployeeRepository
) {

    fun createEmployee(request: EmployeeRequest): Employee {

        return employeeRepository.save(
            Employee(
                firstName = request.firstName,
                lastName = request.lastName,
                email = request.email
            )
        )
    }

    fun findAll(): List<Employee> =
        employeeRepository.findAll()

    fun findById(id: ObjectId): Employee =
        employeeRepository.findById(id)
            .orElseThrow { Exception("Employee with the given id ($id) not found.") }

    fun updateEmployee(id: ObjectId, request: EmployeeRequest): Employee {
        val employeeToUpdate = findById(id)

        return employeeRepository.save(
            employeeToUpdate.apply {
                firstName = request.firstName
                lastName = request.lastName
                email = request.email
            }
        )
    }

    fun deleteById(id: ObjectId) {
        val employeeToDelete = findById(id)

        employeeRepository.delete(employeeToDelete)
    }

}